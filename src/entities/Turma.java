package entities;

public class Turma {
    private String codigoTurma;
	private char turno;
	private String cpfInstrutor;
    
	public Turma(String codigoTurma, char turno, String cpfInstrutor) {
		this.codigoTurma = codigoTurma;
		this.turno = turno;
		this.cpfInstrutor = cpfInstrutor;
	}
	public String getCodigoTurma() {
		return codigoTurma;
	}
	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}
	public char getTurno() {
		return turno;
	}
	public void setTurno(char turno) {
		this.turno = turno;
	}
	public String getCpfInstrutor() {
		return cpfInstrutor;
	}
	public void setCpfInstrutor(String cpfInstrutor) {
		this.cpfInstrutor = cpfInstrutor;
	}
}
