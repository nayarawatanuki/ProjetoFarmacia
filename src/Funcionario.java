import java.util.Date;

public class Funcionario extends Pessoa {
	
	public static enum TipoFuncionario { Atendente, Gerente };
	
	private String usuario;
	private String senha;
	private TipoFuncionario tipo;

	Funcionario(String nome, Date dataNascimento, String cpf,
			String usuario, String senha, TipoFuncionario tipo) {
		super(nome, dataNascimento, cpf);
		this.usuario = usuario;
		this.senha = senha;
		this.tipo = tipo;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoFuncionario getTipo() {
		return tipo;
	}

	public void setTipo(TipoFuncionario tipo) {
		this.tipo = tipo;
	}
}
