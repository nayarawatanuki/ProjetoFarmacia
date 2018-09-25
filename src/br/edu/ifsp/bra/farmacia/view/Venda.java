package br.edu.ifsp.bra.farmacia.view;

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

public class Venda {

	private JFrame frame;
	private JTable table;

	private static final long serialVersionUID = 1L;
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
		
		
		
		frame.setBounds(100, 100, 797, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblVendas = new JLabel("Vendas");
		lblVendas.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		
		JTextPane txtpnFarmciaTel = new JTextPane();
		txtpnFarmciaTel.setEnabled(false);
		txtpnFarmciaTel.setEditable(false);
		txtpnFarmciaTel.setText("                   \n\n            FARMÁCIA   \n\n       Tel.: 3468-2211");
		
		JTextPane textPane = new JTextPane();
		textPane.setText("TOTAL:");
		textPane.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		textPane.setEnabled(false);
		textPane.setEditable(false);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("SUBTOTAL: ");
		textPane_1.setEnabled(false);
		textPane_1.setEditable(false);
		
		DefaultTableModel model = new DefaultTableModel(); 
		model.addColumn("Produto");
        model.addColumn("Quantidade");
        model.addColumn("Valor");
        model.addColumn("Total");
		
		table_1 = new JTable(model);
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setEnabled(false);
		
		// Append a row 
		model.addRow(new Object[]{"Sabão", 3, 2.50, 7.50});
		table_1.setToolTipText("");
		
		JTextPane txtpnFAdicionar = new JTextPane();
		txtpnFAdicionar.setEditable(false);
		txtpnFAdicionar.setForeground(Color.WHITE);
		txtpnFAdicionar.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		txtpnFAdicionar.setText("\n     F2 - ADICIONAR   F3 - QUANTIDADE   F4 - CONSULTA   F5 - PAGAMENTO   F6 - DESCONTO   F7 - OPÇÕES   F8 - CANCELAR");
		txtpnFAdicionar.setBackground(UIManager.getColor("Focus.color"));
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtpnFAdicionar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(table_1, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblVendas))
							.addGap(246)
							.addComponent(txtpnFarmciaTel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
					.addGap(29))
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
								.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtpnFarmciaTel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
					.addGap(60)
					.addComponent(txtpnFAdicionar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
