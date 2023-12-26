package entities;

public class ServicoGeral {
    private String tipoServico;
	private String cpf;

	public ServicoGeral(String tipoServico, String cpf) {
		this.tipoServico = tipoServico;
		this.cpf = cpf;
	}
    
	public String getTipoServico() {
		return tipoServico;
	}
	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
