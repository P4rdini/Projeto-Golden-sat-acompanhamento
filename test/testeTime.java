
import java.time.LocalTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rafa_
 */
public class testeTime {
    public static void main(String[] args) {
        String hora = "15:30";;
        
        String horaSolicitaUniao = String.valueOf(hora.charAt(0))+String.valueOf(hora.charAt(1));
            String minutoSlicitaUniao = String.valueOf(hora.charAt(3))+String.valueOf(hora.charAt(4));
            
           LocalTime horaSolicitada = LocalTime.of(Integer.valueOf(horaSolicitaUniao),Integer.valueOf(minutoSlicitaUniao));
           
           
            System.out.println(horaSolicitada);

    }
}
