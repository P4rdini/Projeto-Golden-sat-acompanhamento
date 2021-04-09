
import DAO.RotaDAO;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javafx.util.converter.LocalDateTimeStringConverter;
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
public class CadastroRotaTeste {
    
    public static void main(String[] args) {
    LocalTime t = LocalTime.of(02,00);
    Rota r = new Rota("a01", 100, 100,t, 5, 50, 1);
    
    RotaDAO dao = new RotaDAO();
    
    dao.create(r);
        
    }
    
    
    
    
    
    
}
