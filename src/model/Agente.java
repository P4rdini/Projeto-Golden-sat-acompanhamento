/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.AgenteDAO;
import DAO.ClienteDAO;
import com.sun.xml.internal.ws.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author rafa_
 */
public class Agente {
    private String nome;
    private double cpf;
    private String placa;
    private boolean registrado; // nao lembro se usa boolean tipo primitivo ou objeto
    private String endereco;

    public Agente(String nome, double cpf, String placa, boolean registrado, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.placa = placa;
        this.registrado = registrado;
        this.endereco = endereco;
    }

    
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCpf() {
        return cpf;
    }

    public void setCpf(double cpf) {
        this.cpf = cpf;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isRegistrado() {
        return registrado;
    }

    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Agente{" + "nome=" + nome + ", cpf=" + cpf + ", placa=" + placa + ", registrado=" + registrado + ", endereco=" + endereco + '}';
    }
    
    public boolean adicionar(Agente agente){
        AgenteDAO dao = new AgenteDAO();
        if(dao.create(agente) != 0){
            return true;
        }else{
            return false;
        }
    }
    
    public static List<Agente> pegarAgentes(JComboBox c){
         AgenteDAO dao = new AgenteDAO();
        List<Agente> l = new ArrayList<Agente>();
        l = dao.read();
        
        for(int i=0;i<l.size();i++){
            c.addItem(StringUtils.capitalize(l.get(i).getNome()));
        }
        
        return l;
    }
    
    
    
}
