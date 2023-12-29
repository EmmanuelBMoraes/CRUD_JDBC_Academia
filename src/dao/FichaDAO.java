package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;
import entities.Ficha;
import server.GenericDAO;
import server.JDBC;

public class FichaDAO implements GenericDAO<Integer,Ficha>{
    protected JDBC gerenciador;

    public FichaDAO() throws ClassNotFoundException{
        this.gerenciador = JDBC.getInstance();
    }

    @Override
    public void inserir(Ficha ficha) throws SQLException {
        Connection con = null;
        PreparedStatement ppst = null;

        try {
            con=gerenciador.getConnection();

            String sql = "insert into ficha(id_ficha, tipo, dias, intensidade) values (?,?,?,?)";

            ppst = con.prepareStatement(sql);
            ppst.setInt(1, ficha.getId_ficha());
            ppst.setString(2, ficha.getTipo());
            ppst.setInt(3, ficha.getDias());
            ppst.setString(4, ficha.getIntensidade());

            int qtd = ppst.executeUpdate();
            if (qtd == 0) throw new SQLException("Cadastro não realizado!");
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
    public void remover(Integer chave) throws SQLException {
        Connection con = null;
        PreparedStatement ppst = null;

        try {
            con = gerenciador.getConnection();

            String sql = "delete from ficha where id_ficha = ?";

            ppst = con.prepareStatement(sql);
            ppst.setInt(1, chave);
            int qtd = ppst.executeUpdate();

            if(qtd == 0) throw new SQLException("Ficha não encontrada!");
        } catch (SQLException se) {
            throw se;
        } finally{
            if(con !=null) con.close();
            if(ppst != null) ppst.close();
        }
    }

    @Override
    public void atualizar(Ficha ficha) throws SQLException {
        Connection con = null;
        PreparedStatement ppst = null;
    
        try {
            con = gerenciador.getConnection();
    
            String sql = "update ficha set tipo = ?, dias = ?, intensidade = ? where id_ficha = ?";
    
            ppst = con.prepareStatement(sql);
            ppst.setString(1, ficha.getTipo());  
            ppst.setInt(2, ficha.getDias());      
            ppst.setString(3, ficha.getIntensidade());
            ppst.setInt(4, ficha.getId_ficha());    
    
            int qtd = ppst.executeUpdate();
    
            if (qtd == 0) {
                throw new SQLException("Usuário não atualizado!");
            }
    
        } catch (SQLException se) {
            throw se;
        } finally {
            if (con != null) con.close();
            if (ppst != null) ppst.close();
        }
    }
    

    @Override
    public List<Ficha> listar() throws SQLException {
        List<Ficha> fichas = null;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = gerenciador.getConnection();

            String sql = "select * from ficha";

            st = con.createStatement();
            rs = st.executeQuery(sql);

            fichas = new ArrayList<>();

            while(rs.next()){
                int id_ficha = rs.getInt(1);
                String tipo = rs.getString(2);
                int dia = rs.getInt(3);
                String intencidade = rs.getString(4);

                Ficha ficha = new Ficha(id_ficha,tipo,dia,intencidade);
                fichas.add(ficha);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally{
            if(con != null)con.close();
			if(st != null)st.close();
			if(rs != null) rs.close();
        }
        return fichas;
    }

    @Override
    public Ficha recuperar(Integer id) throws SQLException {
        Connection con = null;
		PreparedStatement ppst = null;
		ResultSet rs = null;
        Ficha ficha = null;
        
        try {
            con = gerenciador.getConnection();

            String sql = "select * from ficha where id_ficha = ?";

            ppst = con.prepareStatement(sql);
            ppst.setInt(1, id);
            rs = ppst.executeQuery();

            if(rs.next()){
                int id_ficha = rs.getInt(1);
                String tipo = rs.getString(2);
                int dias = rs.getInt(3);
                String intensidade = rs.getString(4);
                ficha = new Ficha(id_ficha,tipo,dias,intensidade);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally{
            if(con != null)con.close();
			if(ppst != null)ppst.close();
			if(rs != null) rs.close();
        }

        return ficha;
    }

    @Override
    public void removerTodos() throws SQLException {
        Connection con = null;
        Statement st = null;

        try {
            con = gerenciador.getConnection();

            String sql = "delete from ficha";

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
