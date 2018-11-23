package br.edu.ifsp.bra.dominio;

import br.edu.ifsp.bra.banco.LoginDAO;

public class LoginBLL {

	public void Logar(String usuario, String senha){
		
		LoginDAO login = new LoginDAO();
		login.Logar(usuario, senha);
		
	}
}
