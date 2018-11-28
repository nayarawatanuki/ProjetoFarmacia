package br.edu.ifsp.bra.banco;

import java.util.List;

import br.edu.ifsp.bra.modelo.Cliente;

public interface IClienteDAO {
	Cliente getCliente(int id);
	List<Cliente> getTodosClientes();
	int novoCliente(Cliente cliente);
	boolean modificaCliente(Cliente cliente);
	List<Cliente> PesquisarClientes(String filtro);
}
