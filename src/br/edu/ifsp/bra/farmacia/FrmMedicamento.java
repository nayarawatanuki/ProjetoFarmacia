package br.edu.ifsp.bra.farmacia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import br.edu.ifsp.bra.dominio.MedicamentoBLL;
import br.edu.ifsp.bra.modelo.Medicamento;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmMedicamento {

	private JFrame frame;
	private JTable tableMed;
	public MedicamentoBLL medbll = new MedicamentoBLL();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMedicamento window = new FrmMedicamento();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
	private void popularTabela(DefaultTableModel modelo)
	{
		MedicamentoBLL medBLL = new MedicamentoBLL();
		
		Set<Medicamento> list = medBLL.getTodosMedicamento();
		
		for(Medicamento med : list)
		{
			modelo.addRow(new Object[] {med.getId(), med.getDescricao(), med.getPreco(), med.getEstoque(), med.getTipo()});
		}
	}
	
	private void criarTabela()
	{
		DefaultTableModel modelo = new DefaultTableModel(); 
		modelo.addColumn("Id");
		modelo.addColumn("Descrição");
		modelo.addColumn("Preço");
		modelo.addColumn("Estoque");
		modelo.addColumn("Tipo");
		
		popularTabela(modelo);
		
		tableMed = new JTable(modelo);		
		tableMed.getColumnModel().getColumn(0).setWidth(0);
	}

	/**
	 * Create the application.
	 */
	public FrmMedicamento() {
		initialize();
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 660, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		criarTabela();
		
		
		JLabel lblMedicamentos = new JLabel("MEDICAMENTOS");
		
		JButton btnAtualizar = new JButton("Atualizar");
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				; 
				medbll.remover((int) tableMed.getValueAt(tableMed.getSelectedRow(), tableMed.getSelectedRow()));
				tableMed.repaint();
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new FrmCadastroMed().setVisible(true);	
				}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(509, Short.MAX_VALUE)
					.addComponent(btnAtualizar)
					.addGap(34))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMedicamentos)
						.addComponent(tableMed, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnRemover)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblMedicamentos)
					.addGap(29)
					.addComponent(btnAtualizar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tableMed, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnAdicionar)
						.addComponent(btnRemover))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
