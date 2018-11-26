package br.edu.ifsp.bra.farmacia;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.edu.ifsp.bra.dominio.CaixaFacade;
import br.edu.ifsp.bra.dominio.MedicamentoBLL;
import br.edu.ifsp.bra.modelo.ItemPedido;
import br.edu.ifsp.bra.modelo.Medicamento;
import br.edu.ifsp.bra.modelo.Pedido;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
class FrmAddItem {

	JFrame frame;
	JPanel panel;
	JLabel lblCodMed;
	JLabel lblQuant;
	JTextField txtCodMed;
	JTextField txtQuant;
	JButton btnConfirmar;
	JTable itens;
	DefaultTableModel model;
	JLabel lblDescricao;
	JLabel lblPrecoUnitario;
	JLabel lblQuantidade;
	JLabel lblPrecoTotal;
	
	private JButton btnFinalizar;
	
	public FrmAddItem()
	{
		frame = new JFrame(" AddItem ");
		frame.setSize(473, 301);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblCodMed = new JLabel("Código do Medicamento");
		lblCodMed.setBounds(0, 18, 131, 29);
		panel.add(lblCodMed);
		txtCodMed = new JTextField(10);
		txtCodMed.setBounds(173, 18, 234, 29);
		panel.add(txtCodMed);
		lblQuant = new JLabel("Quantidade");
		lblQuant.setBounds(0, 58, 301, 29);
		panel.add(lblQuant);
		txtQuant = new JTextField(10);
		txtQuant.setBounds(173, 58, 234, 29);
		panel.add(txtQuant);
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicamentoBLL medBll = new MedicamentoBLL();
				Medicamento med = medBll.getMedicamento(Integer.parseInt(txtCodMed.getText()));
				CaixaFacade facade = new CaixaFacade();
				facade.adicionaMedicamento(med, Integer.parseInt(txtQuant.getText()));
				popularTabela(Pedido.getPedidoAtual().getItens().get((Pedido.getPedidoAtual().getItens().size()) - 1));
			}
		});
		btnConfirmar.setBounds(311, 98, 96, 29);
		panel.add(btnConfirmar);
		
		lblDescricao = new JLabel("");
		lblDescricao.setBounds(0, 132, 301, 14);
		panel.add(lblDescricao);
		
		lblPrecoUnitario = new JLabel("");
		lblPrecoUnitario.setBounds(0, 157, 301, 14);
		panel.add(lblPrecoUnitario);
		
		lblQuantidade = new JLabel("");
		lblQuantidade.setBounds(0, 182, 301, 14);
		panel.add(lblQuantidade);
		
		lblPrecoTotal = new JLabel("");
		lblPrecoTotal.setBounds(0, 207, 301, 14);

		panel.add(lblPrecoTotal);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnFinalizar.setBounds(318, 173, 89, 23);
		panel.add(btnFinalizar);
	/*	criarTabela();
		itens = new JTable(model);
		JScrollPane scroll = new JScrollPane(itens);
		scroll.setViewportView(itens);
		panel.add(scroll);*/
		
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
	private void popularTabela(ItemPedido item)
	{
		lblDescricao.setText("Descrição: " + item.getMedicamento().getDescricao());
		lblPrecoUnitario.setText("Preço Unitário: " + item.getMedicamento().getPreco());
		lblQuantidade.setText("Quantidade: " + txtQuant.getText());
		lblPrecoTotal.setText("Preço Total: " + item.getMedicamento().getPreco() * Double.parseDouble(txtQuant.getText()));
		FrmVendas.isAtualizada = false;
	}
}
