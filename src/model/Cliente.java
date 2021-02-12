/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.ClienteDAO;
import com.sun.xml.internal.ws.util.StringUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javafx.scene.control.ComboBox;
import javax.swing.JComboBox;

/**
 *
 * @author rafa_
 */
public class Cliente {
    private int id;
    private String nome;
    private String endereco;
    private long telefone;
    private String estado;

    public Cliente(int id,String nome, String endereco, long telefone, String estado) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", estado=" + estado + '}';
    }

 
    
    
    
    public boolean adicionar(){
        ClienteDAO dao = new ClienteDAO();
        if(dao.create(this) != 0){
            return true;
        }else{
            return false;
        }
    }
    
    public static List<Cliente> pegarNomes(JComboBox c){
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> l = new ArrayList<Cliente>();
        l = dao.read();
        
        for(int i=0;i<l.size();i++){
            c.addItem(StringUtils.capitalize(l.get(i).getNome()+" - "+l.get(i).getEstado()));
        }
        
        return l;
    }
    
}
