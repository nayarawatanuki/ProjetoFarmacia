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
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;

public class FrmVendas {

	public static boolean isAtualizada = true;
	JFrame frame;
	private JPanel panel;
	static JLabel lblCliente;
	private JLabel vlrTotal;
	private DefaultTableModel model;
	private JButton btnAddItem;
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
		frame.setSize(499, 678);
		
		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		btnAddItem = new JButton("Adicionar Item");
		btnAddItem.setBounds(31, 575, 143, 23);
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(FrmVendas.isAtualizada)
					 new FrmAddItem();
				else
				{
					JOptionPane.showMessageDialog(null, "Atualize a tabela antes");
				}
				
			}
		});
		panel.add(btnAddItem);
		
		criarTabela();
		
		JButton btnPagamento = new JButton("Pagamento");
		btnPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaixaFacade facade = new CaixaFacade();
				Pedido.getPedidoAtual().setId(facade.efetuaVenda());
				frame.dispose();
			}
		});
		btnPagamento.setBounds(186, 575, 113, 23);
		panel.add(btnPagamento);
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CaixaFacade facade = new CaixaFacade();
				facade.cancelaVenda();
			}
		});
		btnCancelar_1.setBounds(317, 575, 89, 23);
		panel.add(btnCancelar_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Itens", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(25, 183, 381, 361);
		panel.add(panel_1);
		
		lblCliente = new JLabel("Cliente: ");
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmClientesConsulta();
			}
		});
		
		JScrollPane scpTotal = new JScrollPane();
		scpTotal.setViewportBorder(new TitledBorder(null, "TOTAL:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scpTotal.setEnabled(false);
		
		JScrollPane scroll = new JScrollPane();
		itens = new JTable(model);
		scroll.setViewportView(itens);
		
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
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAtualizarTabela, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(scroll, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblCliente)
								.addGap(25)
								.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
							.addComponent(scpTotal, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)))
					.addGap(19))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCliente)
						.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scpTotal, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addComponent(btnAtualizarTabela, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblTotalpedido = new JLabel("TotalPedido");
		scpTotal.setViewportView(lblTotalpedido);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Caixa Total", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(25, 80, 178, 102);
		panel.add(panel_2);
		
		vlrTotal = new JLabel("0.00");
		vlrTotal.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(70, Short.MAX_VALUE)
					.addComponent(vlrTotal, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(23)
					.addComponent(vlrTotal, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 499, 22);
		panel.add(menuBar);
		
		JMenu mnFarmacia = new JMenu("Farmacia");
		menuBar.add(mnFarmacia);
		
		JMenuItem mntmEncerrrarSessao = new JMenuItem("Encerrrar Sessao");
		mntmEncerrrarSessao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFarmacia.add(mntmEncerrrarSessao);
		
		JMenu mnMedicamentos = new JMenu("Medicamentos");
		menuBar.add(mnMedicamentos);
		
		JMenuItem mntmCadastroM = new JMenuItem("Cadastro");
		mntmCadastroM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					FrmCadastroMed med = new FrmCadastroMed();
					med.frame.setVisible(true);
					
					frame.dispose();
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		mnMedicamentos.add(mntmCadastroM);
		
		JMenuItem mntmConsultaM = new JMenuItem("Consulta");
		mntmConsultaM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					FrmMedicamento med = new FrmMedicamento();
					med.frame.setVisible(true);
					
					frame.dispose();
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		mnMedicamentos.add(mntmConsultaM);
		
		JMenu mnClientes = new JMenu("FrmClientesConsulta");
		menuBar.add(mnClientes);
		
		JMenuItem mntmCadastroC = new JMenuItem("Cadastro");
		mntmCadastroC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					FrmClienteCadastro cliente = new FrmClienteCadastro();
					cliente.frame.setVisible(true);
					
					frame.dispose();
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		mnClientes.add(mntmCadastroC);
		
		JMenuItem mntmConsultaC = new JMenuItem("Consulta");
		mntmConsultaC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					FrmClientesConsulta cliente = new FrmClientesConsulta();
					cliente.frame.setVisible(true);
					
					frame.dispose();
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		mnClientes.add(mntmConsultaC);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(227, 82, 178, 100);
		panel.add(panel_3);
		
		JTextPane txtpnFarmaciaTel = new JTextPane();
		txtpnFarmaciaTel.setText("                   \n           FARMACIA   \n\n       Tel.: 3468-2211");
		txtpnFarmaciaTel.setEnabled(false);
		txtpnFarmaciaTel.setEditable(false);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(15)
					.addComponent(txtpnFarmaciaTel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(14)
					.addComponent(txtpnFarmaciaTel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		
		frame.setVisible(true);		
	}
	private void criarTabela()
	{
		model = new DefaultTableModel();
		model.addColumn("Descricao");
		model.addColumn("Preco Unitario");
		model.addColumn("Quantidade");
		model.addColumn("Preco Total");
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
				lista[3] = (item.getMedicamento().getPreco() * item.getQuantidade());
			
				model.addRow(lista);
				setPrecoTotal(Pedido.getPedidoAtual().getTotal());
			}
		}
	}
	private void setPrecoTotal(double preco)
	{
		//lblTotalpedido.setText(preco + "");
	}
}