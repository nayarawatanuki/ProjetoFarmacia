package br.edu.ifsp.bra.farmacia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.edu.ifsp.bra.dominio.MedicamentoBLL;
import br.edu.ifsp.bra.modelo.Medicamento;
import br.edu.ifsp.bra.modelo.Medicamento.TipoMedicamento;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmCadastroMed {

	JFrame frame;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JSpinner txtEstoque;
	JComboBox<TipoMedicamento> comboBox;
	private MedicamentoBLL medBLL = new MedicamentoBLL();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroMed window = new FrmCadastroMed();
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
	public FrmCadastroMed() {
		initialize();
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void limpaCampos() {
			txtCodigo.setText("");
			txtNome.setText("");
			txtPreco.setText("");
			txtEstoque.setValue(0);
			comboBox.setSelectedItem(0);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 359);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblMedicamentos = new JLabel("MEDICAMENTOS");
		lblMedicamentos.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JPanel panel = new JPanel();
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		
		
		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

			}
		});
		txtCodigo.setColumns(10);
	
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMedicamentos))
					.addGap(43))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(lblMedicamentos)
					.addGap(12)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
					.addGap(316))
		);
		
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
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		
		txtPreco = new JTextField();
		txtPreco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				JTextField jtf = (JTextField) e.getSource();
				char key = e.getKeyChar();
				boolean press = (key == KeyEvent.VK_PERIOD || key == KeyEvent.VK_DELETE || Character.isDigit(key));
				if (!press || jtf.getText().length() == 10) {
					e.consume();
				}
			}
		});
		txtPreco.setColumns(10);
		
		JLabel lblEstoque = new JLabel("Estoque:");
		
		JLabel lblTipo = new JLabel("Tipo:");
		
		this.comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(TipoMedicamento.values()));
		
		this.txtEstoque = new JSpinner();
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtCodigo.getText() == "" || txtNome.getText() == "" || txtPreco.getText() == "" || txtEstoque.getValue().toString() == "0" || comboBox.getSelectedItem() == "") {
					JOptionPane.showMessageDialog(null, "Favor preencher todos os campos corretamente.");
				}else {

					Medicamento med = new Medicamento(
							txtCodigo.getText(),
							txtNome.getText(),
							Double.parseDouble(txtPreco.getText()),
							(Integer)txtEstoque.getValue(),
							TipoMedicamento.getTipo(comboBox.getSelectedIndex())
							);
					
					if(medBLL.adicionar(med)) {
						JOptionPane.showMessageDialog(new JFrame(), "Produto adicionado.\n\n", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
						limpaCampos();
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Erro ao adicionar.\n\n", "Falha", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaCampos();
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblCodigo)
											.addGap(6)
											.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
											.addGap(6)
											.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
									.addGap(36)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblEstoque)
											.addGap(6)
											.addComponent(txtEstoque, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblPreco, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(txtPreco, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap(96, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(12)
									
									.addGap(38))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnLimpar)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCancelar)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCadastrar)
								)))
					.addGap(58))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(lblCodigo))
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(lblEstoque))
						.addComponent(txtEstoque, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNome))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTipo)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(lblPreco))
						.addComponent(txtPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnLimpar)
						.addComponent(btnCancelar))
					.addGap(616)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(b);
	}
}
