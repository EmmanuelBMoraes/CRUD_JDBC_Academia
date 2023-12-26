package entities;

import java.time.LocalDate;

public class Matricula {
    private String codigoTurma;
	private String cpf;
	private LocalDate dateMat;
	
	public Matricula(String codigoTurma, String cpf, LocalDate dateMat) {
		this.codigoTurma = codigoTurma;
		this.cpf = cpf;
		this.dateMat = dateMat;
	}

	public String getCodigoTurma() {
		return codigoTurma;
	}
	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDateMat() {
		return dateMat;
	}
	public void setDateMat(LocalDate dateMat) {
		this.dateMat = dateMat;
	}
}
