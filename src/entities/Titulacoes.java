package entities;

public class Titulacoes {
    private String titulacao;
	private String cpf;
	
	public Titulacoes(String titulacao, String cpf) {
		this.titulacao = titulacao;
		this.cpf = cpf;
	}
	
	public String getTitulacao() {
		return titulacao;
	}
	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
    }
}
