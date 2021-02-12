package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author rafa_
 */
public class connectionFactory {


     private Connection con;
    
    private void conectar(){
        System.out.println("Conectando ao banco ");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/goldentracking","root","123456");
            System.out.println("Conectado !!!!");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Classe nao encontrada , adicione o drive nas bibliotecas");
            java.util.logging.Logger.getLogger(connectionFactory.class.getName()).log(Level.SEVERE, null , e);
            System.out.println(e);
        }
    }
    public Connection getConexao(){
        conectar();
        return con;
    }
    
    public static void closeConexao(Connection con){
        try {
            if(con != null)con.close();
            System.out.println("fechou conexao");
        } catch (SQLException e) {
            throw new RuntimeException("erro ao fechar a conexao ");
        }
    }
    static void closeConexao(PreparedStatement pst) {
         try {
            if(pst != null)pst.close();
            System.out.println("fechou conexao");
        } catch (SQLException e) {
            throw new RuntimeException("erro ao fechar a conexao ");
        }
    }
    static void closeConexao(PreparedStatement pst, ResultSet rs, connectionFactory con) {
         try {
            if(pst != null)pst.close();
            System.out.println("fechou conexao");
        } catch (SQLException e) {
            throw new RuntimeException("erro ao fechar a conexao ");
        }
    }
}
