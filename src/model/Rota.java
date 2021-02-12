/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.RotaDAO;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author rafa_
 */
public class Rota {
    private String rota;
    private float diaria;
    private int franquiaKM;
    private LocalTime franquiaHora;
    private float adHora;
    private float adKM;
    private int idCliente;
    SimpleDateFormat padraoHora = new SimpleDateFormat("HH:MM:SS");

    public Rota(String rota, float diaria, int franquiaKM, LocalTime franquiaHora, float adHora, float adKM, int idCliente) {
        this.rota = rota;
        this.diaria = diaria;
        this.franquiaKM = franquiaKM;
        this.franquiaHora = franquiaHora;
        this.adHora = adHora;
        this.adKM = adKM;
        this.idCliente = idCliente;
    }

    public Rota(String rota, float diaria, int franquiaKM, LocalTime franquiaHora, float adHora, float adKM) {
        this.rota = rota;
        this.diaria = diaria;
        this.franquiaKM = franquiaKM;
        this.franquiaHora = franquiaHora;
        this.adHora = adHora;
        this.adKM = adKM;
    }
        
    
    
    
    public int getIdCliente() {
        return idCliente;
    }

    
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public float getDiaria() {
        return diaria;
    }

    public void setDiaria(float diaria) {
        this.diaria = diaria;
    }


    public int getFranquiaKM() {
        return franquiaKM;
    }

    public void setFranquiaKM(int franquiaKM) {
        this.franquiaKM = franquiaKM;
    }

    public LocalTime getFranquiaHora() {
        return franquiaHora;
    }

    public void setFranquiaHora(LocalTime franquiaHora) {
        this.franquiaHora = franquiaHora;
    }

    public float getAdHora() {
        return adHora;
    }

    public void setAdHora(float adHora) {
        this.adHora = adHora;
    }

    public float getAdKM() {
        return adKM;
    }

    public void setAdKM(float adKM) {
        this.adKM = adKM;
    }

    @Override
    public String toString() {
        return "Rota{" + "rota=" + rota + ", diaria=" + diaria + ", franquiaKM=" + franquiaKM + ", franquiaHora=" + franquiaHora + ", adHora=" + adHora + ", adKM=" + adKM + ", idCliente=" + idCliente + '}';
    }

    public static List<Rota> pegarRotas(int cliente,JComboBox c){
        List<Rota> rota = new ArrayList<Rota>();
        List<Rota> resp = new ArrayList<Rota>();
        RotaDAO dao = new RotaDAO();
        rota = dao.read();
        for(int i=0;i<rota.size();i++){
            if(rota.get(i).idCliente == cliente){
                resp.add(rota.get(i));
                 c.addItem(rota.get(i).getRota().toUpperCase());
            }
        }
        return resp;
    } 

 
   
    
    public boolean adicionar(){
        RotaDAO dao = new RotaDAO();
        if(dao.create(this) != 0){
            return true;
        }else{
            return false;
        }
    }
    
                                                    
                                                    
                            
}
