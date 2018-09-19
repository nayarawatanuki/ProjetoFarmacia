package br.edu.ifsp.bra.banco;

import br.edu.ifsp.bra.modelo.Cliente;
import br.edu.ifsp.bra.modelo.Funcionario;
import br.edu.ifsp.bra.modelo.ItemPedido;
import br.edu.ifsp.bra.modelo.Pagamento;
import br.edu.ifsp.bra.modelo.Pedido;
import br.edu.ifsp.bra.modelo.Produto;

public class CaixaDAO {
	private static Pedido pedidoAtual;
	private static Funcionario funcionario;
  
	public CaixaDAO() {
		this.pedidoAtual = null;
		this.funcionario = null;
	}
  
	public boolean abrirCaixa(Funcionario f) {
		// TODO: abertura de caixa
		return false;
	}
  
	public boolean fecharCaixa(Funcionario f) {
		// TODO: fechamento de caixa
		return false;
	}
	
	public Pedido novoPedido(Cliente c) {
		// TODO: abertura de pedido
		return null;
	}
	
	public boolean adicionaProduto(Produto p, int quantidade) {
		// TODO: adição de produto
		return false;
	}
	
	public boolean removeProduto(Produto p, int quantidade) {
		// TODO: remoção de item no pedido
		return false;
	}
	
	public boolean fechaPedido(Pagamento p) {
		// TODO: fechamento de pedido
		return false;
	}
}
