import java.util.Calendar;
import model.Faturamento;

public class testeFaturamento {

    public static void main(String[] args) {
    
      
        Calendar inicio = Calendar.getInstance();
        Calendar fim = Calendar.getInstance();
        inicio.set(21,03, 15);
        fim.set(21,03, 19);
        
   
        
        Faturamento f = new Faturamento();
        f.Faturamento(inicio, fim);
        
        
     /*   MissaoDAO mDAO = new MissaoDAO();
        RotaDAO rDAO = new RotaDAO();
        AgenteDAO aDAO = new AgenteDAO();
        List<Missao> missao = new ArrayList<Missao>();
        List<Agente> agente = new ArrayList<Agente>();
        List<Rota> rota = new ArrayList<Rota>();
        List<Faturamento> faturamento = new ArrayList<Faturamento>();
        Faturamento f;
        rota = rDAO.read();
        missao = mDAO.read();
        agente = aDAO.read();

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
                                    minutos -= 60;
                                    faturamento.get(i).setHoraTrabalhada(faturamento.get(i).getHoraTrabalhada() + totalHoras.getHour() + 1);
                                    faturamento.get(i).setMinutoTrabalhada(minutos);
                                } else {
                                    faturamento.get(i).setHoraTrabalhada(faturamento.get(i).getHoraTrabalhada() + totalHoras.getHour());
                                    faturamento.get(i).setMinutoTrabalhada(minutos);
                                }
                            }

                        }
                    }
                }
            }
        }

        for (int i = 0; i < faturamento.size(); i++) {
            System.out.println(faturamento.get(i).toString());
        }*/
    }
}
