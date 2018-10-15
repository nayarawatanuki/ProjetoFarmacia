package br.edu.ifsp.bra.farmacia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.edu.ifsp.bra.banco.CaixaDAO;
import br.edu.ifsp.bra.dominio.CaixaBLL;
import br.edu.ifsp.bra.modelo.Caixa;

import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTree;

public class Menu {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 354, 237);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"NENHUM", "ABERTO", "FECHADO"}));
		
		JLabel lblStatusCaixa = new JLabel("Status Caixa:");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(14)
					.addComponent(lblStatusCaixa)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(103, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStatusCaixa)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnCaixa = new JMenu("Caixa");
		menuBar.add(mnCaixa);
		
		JMenuItem mntmIniciar = new JMenuItem("Iniciar");
		mntmIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					CaixaDAO dao = new CaixaDAO();
					Caixa caixa = new Caixa();
					dao.caixaAberto(caixa);
					
					Venda venda = new Venda();
					venda.frame.setVisible(true);
				}catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		mnCaixa.add(mntmIniciar);
		
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
					ClienteCadastro cliente = new ClienteCadastro();
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
					Clientes cliente = new Clientes();
					cliente.frame.setVisible(true);
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		mnClientes.add(mntmConsultaC);
	}
}
