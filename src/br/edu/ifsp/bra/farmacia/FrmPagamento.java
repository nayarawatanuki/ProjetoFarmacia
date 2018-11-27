package br.edu.ifsp.bra.farmacia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPagamento {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPagamento window = new FrmPagamento();
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
	public FrmPagamento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panelValorCompra = new JPanel();
		panelValorCompra.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Total da Compra", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblCompra = new JLabel("0.0");
		lblCompra.setFont(lblCompra.getFont().deriveFont(30f));
		GroupLayout gl_panelValorCompra = new GroupLayout(panelValorCompra);
		gl_panelValorCompra.setHorizontalGroup(
			gl_panelValorCompra.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelValorCompra.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCompra, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelValorCompra.setVerticalGroup(
			gl_panelValorCompra.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelValorCompra.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addComponent(lblCompra, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(17))
		);
		panelValorCompra.setLayout(gl_panelValorCompra);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resposta = JOptionPane.showConfirmDialog(null, "Emitir nota fiscal?", "Pagamento Efetuado!" , JOptionPane.YES_NO_OPTION);
				
				if (resposta == JOptionPane.YES_OPTION) {
					   
					JOptionPane.showMessageDialog(null, "Imprimindo Nota Fiscal...");
					
				} else if (resposta == JOptionPane.NO_OPTION) {
					
					JOptionPane.showMessageDialog(null, "Compra Concluida.");
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Pagamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel label = new JLabel("0.0");
		label.setFont(label.getFont().deriveFont(30f));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(17))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Troco", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel label_1 = new JLabel("0.0");
		label_1.setFont(label_1.getFont().deriveFont(30f));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 220, Short.MAX_VALUE)
				.addGap(0, 220, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 94, Short.MAX_VALUE)
				.addGap(0, 102, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JButton btnDesconto = new JButton("Desconto");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelValorCompra, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFinalizar)
						.addComponent(btnDesconto))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(panelValorCompra, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnDesconto)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnFinalizar))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
