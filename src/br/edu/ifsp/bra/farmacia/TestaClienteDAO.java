package br.edu.ifsp.bra.farmacia;

import br.edu.ifsp.bra.banco.ClienteDAO;
import br.edu.ifsp.bra.dominio.Cliente;

public class TestaClienteDAO {
	public static void main(String[] args) {
		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = dao.getCliente(1);

		System.out.println("Id: " + cliente.getId());
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("CPF: " + cliente.getCpf());
		System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
		System.out.println("Data de Cadastro: " + cliente.getDataCadastro());
	}
}
