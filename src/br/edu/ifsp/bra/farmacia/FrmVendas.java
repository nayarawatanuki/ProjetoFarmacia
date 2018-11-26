package br.edu.ifsp.bra.farmacia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifsp.bra.dominio.CaixaFacade;
import br.edu.ifsp.bra.modelo.ItemPedido;
import br.edu.ifsp.bra.modelo.Pedido;

import java.awt.Font;

public class FrmVendas {

	public static boolean isAtualizada = true;
	private JFrame frame;
	private JPanel panel;
	private JLabel lblTotal;
	private JLabel vlrTotal;
	private DefaultTableModel model;
	private JButton btnAddItem;
	private JButton btnDesconto;
	private JButton btnCancelar;
	private double total;
	private JTable itens;
	
	
	
	public FrmVendas()
	{
		initialize();
		CaixaFacade facade = new CaixaFacade();
		facade.novoPedido();
	}
	public void initialize()
	{
		frame = new JFrame("  Venda  ");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 400);
		
		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotal.setBounds(25, 9, 67, 14);
		panel.add(lblTotal);
		vlrTotal = new JLabel("0.00");
		vlrTotal.setFont(new Font("Tahoma", Font.PLAIN, 22));
		vlrTotal.setBounds(102, -1, 72, 29);
		panel.add(vlrTotal);
		btnAddItem = new JButton("Adicionar Item");
		btnAddItem.setBounds(0, 338, 105, 23);
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmAddItem addItem;
				if(FrmVendas.isAtualizada)
					 addItem = new FrmAddItem();
				else
				{
					JOptionPane.showMessageDialog(null, "Atualize a tabela antes");
				}
				
			}
		});
		panel.add(btnAddItem);
		
		JButton btnAtualizarTabela = new JButton("Atualizar");
		btnAtualizarTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAtualizada)
				{
					popularTabela();
					FrmVendas.isAtualizada = true;
				}
			}
		});
		btnAtualizarTabela.setBounds(257, 243, 89, 23);
		panel.add(btnAtualizarTabela);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(25, 49, 321, 196);
		panel.add(scroll);
		
		criarTabela();
		itens = new JTable(model);
		scroll.setViewportView(itens);
		
		JButton btnPagamento = new JButton("Pagamento");
		btnPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaixaFacade facade = new CaixaFacade();
				Pedido.getPedidoAtual().setId(facade.efetuaVenda());
				frame.dispose();
			}
		});
		btnPagamento.setBounds(155, 338, 89, 23);
		panel.add(btnPagamento);
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CaixaFacade facade = new CaixaFacade();
				facade.cancelaVenda();
			}
		});
		btnCancelar_1.setBounds(295, 338, 89, 23);
		panel.add(btnCancelar_1);
		
		
		frame.setVisible(true);		
	}
	private void criarTabela()
	{
		model = new DefaultTableModel();
		model.addColumn("Descrição");
		model.addColumn("Preço Unitário");
		model.addColumn("Quantidade");
		model.addColumn("Preço Total");
	}
	private void popularTabela()
	{
		while(model.getRowCount()>0)
		{
			model.removeRow(0);
		}
		if(Pedido.getPedidoAtual() != null)
		{
			List<ItemPedido> itens = Pedido.getPedidoAtual().getItens();
			for(ItemPedido item : itens)
			{
				Object[] lista = new Object[4];
				lista[0] = item.getMedicamento().getDescricao();
				lista[1] = item.getMedicamento().getPreco();
				lista[2] = item.getQuantidade();
				lista[3] = item.getTotal();
			
				model.addRow(lista);
				setPrecoTotal(Pedido.getPedidoAtual().getTotal());
			}
		}
	}
	private void setPrecoTotal(double preco)
	{
		vlrTotal.setText(preco + "");
	}
}