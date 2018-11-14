package br.edu.ifsp.bra.farmacia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import br.edu.ifsp.bra.banco.ConnectionFactory;
import br.edu.ifsp.bra.modelo.Medicamento;
import br.edu.ifsp.bra.modelo.Medicamento.TipoMedicamento;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdicionarItemPedido {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	
	JComboBox<String> cbMedicamento = new JComboBox<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarItemPedido window = new AdicionarItemPedido();
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
	public AdicionarItemPedido() {
		initialize();
		this.populaJComboBox();
	}
	
	public void populaJComboBox() {
		
		Connection connection = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM medicamento;");
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				cbMedicamento.addItem(rs.getString("descricao").toString());
			}
			
			//JOptionPane.showMessageDialog(new JFrame(), "Cadastro \n\n" + "\nProduto incluido com sucesso.", "FrmVenda", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(new JFrame(), "Cadastro \n\n" + "\nFalha na inclusão de Produto.", "FrmVenda", JOptionPane.INFORMATION_MESSAGE);
			ex.printStackTrace();
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("Código:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("Nome:");
		
		JLabel label_2 = new JLabel("Tipo:");
		
		JComboBox<TipoMedicamento> comboBox = new JComboBox<TipoMedicamento>();
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		
		JSpinner spinner = new JSpinner();
		
		JLabel label_4 = new JLabel("Preço:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//JComboBox cbMedicamento = new JComboBox();
				Medicamento item = (Medicamento) cbMedicamento.getSelectedItem();
				//textField.setText((String.valueOf(item.getId())));
				
				
				JOptionPane.showMessageDialog(new JFrame(), "Id: " + String.valueOf(item.getId()) + "Desc: " + String.valueOf(item.getDescricao()));
			}
		});
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(label)
										.addGap(6)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(cbMedicamento, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addGap(36)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblQuantidade)
									.addGap(6)
									.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnCancelar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdicionar)))
					.addGap(58))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(label))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(lblQuantidade))
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(cbMedicamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_2)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(label_4))
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdicionar)
						.addComponent(btnCancelar)))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(52, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
