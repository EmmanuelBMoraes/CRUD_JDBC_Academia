package entities;

public class Funcionario {
    private String nome;
	private double salario;
	private int frequencia;
	private String cpfGerente;
	private String cpf;
	
	public Funcionario(String nome, double salario, int frequencia, String cpfGerente, String cpf) {
		this.nome = nome;
		this.salario = salario;
		this.frequencia = frequencia;
		this.cpfGerente = cpfGerente;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public int getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}
	public String getCpfGerente() {
		return cpfGerente;
	}
	public void setCpfGerente(String cpfGerente) {
		this.cpfGerente = cpfGerente;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
