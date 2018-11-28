package br.edu.ifsp.bra.farmacia;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import br.edu.ifsp.bra.dominio.PedidoBLL;
import br.edu.ifsp.bra.modelo.IPagamento;
import br.edu.ifsp.bra.modelo.ItemPedido;

public class FrmNotaFiscal {

	JFrame frame;
	JPanel panel;
	JTextArea infoEmpresa;
	JTable infoPedido;
	DefaultTableModel model;
	PedidoBLL pedBll;
	JScrollPane scroll;

	public FrmNotaFiscal(IPagamento pagamento)
	{

		pedBll = new PedidoBLL();

		String strInfoEmpresa = "                       Farmacia Projeto                                         \r\n" + 
				"\r\n" + 
				"Endereco: \r\n" + 
				"Bairro:\r\n" + 
				"CEP:\r\n" + 
				"Telefone:\r\n" + 
				"CNPJ:\r\n" + 
				"\r\n";

		frame = new JFrame(" Nota Fiscal ");
		frame.setSize(500,800);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		panel = new JPanel();
		frame.getContentPane().add(panel);

		infoEmpresa = new JTextArea(strInfoEmpresa);
		panel.add(infoEmpresa);


		criarTabela();
		infoPedido = new JTable(model);
		scroll = new JScrollPane(infoPedido);
		popularTabela(pedBll.buscarPedido(pagamento.getPedidoId()).getItens());
		scroll.setViewportView(infoPedido);
		panel.add(scroll);

		frame.setVisible(true);


	}

	private void criarTabela()
	{
		model = new DefaultTableModel();
		model.addColumn("Codigo");
		model.addColumn("Quantidade");
		model.addColumn("Descricao");
		model.addColumn("Preco Unitario");
		model.addColumn("Preco Total");


	}

	private void popularTabela(List<ItemPedido> itens)
	{
		Object[] lista = new Object[5];
		if(itens == null)
		{
			return;
		}
		for(ItemPedido item : itens)
		{
			lista[0] = item.getMedicamento().getId();
			lista[1] = item.getQuantidade();
			lista[2] = item.getMedicamento().getDescricao();
			lista[3] = item.getMedicamento().getPreco();
			lista[4] = item.getPreco();
			model.addRow(lista);	
		}
	}



}

