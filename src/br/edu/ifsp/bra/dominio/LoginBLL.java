package br.edu.ifsp.bra.dominio;

import br.edu.ifsp.bra.banco.LoginDAO;

public class LoginBLL {

	public void Logar(){
		
		LoginDAO login = new LoginDAO();
		login.Logar();
		
	}
}
