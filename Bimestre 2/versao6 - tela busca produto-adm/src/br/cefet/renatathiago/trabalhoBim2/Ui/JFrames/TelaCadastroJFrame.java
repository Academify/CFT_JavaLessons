package br.cefet.renatathiago.trabalhoBim2.Ui.JFrames;

import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaCadastroJFrame extends javax.swing.JFrame {

    CUDAdm cudAdm = new CUDAdm ();
    CUDProduto cudProduto = new CUDProduto();
    ClienteJFrame clienteJFrame = new ClienteJFrame();
    FornecedorJFrame fornecedorJFrame = new FornecedorJFrame();
    
    public TelaCadastroJFrame() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NomeMenuCadastroLabel = new javax.swing.JLabel();
        BotaoVoltar = new javax.swing.JButton();
        BotaoCadastroCliente = new javax.swing.JButton();
        BotaoCadastroProduto = new javax.swing.JButton();
        BotaoCadastroFornecedor = new javax.swing.JButton();
        BotaoCadastroAdministrador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NomeMenuCadastroLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NomeMenuCadastroLabel.setText("Menu de Cadastros");

        BotaoVoltar.setText("Voltar");
        BotaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoVoltarActionPerformed(evt);
            }
        });

        BotaoCadastroCliente.setText("Cadastrar Cliente");
        BotaoCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastroClienteActionPerformed(evt);
            }
        });

        BotaoCadastroProduto.setText("Cadastrar Produto");
        BotaoCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastroProdutoActionPerformed(evt);
            }
        });

        BotaoCadastroFornecedor.setText("Cadastrar Fornecedor");
        BotaoCadastroFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastroFornecedorActionPerformed(evt);
            }
        });

        BotaoCadastroAdministrador.setText("Cadastrar Administrador");
        BotaoCadastroAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastroAdministradorActionPerformed(evt);
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
                        .addComponent(NomeMenuCadastroLabel)
                        .addGap(282, 282, 282))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BotaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BotaoCadastroFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotaoCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(140, 140, 140)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BotaoCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotaoCadastroAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(140, 140, 140))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(NomeMenuCadastroLabel)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoCadastroFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoCadastroAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(BotaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_BotaoVoltarActionPerformed

    private void BotaoCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastroClienteActionPerformed
        clienteJFrame.setVisible(true);
        clienteJFrame.habilitarBotaoCadastrar();
        clienteJFrame.desabilitarBotaoExcluir();
        clienteJFrame.desabilitarBotaoEditar();
        clienteJFrame.habilitarBotaoSelecionar();
        try {
            clienteJFrame.definirCod();
        } catch (DaoException ex) {
            Logger.getLogger(TelaCadastroJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            clienteJFrame.consultarTodos();
        } catch (DaoException ex) {
            Logger.getLogger(TelaCadastroJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoCadastroClienteActionPerformed

    private void BotaoCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastroProdutoActionPerformed
        cudProduto.setVisible(true);
        cudProduto.habilitarBotaoCadastrar();
        cudProduto.desabilitarBotaoExcluir();
        cudProduto.desabilitarBotaoEditar();
        try {
            cudProduto.definirCod();
        } catch (DaoException ex) {
            Logger.getLogger(TelaCadastroJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BotaoCadastroProdutoActionPerformed

    private void BotaoCadastroFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastroFornecedorActionPerformed
        fornecedorJFrame.setVisible(true);
        fornecedorJFrame.habilitarBotaoCadastrar();
        fornecedorJFrame.desabilitarBotaoExcluir();
        fornecedorJFrame.desabilitarBotaoEditar();
        fornecedorJFrame.habilitarBotaoSelecionar();
        try {
            fornecedorJFrame.definirCod();
        } catch (DaoException ex) {
            Logger.getLogger(TelaCadastroJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fornecedorJFrame.consultarTodos();
        } catch (DaoException ex) {
            Logger.getLogger(TelaCadastroJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoCadastroFornecedorActionPerformed

    private void BotaoCadastroAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastroAdministradorActionPerformed
        cudAdm.setVisible(true);
        cudAdm.habilitarBotaoCadastrar();
        cudAdm.desabilitarBotaoExcluir();
        cudAdm.desabilitarBotaoEditar();
        try {
            cudAdm.definirCod();
        } catch (DaoException ex) {
            Logger.getLogger(TelaCadastroJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoCadastroAdministradorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCadastroAdministrador;
    private javax.swing.JButton BotaoCadastroCliente;
    private javax.swing.JButton BotaoCadastroFornecedor;
    private javax.swing.JButton BotaoCadastroProduto;
    private javax.swing.JButton BotaoVoltar;
    private javax.swing.JLabel NomeMenuCadastroLabel;
    // End of variables declaration//GEN-END:variables
}
