package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;
import server.GenericDAO;
import server.JDBC;


public class AlunoDAO implements GenericDAO<String, Aluno>{
     
    //NUMERO DAS COLUNAS DA TUPLA
    //OBS: ACHEI MEIO INÚTIL ESSA PARTE MAS FZ OQ NÉ
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
    public void inserir(Aluno aluno) throws SQLException {
        Connection con = null;
        PreparedStatement ppst = null;

        try {
            con = gerenciador.getConnection();

            String sql = "insert into aluno(cpf, nome, matricula, rua, id_ficha_aluno) values (?,?,?,?,?)";

            ppst = con.prepareStatement(sql);
            ppst.setString(CPF_COLUMN_ORDER, aluno.getCPF());
            ppst.setString(NOME_COLUMN_ORDER, aluno.getNome());
            ppst.setString(MATRICULA_COLUMN_ORDER, aluno.getMatricula());
            ppst.setString(RUA_COLUMN_ORDER, aluno.getRua());
            ppst.setInt(ID_FICA_ALUNO_COLUMN_ORDER, aluno.getIdFicha());

            int qtd = ppst.executeUpdate();
            if (qtd == 0) throw new SQLException("Túpla não inserida!!!!!");
        } catch (SQLException se) {
            se.printStackTrace();
            throw se;
        }
        finally{
            if(ppst != null) ppst.close();
            if(ppst != null) con.close();
        }
    }

    @Override
    public void remover(String chave) throws SQLException {
        Connection con = null;
        PreparedStatement ppst = null;

        try {
            con = gerenciador.getConnection();

            String sql = "delete from aluno where cpf = ?";

            ppst = con.prepareStatement(sql);
            ppst.setString(CPF_COLUMN_ORDER, chave);
            int qtd = ppst.executeUpdate();

            if(qtd == 0) throw new SQLException("Tupla não encontrada");
        } catch (SQLException se) {
            throw se;
        } finally{
            if(con !=null) con.close();
            if(ppst != null) ppst.close();
        }
    }

    @Override
    public void atualizar(Aluno aluno) throws SQLException {
        Connection con = null;
        PreparedStatement ppst = null;

        try {
            con = gerenciador.getConnection();

            String sql = "update aluno set nome = ?, matricula = ?, rua = ?, id_ficha_aluno = ? where cpf = ?";

            ppst = con.prepareStatement(sql);
            ppst.setString(1, aluno.getNome());
            ppst.setString(2, aluno.getMatricula());
            ppst.setString(3, aluno.getRua());
            ppst.setInt(4, aluno.getIdFicha());
            ppst.setString(5, aluno.getCPF());
            int qtd = ppst.executeUpdate();

            if(qtd == 0) throw new SQLException("Túpla não encontrada!");

        } catch (SQLException se) {
            throw se;
        } finally{
            if(con != null) con.close();
            if(ppst != null) ppst.close();
        }
    }

    @Override
    public List<Aluno> listar() throws SQLException {
        List<Aluno> alunos = null;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = gerenciador.getConnection();

            String sql = "select * from aluno";

            st = con.createStatement();
            rs = st.executeQuery(sql);

            alunos = new ArrayList<>();

            while(rs.next()){
                String Cpf = rs.getString(CPF_COLUMN_NAME);
                String nome = rs.getString(NOME_COLUMN_NAME);
                String matricula = rs.getString(MATRICULA_COLUMN_NAME);
                String rua = rs.getString(RUA_COLUMN_NAME);
                int id_ficha_aluno =  rs.getInt(ID_FICA_ALUNO_COLUMN_NAME);

                Aluno aluno = new Aluno(Cpf, nome, matricula, rua, id_ficha_aluno);
                alunos.add(aluno);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally{
            if(con != null)con.close();
			if(st != null)st.close();
			if(rs != null) rs.close();
        }
        return alunos;
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
                String rua = rs.getString(RUA_COLUMN_NAME);
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
        Connection con = null;
        Statement st = null;

        try {
            con = gerenciador.getConnection();

            String sql = "delete from aluno";

            st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException se) {
            throw se;
        } finally{
            if(con != null) con.close();
            if(st != null) st.close();
        }
    }

    
}
