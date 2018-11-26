package br.edu.ifsp.bra.farmacia;
import javax.swing.DefaultComboBoxModel;
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
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
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
		
		lblMed = new JLabel("Medicamento");
		lblMed.setBounds(31, 45, 96, 29);
		panel.add(lblMed);
		
		//comboBox = new JComboBox();
		
		MedicamentoBLL me = new MedicamentoBLL();
		Set<Medicamento> med = me.getTodosMedicamento();
				
		JComboBox<Medicamento> comboBox = new JComboBox<Medicamento>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {""}));
			
			for (Medicamento m : med) {
				comboBox.addItem(m);
			}

		comboBox.setBounds(128, 47, 139, 27);
		panel.add(comboBox);
		
		lblQuant = new JLabel("Quantidade");
		lblQuant.setBounds(31, 86, 89, 29);
		panel.add(lblQuant);
		
		spinner = new JSpinner();
		spinner.setBounds(128, 86, 96, 26);
		panel.add(spinner);
		
		txtpnProduto = new JTextPane();
		txtpnProduto.setBounds(31, 138, 392, 105);
		panel.add(txtpnProduto);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicamentoBLL medBll = new MedicamentoBLL();
				Medicamento med = medBll.getMedicamento(comboBox.getSelectedIndex());
				CaixaFacade facade = new CaixaFacade();
				facade.adicionaMedicamento(med, (int) spinner.getValue());
				popularTabela(Pedido.getPedidoAtual().getItens().get((Pedido.getPedidoAtual().getItens().size()) - 1));
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
		
	/*	criarTabela();
		itens = new JTable(model);
		JScrollPane scroll = new JScrollPane(itens);
		scroll.setViewportView(itens);
		panel.add(scroll);*/
		
		frame.setVisible(true);
	}
	
	/*private void criarTabela()
	{
		model = new DefaultTableModel();
		model.addColumn("Descricao");
		model.addColumn("Preco Unitario");
		model.addColumn("Quantidade");
		model.addColumn("Preco Total");
	}*/
	
	private void popularTabela(ItemPedido item)
	{
		item.setQuantidade((int) spinner.getValue());
		txtpnProduto.setText("Descricao: " + item.getMedicamento().getDescricao() + "\n" + "Preco Unitario: " + item.getMedicamento().getPreco() + "\n" + "Quantidade: " + item.getQuantidade() + "\n" + "Preco Total: " + (item.getMedicamento().getPreco() * (int) spinner.getValue()));
		
		FrmVendas.isAtualizada = false;
	}
}
