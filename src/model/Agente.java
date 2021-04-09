/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.AgenteDAO;
import DAO.ClienteDAO;
import DAO.MissaoDAO;
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
    private String estado;
    private String cidade;

    public Agente(String nome, double cpf, String placa, boolean registrado, String endereco, String estado , String cidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.placa = placa;
        this.registrado = registrado;
        this.endereco = endereco;
        this.estado = estado;
        this.cidade = cidade;
    }

    public Agente() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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
    public static String converterAgente(double id){
        AgenteDAO dao = new AgenteDAO();
        List<Agente> l = new ArrayList<Agente>();
        String str = null;
        l = dao.read();
        
        for(int i=0;i<l.size();i++){
            if(l.get(i).getCpf() == id){
                str = l.get(i).getNome();
            }
        }
        return str;
    }
    
    public static List<Agente> search(String coluna,String pesquisa){
        List<Agente> m = new ArrayList<Agente>();
        List<Agente> resp = new ArrayList<Agente>();
        AgenteDAO dao = new AgenteDAO();
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
        }if(coluna.equals("CPF"))
        {
            for(int i=0;i<m.size();i++)
            {
                if(String.valueOf(m.get(i).getCpf()).toLowerCase().contains(pesquisa.toLowerCase()))
                {
                    resp.add(m.get(i));
                }
            }
        }if (coluna.equals("Placa"))
        {
            for(int i=0;i<m.size();i++)
            {
                if(m.get(i).getPlaca().toLowerCase().contains(pesquisa.toLowerCase()))
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
        }if (coluna.equals("Cidade"))
        {
            for(int i=0;i<m.size();i++)
            {
                if(m.get(i).getCidade().toLowerCase().contains(pesquisa.toLowerCase()))
                {
                    resp.add(m.get(i));
                }
            }
        }if (coluna.equals("Endereço"))
        {
            for(int i=0;i<m.size();i++)
            {
                if(m.get(i).getEndereco().toLowerCase().contains(pesquisa.toLowerCase()))
                {
                    resp.add(m.get(i));
                }
            }
        }
          return resp;  
    }
    
    
}
