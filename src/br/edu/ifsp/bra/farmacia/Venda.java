package br.edu.ifsp.bra.farmacia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;

import br.edu.ifsp.bra.farmacia.Login;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Venda {

	private JFrame frame;
	
	private JTable tableItemPedidos;
	private JTextField txtDesconto;
	private JTable tableCodigosProdutos;
	
	
	
	
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

	/**
	 * Create the application.
	 */
	public Venda() {
		initialize();
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
		/*frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_1) {
					btnAdicionar.setVisible(false);
					
				}
			}
		});*/
	
		
		frame.setBounds(100, 100, 972, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblVendas = new JLabel("Vendas");
		lblVendas.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		
		JTextPane txtpnFarmciaTel = new JTextPane();
		txtpnFarmciaTel.setEnabled(false);
		txtpnFarmciaTel.setEditable(false);
		txtpnFarmciaTel.setText("                   \n\n            FARMÁCIA   \n\n       Tel.: 3468-2211");
		
		
		String[] colunas = new String []{"ID","NOME", "CPF", "preco"};
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(colunas);
		
		// Append a row 
		model.addRow(new Object[]{"Sabão", 3, 2.50, 7.50});
		
		JPanel panelMenu = new JPanel();
		
		JPanel panelAddQtdDesc = new JPanel();
		panelAddQtdDesc.setVisible(false);
		
		JPanel panelDesconto = new JPanel();
		panelDesconto.setBorder(new TitledBorder(null, "Desconto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDesconto.setVisible(false);
		
		JPanel panelCaixa = new JPanel();
		panelCaixa.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Caixa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panelPagamento = new JPanel();
		panelPagamento.setVisible(false);
		
		JPanel panelConsulta = new JPanel();
		panelConsulta.setVisible(false);
		
		JPanel panelOpcoes = new JPanel();
		panelOpcoes.setVisible(false);
		
		JPanel panelProdutos = new JPanel();
		panelProdutos.setBorder(new TitledBorder(null, "C\u00F3digos dos Produtos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelProdutos.setVisible(false);
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelOpcoes, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, 788, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panelAddQtdDesc, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(panelPagamento, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panelConsulta, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
									.addGap(550))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblVendas)
										.addComponent(panelCaixa, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(60)
											.addComponent(panelDesconto, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
											.addComponent(txtpnFarmciaTel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
											.addGap(51))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(75)
											.addComponent(panelProdutos, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
											.addContainerGap())))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblVendas, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(panelDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panelProdutos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(36))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(30)
									.addComponent(panelCaixa, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addComponent(txtpnFarmciaTel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(panelAddQtdDesc, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(panelPagamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelConsulta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelOpcoes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(54))
		);
		
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
					Login window = new Login();
					window.frame.setVisible(true);
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
				
			}
		});
		panelOpcoes.add(btnTrocarUsuario);
		
		JButton btnCancelarItem = new JButton("Cancelar Item");
		panelOpcoes.add(btnCancelarItem);
		
		JButton btnVoltarOpcoes = new JButton("Voltar");
		btnVoltarOpcoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelAddQtdDesc.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
			}
		});
		panelOpcoes.add(btnVoltarOpcoes);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelAddQtdDesc.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
			}
		});
		panelConsulta.add(btnFechar);
		
		JButton btnDinheiro = new JButton("Dinheiro");
		btnDinheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelAddQtdDesc.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
			}
		});
		panelPagamento.add(btnDinheiro);
		
		JButton btnDebito = new JButton("Débito");
		btnDebito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelAddQtdDesc.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
			}
		});
		panelPagamento.add(btnDebito);
		
		JButton btnCredito = new JButton("Crédito");
		btnCredito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelAddQtdDesc.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
			}
		});
		panelPagamento.add(btnCredito);
		
		JTextPane txtpnTotal = new JTextPane();
		txtpnTotal.setText("TOTAL:");
		txtpnTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		txtpnTotal.setEnabled(false);
		txtpnTotal.setEditable(false);
		//model.addColumn("Produto");
        //model.addColumn("Quantidade");
        //model.addColumn("Valor");
        //model.addColumn("Total");
		
		tableItemPedidos = new JTable(model);
		tableItemPedidos.setToolTipText("");
		
		JTextPane txtpnSubtotal = new JTextPane();
		txtpnSubtotal.setText("SUBTOTAL:");
		txtpnSubtotal.setEnabled(false);
		txtpnSubtotal.setEditable(false);
		GroupLayout gl_panelCaixa = new GroupLayout(panelCaixa);
		gl_panelCaixa.setHorizontalGroup(
			gl_panelCaixa.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCaixa.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCaixa.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(tableItemPedidos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panelCaixa.createSequentialGroup()
							.addComponent(txtpnTotal, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtpnSubtotal, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))
					.addGap(14))
		);
		gl_panelCaixa.setVerticalGroup(
			gl_panelCaixa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCaixa.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCaixa.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnSubtotal, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
						.addComponent(txtpnTotal, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tableItemPedidos, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
		);
		panelCaixa.setLayout(gl_panelCaixa);
		panelDesconto.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtDesconto = new JTextField();
		txtDesconto.setColumns(10);
		panelDesconto.add(txtDesconto);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelAddQtdDesc.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
			}
		});
		
		JButton btnVoltar = new JButton("Cancelar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelAddQtdDesc.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
			}
		});
		panelAddQtdDesc.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelAddQtdDesc.add(btnSalvar);
		panelAddQtdDesc.add(btnVoltar);
		
		JButton btnAdicionar = new JButton("Adicionar");
		panelMenu.add(btnAdicionar);
		
		JButton btnQuantidade = new JButton("Quantidade");
		btnQuantidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAddQtdDesc.setVisible(true);
				panelMenu.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
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
				panelAddQtdDesc.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
			}
		});
		panelMenu.add(btnConsulta);
		
		JButton btnPagamento = new JButton("Pagamento");
		btnPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPagamento.setVisible(true);
				panelMenu.setVisible(false);
				panelAddQtdDesc.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
			}
		});
		panelMenu.add(btnPagamento);
		
		JButton btnDesconto = new JButton("Desconto");
		btnDesconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDesconto.setVisible(true);
				panelMenu.setVisible(false);
				panelAddQtdDesc.setVisible(true);
				panelConsulta.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
			}
		});
		panelMenu.add(btnDesconto);
		
		JButton btnOpcoes = new JButton("Opções");
		btnOpcoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelOpcoes.setVisible(true);
				panelMenu.setVisible(false);
				panelAddQtdDesc.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelProdutos.setVisible(false);
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
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAddQtdDesc.setVisible(true);
				panelMenu.setVisible(false);
				panelConsulta.setVisible(false);
				panelDesconto.setVisible(false);
				panelPagamento.setVisible(false);
				panelOpcoes.setVisible(false);
				panelProdutos.setVisible(false);
				
			}
		});
		
		frame.getContentPane().setLayout(groupLayout);
	}
}
