/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Agente;
import model.Cliente;
import model.Missao;
import model.Rota;

/**
 *
 * @author rafa_
 */
public class TelaPesquisa extends javax.swing.JFrame {

    /**
     * Creates new form TelaPesquisa
     */
    public TelaPesquisa() {
        initComponents();
    }

    public void TabelaClienteLista(List<Cliente> l) {
        if (!l.isEmpty()) {
            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Nome");
            model.addColumn("Estado");
            model.addColumn("Telefone");
            model.addColumn("Endereço");

            for (int i = 0; i < l.size(); i++) {
                String[] reg = {l.get(i).getNome(), l.get(i).getEstado(), String.valueOf(l.get(i).getTelefone()), l.get(i).getEndereco()};
                model.addRow(reg);

            }

            Tabela.setModel(model);
            Tabela.setAutoCreateRowSorter(true);
            Tabela.getColumnModel().getColumn(0).setPreferredWidth(160);
            Tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(2).setPreferredWidth(105);
            Tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
            
((DefaultTableCellRenderer) Tabela.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            Tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado !");
        }
    }

    public void TabelaCliente() {
        DefaultTableModel model = new DefaultTableModel();
        Cliente a = new Cliente();
        List<Cliente> l = new ArrayList<Cliente>();
        l = a.pegarNomes(new JComboBox());

        model.addColumn("Nome");
        model.addColumn("Estado");
        model.addColumn("Telefone");

        model.addColumn("Endereço");

        for (int i = 0; i < l.size(); i++) {
            String[] reg = {l.get(i).getNome(), l.get(i).getEstado(), String.valueOf(l.get(i).getTelefone()), l.get(i).getEndereco()};
            model.addRow(reg);

        }

        Tabela.setModel(model);
        Tabela.setAutoCreateRowSorter(true);
        Tabela.getColumnModel().getColumn(0).setPreferredWidth(160);
        Tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
        Tabela.getColumnModel().getColumn(2).setPreferredWidth(105);
        Tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        ((DefaultTableCellRenderer) Tabela.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        Tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
    }

    public void TabelaRotaLista(List<Rota> lista) {
        if (!lista.isEmpty()) {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Cliente");
            model.addColumn("Rota");
            model.addColumn("Franquia KM");
            model.addColumn("Franquia Hora");
            model.addColumn("Diaria");
            model.addColumn("Adicional por KM");
            model.addColumn("Adicional por Hora");

            for (int i = 0; i < lista.size(); i++) {
                String[] reg = {Cliente.converterCliente(lista.get(i).getIdCliente()), lista.get(i).getRota(), String.valueOf(lista.get(i).getFranquiaKM()),
                    String.valueOf(lista.get(i).getFranquiaHora()), String.valueOf(lista.get(i).getDiaria()), String.valueOf(lista.get(i).getAdKM()),
                    String.valueOf(lista.get(i).getAdHora())};
                model.addRow(reg);

            }
            Tabela.setModel(model);
            Tabela.setAutoCreateRowSorter(true);
            Tabela.getColumnModel().getColumn(0).setPreferredWidth(160);
            Tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(2).setPreferredWidth(105);
            Tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(6).setPreferredWidth(100);

            ((DefaultTableCellRenderer) Tabela.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            Tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(4).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(5).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado !");
        }
    }

    public void TabelaRota() {
        DefaultTableModel model = new DefaultTableModel();

        Rota a = new Rota();
        List<Rota> l = new ArrayList<Rota>();
        l = a.pegarTodasRotas();
        model.addColumn("Cliente");
        model.addColumn("Rota");
        model.addColumn("Franquia KM");
        model.addColumn("Franquia Hora");
        model.addColumn("Diaria");
        model.addColumn("Adicional por KM");
        model.addColumn("Adicional por Hora");

        for (int i = 0; i < l.size(); i++) {
            String[] reg = {Cliente.converterCliente(l.get(i).getIdCliente()), l.get(i).getRota(), String.valueOf(l.get(i).getFranquiaKM()),
                String.valueOf(l.get(i).getFranquiaHora()), String.valueOf(l.get(i).getDiaria()), String.valueOf(l.get(i).getAdKM()),
                String.valueOf(l.get(i).getAdHora())};
            model.addRow(reg);
            System.out.println("aquiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        }

        Tabela.setModel(model);
        Tabela.setAutoCreateRowSorter(true);
        Tabela.getColumnModel().getColumn(0).setPreferredWidth(160);
        Tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
        Tabela.getColumnModel().getColumn(2).setPreferredWidth(105);
        Tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
        Tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
        Tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
        Tabela.getColumnModel().getColumn(6).setPreferredWidth(100);

        ((DefaultTableCellRenderer) Tabela.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        Tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(6).setCellRenderer(centralizado);
    }

    public void TabelaMissaoLista(List<Missao> lista) {
        if (!lista.isEmpty()) {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Data");
            model.addColumn("Cliente");
            model.addColumn("Rota");
            model.addColumn("Hora Solicitada");
            model.addColumn("Hora de Inicio");
            model.addColumn("Hora de termino");
            model.addColumn("Agente");
            model.addColumn("Total KM");
            model.addColumn("Nome Motorista");
            model.addColumn("Placa Motorista");
            model.addColumn("Observação");

            for (int i = 0; i < lista.size(); i++) {
                String[] reg = {lista.get(i).getData(), Cliente.converterCliente(lista.get(i).getCliente()), Rota.converterRota(lista.get(i).getRota()),
                    String.valueOf(lista.get(i).getHoraSolicitada()), String.valueOf(lista.get(i).getHoraInicial()), String.valueOf(lista.get(i).getHoraFinal()),
                    Agente.converterAgente(lista.get(i).getAgente()), String.valueOf(lista.get(i).getTotalKM()), lista.get(i).getNomeMot(), lista.get(i).getPlacaMot(), lista.get(i).getDescricao()};
                model.addRow(reg);

            }
            Tabela.setModel(model);
            Tabela.setAutoCreateRowSorter(true);
            Tabela.getColumnModel().getColumn(0).setPreferredWidth(160);
            Tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(2).setPreferredWidth(105);
            Tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(6).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(7).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(8).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(9).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(10).setPreferredWidth(100);

            ((DefaultTableCellRenderer) Tabela.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            Tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(4).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(5).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(6).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(7).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(8).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(9).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(10).setCellRenderer(centralizado);

        } else {
            JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado !");
        }
    }

    public void TabelaMissao() {
        DefaultTableModel model = new DefaultTableModel();
        Missao a = new Missao();
        List<Missao> l = new ArrayList<Missao>();
        l = a.getMissao(new JComboBox());
        System.out.println("Rodou a condicao sem lista ");
        model.addColumn("Data");
        model.addColumn("Cliente");
        model.addColumn("Rota");
        model.addColumn("Hora Solicitada");
        model.addColumn("Hora de Inicio");
        model.addColumn("Hora de termino");
        model.addColumn("Agente");
        model.addColumn("Total KM");
        model.addColumn("Nome Motorista");
        model.addColumn("Placa Motorista");
        model.addColumn("Observação");
        for (int i = 0; i < l.size(); i++) {
            String[] reg = {l.get(i).getData(), Cliente.converterCliente(l.get(i).getCliente()), Rota.converterRota(l.get(i).getRota()),
                String.valueOf(l.get(i).getHoraSolicitada()), String.valueOf(l.get(i).getHoraInicial()), String.valueOf(l.get(i).getHoraFinal()),
                Agente.converterAgente(l.get(i).getAgente()), String.valueOf(l.get(i).getTotalKM()), l.get(i).getNomeMot(), l.get(i).getPlacaMot(), l.get(i).getDescricao()};
            model.addRow(reg);

        }
        Tabela.setModel(model);
        Tabela.setAutoCreateRowSorter(true);
        Tabela.getColumnModel().getColumn(0).setPreferredWidth(160);
        Tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
        Tabela.getColumnModel().getColumn(2).setPreferredWidth(105);
        Tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
        Tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
        Tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
        Tabela.getColumnModel().getColumn(6).setPreferredWidth(100);
        Tabela.getColumnModel().getColumn(7).setPreferredWidth(100);
        Tabela.getColumnModel().getColumn(8).setPreferredWidth(100);
        Tabela.getColumnModel().getColumn(9).setPreferredWidth(100);
        Tabela.getColumnModel().getColumn(10).setPreferredWidth(100);

        ((DefaultTableCellRenderer) Tabela.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        Tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(7).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(8).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(9).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(10).setCellRenderer(centralizado);
    }

    public void TabelaAgenteLista(List<Agente> lista) {
        if (!lista.isEmpty()) {
            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Registrado");
            model.addColumn("Nome");
            model.addColumn("CPF");
            model.addColumn("Placa");
            model.addColumn("Cidade");
            model.addColumn("Estado");
            model.addColumn("Endereço");

            for (int i = 0; i < lista.size(); i++) {
                String[] reg = {String.valueOf(lista.get(i).isRegistrado()), lista.get(i).getNome(), String.valueOf(lista.get(i).getCpf()),
                    lista.get(i).getPlaca(), lista.get(i).getCidade(), lista.get(i).getEstado(), lista.get(i).getEndereco()};
                model.addRow(reg);

            }

            Tabela.setModel(model);

            Tabela.setAutoCreateRowSorter(true);
            Tabela.getColumnModel().getColumn(0).setPreferredWidth(160);
            Tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(2).setPreferredWidth(105);
            Tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(6).setPreferredWidth(100);

            ((DefaultTableCellRenderer) Tabela.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            Tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(4).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(5).setCellRenderer(centralizado);
            Tabela.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado !");
        }
    }

    public void TabelaAgente() {
        DefaultTableModel model = new DefaultTableModel();
        Agente a = new Agente();
        List<Agente> l = new ArrayList<Agente>();
        l = a.pegarAgentes(new JComboBox());

        ((DefaultTableCellRenderer) Tabela.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        model.addColumn("Registrado");
        model.addColumn("Nome");
        model.addColumn("CPF");
        model.addColumn("Placa");
        model.addColumn("Cidade");
        model.addColumn("Estado");
        model.addColumn("Endereço");

        for (int i = 0; i < l.size(); i++) {
            String[] reg = {String.valueOf(l.get(i).isRegistrado()), l.get(i).getNome(), String.valueOf(l.get(i).getCpf()), l.get(i).getPlaca(),
                l.get(i).getCidade(), l.get(i).getEstado(), l.get(i).getEndereco()};
            model.addRow(reg);

        }

        Tabela.setModel(model);
        Tabela.setAutoCreateRowSorter(true);
        Tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
        Tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
        Tabela.getColumnModel().getColumn(2).setPreferredWidth(150);
        Tabela.getColumnModel().getColumn(3).setPreferredWidth(80);
        Tabela.getColumnModel().getColumn(4).setPreferredWidth(80);
        Tabela.getColumnModel().getColumn(5).setPreferredWidth(34);
        Tabela.getColumnModel().getColumn(6).setPreferredWidth(100);

        ((DefaultTableCellRenderer) Tabela.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        Tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        Tabela.getColumnModel().getColumn(6).setCellRenderer(centralizado);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPrincipal = new javax.swing.JPanel();
        pnPesquisa = new javax.swing.JPanel();
        cbPesquisa = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbColuna = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();
        btPesquisa = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(245, 245, 245));

        pnPrincipal.setBackground(new java.awt.Color(245, 245, 245));
        pnPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 0)));

        pnPesquisa.setBackground(new java.awt.Color(245, 245, 245));
        pnPesquisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 0)));

        cbPesquisa.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cbPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Missao", "Rota", "Agente", "Cliente" }));
        cbPesquisa.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 255, 0)));
        cbPesquisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPesquisaItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Pesquisar");

        cbColuna.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cbColuna.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Coluna");

        tfPesquisa.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfPesquisa.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 255, 0)));

        btPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btPesquisa.setText("Pesquisar");
        btPesquisa.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 0)));
        btPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout pnPesquisaLayout = new javax.swing.GroupLayout(pnPesquisa);
        pnPesquisa.setLayout(pnPesquisaLayout);
        pnPesquisaLayout.setHorizontalGroup(
            pnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPesquisaLayout.createSequentialGroup()
                        .addComponent(cbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbColuna, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pnPesquisaLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(pnPesquisaLayout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        pnPesquisaLayout.setVerticalGroup(
            pnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbColuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnPrincipalLayout = new javax.swing.GroupLayout(pnPrincipal);
        pnPrincipal.setLayout(pnPrincipalLayout);
        pnPrincipalLayout.setHorizontalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnPrincipalLayout.setVerticalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed
        if (cbPesquisa.getSelectedIndex() != 0) {
            if (cbPesquisa.getSelectedItem().equals("Missao")) {
                if (!cbColuna.getSelectedItem().toString().equals("Selecione") && !tfPesquisa.getText().isEmpty()) {
                    TabelaMissaoLista(Missao.search(cbColuna.getSelectedItem().toString(), tfPesquisa.getText()));
                } else {
                    TabelaMissao();
                }
            }
            if (cbPesquisa.getSelectedItem().equals("Rota")) {
                if (!cbColuna.getSelectedItem().toString().equals("Selecione") && !tfPesquisa.getText().isEmpty()) {
                    TabelaRotaLista(Rota.search(cbColuna.getSelectedItem().toString(), tfPesquisa.getText()));
                } else {
                    TabelaRota();
                }
            }
            if (cbPesquisa.getSelectedItem().equals("Agente")) {
                if (!cbColuna.getSelectedItem().toString().equals("Selecione") && !tfPesquisa.getText().isEmpty()) {
                    TabelaAgenteLista(Agente.search(cbColuna.getSelectedItem().toString(), tfPesquisa.getText()));
                } else {
                    TabelaAgente();
                }
            }
            if (cbPesquisa.getSelectedItem().equals("Cliente")) {
                if (!cbColuna.getSelectedItem().toString().equals("Selecione") && !tfPesquisa.getText().isEmpty()) {
                    TabelaClienteLista(Cliente.search(cbColuna.getSelectedItem().toString(), tfPesquisa.getText()));
                } else {
                    TabelaCliente();
                }
            }
        }
    }//GEN-LAST:event_btPesquisaActionPerformed

    private void cbPesquisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPesquisaItemStateChanged
        cbColuna.removeAllItems();
        if (evt.getItem().equals("Agente")) {
            cbColuna.addItem("Selecione");
            cbColuna.addItem("Nome");
            cbColuna.addItem("CPF");
            cbColuna.addItem("Placa");
            cbColuna.addItem("Cidade");
            cbColuna.addItem("Estado");
            cbColuna.addItem("Endereço");
        } else if (evt.getItem().equals("Rota")) {
            cbColuna.addItem("Selecione");
            cbColuna.addItem("Cliente");
            cbColuna.addItem("Rota");
        } else if (evt.getItem().equals("Cliente")) {
            cbColuna.addItem("Selecione");
            cbColuna.addItem("Nome");
            cbColuna.addItem("Estado");
            cbColuna.addItem("Telefone");
        } else if (evt.getItem().equals("Missao")) {
            cbColuna.addItem("Selecione");
            cbColuna.addItem("Cliente");
            cbColuna.addItem("Data");
            cbColuna.addItem("Rota");
            cbColuna.addItem("Agente");
            cbColuna.addItem("Motorista");
        }
    }//GEN-LAST:event_cbPesquisaItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPesquisa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabela;
    private javax.swing.JButton btPesquisa;
    private javax.swing.JComboBox<String> cbColuna;
    private javax.swing.JComboBox<String> cbPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel pnPesquisa;
    private javax.swing.JPanel pnPrincipal;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
}
