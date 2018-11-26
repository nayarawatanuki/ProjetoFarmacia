package br.edu.ifsp.bra.farmacia;


import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.edu.ifsp.bra.dominio.ClienteBLL;
import br.edu.ifsp.bra.modelo.Cliente;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Clientes {

	JFrame frame;
	JPanel panel;
	JLabel lblPesquisa;
	JTextField txtPesquisa;
	JLabel lblClientes;
	JButton btnPesquisa;
	JButton btnAtualizar;
	JButton btnSair;
	private JTable clientes;
	DefaultTableModel model;
	JScrollPane scroll;
	List<Cliente> listaCliente;
	

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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblPesquisa = new JLabel("Nome/Filtro:");
		lblPesquisa.setBounds(10, 9, 81, 14);
		panel.add(lblPesquisa);
		
		txtPesquisa = new JTextField(20);
		txtPesquisa.setBounds(101, 6, 186, 20);
		panel.add(txtPesquisa);
		
		
		
		lblClientes = new JLabel("CLIENTES");
		lblClientes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		btnPesquisa = new JButton("Pesquisa");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteBLL bll = new ClienteBLL();
				listaCliente = bll.PesquisarCliente(txtPesquisa.getText());
				popularTabela(listaCliente);
				
			}
		});
		btnPesquisa.setBounds(297, 5, 97, 23);
		panel.add(btnPesquisa);
		
		btnAtualizar = new JButton("Atualizar");
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(354, 280, 70, 23);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(btnSair);
		
		criarTabela();
		
		clientes = new JTable(model);
		clientes.setBounds(68, 59, 289, 176);
		
		scroll = new JScrollPane(clientes);
		scroll.setBounds(68, 59, 289, 176);

		panel.add(scroll);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente.setClienteAtual(listaCliente.get(clientes.getSelectedRow()));
				frame.dispose();
				FrmCaixa2 caixa = new FrmCaixa2();
			}
		});
		btnConfirmar.setBounds(10, 280, 105, 23);
		panel.add(btnConfirmar);
	
		frame.setVisible(true);
	}
	
	public void criarTabela()
	{
		model = new DefaultTableModel();
		model.addColumn("Nome");
		model.addColumn("CPF");
	}
	public void popularTabela(List<Cliente> clientes)
	{
		for(Cliente cliente : clientes)
		{
			model.addRow(new Object[] {cliente.getNome(), cliente.getCpf()});
		}
	}
}
