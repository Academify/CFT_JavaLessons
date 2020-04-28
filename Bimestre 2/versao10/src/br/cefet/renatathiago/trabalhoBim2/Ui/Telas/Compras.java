/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.renatathiago.trabalhoBim2.Ui.Telas;

import br.cefet.renatathiago.trabalhoBim2.Ui.Telas.NovoCompra;
import br.cefet.renatathiago.trabalhoBim2.Ui.Telas.AlterarCompra;
import br.cefet.renatathiago.trabalhoBim2.Dao.CompraDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Compras extends javax.swing.JFrame {

    CompraDao cDao = new CompraDao();
    
    public Compras() {
        initComponents();
        try {
            preencherTabela(cDao.consultarTodos());
        } catch (DaoException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BotoesPnl = new javax.swing.JPanel();
        VoltarBtn = new javax.swing.JButton();
        NovoBtn = new javax.swing.JButton();
        AlterarBtn = new javax.swing.JButton();
        ExcluirBtn = new javax.swing.JButton();
        visualizarBtn = new javax.swing.JButton();
        FiltroPnl = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        FiltrosCBB = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        FiltroTf = new javax.swing.JTextField();
        FiltrarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel1.setText("Compras");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        VoltarBtn.setText("Voltar");
        VoltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBtnActionPerformed(evt);
            }
        });
        BotoesPnl.add(VoltarBtn);

        NovoBtn.setText("Novo");
        NovoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoBtnActionPerformed(evt);
            }
        });
        BotoesPnl.add(NovoBtn);

        AlterarBtn.setText("Alterar");
        AlterarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarBtnActionPerformed(evt);
            }
        });
        BotoesPnl.add(AlterarBtn);

        ExcluirBtn.setText("Excluir");
        ExcluirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirBtnActionPerformed(evt);
            }
        });
        BotoesPnl.add(ExcluirBtn);

        visualizarBtn.setText("Visualizar");
        visualizarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarBtnActionPerformed(evt);
            }
        });
        BotoesPnl.add(visualizarBtn);

        getContentPane().add(BotoesPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 660, -1));

        jLabel2.setText("Filtro:");
        FiltroPnl.add(jLabel2);

        FiltrosCBB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Código", "Fornecedor" }));
        FiltroPnl.add(FiltrosCBB);

        jLabel3.setText("Igual a:");
        FiltroPnl.add(jLabel3);

        FiltroTf.setColumns(8);
        FiltroTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FiltroTfKeyPressed(evt);
            }
        });
        FiltroPnl.add(FiltroTf);

        FiltrarBtn.setText("Filtrar");
        FiltrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarBtnActionPerformed(evt);
            }
        });
        FiltroPnl.add(FiltrarBtn);

        getContentPane().add(FiltroPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 660, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 620, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FiltroTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FiltroTfKeyPressed
      if (evt.getKeyCode()==10){
           List<Compra> lista = new ArrayList();

            try {
            
            switch(FiltrosCBB.getSelectedIndex()){
                case 0:
            {
                try {
                    preencherTabela(cDao.consultarTodos());
                } catch (DaoException ex) {
                    Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
                case 1:
                lista.add(cDao.consultarPorCod(Integer.parseInt(FiltroTf.getText())));
                preencherTabela(lista);
                lista.clear();
                break;
                case 2:
                preencherTabela(cDao.consultarPorFornecedor(Integer.parseInt(FiltroTf.getText())));
                break;
            }
        } catch (DaoException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }//GEN-LAST:event_FiltroTfKeyPressed

    private void FiltrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarBtnActionPerformed
       List<Compra> lista = new ArrayList();

            try {
            
            switch(FiltrosCBB.getSelectedIndex()){
                case 0:
            {
                try {
                    preencherTabela(cDao.consultarTodos());
                } catch (DaoException ex) {
                    Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
                case 1:
                lista.add(cDao.consultarPorCod(Integer.parseInt(FiltroTf.getText())));
                preencherTabela(lista);
                lista.clear();
                break;
                case 2:
                preencherTabela(cDao.consultarPorFornecedor(Integer.parseInt(FiltroTf.getText())));
                break;
            }
        } catch (DaoException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_FiltrarBtnActionPerformed

    private void NovoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoBtnActionPerformed
        NovoCompra n = new NovoCompra(this, true);
        n.setVisible(true);
        try {
            preencherTabela(cDao.consultarTodos());
        } catch (DaoException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NovoBtnActionPerformed

    private void AlterarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarBtnActionPerformed
        Compra p = new Compra();
        try {
            p = getItemSelecionado();
        } catch (DaoException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
        AlterarCompra a = new AlterarCompra(this, true, p);
        a.setVisible(true);
        try {
            preencherTabela(cDao.consultarTodos());
        } catch (DaoException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AlterarBtnActionPerformed

    private void ExcluirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirBtnActionPerformed
        try {
            Compra p = getItemSelecionado();
            cDao.excluir(p.getCod());
            preencherTabela(cDao.consultarTodos());
        } catch (DaoException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ExcluirBtnActionPerformed

    private void VoltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarBtnActionPerformed
        setVisible(false);
    }//GEN-LAST:event_VoltarBtnActionPerformed

    private void visualizarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarBtnActionPerformed
        
        try {
            VisualizarCompra vc = new VisualizarCompra(this,true, cDao.consultarPorCod(Integer.parseInt((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0))));
            vc.setVisible(true);
        } catch (DaoException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_visualizarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlterarBtn;
    private javax.swing.JPanel BotoesPnl;
    private javax.swing.JButton ExcluirBtn;
    private javax.swing.JButton FiltrarBtn;
    private javax.swing.JPanel FiltroPnl;
    private javax.swing.JTextField FiltroTf;
    private javax.swing.JComboBox<String> FiltrosCBB;
    private javax.swing.JButton NovoBtn;
    private javax.swing.JButton VoltarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton visualizarBtn;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela(List<br.cefet.renatathiago.trabalhoBim2.Entidade.Compra> lista) {
            String[] vetor = new String[5];
            vetor [0]= "Cod";
            vetor [1]= "Cód. Fornecedor";
            vetor [2]= "Data";
            vetor [3] = "Valor Total";
            vetor [4] = "Forma Pag.";
            String [][] matriz = new String[lista.size()][5];
            
            for (int i = 0; i<lista.size(); i++){
                  matriz [i][0]=lista.get(i).getCod()+"";
                  matriz [i][1]=Integer.toString(lista.get(i).getCodFornecedor());
                  matriz [i][2]=lista.get(i).getData();
                  matriz [i][3]=lista.get(i).getValorTotal()+"";
                  matriz [i][4]=lista.get(i).getFormaPg()+"";
                  
            }
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
         matriz, vetor));
    }

    private Compra getItemSelecionado() throws DaoException {
        int l = jTable1.getSelectedRow();
        int num = Integer.parseInt((String) jTable1.getValueAt(l, 0));
        return cDao.consultarPorCod(num);
    }
    
}
