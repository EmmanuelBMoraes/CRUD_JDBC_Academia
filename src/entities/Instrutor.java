package entities;

import java.time.LocalDate;

public class Instrutor {
    private String cpf;
	private String cref;
	private LocalDate dataNasc;
	
	public Instrutor(String cpf, String cref, LocalDate dataNasc) {
		this.cpf = cpf;
		this.cref = cref;
		this.dataNasc = dataNasc;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCref() {
		return cref;
	}
	public void setCref(String cref) {
		this.cref = cref;
	}
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	
}
