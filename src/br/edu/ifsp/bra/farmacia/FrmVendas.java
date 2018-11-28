package br.edu.ifsp.bra.farmacia;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.ifsp.bra.dominio.CaixaFacade;
import br.edu.ifsp.bra.modelo.Caixa;
import br.edu.ifsp.bra.modelo.Cartao;
import br.edu.ifsp.bra.modelo.Cliente;
import br.edu.ifsp.bra.modelo.Dinheiro;
import br.edu.ifsp.bra.modelo.ItemPedido;
import br.edu.ifsp.bra.modelo.Pagamento;
import br.edu.ifsp.bra.modelo.Pagamento.TipoPagamento;
import br.edu.ifsp.bra.modelo.Pedido;

public class FrmVendas {

	public static boolean isAtualizada = true;
	JFrame frame;
	private JPanel panel;
	static JLabel lblCliente;
	private JLabel vlrTotal;
	private DefaultTableModel model;
	private JButton btnAddItem;
	private JTable itens;
	private CaixaFacade facade;
	public FrmVendas()
	{
		this.facade = new CaixaFacade();
		facade.novoPedido();
		initialize();

	}
	
	private int idValido() {
		return Cliente.getClienteAtual() != null ? Cliente.getClienteAtual().getId() : 0; 
	}
	
	public void initialize()
	{
		frame = new JFrame("  Venda  ");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(499, 715);
		frame.setLocationRelativeTo(null);
		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		criarTabela();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Itens", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(25, 183, 423, 361);
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
		
		JLabel lblTotalpedido = new JLabel("TotalPedido");
		
		JButton btnAtualizarTabela = new JButton("Atualizar");
		btnAtualizarTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAtualizada)
				{
					popularTabela();
					FrmVendas.isAtualizada = true;
					lblTotalpedido.setText(Pedido.getPedidoAtual().getTotal() + "");
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(22, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAtualizarTabela, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblCliente)
								.addGap(25)
								.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
							.addComponent(scpTotal, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
							.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)))
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
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addComponent(btnAtualizarTabela, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		
		scpTotal.setViewportView(lblTotalpedido);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Caixa Total", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(25, 80, 220, 102);
		panel.add(panel_2);
		
		vlrTotal = new JLabel("" + Caixa.getValorAbertura());
		vlrTotal.setFont(vlrTotal.getFont().deriveFont(30f));
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(vlrTotal, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(23)
					.addComponent(vlrTotal, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
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
					
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		mnMedicamentos.add(mntmConsultaM);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmCadastroC = new JMenuItem("Cadastro");
		mntmCadastroC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					FrmClienteCadastro cliente = new FrmClienteCadastro();
					cliente.frame.setVisible(true);
					
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
					
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		mnClientes.add(mntmConsultaC);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(257, 80, 191, 102);
		panel.add(panel_3);
		
		JTextPane txtpnFarmaciaTel = new JTextPane();
		txtpnFarmaciaTel.setText("                   \n           FARMACIA   \n\n       Tel.: 3468-2211");
		txtpnFarmaciaTel.setEnabled(false);
		txtpnFarmaciaTel.setEditable(false);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addComponent(txtpnFarmaciaTel, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(14))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(txtpnFarmaciaTel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panelOpcoes = new JPanel();
		panelOpcoes.setBounds(25, 556, 423, 39);
		panel.add(panelOpcoes);
		panelOpcoes.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCancelar = new JButton("Cancelar Venda");
		panelOpcoes.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnCancelar.getText() == "Cancelar Venda") {
					
					facade.cancelaVenda();
					
					lblCliente.setText("Cliente: ");
					
					String caixa = vlrTotal.getText();
					vlrTotal.setText("" + (Double.parseDouble(lblTotalpedido.getText()) + Double.parseDouble(caixa)));
					
					lblTotalpedido.setText("");
					
					itens.selectAll();
					((DefaultTableModel) itens.getModel()).setRowCount(0);
					itens = new JTable(model);
					
					btnCancelar.setText("Cancelar Venda");
					
					facade.novoPedido();
					
				}else if(btnCancelar.getText() == "Novo Pedido") {
					
					lblCliente.setText("Cliente: ");
					
					String caixa = vlrTotal.getText();
					vlrTotal.setText("" + (Double.parseDouble(lblTotalpedido.getText()) + Double.parseDouble(caixa)));
					
					lblTotalpedido.setText("");
					
					itens.selectAll();
					((DefaultTableModel) itens.getModel()).setRowCount(0);
					
					
					btnCancelar.setText("Cancelar Venda");
					
					facade.novoPedido();
					
				}
				
			}
		});
		
		JButton btnPagamento = new JButton("Pagamento");
		panelOpcoes.add(btnPagamento);
		btnAddItem = new JButton("Adicionar Item");
		panelOpcoes.add(btnAddItem);
		
		JPanel panelPagamento = new JPanel();
		panelPagamento.setBounds(25, 607, 423, 39);
		panelPagamento.setVisible(false);
		panel.add(panelPagamento);
		
		JButton btnDinheiro = new JButton("Dinheiro");
		btnDinheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedido.getPedidoAtual().setId(facade.efetuaVenda());
				Pedido p = Pedido.getPedidoAtual();
				Pagamento pgto = new Dinheiro(p.getId(), p.getTotal(), TipoPagamento.DINHEIRO, 0);
				pgto.setClienteId(idValido());
				facade.realizaPagamento(pgto);
				JOptionPane.showMessageDialog(null, "Pagamento por dinheiro realizado com sucesso.");
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(true);
				btnCancelar.setText("Novo Pedido");
				
			}
		});
		panelPagamento.add(btnDinheiro);
		
		JButton btnCredito = new JButton("Credito");
		btnCredito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedido.getPedidoAtual().setId(facade.efetuaVenda());
				Pedido p = Pedido.getPedidoAtual();
				Pagamento pgto = new Cartao( p.getId(), p.getTotal(), TipoPagamento.CREDITO, "1364","25745-3");
				pgto.setClienteId(idValido());
					
				facade.realizaPagamento(pgto);
				JOptionPane.showMessageDialog(null, "Pagamento por credito realizado com sucesso.");
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(true);
				btnCancelar.setText("Novo Pedido");
			}
		});
		panelPagamento.add(btnCredito);
		
		JButton btnDebito = new JButton("Debito");
		btnDebito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedido.getPedidoAtual().setId(facade.efetuaVenda());
				Pedido p = Pedido.getPedidoAtual();
				Pagamento pgto = new Cartao( p.getId(), p.getTotal(), TipoPagamento.DEBITO, "1364","25745-3");				
				pgto.setClienteId(idValido());
				facade.realizaPagamento(pgto);
				JOptionPane.showMessageDialog(null, "Pagamento por debito realizado com sucesso.");
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(true);
				btnCancelar.setText("Novo Pedido");
			}
		});
		panelPagamento.add(btnDebito);
		
		JButton btnCancelarpg = new JButton("Voltar");
		btnCancelarpg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelOpcoes.setVisible(true);
				panelPagamento.setVisible(false);
			}
		});
		panelPagamento.add(btnCancelarpg);
		
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(FrmVendas.isAtualizada) {
					new FrmAddItem();
			}else
				{
					JOptionPane.showMessageDialog(null, "Atualize a tabela antes");
				}
				popularTabela();
				
			}
		});
		btnPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelPagamento.setVisible(true);
				panelOpcoes.setVisible(false);
				
				
				//frame.dispose();
			}
		});
		
		
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
	
	public void popularTabela()
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
				lista[3] = (item.getTotal());
			
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