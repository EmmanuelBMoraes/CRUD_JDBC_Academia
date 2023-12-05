package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entities.Aluno;
import server.GenericDAO;
import server.JDBC;


public class AlunoDAO implements GenericDAO<String, Aluno>{
     
    //NUMERO DAS COLUNAS DA TUPLA
    public static final int CPF_COLUMN_ORDER = 1;
    public static final int NOME_COLUMN_ORDER = 2; 
    public static final int MATRICULA_COLUMN_ORDER = 3;
    public static final int RUA_COLUMN_ORDER = 4;
    public static final int ID_FICA_ALUNO_COLUMN_ORDER = 5;

    //NOME DAS COLUNAS DA TUPLA
    public static final String CPF_COLUMN_NAME = "cpf";
    public static final String NOME_COLUMN_NAME = "nome"; 
    public static final String MATRICULA_COLUMN_NAME = "matricula";
    public static final String RUA_COLUMN_NAME = "rua";
    public static final String ID_FICA_ALUNO_COLUMN_NAME = "id_ficha_aluno";

    protected JDBC gerenciador;

    public AlunoDAO() throws ClassNotFoundException{
        this.gerenciador = JDBC.getInstance();
    }

    @Override
    public void inserir(Aluno entity) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserir'");
    }

    @Override
    public void remover(String chave) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public void atualizar(Aluno entity) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public List<Aluno> listar() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    @Override
    public Aluno recuperar(String cpf) throws SQLException {
        Connection con = null;
		PreparedStatement ppst = null;
		ResultSet rs = null;
        Aluno aluno = null;
        
        try {
            con = gerenciador.getConnection();

            String sql = "select * from aluno where cpf = ?";

            ppst = con.prepareStatement(sql);
            ppst.setString(CPF_COLUMN_ORDER, cpf);
            rs = ppst.executeQuery();

            if(rs.next()){
                String Cpf = rs.getString(CPF_COLUMN_NAME);
                String nome = rs.getString(NOME_COLUMN_NAME);
                String matricula = rs.getString(MATRICULA_COLUMN_NAME);
                String rua = rs.getString(MATRICULA_COLUMN_NAME);
                int id_ficha_aluno =  rs.getInt(ID_FICA_ALUNO_COLUMN_NAME);

                aluno = new Aluno(Cpf, nome, matricula, rua, id_ficha_aluno);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally{
            if(con != null)con.close();
			if(ppst != null)ppst.close();
			if(rs != null) rs.close();
        }

        return aluno;
    }

    @Override
    public void removerTodos() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerTodos'");
    }

    
}
