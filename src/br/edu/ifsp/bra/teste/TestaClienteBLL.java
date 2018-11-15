package br.edu.ifsp.bra.teste;

import br.edu.ifsp.bra.dominio.ClienteBLL;
import br.edu.ifsp.bra.modelo.Cliente;

public class TestaClienteBLL {
	public static void main(String[] args) {
		ClienteBLL bll = new ClienteBLL();
		Cliente cliente = bll.getCliente(1);

		System.out.println("Id: " + cliente.getId());
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("CPF: " + cliente.getCpf());
		System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
		System.out.println("Data de Cadastro: " + cliente.getDataCadastro());
		
		//int id = bll.novoCliente(cliente);
		//System.out.println(id);
	}
}
