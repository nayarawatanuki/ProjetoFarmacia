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

public class Venda {

	private JFrame frame;
	private JTextPane txtpnFAdicionar;
	
	private JTable table_1;
	
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
		
		
		frame.setBounds(100, 100, 899, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblVendas = new JLabel("Vendas");
		lblVendas.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		
		JTextPane txtpnFarmciaTel = new JTextPane();
		txtpnFarmciaTel.setEnabled(false);
		txtpnFarmciaTel.setEditable(false);
		txtpnFarmciaTel.setText("                   \n\n            FARMÁCIA   \n\n       Tel.: 3468-2211");
		
		JTextPane txtpnTotal = new JTextPane();
		txtpnTotal.setText("TOTAL:");
		txtpnTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		txtpnTotal.setEnabled(false);
		txtpnTotal.setEditable(false);
		
		JTextPane txtpnSubtotal = new JTextPane();
		txtpnSubtotal.setText("SUBTOTAL:");
		txtpnSubtotal.setEnabled(false);
		txtpnSubtotal.setEditable(false);
		
		
		String[] colunas = new String []{"ID","NOME", "CPF", "preco"};
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(colunas);
		//model.addColumn("Produto");
        //model.addColumn("Quantidade");
        //model.addColumn("Valor");
        //model.addColumn("Total");
		
		table_1 = new JTable(model);
		//table_1.setSurrendersFocusOnKeystroke(true);
		//table_1.setEnabled(true);
		
		// Append a row 
		model.addRow(new Object[]{"Sabão", 3, 2.50, 7.50});
		table_1.setToolTipText("");
		
		JPanel panelMenu = new JPanel();
		
		JPanel panelAddQtdDesc = new JPanel();
		panelAddQtdDesc.setVisible(false);
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelAddQtdDesc, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelMenu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(table_1, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(txtpnTotal, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtpnSubtotal, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblVendas))
									.addGap(246)
									.addComponent(txtpnFarmciaTel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
							.addGap(73))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblVendas, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnSubtotal, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnTotal, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtpnFarmciaTel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(panelAddQtdDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(17))
		);
		
		JButton btnSalvar = new JButton("Salvar");
		
		JButton btnVoltar = new JButton("Cancelar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelAddQtdDesc.setVisible(false);
			}
		});
		GroupLayout gl_panelAddQtdDesc = new GroupLayout(panelAddQtdDesc);
		gl_panelAddQtdDesc.setHorizontalGroup(
			gl_panelAddQtdDesc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAddQtdDesc.createSequentialGroup()
					.addGap(14)
					.addComponent(btnSalvar)
					.addGap(5)
					.addComponent(btnVoltar)
					.addContainerGap(331, Short.MAX_VALUE))
		);
		gl_panelAddQtdDesc.setVerticalGroup(
			gl_panelAddQtdDesc.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelAddQtdDesc.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelAddQtdDesc.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSalvar)
						.addComponent(btnVoltar)))
		);
		panelAddQtdDesc.setLayout(gl_panelAddQtdDesc);
		
		JButton btnAdicionar = new JButton("Adicionar");
		panelMenu.add(btnAdicionar);
		
		JButton btnQuantidade = new JButton("Quantidade");
		panelMenu.add(btnQuantidade);
		
		JButton btnConsulta = new JButton("Consulta");
		panelMenu.add(btnConsulta);
		
		JButton btnPagamento = new JButton("Pagamento");
		panelMenu.add(btnPagamento);
		
		JButton btnDesconto = new JButton("Desconto");
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
