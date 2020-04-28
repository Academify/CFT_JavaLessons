package br.cefet.renatathiago.trabalhoBim2.Ui.JFrames;

import br.cefet.renatathiago.trabalhoBim2.Ui.JFrames.CUDAdm;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaBuscaJFrame extends javax.swing.JFrame {
    
    BuscaAdm buscaAdm = new BuscaAdm();
    BuscaProduto buscaProduto = new BuscaProduto();
    ClienteJFrame clienteJFrame = new ClienteJFrame();
    FornecedorJFrame fornecedorJFrame = new FornecedorJFrame();
    BuscaCompra BuscaCompra = new BuscaCompra();
    VendaJFrame vendaJFrame = new VendaJFrame();

    public TelaBuscaJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NomeMenuBuscaLabel = new javax.swing.JLabel();
        BotaoBuscaProduto = new javax.swing.JButton();
        BotaoBuscaCliente = new javax.swing.JButton();
        BotaoBuscaFornecedor = new javax.swing.JButton();
        BotaoBuscaVenda = new javax.swing.JButton();
        BotaoBuscaCompra = new javax.swing.JButton();
        BotaoBuscaAdm = new javax.swing.JButton();
        BotaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NomeMenuBuscaLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NomeMenuBuscaLabel.setText("Menu de Buscas");

        BotaoBuscaProduto.setText("Busca por Produto");
        BotaoBuscaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscaProdutoActionPerformed(evt);
            }
        });

        BotaoBuscaCliente.setText("Busca por Cliente");
        BotaoBuscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscaClienteActionPerformed(evt);
            }
        });

        BotaoBuscaFornecedor.setText("Busca por Fornecedor");
        BotaoBuscaFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscaFornecedorActionPerformed(evt);
            }
        });

        BotaoBuscaVenda.setText("Busca por Venda");
        BotaoBuscaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscaVendaActionPerformed(evt);
            }
        });

        BotaoBuscaCompra.setText("Busca por Compra");
        BotaoBuscaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscaCompraActionPerformed(evt);
            }
        });

        BotaoBuscaAdm.setText("Busca por Administrador");
        BotaoBuscaAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscaAdmActionPerformed(evt);
            }
        });

        BotaoVoltar.setText("Voltar");
        BotaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(NomeMenuBuscaLabel)
                        .addGap(282, 282, 282))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BotaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BotaoBuscaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotaoBuscaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotaoBuscaFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(140, 140, 140)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BotaoBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotaoBuscaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotaoBuscaAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(140, 140, 140))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(NomeMenuBuscaLabel)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoBuscaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoBuscaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoBuscaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoBuscaFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoBuscaAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(BotaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoBuscaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaProdutoActionPerformed
        buscaProduto.setVisible(true);

        try {
            buscaProduto.consultarTodos();
        } catch (DaoException ex) {
            Logger.getLogger(TelaCadastroJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BotaoBuscaProdutoActionPerformed

    private void BotaoBuscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaClienteActionPerformed
        clienteJFrame.setVisible(true);
        clienteJFrame.desabilitarBotaoCadastrar();
        clienteJFrame.desabilitarBotaoEditar();
        clienteJFrame.desabilitarBotaoExcluir();
        clienteJFrame.desabilitarJTF();
        try {
            clienteJFrame.consultarTodos();
        } catch (DaoException ex) {
            Logger.getLogger(TelaBuscaJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BotaoBuscaClienteActionPerformed

    private void BotaoBuscaAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaAdmActionPerformed

        buscaAdm.setVisible(true);

        try {
            buscaAdm.consultarTodos();
        } catch (DaoException ex) {
            Logger.getLogger(TelaCadastroJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoBuscaAdmActionPerformed

    private void BotaoBuscaFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaFornecedorActionPerformed
        fornecedorJFrame.setVisible(true);
        fornecedorJFrame.desabilitarBotaoCadastrar();
        fornecedorJFrame.desabilitarBotaoEditar();
        fornecedorJFrame.desabilitarBotaoExcluir();
        fornecedorJFrame.desabilitarJTF();
        fornecedorJFrame.limparDados();
        try {
            fornecedorJFrame.consultarTodos();
        } catch (DaoException ex) {
            Logger.getLogger(TelaBuscaJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoBuscaFornecedorActionPerformed

    private void BotaoBuscaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaVendaActionPerformed
//        vendaJFrame.setVisible(true);
//        vendaJFrame.desabilitarBotaoCadastrar();
//        vendaJFrame.desabilitarBotaoEditar();
//        vendaJFrame.desabilitarBotaoExcluir();
//        vendaJFrame.desabilitarJTF();
//        vendaJFrame.limparDados();
//        try {
//            vendaJFrame.consultarTodos();
//        } catch (DaoException ex) {
//            Logger.getLogger(TelaBuscaJFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }//GEN-LAST:event_BotaoBuscaVendaActionPerformed

    private void BotaoBuscaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaCompraActionPerformed
        BuscaCompra.setVisible(true);
        BuscaCompra.desabilitarBotaoExcluir();
        BuscaCompra.limparDados();
        
        try {
            BuscaCompra.consultarTodos();
        } catch (DaoException ex) {
            Logger.getLogger(TelaBuscaJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BotaoBuscaCompraActionPerformed

    private void BotaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_BotaoVoltarActionPerformed

    public void telaBusca() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaBuscaJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoBuscaAdm;
    private javax.swing.JButton BotaoBuscaCliente;
    private javax.swing.JButton BotaoBuscaCompra;
    private javax.swing.JButton BotaoBuscaFornecedor;
    private javax.swing.JButton BotaoBuscaProduto;
    private javax.swing.JButton BotaoBuscaVenda;
    private javax.swing.JButton BotaoVoltar;
    private javax.swing.JLabel NomeMenuBuscaLabel;
    // End of variables declaration//GEN-END:variables
}
