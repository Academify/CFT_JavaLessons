/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.renatathiago.trabalhoBim2.Ui.Telas;

import br.cefet.renatathiago.trabalhoBim2.Dao.VendaClienteDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.VendaCliente;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import br.cefet.renatathiago.trabalhoBim2.Relatorios.VendaClienteRelatorio;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class VendasCliente extends javax.swing.JFrame {

    VendaClienteDao vcDao = new VendaClienteDao();
    private List<VendaCliente> itensTabela = new ArrayList();
    
    public VendasCliente() throws DaoException {
        initComponents();
        preencherTabela(vcDao.consultarTodos());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FiltroPnl = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        FiltroNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        FiltroFormaPg = new javax.swing.JTextField();
        FiltrarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BotoesPnl = new javax.swing.JPanel();
        VoltarBtn = new javax.swing.JButton();
        RelatorioBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Nome do Cliente:");
        FiltroPnl.add(jLabel2);

        FiltroNome.setColumns(8);
        FiltroNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FiltroNomeKeyPressed(evt);
            }
        });
        FiltroPnl.add(FiltroNome);

        jLabel5.setText("Forma de Pagamento:");
        FiltroPnl.add(jLabel5);

        FiltroFormaPg.setColumns(8);
        FiltroFormaPg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FiltroFormaPgKeyPressed(evt);
            }
        });
        FiltroPnl.add(FiltroFormaPg);

        FiltrarBtn.setText("Filtrar");
        FiltrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarBtnActionPerformed(evt);
            }
        });
        FiltroPnl.add(FiltrarBtn);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel1.setText("Vendas por Cliente");

        VoltarBtn.setText("Voltar");
        VoltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBtnActionPerformed(evt);
            }
        });
        BotoesPnl.add(VoltarBtn);

        RelatorioBtn.setText("Relatório");
        RelatorioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioBtnActionPerformed(evt);
            }
        });
        BotoesPnl.add(RelatorioBtn);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotoesPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(FiltroPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(FiltroPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(BotoesPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FiltroNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FiltroNomeKeyPressed
        if (evt.getKeyCode()==10){
            List<VendasCliente> lista = new ArrayList();

            try {
                String nome = FiltroNome.getText();
                String formapg = FiltroFormaPg.getText();
                if (nome.equals("") && formapg.equals("")){
                    preencherTabela(vcDao.consultarTodos());
                } else if (formapg.equals("")){
                    preencherTabela(vcDao.consultarPorCliente(nome));
                } else if (nome.equals("")){
                    preencherTabela(vcDao.consultarPorFormaPg(formapg));
                } else {
                    preencherTabela(vcDao.consultarPorClienteFormaPg(nome, formapg));
                }
            } catch (DaoException ex) {
                Logger.getLogger(VendasCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_FiltroNomeKeyPressed

    private void FiltroFormaPgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FiltroFormaPgKeyPressed
        if (evt.getKeyCode()==10){
            List<VendasCliente> lista = new ArrayList();

            try {
                String nome = FiltroNome.getText();
                String formapg = FiltroFormaPg.getText();
                if (nome.equals("") && formapg.equals("")){
                    preencherTabela(vcDao.consultarTodos());
                } else if (formapg.equals("")){
                    preencherTabela(vcDao.consultarPorCliente(nome));
                } else if (nome.equals("")){
                    preencherTabela(vcDao.consultarPorFormaPg(formapg));
                } else {
                    preencherTabela(vcDao.consultarPorClienteFormaPg(nome, formapg));
                }
            } catch (DaoException ex) {
                Logger.getLogger(VendasCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_FiltroFormaPgKeyPressed

    private void FiltrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarBtnActionPerformed
        List<VendasCliente> lista = new ArrayList();

        try {
                String nome = FiltroNome.getText();
                String formapg = FiltroFormaPg.getText();
                if (nome.equals("") && formapg.equals("")){
                    preencherTabela(vcDao.consultarTodos());
                } else if (formapg.equals("")){
                    preencherTabela(vcDao.consultarPorCliente(nome));
                } else if (nome.equals("")){
                    preencherTabela(vcDao.consultarPorFormaPg(formapg));
                } else {
                    preencherTabela(vcDao.consultarPorClienteFormaPg(nome, formapg));
                }
        } catch (DaoException ex) {
            Logger.getLogger(VendasCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_FiltrarBtnActionPerformed

    private void VoltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarBtnActionPerformed
        setVisible(false);
    }//GEN-LAST:event_VoltarBtnActionPerformed

    private void RelatorioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioBtnActionPerformed
        VendaClienteRelatorio prel = new VendaClienteRelatorio();
        prel.emitirRelatorio(itensTabela);
    }//GEN-LAST:event_RelatorioBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BotoesPnl;
    private javax.swing.JButton FiltrarBtn;
    private javax.swing.JTextField FiltroFormaPg;
    private javax.swing.JTextField FiltroNome;
    private javax.swing.JPanel FiltroPnl;
    private javax.swing.JButton RelatorioBtn;
    private javax.swing.JButton VoltarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
    private void preencherTabela(List<br.cefet.renatathiago.trabalhoBim2.Entidade.VendaCliente> lista) {
            String[] vetor = new String[6];
            vetor [0]= "Cod. Cliente";
            vetor [1]= "Cód. Venda";
            vetor [2]= "Nome";
            vetor [3] = "Data";
            vetor [4] = "Valor";
            vetor [5] = "Forma Pg";
            String [][] matriz = new String[lista.size()][6];
            
            for (int i = 0; i<lista.size(); i++){
                  matriz [i][0]=lista.get(i).getCodCliente()+"";
                  matriz [i][1]=lista.get(i).getCodVenda()+"";
                  matriz [i][2]=lista.get(i).getNome();
                  matriz [i][3]=lista.get(i).getData()+"";
                  matriz [i][4]=lista.get(i).getValor()+"";
                  matriz [i][5]=lista.get(i).getFormapg()+"";
            }
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
         matriz, vetor));
        
        itensTabela = lista;
    }
}
