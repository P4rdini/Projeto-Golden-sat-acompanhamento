/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import model.Agente;
import model.Missao;


/**
 *
 * @author rafa_
 */
public class MissaoDAO implements persistencia<Missao> {

    @Override
    public int create(Missao obj) {
           int id=0;
            connectionFactory con = new connectionFactory();
           PreparedStatement pst = null;
           ResultSet rs = null;
       
        String sql= "insert into missao (data,agente,cliente,rota,nomeMot,placaMot,horaSolicitada,horaInicio,horaFim,totalKM,observacao) value (?,?,?,?,?,?,?,?,?,?,?)";
        try {
        pst = con.getConexao().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
              
  
            pst.setString(1, obj.getData());
            pst.setDouble(2, obj.getAgente());
            pst.setInt(3, obj.getCliente());
            pst.setInt(4, obj.getRota());
            pst.setString(5, obj.getNomeMot());
            pst.setString(6, obj.getPlacaMot());
            pst.setTime(7, obj.getHoraSolicitada());
            pst.setTime(8, obj.getHoraInicial());
            pst.setTime(9, obj.getHoraFinal());
            pst.setFloat(10, obj.getTotalKM());
            pst.setString(11, obj.getDescricao());
        
        
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
    public List<Missao> read() {
         connectionFactory con = new connectionFactory();
         List<Missao> l = new ArrayList<Missao>();
           PreparedStatement pst = null;
           ResultSet rs = null;
       
        String sql= "select * from missao";
        try {
            pst = con.getConexao().prepareCall(sql);
           rs = pst.executeQuery();
          while(rs.next()){
            
           Missao c = new Missao(rs.getString("data"),rs.getInt("cliente"),rs.getDouble("agente"),rs.getInt("rota"),rs.getString("nomeMot"),rs.getString("placaMot"),rs.getTime("horasolicitada"),rs.getTime("horaInicio"),rs.getTime("horaFim"),rs.getFloat("totalKM"),rs.getString("observacao"));
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
    public boolean update(Missao obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Missao obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 
}
