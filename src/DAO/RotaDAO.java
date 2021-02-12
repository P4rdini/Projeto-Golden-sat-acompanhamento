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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Rota;

/**
 *
 * @author rafa_
 */
public class RotaDAO implements persistencia<Rota> {

    @Override
    public int create(Rota obj) {
        if(isBanco(obj.getIdCliente(), obj.getRota())){
            System.out.println("falha");
            return 0;
        }else{
            
        int id =0;
        connectionFactory con = new connectionFactory();
        PreparedStatement pst = null;
    //    PreparedStatement pst2 = null;
        ResultSet rs = null;
        String sql = "insert into rota (rota,franquiaKM,franquiaHora,adHora,adKM,diaria,cliente_id)value(?,?,?,?,?,?,?)";
       // String sql2 = "update cliente set rota = ? where idCliente = 5";
        try {
             pst = con.getConexao().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
       //      pst2 = con.getConexao().prepareStatement(sql2,PreparedStatement.RETURN_GENERATED_KEYS);
//            Rota r = new Rota(obj.getRota(),obj.getDiaria(),obj.getFranquiaKM(),obj.getFranquiaHora(),obj.getAdHora(),obj.getAdKM());
//            
//           pst2.setObject(1, r);
//            pst2.executeQuery();
            
            pst.setString(1, obj.getRota());
            pst.setInt(2, obj.getFranquiaKM());
            pst.setTime(3,Time.valueOf(obj.getFranquiaHora()));
            pst.setFloat(4, obj.getAdHora());
            pst.setFloat(5, obj.getAdKM());
            pst.setFloat(6, obj.getDiaria());
            pst.setInt(7, obj.getIdCliente());
            
            pst.execute();
            rs = pst.getGeneratedKeys();
            
                
          //      Rota r = new Rota(obj.getRota(),obj.getDiaria(),obj.getFranquiaKM(),obj.getFranquiaHora(),obj.getAdHora(),obj.getAdKM());
                if(rs.next()){
                    id = rs.getInt(1);
           /*     System.out.println(rs.getInt(1));
                pst2.setInt(1, rs.getInt(1));
                
                pst2.execute();
                rs = pst2.getGeneratedKeys();*/
                }
            
             System.out.println("rodouuuuuuuuuuuuuuuuuuuuu");
        } catch (SQLException e) {
            id=0;
            System.out.println(e.getMessage());
        }finally{
            connectionFactory.closeConexao(pst,rs,con);
      //      connectionFactory.closeConexao(pst2);
        }
        return id;
        }
    }

    @Override
    public List<Rota> read() {
            connectionFactory con = new connectionFactory();
         List<Rota> l = new ArrayList<Rota>();
           PreparedStatement pst = null;
           ResultSet rs = null;
       
        String sql= "select * from rota";
        try {
            pst = con.getConexao().prepareCall(sql);
           rs = pst.executeQuery();
          while(rs.next()){
            
           Rota c = new Rota(rs.getString("rota"), rs.getFloat("diaria"),rs.getInt("franquiaKM"),rs.getTime("franquiaHora").toLocalTime(),rs.getFloat("adHora"),rs.getFloat("adKM"), rs.getInt("cliente_id"));
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
    public boolean update(Rota obj) {
        return false;
    }

    @Override
    public boolean delete(Rota obj) {
        return false;
    }
    
    public boolean isBanco(int cliente,String rota){
        List<Rota> l = new ArrayList<Rota>();
        l = read();
        boolean retorno =false;
        String str = cliente+rota;
        for(int i=0;i<l.size();i++){
            String str2 =l.get(i).getIdCliente()+l.get(i).getRota();
            if(str.equals(str2)){
                retorno = true;
            }
        }
        return retorno;
    }
    
}
