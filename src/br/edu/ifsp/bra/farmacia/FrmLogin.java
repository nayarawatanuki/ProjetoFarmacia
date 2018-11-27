package br.edu.ifsp.bra.farmacia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import br.edu.ifsp.bra.dominio.CaixaBLL;
import br.edu.ifsp.bra.dominio.FuncionarioBLL;
import br.edu.ifsp.bra.dominio.LoginBLL;
import br.edu.ifsp.bra.modelo.Caixa;
import br.edu.ifsp.bra.modelo.Funcionario;
import br.edu.ifsp.bra.modelo.Login;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmLogin {

	JFrame frame;
	private JButton btnEntrar;
	private JPasswordField pwdSenha;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 346, 273);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblUser = new JLabel("User:");
		
		JLabel lblSenha = new JLabel("Senha:");
		
		pwdSenha = new JPasswordField();
		
		JLabel lblCaixa = new JLabel("Caixa:");
		
		CaixaBLL cx = new CaixaBLL();
		List<Caixa> caixas = cx.getTodosCaixas();
		
		JComboBox<Caixa> comboBox = new JComboBox<Caixa>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {""}));
		for (Caixa c : caixas) {
			comboBox.addItem(c);
		}
		
		FuncionarioBLL func = new FuncionarioBLL();
		List<Funcionario> fun = func.getTodosFuncionarios();
		
		JComboBox<Funcionario> cbxUser = new JComboBox<Funcionario>();
		
		for (Funcionario f : fun) {
			cbxUser.addItem(f);
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
								.addComponent(lblUser)
								.addComponent(lblSenha))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(pwdSenha, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addComponent(cbxUser, 0, 130, Short.MAX_VALUE))))
					.addGap(28))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUser)
						.addComponent(cbxUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cbxUser.getSelectedItem() == "" || pwdSenha.getPassword().toString() == "" || comboBox.getSelectedItem() == "") {
					
					JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
				
				}else{
				
					try {
						Login login = new Login();
						LoginBLL bll = new LoginBLL();
						CaixaBLL c = new CaixaBLL();
						
						
						login.setLogin(((Funcionario)cbxUser.getSelectedItem()).getUsuario());
						login.setSenha(pwdSenha.getText());
						
						
						
						if(bll.Logar(login))
						{
						
							Funcionario.setFuncionarioAtual((Funcionario) cbxUser.getSelectedItem());
							Caixa.setCaixaAtual(c.getCaixa(comboBox.getSelectedIndex()));
						
							FrmCaixa caixa = new FrmCaixa();
							caixa.frame.setVisible(true);
						
							frame.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(new JFrame(), "Login \n\n" + "\nAcesso Negado.", "FrmFuncionario", JOptionPane.INFORMATION_MESSAGE);

						}
						
		
						
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					
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
