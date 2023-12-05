package service;

import java.sql.SQLException;
import entities.Aluno;
import dao.AlunoDAO;
import java.util.List;

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

    public boolean atualizarAluno(Aluno aluno){
        try {
            dao.atualizar(aluno);
            return true;
        } catch (SQLException se) {
            return false;
        }
    }

    public List<Aluno> listarAlunos(){
        try {
            return dao.listar();
        } catch (SQLException se) {
            return null;
        }
    }

    public Aluno recuperarAluno(String cpf){
        try {
            return dao.recuperar(cpf);
        } catch (SQLException se) {
            return null;
        }
    }

    public boolean deletarTodos(){
        try {
            dao.removerTodos();
            return true;
        } catch (SQLException se) {
            return false;
        }
    }
}
