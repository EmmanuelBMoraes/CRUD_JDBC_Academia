package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/academia";

    static final String USER = "postgres";
	static final String PASS = "admin";

    private static JDBC instance = null;

    protected JDBC(){}

    public static JDBC getInstance() throws ClassNotFoundException{
        if(instance == null){
            //CARREGA O DRIVER
            Class.forName(JDBC_DRIVER);
            //CRIA A INSTANCIA DO GERENCIADOR
            instance = new JDBC(); 
        }
        return instance;
    }

    public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return con;
    }

    public static String getJdbcDriver() {
        return JDBC_DRIVER;
    }
    
    public static String getPass() {
        return PASS;
    }

    public static String getUser() {
        return USER;
    }
    public static String getDbUrl() {
        return DB_URL;
    }
}
