package br.edu.ifsp.bra.farmacia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import br.edu.ifsp.bra.banco.CaixaDAO;
import br.edu.ifsp.bra.modelo.Caixa;
//import br.edu.ifsp.bra.modelo.Caixa.StatusCaixa;
import br.edu.ifsp.bra.modelo.Funcionario;

import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

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
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 354, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 193, Short.MAX_VALUE)
		);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnVendas = new JMenu("Vendas");
		menuBar.add(mnVendas);
		
		JMenuItem mntmIniciar = new JMenuItem("Iniciar");
		mntmIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					FrmVenda venda = new FrmVenda();
					venda.frame.setVisible(true);
					
					frame.dispose();
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		mnVendas.add(mntmIniciar);
		
		JMenu mnMedicamentos = new JMenu("Medicamentos");
		menuBar.add(mnMedicamentos);
		
		JMenuItem mntmCadastroM = new JMenuItem("Cadastro");
		mntmCadastroM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					FrmCadastroMed med = new FrmCadastroMed();
					med.frame.setVisible(true);
					
					frame.dispose();
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
					
					frame.dispose();
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
					
					frame.dispose();
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
					
					frame.dispose();
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		mnClientes.add(mntmConsultaC);
	}
}
