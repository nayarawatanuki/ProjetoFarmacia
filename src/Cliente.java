
public class Cliente extends Pessoa {
	private String dataCadastro;	// TODO: Date
	
	Cliente(String nome, String dataNascimento, String cpf, String dataCadastro) {
		super(nome, dataNascimento, cpf);
		this.setDataCadastro = dataCadastro;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
