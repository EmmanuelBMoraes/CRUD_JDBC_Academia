package entities;

public class Dependente {
    private String nome;
	private String parentesco; 
	private String cpf;

	public Dependente(String nome, String parentesco, String cpf) {
		this.nome = nome;
		this.parentesco = parentesco;
		this.cpf = cpf;
	}
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
