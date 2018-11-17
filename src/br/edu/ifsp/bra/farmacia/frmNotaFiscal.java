package br.edu.ifsp.bra.farmacia;

import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import br.edu.ifsp.bra.dominio.CaixaBLL;
import br.edu.ifsp.bra.dominio.ItemPedidoBLL;
import br.edu.ifsp.bra.dominio.MedicamentoBLL;
import br.edu.ifsp.bra.dominio.PedidoBLL;
import br.edu.ifsp.bra.modelo.ItemPedido;
import br.edu.ifsp.bra.modelo.Medicamento;
import br.edu.ifsp.bra.modelo.Pagamento;

public class frmNotaFiscal {

	JFrame frame;
	JPanel panel;
	JTextArea infoEmpresa;
	JTable infoPedido;
	DefaultTableModel model;
	PedidoBLL pedBll;
	
	public frmNotaFiscal(Pagamento pagamento)
	{
		
		pedBll = new PedidoBLL();
		
		String strInfoEmpresa = "                       Farmácia Projeto                                         \r\n" + 
				"\r\n" + 
				"Endereço: \r\n" + 
				"Bairro:\r\n" + 
				"CEP:\r\n" + 
				"Telefone:\r\n" + 
				"CNPJ:\r\n" + 
				"\r\n";
		
		frame = new JFrame(" Nota Fiscal ");
		
		panel = new JPanel();
		frame.add(panel);
		
		infoEmpresa = new JTextArea(strInfoEmpresa);
		panel.add(infoEmpresa);
		
		infoPedido = new JTable();
		criarTabela();
		//Precisa de um metodo que pegue um pedido por pelo id e um que pegue os itens ligados aquele pedido
		popularTabela(pedBll.getPedido(pagamento.getPedidoId()).getItens());
		
		frame.pack();
		frame.setVisible(true);
		

	}
	
	private void criarTabela()
	{
		model = new DefaultTableModel();
		model.addColumn("Código");
		model.addColumn("Quantidade");
		model.addColumn("Descricao");
		model.addColumn("Preço Unitário");
		model.addColumn("Preço Total");


	}
	
	private void popularTabela(List<ItemPedido> itens)
	{
		Object[] lista = new Object[5];
		MedicamentoBLL medBll = new MedicamentoBLL();
		for(ItemPedido item : itens)
		{
			lista[0] = item.getProdutoId();
			lista[1] = item.getQuantidade();
			lista[2] = medBll.getMedicamento(item.getProdutoId()).getDescricao();
			lista[3] = medBll.getMedicamento(item.getProdutoId()).getPreco();
			lista[4] = item.getPreco();
			model.addRow(lista);	
		}
	}
	
	
	
}
