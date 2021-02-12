
import DAO.RotaDAO;
import java.time.LocalTime;
import model.Rota;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rafa_
 */
public class testeDAORota {
       
    public static void main(String[] args) {
         LocalTime l = LocalTime.of(15, 00);
        Rota r = new Rota("a03",100, 100,l,2,100);
        
        RotaDAO dao = new RotaDAO();
        dao.create(r);
    }
        
    
}
