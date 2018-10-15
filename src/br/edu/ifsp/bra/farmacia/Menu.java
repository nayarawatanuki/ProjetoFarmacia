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
import br.edu.ifsp.bra.modelo.Caixa.StatusCaixa;
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
		
		JPanel panelAbrirCaixa = new JPanel();
		panelAbrirCaixa.setVisible(false);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(panelAbrirCaixa, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(panelAbrirCaixa, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		JComboBox<StatusCaixa> cbStatus = new JComboBox<>();
		cbStatus.setModel(new DefaultComboBoxModel<>(StatusCaixa.values()));
		
		JLabel lblStatusCaixa = new JLabel("Status Caixa:");
		
		JDateChooser dateAbertura = new JDateChooser();
		dateAbertura.setDateFormatString("yyyy-MM-dd");
		
		JLabel lblDataAbertura = new JLabel("Data de Abertura:");
		
		
		JButton btnAbrirCaixa = new JButton("Abrir Caixa");
		btnAbrirCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbStatus.getSelectedItem() == "NENHUM" || dateAbertura.getCalendar() == null) {
					JOptionPane.showMessageDialog(null, "Favor preencher todos os campos corretamente.");
				}else {

					Funcionario fun = new Funcionario();
					Caixa caixa = new Caixa(
							fun.getId(),
							StatusCaixa.getStatus(cbStatus.getSelectedIndex()),
							dateAbertura.getDate()
							);
					
					/*Caixa caixa = new Caixa();
					caixa.setAtendenteId(fun.getId());
					StatusCaixa.setStatus(StatusCaixa.getStatus(cbStatus.getSelectedIndex()));
					caixa.setDataAbertura(dateAbertura.getDate());*/
					
					
					CaixaDAO dao = new CaixaDAO();
					dao.caixaAberto(caixa);
				}
				try{
					
					CaixaDAO dao = new CaixaDAO();
					Caixa caixa = new Caixa();
					;
					dao.caixaAberto(caixa);
					
					Venda venda = new Venda();
					venda.frame.setVisible(true);
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		GroupLayout gl_panelAbrirCaixa = new GroupLayout(panelAbrirCaixa);
		gl_panelAbrirCaixa.setHorizontalGroup(
			gl_panelAbrirCaixa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAbrirCaixa.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panelAbrirCaixa.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblStatusCaixa)
						.addComponent(lblDataAbertura, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(gl_panelAbrirCaixa.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelAbrirCaixa.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelAbrirCaixa.createParallelGroup(Alignment.LEADING)
								.addComponent(cbStatus, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateAbertura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(61, Short.MAX_VALUE))
						.addGroup(gl_panelAbrirCaixa.createSequentialGroup()
							.addGap(59)
							.addComponent(btnAbrirCaixa)
							.addGap(14))))
		);
		gl_panelAbrirCaixa.setVerticalGroup(
			gl_panelAbrirCaixa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAbrirCaixa.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_panelAbrirCaixa.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStatusCaixa)
						.addComponent(cbStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panelAbrirCaixa.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAbrirCaixa.createSequentialGroup()
							.addGap(16)
							.addComponent(lblDataAbertura))
						.addGroup(gl_panelAbrirCaixa.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(dateAbertura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(btnAbrirCaixa)
					.addGap(18))
		);
		panelAbrirCaixa.setLayout(gl_panelAbrirCaixa);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnCaixa = new JMenu("Caixa");
		menuBar.add(mnCaixa);
		
		JMenuItem mntmIniciar = new JMenuItem("Iniciar");
		mntmIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAbrirCaixa.setVisible(true);
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
