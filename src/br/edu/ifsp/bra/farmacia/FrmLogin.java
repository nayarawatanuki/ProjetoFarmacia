package br.edu.ifsp.bra.farmacia;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import br.edu.ifsp.bra.dominio.CaixaBLL;
import br.edu.ifsp.bra.dominio.FuncionarioBLL;
import br.edu.ifsp.bra.dominio.LoginBLL;
import br.edu.ifsp.bra.modelo.Caixa;
import br.edu.ifsp.bra.modelo.Funcionario;
import br.edu.ifsp.bra.modelo.Login;

public class FrmLogin {

	private JFrame frame;
	private JPasswordField pwdSenha = new JPasswordField();
	private CaixaBLL caixaBLL = new CaixaBLL();
	private FuncionarioBLL funcionarioBLL = new FuncionarioBLL();

	/*
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin window = new FrmLogin();
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
	public FrmLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Farmácia IFSP - Entrar");
		frame.setBounds(100, 100, 346, 273);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Entrar", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JLabel lblUsuario = new JLabel("Usuário:");
		JLabel lblSenha = new JLabel("Senha:");
		JLabel lblCaixa = new JLabel("Caixa:");

		JComboBox<Caixa> comboBox = new JComboBox<Caixa>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {""}));
		for (Caixa c : caixaBLL.getTodosCaixas()) {
			comboBox.addItem(c);
		}

		JComboBox<Funcionario> cmbUsuario = new JComboBox<Funcionario>();
		for (Funcionario f : funcionarioBLL.getTodosFuncionarios()) {
			cmbUsuario.addItem(f);
		}

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGap(23)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblCaixa, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(comboBox, 0, 130, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblUsuario)
												.addComponent(lblSenha))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(pwdSenha, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
												.addComponent(cmbUsuario, 0, 130, Short.MAX_VALUE))))
						.addGap(28))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGap(15)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsuario)
								.addComponent(cmbUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSenha)
								.addComponent(pwdSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCaixa)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(16, Short.MAX_VALUE))
				);

		panel.setLayout(gl_panel);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbUsuario.getSelectedItem() == "" || pwdSenha.getPassword().toString() == "" || comboBox.getSelectedItem() == "") {
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
					return;
				}

				try {
					Login login = new Login();
					LoginBLL bll = new LoginBLL();
					CaixaBLL c = new CaixaBLL();

					login.setLogin(((Funcionario)cmbUsuario.getSelectedItem()).getUsuario());
					login.setSenha(String.valueOf(pwdSenha.getPassword()));
					
					if (!bll.Logar(login)) {
						JOptionPane.showMessageDialog(new JFrame(), "Usuário e/ou senha inválido(s).", "Autenticação", JOptionPane.INFORMATION_MESSAGE);
						return;
					}

					Funcionario.setFuncionarioAtual((Funcionario) cmbUsuario.getSelectedItem());
					Caixa.setCaixaAtual(c.getCaixa(comboBox.getSelectedIndex()));

					FrmAbertura abertura = new FrmAbertura();
					abertura.frame.setVisible(true);
					
					frame.dispose();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(49)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEntrar))
						.addContainerGap(51, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addContainerGap(19, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnEntrar)
						.addGap(20))
				);
		frame.getContentPane().setLayout(groupLayout);
	}
}
