package br.edu.ifsp.bra.farmacia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;

import br.edu.ifsp.bra.dominio.ItemPedidoBLL;
import br.edu.ifsp.bra.dominio.MedicamentoBLL;
import br.edu.ifsp.bra.dominio.PedidoBLL;
import br.edu.ifsp.bra.modelo.ItemPedido;
import br.edu.ifsp.bra.modelo.Medicamento;

import java.util.Set;
import javax.swing.JScrollPane;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class Venda {

	JFrame frame;
	private JTable tableItemPedidos;
	private JTextField txtDesconto;
	private JTable tableCodigosProdutos;
	public PedidoBLL PedBLL = new PedidoBLL();
	public ItemPedidoBLL ItemPedBLL = new ItemPedidoBLL();
	DefaultTableModel model = new DefaultTableModel();
	private JTextField txtTotal;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Venda window = new Venda();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private void popularTabela(DefaultTableModel model)
	{
		ItemPedidoBLL ItemPedBLL = new ItemPedidoBLL();
		
		Set<ItemPedido> list = ItemPedBLL.getItens();
		
		for(ItemPedido ped : list)
		{
			MedicamentoBLL medBLL = new MedicamentoBLL();
			
			Set<Medicamento> listmed = medBLL.getTodosMedicamento();
			
			for(Medicamento med : listmed) {
				model.addRow(new Object[] {ped.getPedidoId(), ped.getProdutoId(), med.getDescricao(),
						ped.getQuantidade(), ped.getPreco()});
			}
			
		}
	}
	
	private void criarTabela()
	{
		
		model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("ProdutoId");
		model.addColumn("Descricao");
		model.addColumn("Quantidade");
		model.addColumn("Total");
		popularTabela(model);

	}
	
	private String calcularVenda() {
		Double total = 0.00;
        for (int i = 0; i < tableItemPedidos.getRowCount(); i++){
            total += Double.parseDouble(tableItemPedidos.getValueAt(i, 4).toString());
        }
        return total.toString();
	}

	/**
	 * Create the application.
	 */
	public Venda() {
		initialize();
		frame.setLocationRelativeTo(null);
	}
	
	/*public void keyPressed(KeyEvent e) {
		//JTextPane txtpnFAdicionar = new JTextPane();
	    if (e.getKeyCode() == KeyEvent.VK_1) {
	    	txtpnFAdicionar.setText("\n     F5 - SALVAR   ESC - CANCELAR");
	    	System.out.println(" F5 - SALVAR   ESC - CANCELAR");
	    }
	}*/

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1220, 708);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		criarTabela();
		
		
		JLabel lblVendas = new JLabel("Vendas");
		lblVendas.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		
		JTextPane txtpnFarmciaTel = new JTextPane();
		txtpnFarmciaTel.setEnabled(false);
		txtpnFarmciaTel.setEditable(false);
		txtpnFarmciaTel.setText("                   \n\n            FARMÁCIA   \n\n       Tel.: 3468-2211");
		
		
		
		JPanel panelMenu = new JPanel();
		
		JPanel panelAdd = new JPanel();
		panelAdd.setVisible(false);
		
		JPanel panelDesconto = new JPanel();
		panelDesconto.setBorder(new TitledBorder(null, "Desconto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDesconto.setVisible(false);
		
		JPanel panelPagamento = new JPanel();
		panelPagamento.setVisible(false);
		
		JPanel panelConsulta = new JPanel();
		panelConsulta.setVisible(false);
		
		JPanel panelOpcoes = new JPanel();
		panelOpcoes.setVisible(false);
		
		JPanel panelProdutos = new JPanel();
		panelProdutos.setBorder(new TitledBorder(null, "C\u00F3digos dos Produtos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelProdutos.setVisible(false);
		
		JPanel panelItens = new JPanel();
		panelItens.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Itens", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panelQtd = new JPanel();
		panelQtd.setVisible(false);
		
		JPanel panelDesc = new JPanel();
		panelDesc.setVisible(false);
		
		JPanel panelCaixa = new JPanel();
		panelCaixa.setBorder(new TitledBorder(null, "Caixa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelOpcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panelAdd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelQtd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelConsulta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelPagamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(180))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblVendas)
										.addComponent(panelCaixa, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(panelItens, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(18)
											.addComponent(panelDesconto, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
											.addComponent(txtpnFarmciaTel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
											.addContainerGap(48, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(201)
											.addComponent(panelProdutos, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
											.addContainerGap())))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(22)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtpnFarmciaTel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblVendas, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(panelCaixa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(panelItens, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(178)
									.addComponent(panelDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelProdutos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(75)))
					.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelAdd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelQtd, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelConsulta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelPagamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelOpcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(67))
		);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblStatus = new JLabel("Status");
		GroupLayout gl_panelCaixa = new GroupLayout(panelCaixa);
		gl_panelCaixa.setHorizontalGroup(
			gl_panelCaixa.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelCaixa.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addGroup(gl_panelCaixa.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblStatus)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE))
					.addGap(16))
		);
		gl_panelCaixa.setVerticalGroup(
			gl_panelCaixa.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelCaixa.createSequentialGroup()
					.addComponent(lblStatus)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelCaixa.setLayout(gl_panelCaixa);
		
		JButton btnSalvardesc = new JButton("Salvar");
		btnSalvardesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemPedido itempedido = new ItemPedido();
				ItemPedidoBLL itempedidoBLL = new ItemPedidoBLL();
				
				double desconto = Double.parseDouble(txtDesconto.getText()) / 100;
				double preco = Double.parseDouble(txtTotal.getText()) * desconto;
				
				itempedidoBLL.modificar(itempedido);
			}
		});
		panelDesc.add(btnSalvardesc);
		
		JButton btnCancelardesc = new JButton("Cancelar");
		panelDesc.add(btnCancelardesc);
		
		JButton btnSalvarqtd = new JButton("Salvar");
		btnSalvarqtd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelAdd.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
				panelQtd.setVisible(false);
				panelDesc.setVisible(false);
				
				Double total = 0.00;
		        for (int i = 0; i < tableItemPedidos.getRowCount(); i++){
		            total += Double.parseDouble(tableItemPedidos.getValueAt(i, 4).toString());
		            txtTotal.setText(total.toString());
		        }
				
				ItemPedido itempedido = new ItemPedido();
				itempedido.setPedidoId((int)tableItemPedidos.getModel().getValueAt(tableItemPedidos.getSelectedRow(), 0));
				itempedido.setProdutoId((int)tableItemPedidos.getModel().getValueAt(tableItemPedidos.getSelectedRow(), 1));
				itempedido.setQuantidade((int)tableItemPedidos.getModel().getValueAt(tableItemPedidos.getSelectedRow(), 3));
				itempedido.setPreco((Double)tableItemPedidos.getModel().getValueAt(tableItemPedidos.getSelectedRow(), 4));				
				ItemPedBLL.modificar(itempedido);
			}
		});
		panelQtd.add(btnSalvarqtd);
		
		JButton btnCancelarqtd = new JButton("Cancelar");
		btnCancelarqtd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelAdd.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
				panelQtd.setVisible(false);
				panelDesc.setVisible(false);
			}
		});
		panelQtd.add(btnCancelarqtd);
		
		tableItemPedidos = new JTable(model);	
		tableItemPedidos.setColumnSelectionAllowed(true);
		tableItemPedidos.setCellSelectionEnabled(true);
		
		JScrollPane scrlPaneItemPedidos = new JScrollPane(tableItemPedidos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setViewportBorder(new TitledBorder(null, "TOTAL:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panelItens = new GroupLayout(panelItens);
		gl_panelItens.setHorizontalGroup(
			gl_panelItens.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelItens.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panelItens.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPane, Alignment.LEADING)
						.addComponent(scrlPaneItemPedidos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_panelItens.setVerticalGroup(
			gl_panelItens.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelItens.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrlPaneItemPedidos, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		txtTotal = new JTextField();
		txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotal.setText(calcularVenda().toString());
		txtTotal.setEditable(false);
		scrollPane.setViewportView(txtTotal);
		txtTotal.setColumns(10);
		panelItens.setLayout(gl_panelItens);
		
		tableCodigosProdutos = new JTable();
		GroupLayout gl_panelProdutos = new GroupLayout(panelProdutos);
		gl_panelProdutos.setHorizontalGroup(
			gl_panelProdutos.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelProdutos.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addComponent(tableCodigosProdutos, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addGap(14))
		);
		gl_panelProdutos.setVerticalGroup(
			gl_panelProdutos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProdutos.createSequentialGroup()
					.addContainerGap()
					.addComponent(tableCodigosProdutos, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panelProdutos.setLayout(gl_panelProdutos);
		
		JButton btnTrocarUsuario = new JButton("Trocar Usuário");
		btnTrocarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				try {
					FrmLogin window = new FrmLogin();
					window.frame.setVisible(true);
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
				
			}
		});
		panelOpcoes.add(btnTrocarUsuario);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelOpcoes.add(btnClientes);
		
		JButton btnVoltarOpcoes = new JButton("Voltar");
		btnVoltarOpcoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelAdd.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
				panelQtd.setVisible(false);
				panelDesc.setVisible(false);
			}
		});
		panelOpcoes.add(btnVoltarOpcoes);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelAdd.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
				panelQtd.setVisible(false);
				panelDesc.setVisible(false);
			}
		});
		panelConsulta.add(btnFechar);
		
		JButton btnDinheiro = new JButton("Dinheiro");
		btnDinheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelAdd.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
				panelQtd.setVisible(false);
				panelDesc.setVisible(false);
				
				/*Pagamento pg = new Pagamento();
				pg.setTipo(TipoPagamento.DINHEIRO);*/
			}
		});
		panelPagamento.add(btnDinheiro);
		
		JButton btnDebito = new JButton("Débito");
		btnDebito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelAdd.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
				panelQtd.setVisible(false);
				panelDesc.setVisible(false);
				
				/*Pagamento pg = new Pagamento();
				pg.setTipo(TipoPagamento.DEBITO);*/
			}
		});
		panelPagamento.add(btnDebito);
		
		JButton btnCredito = new JButton("Crédito");
		btnCredito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelAdd.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
				panelQtd.setVisible(false);
				panelDesc.setVisible(false);
				
				/*Pagamento pg = new Pagamento();
				pg.setTipo(TipoPagamento.CREDITO);*/
			}
		});
		panelPagamento.add(btnCredito);
		panelDesconto.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtDesconto = new JTextField();
		txtDesconto.setColumns(10);
		panelDesconto.add(txtDesconto);
		
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelAdd.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
				panelQtd.setVisible(false);
				panelDesc.setVisible(false);
				
				try {
					ItemPedido itempedido = new ItemPedido();
					
					itempedido.setProdutoId((int)tableItemPedidos.getModel().getValueAt(tableItemPedidos.getSelectedRow(), 1));
					itempedido.setQuantidade((int)tableItemPedidos.getModel().getValueAt(tableItemPedidos.getSelectedRow(), 3));		
					itempedido.setPreco((Double)tableItemPedidos.getModel().getValueAt(tableItemPedidos.getSelectedRow(), 4));			
					ItemPedBLL.adicionaItens(itempedido);
				}catch (Exception ex) {
					ex.printStackTrace();
				}
				
				
				
			}
		});
		
		JButton btnVoltar = new JButton("Cancelar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelAdd.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
				panelQtd.setVisible(false);
				panelDesc.setVisible(false);
			}
		});
		panelAdd.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelAdd.add(btnSalvar);
		panelAdd.add(btnVoltar);
		
		JButton btnAdicionar = new JButton("Adicionar");
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					panelAdd.setVisible(true);
					panelMenu.setVisible(false);
					panelConsulta.setVisible(false);
					panelDesconto.setVisible(false);
					panelPagamento.setVisible(false);
					panelOpcoes.setVisible(false);
					panelProdutos.setVisible(false);
					panelQtd.setVisible(false);
					panelDesc.setVisible(false);
					
					AdicionarItemPedido addItem = new AdicionarItemPedido();
					addItem.frame.setVisible(true);
				
		        }catch(Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Cadastro \n\n" + "\nFalha na inclusão de Produto.", "Venda", JOptionPane.INFORMATION_MESSAGE);
					ex.printStackTrace();
				}
			}
		});
		
		panelMenu.add(btnAdicionar);
		
		JButton btnQuantidade = new JButton("Quantidade");
		btnQuantidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelQtd.setVisible(true);
				panelAdd.setVisible(false);
				panelMenu.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
				panelDesc.setVisible(false);
			}
		});
		panelMenu.add(btnQuantidade);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelConsulta.setVisible(true);
				panelProdutos.setVisible(true);
				panelMenu.setVisible(false);
				panelDesconto.setVisible(false);
				panelAdd.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelQtd.setVisible(false);
				panelDesc.setVisible(false);
			}
		});
		panelMenu.add(btnConsulta);
		
		JButton btnPagamento = new JButton("Pagamento");
		btnPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPagamento.setVisible(true);
				panelMenu.setVisible(false);
				panelAdd.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
				panelQtd.setVisible(false);
				panelDesc.setVisible(false);
			}
		});
		panelMenu.add(btnPagamento);
		
		JButton btnDesconto = new JButton("Desconto");
		btnDesconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDesc.setVisible(true);
				panelDesconto.setVisible(true);
				panelMenu.setVisible(false);
				panelAdd.setVisible(false);
				panelConsulta.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
				panelQtd.setVisible(false);
			}
		});
		panelMenu.add(btnDesconto);
		
		JButton btnOpcoes = new JButton("Opções");
		btnOpcoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelOpcoes.setVisible(true);
				panelMenu.setVisible(false);
				panelAdd.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelProdutos.setVisible(false);
				panelQtd.setVisible(false);
				panelDesc.setVisible(false);
			}
		});
		panelMenu.add(btnOpcoes);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panelMenu.add(btnCancelar);
		
		frame.getContentPane().setLayout(groupLayout);
	}
}
