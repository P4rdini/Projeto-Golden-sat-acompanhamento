/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author rafa_
 */
public class GerenciarJanela {

    private static JDesktopPane desktop;
    
    public GerenciarJanela(JDesktopPane desktop) {
        this.desktop = desktop;
    }
    
    public void abrirJanela(JInternalFrame frame){
        if(frame.isVisible()){
            frame.toFront();
            frame.requestFocus();
        }else{
            desktop.repaint();
            desktop.add(frame);
            frame.setVisible(true);
        }
    }
    
}
