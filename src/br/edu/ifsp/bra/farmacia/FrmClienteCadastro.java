package br.edu.ifsp.bra.farmacia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.text.MaskFormatter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmClienteCadastro {

	JFrame frame;
	private JTextField txtNome;
	private JFormattedTextField frmtdtxtfldCpf;
	private JFormattedTextField frmtdtxtfldDatanascimento;
	private JFormattedTextField frmtdtxtfldTelefone;
	private JTextField txtEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmClienteCadastro window = new FrmClienteCadastro();
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
	public FrmClienteCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 568, 403);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblClientes = new JLabel("CLIENTES");
		lblClientes.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JPanel panel = new JPanel();
		
		JLabel lblNome = new JLabel("Nome:");
		
		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				JTextField jtf = (JTextField) e.getSource();
				char key = e.getKeyChar();
				boolean press = (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_DELETE || Character.isAlphabetic(key));
				if (!press || jtf.getText().length() == 50) {
					e.consume();
				}
			}
		});
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
		
		try{
			MaskFormatter cpf = new MaskFormatter("###.###.###-##");
			frmtdtxtfldCpf = new JFormattedTextField(cpf);
			
		}catch (Exception e){
		}
		
		try{
			MaskFormatter dataNascimento = new MaskFormatter("##/##/####");
			frmtdtxtfldDatanascimento = new JFormattedTextField(dataNascimento);
		}catch (Exception e){
		}
		
		try{
			MaskFormatter telefone = new MaskFormatter("(##) ####-####");
			frmtdtxtfldTelefone = new JFormattedTextField(telefone);
		}catch (Exception e){
		}
		
		JLabel lblTelefone = new JLabel("Telefone:");
		
		JLabel lblEndereco = new JLabel("Endereço:");
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				frmtdtxtfldCpf.setText(null);
				frmtdtxtfldDatanascimento.setText(null);
				frmtdtxtfldTelefone.setText(null);
				txtEndereco.setText("");
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNome.getText() == "" || frmtdtxtfldCpf.getText().equals("   .   .   -  ") || frmtdtxtfldDatanascimento.getText().equals("  /  /    ") || frmtdtxtfldTelefone.getText().equals("(  )     -    ") || txtEndereco.getText() == "") {
					JOptionPane.showMessageDialog(null, "Favor preencher todos os campos corretamente.");
				}else {
					
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnLimpar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCadastrar))
						.addComponent(lblTelefone, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblCpf, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(27)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(frmtdtxtfldTelefone, 133, 133, 133)
										.addComponent(frmtdtxtfldCpf, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
									.addGap(20)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblDataNascimento)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(frmtdtxtfldDatanascimento, 97, 97, 97))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblEndereco)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtEndereco, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))))
								.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))))
					.addGap(69))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(frmtdtxtfldDatanascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDataNascimento)
						.addComponent(frmtdtxtfldCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTelefone)
							.addComponent(frmtdtxtfldTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(lblEndereco))
						.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(83)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnCancelar)
						.addComponent(btnLimpar))
					.addGap(570))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(38, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblClientes, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
					.addGap(32))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(lblClientes, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(606, Short.MAX_VALUE))
		);
		
		frame.getContentPane().setLayout(groupLayout);
	}
}
