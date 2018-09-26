package br.edu.ifsp.bra.dominio;

import java.util.Set;

import br.edu.ifsp.bra.banco.ClienteDAO;
import br.edu.ifsp.bra.modelo.Cliente;

public class ClienteBLL {

	ClienteDAO dao = new ClienteDAO();
	
	public Cliente getCliente(int id) {
		return dao.getCliente(id);
	}
	
	public Set<Cliente> getTodosClientes() {
		return dao.getTodosClientes();
	}
	
	public boolean novoCliente(Cliente cliente) {
		return dao.novoCliente(cliente);
	}
	
	public boolean modificaCliente(Cliente cliente) {
		return dao.modificaCliente(cliente);
	}
}
