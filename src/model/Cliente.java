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

    public Cliente() {
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
    public static String converterCliente(int id){
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> l = new ArrayList<Cliente>();
        l = dao.read();
        String str = null;
        
        for(int i=0;i<l.size();i++){
            if(l.get(i).getId() == id){
                str = l.get(i).getNome()+" - "+l.get(i).getEstado();
            }
        }
        return str;
    }
    
    public static List<Cliente> search(String coluna,String pesquisa){
        List<Cliente> m = new ArrayList<Cliente>();
        List<Cliente> resp = new ArrayList<Cliente>();
        ClienteDAO dao = new ClienteDAO();
        m = dao.read();
        if(coluna.equals("Nome"))
        {
            for(int i=0;i<m.size();i++)
            {
                if(m.get(i).getNome().toLowerCase().contains(pesquisa.toLowerCase()))
                {
                    resp.add(m.get(i));
                }
            }
        }if(coluna.equals("Telefone"))
        {
            for(int i=0;i<m.size();i++)
            {
                if(String.valueOf(m.get(i).getTelefone()).toLowerCase().contains(pesquisa.toLowerCase()))
                {
                    resp.add(m.get(i));
                }
            }
        }if (coluna.equals("Estado"))
        {
            for(int i=0;i<m.size();i++)
            {
                if(m.get(i).getEstado().toLowerCase().contains(pesquisa.toLowerCase()))
                {
                    resp.add(m.get(i));
                }
            }
        }
          return resp;  
    }
    
}
