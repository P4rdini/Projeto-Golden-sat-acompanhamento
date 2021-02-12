/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Agente;
import model.Cliente;

/**
 *
 * @author rafa_
 */
public class AgenteDAO implements persistencia<Agente> {

    @Override
    public int create(Agente obj) {
           int id=0;
            connectionFactory con = new connectionFactory();
           PreparedStatement pst = null;
           ResultSet rs = null;
       
        String sql= "insert into agente (nome,cpf,placa,registrado,endereco) value (?,?,?,?,?)";
        try {
        pst = con.getConexao().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
              
  
            pst.setString(1,obj.getNome());
            pst.setDouble(2, obj.getCpf());
            pst.setString(3, obj.getPlaca());
            pst.setBoolean(4,obj.isRegistrado());
            pst.setString(5, obj.getEndereco());
            
            pst.execute();                                                                                                    
            rs = pst.getGeneratedKeys();
            
            if(rs.next()){
                id = rs.getInt(1);
            }
                                                         
        } catch (SQLException e) {
            id=0;
            
            System.out.println(e.getLocalizedMessage());
        }finally{
            connectionFactory.closeConexao(pst);
        }
       return id;
    }

    @Override
    public List<Agente> read() {
        connectionFactory con = new connectionFactory();
         List<Agente> l = new ArrayList<Agente>();
           PreparedStatement pst = null;
           ResultSet rs = null;
       
        String sql= "select * from agente";
        try {
            pst = con.getConexao().prepareCall(sql);
           rs = pst.executeQuery();
          while(rs.next()){
            
           Agente c = new Agente(rs.getString("nome"),rs.getLong("cpf"),rs.getString("placa"), rs.getBoolean("registrado"), rs.getString("endereco"));
           l.add(c);
        }
        } catch (SQLException e) {
            System.out.println("deu errado "+e.getMessage());
        }finally{
            connectionFactory.closeConexao(pst, rs, con);
        }
        return l;
    }

    @Override
    public boolean update(Agente obj) {
        return true;
    }

    @Override
    public boolean delete(Agente obj) {
        return true;
    }
    
    
}
