/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author rafa_
 */
public class Mascara {
        
        public static DefaultFormatterFactory getCPF(){
            MaskFormatter mask = null;
            try {
                mask = new MaskFormatter("###.###.###-##");
                mask.setPlaceholderCharacter('_');
            } catch (ParseException e) {
                return null;
            }
            return (new DefaultFormatterFactory(mask,mask));
        }
    
        public static DefaultFormatterFactory getPlaca(){
            MaskFormatter mask = null;
            try {
                mask = new MaskFormatter("UUU-#H##");
                mask.setPlaceholderCharacter('_');
            } catch (ParseException e) {
                return null;
            }
            return (new DefaultFormatterFactory(mask,mask));
        }
        public static DefaultFormatterFactory getHora(){
            MaskFormatter mask = null;
            
            try {
                mask = new MaskFormatter("##:##");
                
            } catch (ParseException e) {
                return null;
            }
            return (new DefaultFormatterFactory(mask,mask));
        }
        
        public static String nomeCliente(String nome,String estado){
            return (String)nome+" - "+estado;
        }
        
        public static DefaultFormatterFactory getFone(){
             MaskFormatter mask = null;
            
            try {
                mask = new MaskFormatter("(##)#####-####");
                mask.setPlaceholderCharacter(' ');
            } catch (ParseException e) {
                return null;
            }
            return (new DefaultFormatterFactory(mask,mask));
        }
}
