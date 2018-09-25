package br.edu.ifsp.bra.dominio;

import java.util.Set;

import br.edu.ifsp.bra.banco.ClienteDAO;
import br.edu.ifsp.bra.modelo.Cliente;

public class ClienteBLL {
	
	public Cliente getCliente(int id) {
		ClienteDAO dao = new ClienteDAO();
		return dao.getCliente(id);
	}
	
	public Set<Cliente> getTodosClientes() {
		ClienteDAO dao = new ClienteDAO();
		return dao.getTodosClientes();
	}
	
	public boolean novoCliente(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO();
		return dao.novoCliente(cliente);
	}
	
	public boolean modificaCliente(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO();
		return dao.modificaCliente(cliente);
	}
}
