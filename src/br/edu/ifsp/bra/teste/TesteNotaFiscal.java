package br.edu.ifsp.bra.teste;

import java.util.Date;

import br.edu.ifsp.bra.farmacia.frmNotaFiscal;
import br.edu.ifsp.bra.modelo.Caixa;
import br.edu.ifsp.bra.modelo.Cliente;
import br.edu.ifsp.bra.modelo.Dinheiro;
import br.edu.ifsp.bra.modelo.ItemPedido;
import br.edu.ifsp.bra.modelo.Medicamento;
import br.edu.ifsp.bra.modelo.Medicamento.TipoMedicamento;
import br.edu.ifsp.bra.modelo.Pagamento;
import br.edu.ifsp.bra.modelo.Pagamento.TipoPagamento;
import br.edu.ifsp.bra.modelo.Pedido;
import br.edu.ifsp.bra.modelo.Pedido.StatusPedido;

public class TesteNotaFiscal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Medicamento med1 = new Medicamento("123", "Paracetol", 1.5, 30, TipoMedicamento.PILULA);
		med1.setId(1);
		Medicamento med2 = new Medicamento("456", "Dipirona", 1, 50, TipoMedicamento.PILULA);
		med2.setId(2);
		Medicamento med3 = new Medicamento("123", "Amoxilina", 6, 80, TipoMedicamento.DRAGEA);
		med3.setId(3);
		
		Caixa caixa = new Caixa("Caixa1");
		caixa.setId(1);
		
		Pedido ped1 = new Pedido(1, StatusPedido.FECHADO, 0, new Date());
		
		ItemPedido item1 = new ItemPedido(1, 1, 5, 7.5);
		ItemPedido item2 = new ItemPedido(1, 2, 2, 2);
		ItemPedido item3 = new ItemPedido(1, 3, 6, 36);
		
		ped1.adicionaItem(item1);
		ped1.adicionaItem(item2);
		ped1.adicionaItem(item3);
		
		Cliente cliente = new Cliente("Jean", "Extrema", "912345678", "13574901607", new Date(), true, new Date());
		cliente.setId(9);
		
		Pagamento pagamento = new Dinheiro(9,1, (7.5 + 2 + 36), TipoPagamento.DINHEIRO, (7.5 + 2 + 36 + 1), 1);
		
		frmNotaFiscal nota = new frmNotaFiscal(pagamento);
		
	}

}
