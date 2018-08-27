import java.util.Date;

public class Cliente extends Pessoa {
	private Date dataCadastro;
	
	Cliente(String nome, Date dataNascimento, String cpf, Date dataCadastro) {
		super(nome, dataNascimento, cpf);
		this.dataCadastro = dataCadastro;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
