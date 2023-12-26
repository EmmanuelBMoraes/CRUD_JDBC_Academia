package entities;

public class Ficha {
    private int id_ficha;
    private char tipo;
    private int dias;
    private String intensidade;

    public Ficha(int id_ficha,char tipo,int dias,String intensidade){
        this.tipo=tipo;
        this.id_ficha=id_ficha;
        this.dias=dias;
        this.intensidade=intensidade;
    }
    
    public int getId_ficha() {
        return id_ficha;
    }
    public void setId_ficha(int id_ficha) {
        this.id_ficha = id_ficha;
    }
    public char getTipo() {
        return tipo;
    }
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    public int getDias() {
        return dias;
    }
    public void setDias(int dias) {
        this.dias = dias;
    }
    public String getIntensidade() {
        return intensidade;
    }
    public void setIntensidade(String intensidade) {
        this.intensidade = intensidade;
    }
}
