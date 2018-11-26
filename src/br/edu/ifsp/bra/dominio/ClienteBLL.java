package br.edu.ifsp.bra.dominio;

import java.util.List;

import br.edu.ifsp.bra.banco.ClienteDAO;
import br.edu.ifsp.bra.modelo.Cliente;

public class ClienteBLL {

	ClienteDAO dao = new ClienteDAO();
	
	public Cliente getCliente(int id) {
		return dao.getCliente(id);
	}
	
	public List<Cliente> getTodosClientes() {
		return dao.getTodosClientes();
	}
	
	public int novoCliente(Cliente cliente) {
		return dao.novoCliente(cliente);
	}
	
	public boolean modificaCliente(Cliente cliente) {
		return dao.modificaCliente(cliente);
	}
	public List<Cliente> PesquisarCliente(String filtro)
	{
		return dao.PesquisarClientes(filtro);
	}
}
