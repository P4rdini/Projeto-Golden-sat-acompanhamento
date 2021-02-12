/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author rafa_
 */
public class Missao {
    private int id;
    private Date data;
    private Cliente cliente;
    private Agente agente;
    private Rota rota;
    private String nomeMot;
    private String placaMot;
    private Date horaSolicitada;
    private Date horaInicial;
    private Date horaFinal;
    private float totalKM;
    private float adMissao;
    private String descricao;

    public Missao() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
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

    public Date getHoraSolicitada() {
        return horaSolicitada;
    }

    public void setHoraSolicitada(Date horaSolicitada) {
        this.horaSolicitada = horaSolicitada;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
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

  
    
    
    
    
}
