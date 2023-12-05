package service;

import java.sql.SQLException;
import entities.Aluno;
import dao.AlunoDAO;

public class AlunoService {
    
    private AlunoDAO dao;

    public AlunoService() throws ClassNotFoundException{
        this.dao = new AlunoDAO();
    }

    public Aluno recuperarAluno(String cpf){
        try {
            return dao.recuperar(cpf);
        } catch (SQLException se) {
            return null;
        }
    }
}
