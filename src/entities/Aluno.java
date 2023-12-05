package entities;

public class Aluno {
	
	private String cpf;
	private String nome;
	private String matricula;
	private String rua;
	private int id_ficha_aluno;
	
	public Aluno(String cpf, String nome, String matricula, String rua, int id_ficha_aluno) {
		this.cpf = cpf;
		this.nome = nome;
		this.matricula = matricula;
		this.rua = rua;
		this.id_ficha_aluno = id_ficha_aluno;
	}
	
	public String getCPF() {
		return this.cpf;
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getMatricula() {
		return this.matricula;
	}
	public String getRua() {
		return this.rua;
	}
	
	public int getIdFicha() {
		return this.id_ficha_aluno;
	}
}