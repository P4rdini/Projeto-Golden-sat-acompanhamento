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
import model.Cliente;
import model.Rota;

/**
 *
 * @author rafa_
 */
public class ClienteDAO implements persistencia<Cliente> {

    @Override
    public int create(Cliente obj) {
       if(isBanco(obj.getNome(), obj.getEstado())){
           System.out.println("falha");
           return 0;
       }else{
          int id=0;
            connectionFactory con = new connectionFactory();
           PreparedStatement pst = null;
           ResultSet rs = null;
           
        String sql= "insert into cliente (nome,endereco,telefone,estado) value (?,?,?,?)";
        try {
        pst = con.getConexao().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
              
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getEndereco());
            pst.setLong(3, obj.getTelefone());
            pst.setString(4, obj.getEstado());
            
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

    }

    @Override
    public List<Cliente> read() {
         connectionFactory con = new connectionFactory();
         List<Cliente> l = new ArrayList<Cliente>();
           PreparedStatement pst = null;
           ResultSet rs = null;
       
        String sql= "select * from cliente";
        try {
            pst = con.getConexao().prepareCall(sql);
           rs = pst.executeQuery();
          while(rs.next()){
            
           Cliente c = new Cliente(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5));
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
    public boolean update(Cliente obj) {
        return false;
    }

    @Override
    public boolean delete(Cliente obj) {
        return false;
    }
    
    
    public boolean isBanco(String nome,String estado){
        boolean retorno =false;
        String str = nome+" - "+estado;
        List<Cliente> l = new ArrayList<Cliente>();
        l = read();
        for(int i=0;i<l.size();i++){
            String resp =l.get(i).getNome()+" - "+l.get(i).getEstado();
            if(str.equals(resp)){
                retorno = true;
            }
        }
        return retorno;
    }
    
}
