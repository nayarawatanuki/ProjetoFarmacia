package br.edu.ifsp.bra.dominio;

import br.edu.ifsp.bra.banco.LoginDAO;
import br.edu.ifsp.bra.modelo.Login;

public class LoginBLL {

	public boolean Logar(Login login){
		
		LoginDAO loginDao = new LoginDAO();
		return loginDao.Logar(login);
		
	}
}
