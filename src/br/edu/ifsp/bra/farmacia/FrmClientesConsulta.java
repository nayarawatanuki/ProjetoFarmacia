package br.edu.ifsp.bra.farmacia;


import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.edu.ifsp.bra.dominio.ClienteBLL;
import br.edu.ifsp.bra.modelo.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FrmClientesConsulta {

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
	private JPanel panel_1;
	private JLabel lblClientes_1;
	

	/**
	 * Create the application.
	 */
	public FrmClientesConsulta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 402);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel);
		
		
		
		lblClientes = new JLabel("CLIENTES");
		lblClientes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		btnAtualizar = new JButton("Atualizar");
		
		criarTabela();
		
		panel_1 = new JPanel();
		
		lblClientes_1 = new JLabel("FARMACIA - CLIENTES");
		lblClientes_1.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblClientes_1)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(lblClientes_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		lblPesquisa = new JLabel("Nome/Filtro:");
		
		txtPesquisa = new JTextField(20);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		clientes = new JTable(model);
		clientes.setBounds(68, 59, 289, 176);
		
		scroll = new JScrollPane(clientes);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cliente.setClienteAtual(listaCliente.get(clientes.getSelectedRow()));
					
					FrmVendas.lblCliente.setText("Cliente: " + Cliente.getClienteAtual().getNome());
					
					frame.dispose();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione o cliente.");
					e1.getStackTrace();
				}
				
			}
		});
		
		btnPesquisa = new JButton("Pesquisa");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtPesquisa.getText().equals(""))
				{
					ClienteBLL bll = new ClienteBLL();
					listaCliente = bll.PesquisarCliente(txtPesquisa.getText());
					popularTabela(listaCliente);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Campo Pesquisar em branco");
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(6)
									.addComponent(lblPesquisa))
								.addComponent(txtPesquisa, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))
							.addGap(5)
							.addComponent(btnPesquisa, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(1)
							.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(210)
							.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(18, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblPesquisa, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(txtPesquisa, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(13)
							.addComponent(btnPesquisa, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGap(20)
					.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(14))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
	
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
