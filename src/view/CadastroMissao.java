/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.Agente;
import model.Cliente;
import model.Missao;
import model.Rota;
import util.Mascara;

/**
 *
 * @author rafa_
 */
public class CadastroMissao extends javax.swing.JInternalFrame {

    private List<Cliente> cliente = new ArrayList<>();
    private List<Agente> agente = new ArrayList<>();
    private List<Rota> rota = new ArrayList<>();
    private int id;
    private static CadastroMissao tela;
    
    public static JInternalFrame getInstancia(){
        if(tela ==null){
            tela = new CadastroMissao();
        }
        return tela;
    }
    public CadastroMissao() {
        initComponents();
        cliente = Cliente.pegarNomes(cbCliente);
        agente = Agente.pegarAgentes(cbAgente);
        tfPlacaMot.setFormatterFactory(Mascara.getPlaca());
        tfHoraSolicitada.setFormatterFactory(Mascara.getHora());
        tfHoraInicio.setFormatterFactory(Mascara.getHora());
        tfHoraFim.setFormatterFactory(Mascara.getHora());
    }

    
     public void limpar(){
        cbCliente.setSelectedIndex(0);
        cbRota.setSelectedIndex(0);
        cbAgente.setSelectedIndex(0);
        tfNomeMot.setText("");
        tfPlacaMot.setText("");
        tfHoraSolicitada.setText("");
        tfHoraInicio.setText("");
        tfHoraFim.setText("");
        tfKMfinal.setText("");
        tfKMinicial.setText("");
        taDescricao.setText("");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPrincipal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbRota = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbAgente = new javax.swing.JComboBox<>();
        lbPlaca = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfNomeMot = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfKMinicial = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfKMfinal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        btCadastro = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        tfPlacaMot = new javax.swing.JFormattedTextField();
        tfHoraSolicitada = new javax.swing.JFormattedTextField();
        tfHoraInicio = new javax.swing.JFormattedTextField();
        tfHoraFim = new javax.swing.JFormattedTextField();
        tfTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setClosable(true);
        setMaximizable(true);

        pnPrincipal.setBackground(new java.awt.Color(245, 245, 245));
        pnPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Cliente:");

        cbCliente.setBackground(new java.awt.Color(243, 243, 243));
        cbCliente.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 255, 0)));
        cbCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbClienteItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Rota:");

        cbRota.setBackground(new java.awt.Color(243, 243, 243));
        cbRota.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cbRota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbRota.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 255, 0)));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Agente:");

        cbAgente.setBackground(new java.awt.Color(243, 243, 243));
        cbAgente.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cbAgente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbAgente.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 255, 0)));
        cbAgente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAgenteItemStateChanged(evt);
            }
        });

        lbPlaca.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbPlaca.setText("Placa:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Nome Motorista:");

        tfNomeMot.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfNomeMot.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 255, 0)));
        tfNomeMot.setCaretColor(new java.awt.Color(243, 243, 243));
        tfNomeMot.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfNomeMot.setSelectedTextColor(new java.awt.Color(243, 243, 243));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Placa Motorista:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Hora Solicitada:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("Hora Inicio:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Hora termino:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText("KM Inicial:");

        tfKMinicial.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 255, 0)));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("KM Final:");

        tfKMfinal.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 255, 0)));

        taDescricao.setColumns(20);
        taDescricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taDescricao.setRows(5);
        taDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrição", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jScrollPane1.setViewportView(taDescricao);

        btCadastro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btCadastro.setText("Cadastrar");
        btCadastro.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 255, 0)));
        btCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroActionPerformed(evt);
            }
        });

        btLimpar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 255, 0)));
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        tfPlacaMot.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 255, 0)));

        tfHoraSolicitada.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 255, 0)));

        tfHoraInicio.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 255, 0)));

        tfHoraFim.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 255, 0)));

        tfTitulo.setBackground(new java.awt.Color(243, 243, 243));
        tfTitulo.setFont(new java.awt.Font("Candara Light", 1, 36)); // NOI18N
        tfTitulo.setForeground(new java.awt.Color(216, 219, 70));
        tfTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfTitulo.setText("Cadastro Missao");

        javax.swing.GroupLayout pnPrincipalLayout = new javax.swing.GroupLayout(pnPrincipal);
        pnPrincipal.setLayout(pnPrincipalLayout);
        pnPrincipalLayout.setHorizontalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPrincipalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnPrincipalLayout.createSequentialGroup()
                        .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnPrincipalLayout.createSequentialGroup()
                                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbAgente, 0, 212, Short.MAX_VALUE)
                                    .addComponent(tfNomeMot))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbPlaca, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(pnPrincipalLayout.createSequentialGroup()
                                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfHoraSolicitada)
                                    .addComponent(tfKMinicial, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                                .addGap(51, 51, 51)
                                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfKMfinal, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(tfHoraInicio))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbRota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPlacaMot, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(tfHoraFim))
                        .addGap(34, 34, 34))
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnPrincipalLayout.createSequentialGroup()
                                .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31))))
            .addComponent(tfTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
        );
        pnPrincipalLayout.setVerticalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tfTitulo)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbRota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbAgente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPlaca))
                .addGap(23, 23, 23)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfNomeMot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tfPlacaMot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(tfHoraSolicitada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfHoraFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfKMinicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(tfKMfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastro)
                    .addComponent(btLimpar))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbClienteItemStateChanged
        cbRota.removeAllItems();
        cbRota.addItem("Selecione");
        for(int i=0;i<cliente.size();i++){
            String str = Mascara.nomeCliente(cliente.get(i).getNome(), cliente.get(i).getEstado());
            String str2 = evt.getItem().toString();

            if(str.toLowerCase().equals(str2.toLowerCase())){
                id = cliente.get(i).getId();
                rota = Rota.pegarRotas(id,cbRota);
            }

        }
    }//GEN-LAST:event_cbClienteItemStateChanged

    private void cbAgenteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAgenteItemStateChanged
        for(int i=0;i<agente.size();i++){

            if(cbAgente.getSelectedItem().toString().equals(agente.get(i).getNome())){
                lbPlaca.setText("Placa: "+agente.get(i).getPlaca());
            }
        }
    }//GEN-LAST:event_cbAgenteItemStateChanged

    private void btCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroActionPerformed
        if(cbCliente.getSelectedIndex() == 0
            || cbAgente.getSelectedIndex() ==0
            ||tfNomeMot.getText().isEmpty()
            ||tfHoraSolicitada.getText().isEmpty()
            ||tfHoraInicio.getText().isEmpty()
            ||tfHoraFim.getText().isEmpty()
            ||tfKMfinal.getText().isEmpty()
            ||tfKMinicial.getText().isEmpty()){
            System.out.println("vazio");
            //  Missao m = new Missao();

        }else{
            Calendar c = Calendar.getInstance();
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/YY HH:mm");
            double idAgente=0;
            int idRota=0;
            String horaSolicitaUniao = String.valueOf(tfHoraSolicitada.getText().charAt(0))+String.valueOf(tfHoraSolicitada.getText().charAt(1));
            String minutoSlicitaUniao = String.valueOf(tfHoraSolicitada.getText().charAt(3))+String.valueOf(tfHoraSolicitada.getText().charAt(4));
            System.out.println("Hora solicitada : "+horaSolicitaUniao+minutoSlicitaUniao);
            String horaInicialUniao = String.valueOf(tfHoraInicio.getText().charAt(0))+String.valueOf(tfHoraInicio.getText().charAt(1));
            String minutoInicialUniao = String.valueOf(tfHoraInicio.getText().charAt(3))+String.valueOf(tfHoraInicio.getText().charAt(4));

            String horaFimUniao = String.valueOf(tfHoraFim.getText().charAt(0))+String.valueOf(tfHoraFim.getText().charAt(1));
            String minutoFimUniao = String.valueOf(tfHoraFim.getText().charAt(3))+String.valueOf(tfHoraFim.getText().charAt(4));

            LocalTime horaSolicitada = LocalTime.of(Integer.valueOf(horaSolicitaUniao),Integer.valueOf(minutoSlicitaUniao));
            LocalTime horaInicial = LocalTime.of(Integer.valueOf(horaInicialUniao),Integer.valueOf(minutoInicialUniao));
            LocalTime horaFim = LocalTime.of(Integer.valueOf(horaFimUniao),Integer.valueOf(minutoFimUniao));

            for(int i=0;i<agente.size();i++){
                if (agente.get(i).getNome().equals(cbAgente.getSelectedItem().toString())){
                    idAgente = agente.get(i).getCpf();
                }
            }
            for(int i=0;i<rota.size();i++){
                if(cbRota.getSelectedIndex() != 0){
                    if(cbRota.getSelectedItem().toString().toUpperCase().equals(rota.get(i).getRota().toUpperCase())){
                        idRota = rota.get(i).getId();
                        System.out.println("Rodouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu   "+idRota);
                    }
                }
            }

            Missao m = new Missao(f.format(c.getTime()), id, idAgente, idRota, tfNomeMot.getText(), tfPlacaMot.getText(), Time.valueOf(horaSolicitada), Time.valueOf(horaInicial), Time.valueOf(horaFim), (Integer.valueOf(tfKMfinal.getText())- Integer.valueOf(tfKMinicial.getText())), taDescricao.getText());
            System.out.println(m.toString());
            if(m.cadastrar()){
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
                limpar();
            }else{
                JOptionPane.showMessageDialog(null, "Erro ,feche e abra o programa e tente novamente ");
            }

        }
    }//GEN-LAST:event_btCadastroActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastro;
    private javax.swing.JButton btLimpar;
    private javax.swing.JComboBox<String> cbAgente;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JComboBox<String> cbRota;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbPlaca;
    private javax.swing.JPanel pnPrincipal;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JFormattedTextField tfHoraFim;
    private javax.swing.JFormattedTextField tfHoraInicio;
    private javax.swing.JFormattedTextField tfHoraSolicitada;
    private javax.swing.JTextField tfKMfinal;
    private javax.swing.JTextField tfKMinicial;
    private javax.swing.JTextField tfNomeMot;
    private javax.swing.JFormattedTextField tfPlacaMot;
    private javax.swing.JLabel tfTitulo;
    // End of variables declaration//GEN-END:variables
}
