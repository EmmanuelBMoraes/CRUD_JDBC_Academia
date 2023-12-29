package service;

import java.sql.SQLException;
import java.util.List;
import dao.FichaDAO;
import entities.Ficha;

public class FichaService {
    private FichaDAO dao;

    public FichaService() throws ClassNotFoundException{
        this.dao=new FichaDAO();
    } 

    public boolean salvarFicha(Ficha ficha){
        try {
            this.dao.inserir(ficha);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean removerFicha(int chave){
        try {
            dao.remover(chave);
            return true;
        } catch (SQLException se) {
            return false;
        }
    }

    public boolean atualizarFicha(Ficha ficha){
        try {
            dao.atualizar(ficha);
            return true;
        } catch (SQLException se) {
            return false;
        }
    }

    public List<Ficha> listarFichas(){
        try {
            return dao.listar();
        } catch (SQLException se) {
            return null;
        }
    }

    public Ficha recuperarFicha(int id){
        try {
            return dao.recuperar(id);
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
