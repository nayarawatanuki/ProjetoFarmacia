package br.edu.ifsp.bra.farmacia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.MenuKeyListener;
import java.awt.Event;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;

public class Venda {

	private JFrame frame;
	private JTextPane txtpnFAdicionar;
	
	private JTable table_1;
	private JTextField txtDesconto;
	
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
		//table_1.setSurrendersFocusOnKeystroke(true);
		//table_1.setEnabled(true);
		
		// Append a row 
		model.addRow(new Object[]{"Sabão", 3, 2.50, 7.50});
		
		JPanel panelMenu = new JPanel();
		
		JPanel panelAddQtdDesc = new JPanel();
		panelAddQtdDesc.setVisible(false);
		
		JPanel panelDesconto = new JPanel();
		panelDesconto.setBorder(new TitledBorder(null, "Desconto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDesconto.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Caixa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panelPagamento = new JPanel();
		
		JPanel panelConsulta = new JPanel();
		
		JPanel panelOpcoes = new JPanel();
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelOpcoes, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, 788, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panelAddQtdDesc, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(panelPagamento, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelConsulta, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addGap(301))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblVendas))
								.addGap(60)
								.addComponent(panelDesconto, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
								.addComponent(txtpnFarmciaTel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addGap(51)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblVendas, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(81)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panelConsulta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(panelPagamento, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(panelAddQtdDesc, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addComponent(txtpnFarmciaTel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelOpcoes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(170))
		);
		
		JButton btnTrocarUsuario = new JButton("Trocar Usuário");
		panelOpcoes.add(btnTrocarUsuario);
		
		JButton btnCancelarItem = new JButton("Cancelar Item");
		panelOpcoes.add(btnCancelarItem);
		
		JButton btnFechar = new JButton("Fechar");
		panelConsulta.add(btnFechar);
		
		JButton btnDinheiro = new JButton("Dinheiro");
		panelPagamento.add(btnDinheiro);
		
		JButton btnDebito = new JButton("Débito");
		panelPagamento.add(btnDebito);
		
		JButton btnCredito = new JButton("Crédito");
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
		
		table_1 = new JTable(model);
		table_1.setToolTipText("");
		
		JTextPane txtpnSubtotal = new JTextPane();
		txtpnSubtotal.setText("SUBTOTAL:");
		txtpnSubtotal.setEnabled(false);
		txtpnSubtotal.setEditable(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(table_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnTotal, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtpnSubtotal, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))
					.addGap(14))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnSubtotal, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
						.addComponent(txtpnTotal, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
		);
		panel.setLayout(gl_panel);
		panelDesconto.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtDesconto = new JTextField();
		txtDesconto.setColumns(10);
		panelDesconto.add(txtDesconto);
		
		JButton btnSalvar = new JButton("Salvar");
		
		JButton btnVoltar = new JButton("Cancelar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelAddQtdDesc.setVisible(false);
				panelDesconto.setVisible(false);
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
			}
		});
		panelMenu.add(btnQuantidade);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelConsulta.setVisible(true);
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
			}
		});
		panelMenu.add(btnPagamento);
		
		JButton btnDesconto = new JButton("Desconto");
		btnDesconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDesconto.setVisible(true);
				panelMenu.setVisible(false);
				panelAddQtdDesc.setVisible(true);
			}
		});
		panelMenu.add(btnDesconto);
		
		JButton btnOpcoes = new JButton("Opções");
		panelMenu.add(btnOpcoes);
		
		JButton btnCancelar = new JButton("Cancelar");
		panelMenu.add(btnCancelar);
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(false);
				panelAddQtdDesc.setVisible(true);
				
			}
		});
		
		frame.getContentPane().setLayout(groupLayout);
	}
}
