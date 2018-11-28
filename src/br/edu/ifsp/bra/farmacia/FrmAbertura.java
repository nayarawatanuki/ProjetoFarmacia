package br.edu.ifsp.bra.farmacia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import br.edu.ifsp.bra.dominio.CaixaFacade;
import br.edu.ifsp.bra.modelo.Caixa;
import br.edu.ifsp.bra.modelo.Funcionario;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmAbertura {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAbertura window = new FrmAbertura();
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
	public FrmAbertura() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Abertura de caixa");
		frame.setBounds(100, 100, 297, 217);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(32)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(78, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(27)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(30, Short.MAX_VALUE))
				);

		JLabel lblValorDeAbertura = new JLabel("Valor de abertura");
		lblValorDeAbertura.setFont(new Font("Verdana", Font.PLAIN, 18));

		JFormattedTextField frmtdtxtValorAbertura = new JFormattedTextField();
		frmtdtxtValorAbertura.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				JTextField jtf = (JTextField) e.getSource();
				char key = e.getKeyChar();
				boolean press = (key == KeyEvent.VK_PERIOD || key == KeyEvent.VK_ENTER || key == KeyEvent.VK_DELETE || Character.isDigit(key));
				if (!press || jtf.getText().length() == 50) {
					e.consume();
				}
			}
		});

		JButton btnOk = new JButton("Abrir caixa");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Caixa.setValorAbertura(Double.parseDouble(frmtdtxtValorAbertura.getText()));
					if (Caixa.getValorAbertura() < 100) {
						JOptionPane.showMessageDialog(null, "O caixa deve ser aberto com um valor mínimo de 100");
						return;
					}

					new CaixaFacade(Caixa.getCaixaAtual(), Funcionario.getFuncionarioAtual(), Caixa.getValorAbertura());

					FrmVendas vendas = new FrmVendas();
					vendas.frame.setVisible(true);

					frame.dispose();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGap(25)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblValorDeAbertura, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
										.addComponent(frmtdtxtValorAbertura, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(34, Short.MAX_VALUE))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGap(21)
						.addComponent(lblValorDeAbertura, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(frmtdtxtValorAbertura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnOk)
						.addContainerGap(23, Short.MAX_VALUE))
				);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
