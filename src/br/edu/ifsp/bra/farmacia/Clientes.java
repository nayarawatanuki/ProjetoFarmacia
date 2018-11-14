package br.edu.ifsp.bra.farmacia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Clientes {

	JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes window = new Clientes();
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
	public Clientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable();
		
		JLabel lblCpf = new JLabel("CPF/Nome:");
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblClientes = new JLabel("CLIENTES");
		lblClientes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JButton btnNovaVenda = new JButton("Nova FrmVenda");
		
		JButton btnAtualizar = new JButton("Atualizar");
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblClientes)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(table, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCpf)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox, 0, 302, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNovaVenda)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAtualizar)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSair)))
							.addGap(37))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblClientes)
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNovaVenda)
						.addComponent(btnAtualizar)
						.addComponent(btnSair))
					.addGap(19))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
