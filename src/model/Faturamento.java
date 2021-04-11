/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.AgenteDAO;
import DAO.MissaoDAO;
import DAO.RotaDAO;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafa_
 */
public class Faturamento {
    private String agente;
    private int horaTrabalhada;
    private int minutoTrabalhada;
    private float kmPercorrido;
    private double total;

    
    
    public List<Faturamento> Faturamento(Calendar inicio , Calendar fim) {
        MissaoDAO mDAO = new MissaoDAO();
        RotaDAO rDAO = new RotaDAO();
        AgenteDAO aDAO = new AgenteDAO();
        List<Missao> m = new ArrayList<Missao>();
        List<Missao> missao = new ArrayList<Missao>();
        List<Agente> agente = new ArrayList<Agente>();
        List<Rota> rota = new ArrayList<Rota>();
        List<Faturamento> faturamento = new ArrayList<Faturamento>();
        Faturamento f;
        rota = rDAO.read();
        agente = aDAO.read();
        fim.add(Calendar.DAY_OF_MONTH, 1);
        m = mDAO.read();
        for(int i=0;i<m.size();i++){
            Calendar data = Calendar.getInstance();
            data.set(Integer.valueOf(m.get(i).getData().substring(6, 8)), Integer.valueOf(m.get(i).getData().substring(3, 5)),
                    Integer.valueOf( m.get(i).getData().substring(0, 2)));
            if(inicio.before(data) && fim.after(data)){
                missao.add(m.get(i));
                System.out.println("rodouuu");
            }
        }
        
        for (int j = 0; j < agente.size(); j++) {
            f = new Faturamento();
            f.setAgente(agente.get(j).getNome());
            faturamento.add(f);
        }
        for (int i = 0; i < faturamento.size(); i++) {
            for (int j = 0; j < missao.size(); j++) {
                if (faturamento.get(i).getAgente().equals(Agente.converterAgente(missao.get(j).getAgente()))) {
                    faturamento.get(i).setKmPercorrido(faturamento.get(i).getKmPercorrido() + missao.get(j).getTotalKM());
                    for (int k = 0; k < rota.size(); k++) {
                        if (rota.get(k).getId() == missao.get(j).getRota()) {
                            
                            LocalTime franquia = LocalTime.of(rota.get(k).getFranquiaHora().getHour(), rota.get(k).getFranquiaHora().getMinute());
                            LocalTime totalHoras = missao.get(j).getHoraFinal().toLocalTime().minusHours(missao.get(j).getHoraInicial().toLocalTime().getHour()).minusMinutes(missao.get(j).getHoraInicial().toLocalTime().getMinute());
                            faturamento.get(i).setTotal(faturamento.get(i).getTotal() + rota.get(k).getDiaria());
                            
                            if (missao.get(j).getTotalKM() > rota.get(k).getFranquiaKM()) {
                                float resta = missao.get(j).getTotalKM() - rota.get(k).getFranquiaKM();
                                faturamento.get(i).setTotal(faturamento.get(i).getTotal() + (rota.get(k).getAdKM() * resta));
                            }

                            if (totalHoras.toNanoOfDay() > franquia.toNanoOfDay()) {
                                LocalTime resp;
                                int minutos = (totalHoras.getMinute() + faturamento.get(i).getMinutoTrabalhada());
                                if (minutos > 59) {
                                    System.out.println("Rodou condicao");
                                    minutos -= 60;
                                    faturamento.get(i).setHoraTrabalhada(faturamento.get(i).getHoraTrabalhada() + totalHoras.getHour() + 1);
                                    faturamento.get(i).setMinutoTrabalhada(minutos);
                                } else {
                                    System.out.println("Nao Rodou condicao");
                                    faturamento.get(i).setHoraTrabalhada(faturamento.get(i).getHoraTrabalhada() + totalHoras.getHour());
                                    faturamento.get(i).setMinutoTrabalhada(minutos);
                                }
                            }else{
                                LocalTime resp;
                                int minutos = (totalHoras.getMinute() + faturamento.get(i).getMinutoTrabalhada());
                                faturamento.get(i).setHoraTrabalhada(faturamento.get(i).getHoraTrabalhada() + totalHoras.getHour());
                                faturamento.get(i).setMinutoTrabalhada(minutos);
                            }

                        }
                    }
                }
            }
        }
        List<Faturamento> resp = new ArrayList<Faturamento>();
        
        for (int i = 0; i < faturamento.size(); i++) {
            System.out.println(faturamento.get(i).toString());
            if(!(faturamento.get(i).getTotal() == 0.0)){
                resp.add(faturamento.get(i));
            }
        }
        
        return resp;
    }

    public Faturamento() {
    }
    
    
    public int getMinutoTrabalhada() {
        return minutoTrabalhada;
    }

    public void setMinutoTrabalhada(int minutoTrabalhada) {
        this.minutoTrabalhada = minutoTrabalhada;
    }
    
    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public int getHoraTrabalhada() {
        return horaTrabalhada;
    }

    public void setHoraTrabalhada(int horaTrabalhada) {
        this.horaTrabalhada = horaTrabalhada;
    }

    public float getKmPercorrido() {
        return kmPercorrido;
    }

    public void setKmPercorrido(float kmPercorrido) {
        this.kmPercorrido = kmPercorrido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    @Override
    public String toString() {
        return "Faturamento{" + "agente=" + agente + ", horaTrabalhada=" + horaTrabalhada +":"+minutoTrabalhada+  ", kmPercorrido=" + kmPercorrido + ", total=" + total + '}';
    }

    

    
    
    
    
    
    
}
