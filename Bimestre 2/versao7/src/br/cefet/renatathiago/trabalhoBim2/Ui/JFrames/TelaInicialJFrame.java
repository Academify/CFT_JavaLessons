package br.cefet.renatathiago.trabalhoBim2.Ui.JFrames;

import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import br.cefet.renatathiago.trabalhoBim2.Ui.PrincipalUi;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaInicialJFrame extends javax.swing.JFrame {

    private TelaBuscaJFrame buscaJFrame = new TelaBuscaJFrame();
    private TelaCadastroJFrame cadastroJFrame = new TelaCadastroJFrame();
    private RealizarCompraJFrame realizarCompraJFrame = new RealizarCompraJFrame();
    private VendaJFrame vendaJFrame = new VendaJFrame();
    
    public TelaInicialJFrame() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NomeTelaInicialLabel = new javax.swing.JLabel();
        BotaoRealizarVenda = new javax.swing.JButton();
        BotaoRealizarCompra = new javax.swing.JButton();
        BotaoTelaCadastro = new javax.swing.JButton();
        BotaoTelaBusca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NomeTelaInicialLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NomeTelaInicialLabel.setText("Tela Inicial");

        BotaoRealizarVenda.setText("Realizar Venda");
        BotaoRealizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRealizarVendaActionPerformed(evt);
            }
        });

        BotaoRealizarCompra.setText("Realizar Compra");
        BotaoRealizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRealizarCompraActionPerformed(evt);
            }
        });

        BotaoTelaCadastro.setText("Cadastrar");
        BotaoTelaCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoTelaCadastroActionPerformed(evt);
            }
        });

        BotaoTelaBusca.setText("Buscar");
        BotaoTelaBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoTelaBuscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(183, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BotaoRealizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotaoTelaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(BotaoRealizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(189, 189, 189))
            .addGroup(layout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(NomeTelaInicialLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(179, 179, 179)
                    .addComponent(BotaoTelaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(430, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(NomeTelaInicialLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoRealizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoTelaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(BotaoRealizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(256, Short.MAX_VALUE)
                    .addComponent(BotaoTelaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(175, 175, 175)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoRealizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRealizarVendaActionPerformed
        vendaJFrame.setVisible(true);
    }//GEN-LAST:event_BotaoRealizarVendaActionPerformed

    private void BotaoRealizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRealizarCompraActionPerformed
        realizarCompraJFrame.setVisible(true);
        realizarCompraJFrame.habilitarBotaoConfirmar();
        realizarCompraJFrame.habilitarBotaoCancelar();
        realizarCompraJFrame.limparDados();
        try {
            realizarCompraJFrame.definirCod();
            realizarCompraJFrame.preencherTabelaProdutoFornecedor();
        } catch (DaoException ex) {
            Logger.getLogger(TelaInicialJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoRealizarCompraActionPerformed

    private void BotaoTelaCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoTelaCadastroActionPerformed
       cadastroJFrame.setVisible(true);
    }//GEN-LAST:event_BotaoTelaCadastroActionPerformed

    private void BotaoTelaBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoTelaBuscaActionPerformed
        buscaJFrame.setVisible(true);
    }//GEN-LAST:event_BotaoTelaBuscaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoRealizarCompra;
    private javax.swing.JButton BotaoRealizarVenda;
    private javax.swing.JButton BotaoTelaBusca;
    private javax.swing.JButton BotaoTelaCadastro;
    private javax.swing.JLabel NomeTelaInicialLabel;
    // End of variables declaration//GEN-END:variables

    public void telaInicial() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicialJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicialJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicialJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicialJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicialJFrame().setVisible(true);
            }
        });
    }
}
