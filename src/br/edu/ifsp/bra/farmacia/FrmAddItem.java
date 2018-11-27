package br.edu.ifsp.bra.farmacia;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifsp.bra.dominio.CaixaFacade;
import br.edu.ifsp.bra.dominio.MedicamentoBLL;
import br.edu.ifsp.bra.modelo.ItemPedido;
import br.edu.ifsp.bra.modelo.Medicamento;
import br.edu.ifsp.bra.modelo.Pedido;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JTextField;
public class FrmAddItem {

	static JFrame frame;
	JPanel panel;
	JLabel lblMed;
	JLabel lblQuant;
	JTextPane txtpnProduto;
	
	JButton btnConfirmar;
	JTable itens;
	DefaultTableModel model;
	
	private JButton btnFinalizar;
	private JSpinner spinner;
	private JTextField txtCodMed;
	
	public FrmAddItem()
	{
		initialize();
	}
	
	public void initialize() {
		
		frame = new JFrame(" AddItem ");
		frame.setSize(451, 285);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblMed = new JLabel("Cod. do Medicamento");
		lblMed.setBounds(31, 46, 116, 29);
		panel.add(lblMed);
		
		
		lblQuant = new JLabel("Quantidade");
		lblQuant.setBounds(31, 86, 89, 29);
		panel.add(lblQuant);
		
		spinner = new JSpinner();
		spinner.setBounds(157, 87, 96, 26);
		panel.add(spinner);
		
		txtpnProduto = new JTextPane();
		txtpnProduto.setBounds(31, 138, 392, 105);
		panel.add(txtpnProduto);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					MedicamentoBLL medBll = new MedicamentoBLL();
					//Mudar a forma de adicionar medicamento ao pedido
					Medicamento med = medBll.getMedicamento(Integer.parseInt(txtCodMed.getText()));
					CaixaFacade facade = new CaixaFacade();
					facade.adicionaMedicamento(med, (int) spinner.getValue());
					popularTabela(Pedido.getPedidoAtual().getItens().get((Pedido.getPedidoAtual().getItens().size()) - 1));
					btnConfirmar.setEnabled(false);
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnConfirmar.setBounds(327, 46, 96, 29);
		panel.add(btnConfirmar);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnFinalizar.setBounds(327, 90, 96, 23);
		panel.add(btnFinalizar);
		
		txtCodMed = new JTextField();
		txtCodMed.setBounds(157, 46, 96, 24);
		panel.add(txtCodMed);
		txtCodMed.setColumns(10);
		
		
		frame.setVisible(true);
	}
	
	private void popularTabela(ItemPedido item)
	{
		
		txtpnProduto.setText("Descricao: " + item.getMedicamento().getDescricao() + "\n" + "Preco Unitario: " + item.getMedicamento().getPreco() + "\n" + "Quantidade: " + (int) spinner.getValue() + "\n" + "Preco Total: " + (item.getMedicamento().getPreco() * (int) spinner.getValue()));
		
		FrmVendas.isAtualizada = false;
	}
}
