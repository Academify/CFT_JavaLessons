/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.renatathiago.trabalhoBim2.Ui.Telas;

import static javafx.application.Platform.exit;

public class Principal extends javax.swing.JFrame {

    Produtos p = new Produtos();
    Clientes c = new Clientes();
    Fornecedores f = new Fornecedores();
    Administradores a = new Administradores();
    public Principal() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        SairBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        ProdutoBtn = new javax.swing.JButton();
        VendaBtn = new javax.swing.JButton();
        CompraBtn = new javax.swing.JButton();
        AdmBtn = new javax.swing.JButton();
        FornecedorBtn = new javax.swing.JButton();
        ClienteBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel1.setText("Sacolão do Zé");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        SairBtn.setText("Sair");
        SairBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairBtnActionPerformed(evt);
            }
        });
        getContentPane().add(SairBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 99, -1));

        ProdutoBtn.setText("Produto");
        ProdutoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdutoBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ProdutoBtn);

        VendaBtn.setText("Venda");
        VendaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VendaBtnActionPerformed(evt);
            }
        });
        jPanel1.add(VendaBtn);

        CompraBtn.setText("Compra");
        CompraBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompraBtnActionPerformed(evt);
            }
        });
        jPanel1.add(CompraBtn);

        AdmBtn.setText("Administrador");
        AdmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmBtnActionPerformed(evt);
            }
        });
        jPanel1.add(AdmBtn);

        FornecedorBtn.setText("Fornecedor");
        FornecedorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FornecedorBtnActionPerformed(evt);
            }
        });
        jPanel1.add(FornecedorBtn);

        ClienteBtn.setText("Cliente");
        ClienteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ClienteBtn);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 290, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProdutoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdutoBtnActionPerformed
        p.setVisible(true);
    }//GEN-LAST:event_ProdutoBtnActionPerformed

    private void VendaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VendaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VendaBtnActionPerformed

    private void CompraBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompraBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CompraBtnActionPerformed

    private void AdmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmBtnActionPerformed
        a.setVisible(true);
    }//GEN-LAST:event_AdmBtnActionPerformed

    private void FornecedorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FornecedorBtnActionPerformed
        f.setVisible(true);
    }//GEN-LAST:event_FornecedorBtnActionPerformed

    private void ClienteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteBtnActionPerformed
        c.setVisible(true);
    }//GEN-LAST:event_ClienteBtnActionPerformed

    private void SairBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SairBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdmBtn;
    private javax.swing.JButton ClienteBtn;
    private javax.swing.JButton CompraBtn;
    private javax.swing.JButton FornecedorBtn;
    private javax.swing.JButton ProdutoBtn;
    private javax.swing.JButton SairBtn;
    private javax.swing.JButton VendaBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public void iniciar(){
        setVisible(true);
    }
}
