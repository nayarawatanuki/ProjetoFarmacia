package br.edu.ifsp.bra.dominio;

import java.time.LocalDateTime;
import java.util.Date;

import br.edu.ifsp.bra.banco.PedidoDAO;
import br.edu.ifsp.bra.modelo.Funcionario;
import br.edu.ifsp.bra.modelo.Pedido;
import br.edu.ifsp.bra.modelo.Pedido.statusPedido;

public class CaixaBLL {
	
	static Pedido pedidoAtual;
	static boolean CaixaAberto;
	static Funcionario funcionario;
	static int numeroPedido;
	
	public static Pedido getPedidoAtual() {
		return pedidoAtual;
	}

	public static boolean isCaixaAberto() {
		return CaixaAberto;
	}

	public static Funcionario getFuncionario() {
		return funcionario;
	}

	public static void setFuncionario(Funcionario funcionario) {
		CaixaBLL.funcionario = funcionario;
	}

	public void abrirCaixa(Funcionario f) {
		
	}
	
	public void fecharCaixa(Funcionario f) {
		
	}
	
	public void novoPedido() {
		if(pedidoAtual.getStatus() != statusPedido.ABERTO) {
			
			//pedidoAtual = PedidoDAO.NovoPedido();
			
		}else {
			//// Acredito que seja bom guardar todo tipo de pedido, desde os cancelados aos abertos que nao foram fechados
			
			 // pedidoAtual.setStatus(statusPedido.CANCELADO);
			//	PedidoDAO.adicionar(pedidoAtual)  Salva o pedido atual
			// pedidoAtual = PedidoDAO.NovoPedido();	
		}	
	}
}
