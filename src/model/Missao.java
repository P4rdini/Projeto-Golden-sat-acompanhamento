/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.MissaoDAO;
import java.sql.Time;

/**
 *
 * @author rafa_
 */
public class Missao {
    private int id;
    private String data;
    private int cliente;
    private double agente;
    private int rota;
    private String nomeMot;
    private String placaMot;
    private Time horaSolicitada;
    private Time horaInicial;
    private Time horaFinal;
    private float totalKM;
    private float adMissao;
    private String descricao;

    public Missao(String data, int cliente, double agente, int rota, String nomeMot, String placaMot, Time horaSolicitada, Time horaInicial, Time horaFinal, float totalKM, String descricao) {
        
        this.data = data;
        this.cliente = cliente;
        this.agente = agente;
        this.rota = rota;
        this.nomeMot = nomeMot;
        this.placaMot = placaMot;
        this.horaSolicitada = horaSolicitada;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.totalKM = totalKM;
        this.descricao = descricao;
    }

    public Missao() {
    }

    
    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public float getAdMissao() {
        return adMissao;
    }

    public void setAdMissao(float adMissao) {
        this.adMissao = adMissao;
    }
    
    
    public String getDescricao() {
        return descricao;
    }
        
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getAgente() {
        return agente;
    }

    public void setAgente(double agente) {
        this.agente = agente;
    }

    public int getRota() {
        return rota;
    }

    public void setRota(int rota) {
        this.rota = rota;
    }

    public String getNomeMot() {
        return nomeMot;
    }

    public void setNomeMot(String nomeMot) {
        this.nomeMot = nomeMot;
    }

    public String getPlacaMot() {
        return placaMot;
    }

    public void setPlacaMot(String placaMot) {
        this.placaMot = placaMot;
    }

    public Time getHoraSolicitada() {
        return horaSolicitada;
    }

    public void setHoraSolicitada(Time horaSolicitada) {
        this.horaSolicitada = horaSolicitada;
    }

    public Time getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Time horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Time getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Time horaFinal) {
        this.horaFinal = horaFinal;
    }

    public float getTotalKM() {
        return totalKM;
    }

    public void setTotalKM(float totalKM) {
        this.totalKM = totalKM;
    }

    @Override
    public String toString() {
        return "Missao{" + "id=" + id + ", data=" + data + ", agente=" + agente + ", rota=" + rota + ", nomeMot=" + nomeMot + ", placaMot=" + placaMot + ", horaSolicitada=" + horaSolicitada + ", horaInicial=" + horaInicial + ", horaFinal=" + horaFinal + ", totalKM=" + totalKM + ", adMissao=" + adMissao + ", descricao=" + descricao + '}';
    }

  
    public boolean cadastrar(){
        MissaoDAO dao = new MissaoDAO();
        if(dao.create(this) != 0){
            return true;
        }else{
            return false;
        }
    }
    
    
    
}
