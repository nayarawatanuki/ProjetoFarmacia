package br.edu.ifsp.bra.farmacia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import br.edu.ifsp.bra.dominio.MedicamentoBLL;
import br.edu.ifsp.bra.modelo.Medicamento;
import br.edu.ifsp.bra.modelo.Medicamento.TipoMedicamento;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmMedicamento {

	JFrame frame;
	private JTable tableMed;
	public MedicamentoBLL medbll = new MedicamentoBLL();
	DefaultTableModel modelo = new DefaultTableModel(); 
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
			modelo.addRow(new Object[] {med.getId(),med.getCodigo(),
					med.getDescricao(), med.getPreco(), med.getEstoque(), med.getTipo()});
		}
	}
	
	private void criarTabela()
	{
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Id");
		modelo.addColumn("Codigo");
		modelo.addColumn("Descri��o");
		modelo.addColumn("Pre�o");
		modelo.addColumn("Estoque");
		modelo.addColumn("Tipo");
		popularTabela(modelo);
		
		tableMed = new JTable(modelo);	

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
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				medbll.remover((int) tableMed.getValueAt(tableMed.getSelectedRow(),0));
				tableMed.removeAll();
				modelo.removeRow(tableMed.getSelectedRow());

			}
		});
		btnRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medicamento m = new Medicamento();
				
				m.setId((int)tableMed.getModel().getValueAt(tableMed.getSelectedRow(), 0));
				m.setCodigo((String)tableMed.getModel().getValueAt(tableMed.getSelectedRow(), 1));
				m.setDescricao((String)tableMed.getModel().getValueAt(tableMed.getSelectedRow(), 2));
				m.setPreco((Double)tableMed.getModel().getValueAt(tableMed.getSelectedRow(), 3));
				m.setEstoque((int) tableMed.getModel().getValueAt(tableMed.getSelectedRow(), 4));
				m.setTipo((TipoMedicamento)tableMed.getModel().getValueAt(tableMed.getSelectedRow(), 5));				
				medbll.modificar(m);
			}
		});
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new FrmCadastroMed().setVisible(true);	
				}
		});
		JScrollPane scrollPane= new  JScrollPane(tableMed);
		frame.getContentPane().add(scrollPane);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMedicamentos)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
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
					.addGap(67)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnAdicionar)
						.addComponent(btnRemover))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
