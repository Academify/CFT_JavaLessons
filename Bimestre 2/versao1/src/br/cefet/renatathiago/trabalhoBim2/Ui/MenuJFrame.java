package br.cefet.renatathiago.trabalhoBim2.Ui;

public class MenuJFrame extends javax.swing.JFrame {
    
    AdmJFrame admJFrame = new AdmJFrame();
    ProdutoJFrame produtoJFrame = new ProdutoJFrame();
    ClienteJFrame clienteJFrame = new ClienteJFrame();
    FornecedorJFrame fornecedorJFrame = new FornecedorJFrame();
    CompraJFrame compraJFrame = new CompraJFrame();
    VendaJFrame vendaJFrame = new VendaJFrame();

    public MenuJFrame() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NomeMenuBuscaLabel.setText("Menu de Busca");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoBuscaProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotaoBuscaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotaoBuscaFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotaoBuscaVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotaoBuscaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotaoBuscaAdm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(347, Short.MAX_VALUE)
                .addComponent(NomeMenuBuscaLabel)
                .addContainerGap(357, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(NomeMenuBuscaLabel)
                .addGap(34, 34, 34)
                .addComponent(BotaoBuscaProduto)
                .addGap(45, 45, 45)
                .addComponent(BotaoBuscaCliente)
                .addGap(43, 43, 43)
                .addComponent(BotaoBuscaFornecedor)
                .addGap(45, 45, 45)
                .addComponent(BotaoBuscaVenda)
                .addGap(45, 45, 45)
                .addComponent(BotaoBuscaCompra)
                .addGap(45, 45, 45)
                .addComponent(BotaoBuscaAdm)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoBuscaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaProdutoActionPerformed
        produtoJFrame.setVisible(true);

    }//GEN-LAST:event_BotaoBuscaProdutoActionPerformed

    private void BotaoBuscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaClienteActionPerformed
        clienteJFrame.setVisible(true);

    }//GEN-LAST:event_BotaoBuscaClienteActionPerformed

    private void BotaoBuscaAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaAdmActionPerformed
        admJFrame.setVisible(true);
        admJFrame.preencherTabela();
    }//GEN-LAST:event_BotaoBuscaAdmActionPerformed

    private void BotaoBuscaFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaFornecedorActionPerformed
        fornecedorJFrame.setVisible(true);

    }//GEN-LAST:event_BotaoBuscaFornecedorActionPerformed

    private void BotaoBuscaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaVendaActionPerformed
        vendaJFrame.setVisible(true);

    }//GEN-LAST:event_BotaoBuscaVendaActionPerformed

    private void BotaoBuscaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaCompraActionPerformed
        compraJFrame.setVisible(true);

    }//GEN-LAST:event_BotaoBuscaCompraActionPerformed

    public void telaBusca() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuJFrame().setVisible(true);
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
    private javax.swing.JLabel NomeMenuBuscaLabel;
    // End of variables declaration//GEN-END:variables
}
