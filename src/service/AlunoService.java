package service;

import java.sql.SQLException;
import entities.Aluno;
import dao.AlunoDAO;

public class AlunoService {
    
    private AlunoDAO dao;

    public AlunoService() throws ClassNotFoundException{
        this.dao = new AlunoDAO();
    }

    public boolean salvarAluno(Aluno aluno){
        try {
            this.dao.inserir(aluno);
            return true;
        } catch (SQLException se) {
            return false;
        }
    }

    public boolean removerAluno(String chave){
        try {
            dao.remover(chave);
            return true;
        } catch (SQLException se) {
            return false;
        }
    }

    public Aluno recuperarAluno(String cpf){
        try {
            return dao.recuperar(cpf);
        } catch (SQLException se) {
            return null;
        }
    }
}
