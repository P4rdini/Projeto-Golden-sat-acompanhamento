package view;

import DAO.MissaoDAO;
import DAO.RotaDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Agente;
import model.Faturamento;
import model.Missao;
import model.Rota;
import util.Calendario;


public class TelaFaturamento extends javax.swing.JInternalFrame {
    
    private static TelaFaturamento tela;
    
    public static TelaFaturamento getInstancia(){
        if(tela == null){
            tela = new TelaFaturamento();
        }
            return tela;
       
    }
    
    public TelaFaturamento() {
        initComponents();
        
    }
    public void getTabela(List<Faturamento> l){
        
        if(!l.isEmpty()){
            
            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Agente");
            model.addColumn("Horas Trabalhadas");
            model.addColumn("KM Percorrido");
            model.addColumn("Valor Total");

            for (int i = 0; i < l.size(); i++) {
                String[] reg = {l.get(i).getAgente(), String.valueOf(l.get(i).getHoraTrabalhada()+":"+l.get(i).getMinutoTrabalhada()), String.valueOf(l.get(i).getKmPercorrido()), String.valueOf(l.get(i).getTotal())};
                model.addRow(reg);

            }

            Tabela.setModel(model);
            Tabela.setAutoCreateRowSorter(true);
            ((DefaultTableCellRenderer) Tabela.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            Tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        }else{
            JOptionPane.showMessageDialog(null, "Nenhum Resultado encontrado !");
        }
    }
    
    public void Faturamento(){
        MissaoDAO mDAO = new MissaoDAO();
        RotaDAO rDAO = new RotaDAO();
        List<Missao> missao = new ArrayList<Missao>();
        List<Rota> rota = new ArrayList<Rota>();
        List<Faturamento> faturamento = new ArrayList<Faturamento>();
        Faturamento f = new Faturamento();
        rota = rDAO.read();
        missao = mDAO.read();
        
        for(int i=0;i<missao.size();i++){
            for(int j=0;j<rota.size();j++){
                if(missao.get(i).getRota() == rota.get(j).getId()){
                    f.setAgente(Agente.converterAgente(missao.get(i).getAgente()));
                    f.setKmPercorrido(missao.get(i).getTotalKM());
                    faturamento.add(f);
                    
                }
            }
        }
        
        System.out.println(faturamento.toString());
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        lbDataInicial = new javax.swing.JLabel();
        lbDataFinal = new javax.swing.JLabel();
        btFaturar = new javax.swing.JButton();
        tfDatainicial = new javax.swing.JTextField();
        tfDataFinal = new javax.swing.JTextField();
        btDataInicial = new javax.swing.JButton();
        btDataFinal = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tabela);

        lbDataInicial.setText("Data Inicial:");

        lbDataFinal.setText("Data Final:");

        btFaturar.setText("Faturar");
        btFaturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFaturarActionPerformed(evt);
            }
        });

        tfDatainicial.setEditable(false);
        tfDatainicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfDatainicialKeyPressed(evt);
            }
        });

        tfDataFinal.setEditable(false);
        tfDataFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfDataFinalKeyPressed(evt);
            }
        });

        btDataInicial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_calendar_20px.png"))); // NOI18N
        btDataInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDataInicialActionPerformed(evt);
            }
        });

        btDataFinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_calendar_20px.png"))); // NOI18N
        btDataFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDataFinalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDataInicial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDatainicial, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDataInicial)
                .addGap(83, 83, 83)
                .addComponent(lbDataFinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDataFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDataFinal)
                .addGap(159, 159, 159)
                .addComponent(btFaturar, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addGap(52, 52, 52))
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btDataInicial)
                    .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbDataInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbDataFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfDatainicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btDataFinal)
                    .addComponent(btFaturar))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 847, 524);
    }// </editor-fold>//GEN-END:initComponents

    private void tfDataFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDataFinalKeyPressed
        
    }//GEN-LAST:event_tfDataFinalKeyPressed

    private void tfDatainicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDatainicialKeyPressed
                // TODO add your handling code here:
    }//GEN-LAST:event_tfDatainicialKeyPressed

    private void btDataInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDataInicialActionPerformed
          Calendario c = new Calendario(tfDatainicial);
        c.setVisible(true);
        c.setLocation(tfDatainicial.getX(), tfDatainicial.getY());
    }//GEN-LAST:event_btDataInicialActionPerformed

    private void btDataFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDataFinalActionPerformed
        Calendario c = new Calendario(tfDataFinal);
        c.setVisible(true);
        c.setLocation(tfDataFinal.getX(), tfDataFinal.getY()); 
    }//GEN-LAST:event_btDataFinalActionPerformed

    private void btFaturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFaturarActionPerformed
        if(!tfDatainicial.getText().isEmpty() && !tfDataFinal.getText().isEmpty()){
        Tabela.setModel(new DefaultTableModel());
        Calendar inicio = Calendar.getInstance();
        Calendar fim = Calendar.getInstance();
        
        inicio.set(Integer.valueOf(tfDatainicial.getText().substring(8, 10)),Integer.valueOf(tfDatainicial.getText().substring(3, 5)),
                Integer.valueOf(tfDatainicial.getText().substring(0, 2)));
        fim.set(Integer.valueOf(tfDataFinal.getText().substring(8, 10)),Integer.valueOf(tfDataFinal.getText().substring(3, 5)),
                Integer.valueOf(tfDataFinal.getText().substring(0, 2)));
        
        if(fim.getTimeInMillis()<inicio.getTimeInMillis()){
            JOptionPane.showMessageDialog(null,"Data Final nao pode anterior a data Inicial");
            tfDatainicial.setText("");
            tfDataFinal.setText("");
            
        }else{
            List<Faturamento> lista = new ArrayList<Faturamento>();
            Faturamento f = new Faturamento();
            lista = f.Faturamento(inicio, fim);
            getTabela(lista);
        }
            
        }else{
            JOptionPane.showMessageDialog(null, "Preencha o Periodo !");
        }
    }//GEN-LAST:event_btFaturarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabela;
    private javax.swing.JButton btDataFinal;
    private javax.swing.JButton btDataInicial;
    private javax.swing.JButton btFaturar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDataFinal;
    private javax.swing.JLabel lbDataInicial;
    private javax.swing.JPanel pnMain;
    private javax.swing.JTextField tfDataFinal;
    private javax.swing.JTextField tfDatainicial;
    // End of variables declaration//GEN-END:variables
}
