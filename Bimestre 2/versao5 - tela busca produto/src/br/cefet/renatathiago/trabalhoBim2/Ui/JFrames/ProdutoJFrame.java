package br.cefet.renatathiago.trabalhoBim2.Ui.JFrames;

import br.cefet.renatathiago.trabalhoBim2.Dao.ProdutoDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Produto;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import br.cefet.renatathiago.trabalhoBim2.Utilidades.CellRenderer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProdutoJFrame extends javax.swing.JFrame {

    private ProdutoDao pDao = new ProdutoDao();
    private List<Produto> lista = new ArrayList();
    private Produto p = new Produto();
    private BuscaProduto buscaProduto = new BuscaProduto();
    
    public ProdutoJFrame() {
        initComponents();
        CodProdutoJTF.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotaoEditarProduto = new javax.swing.JButton();
        QtdEstoqueProdutoJTF = new javax.swing.JTextField();
        PrecoVendaProdutoLabel = new javax.swing.JLabel();
        BotaoExcluirProduto = new javax.swing.JButton();
        PrecoVendaProdutoJTF = new javax.swing.JTextField();
        NomeProdutoLabel = new javax.swing.JLabel();
        NomeProdutoJTF = new javax.swing.JTextField();
        CodProdutoLabel = new javax.swing.JLabel();
        CodProdutoJTF = new javax.swing.JTextField();
        QtdEstoqueProdutoLabel = new javax.swing.JLabel();
        BotaoCadastroProduto = new javax.swing.JButton();
        MarcaProdutoLabel = new javax.swing.JLabel();
        MarcaProdutoJTF = new javax.swing.JTextField();
        PrecoCompraProdutoLabel = new javax.swing.JLabel();
        PrecoCompraProdutoJTF = new javax.swing.JTextField();
        BotaoBuscarProduto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BotaoVoltarMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotaoEditarProduto.setText("Salvar");
        BotaoEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarProdutoActionPerformed(evt);
            }
        });

        QtdEstoqueProdutoJTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QtdEstoqueProdutoJTFActionPerformed(evt);
            }
        });

        PrecoVendaProdutoLabel.setText("Preço de Venda");

        BotaoExcluirProduto.setText("Excluir");
        BotaoExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluirProdutoActionPerformed(evt);
            }
        });

        NomeProdutoLabel.setText("Nome");

        NomeProdutoJTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeProdutoJTFActionPerformed(evt);
            }
        });

        CodProdutoLabel.setText("Código");

        CodProdutoJTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodProdutoJTFActionPerformed(evt);
            }
        });

        QtdEstoqueProdutoLabel.setText("Qtd Estoque");

        BotaoCadastroProduto.setText("Cadastrar");
        BotaoCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastroProdutoActionPerformed(evt);
            }
        });

        MarcaProdutoLabel.setText("Marca");

        MarcaProdutoJTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarcaProdutoJTFActionPerformed(evt);
            }
        });

        PrecoCompraProdutoLabel.setText("Preço de Compra");

        PrecoCompraProdutoJTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecoCompraProdutoJTFActionPerformed(evt);
            }
        });

        BotaoBuscarProduto.setText("Buscar Produto");
        BotaoBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscarProdutoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("Tela de Produtos");

        BotaoVoltarMenu.setText("Voltar");
        BotaoVoltarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoVoltarMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(NomeProdutoLabel)
                            .addComponent(CodProdutoLabel)
                            .addComponent(MarcaProdutoLabel))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MarcaProdutoJTF)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BotaoCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotaoEditarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotaoExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotaoVoltarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(NomeProdutoJTF)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CodProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotaoBuscarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(QtdEstoqueProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(QtdEstoqueProdutoLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PrecoCompraProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PrecoCompraProdutoLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PrecoVendaProdutoLabel)
                                    .addComponent(PrecoVendaProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(CodProdutoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CodProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(NomeProdutoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NomeProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MarcaProdutoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MarcaProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrecoVendaProdutoLabel)
                    .addComponent(PrecoCompraProdutoLabel)
                    .addComponent(QtdEstoqueProdutoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrecoVendaProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrecoCompraProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QtdEstoqueProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoCadastroProduto)
                    .addComponent(BotaoEditarProduto)
                    .addComponent(BotaoExcluirProduto)
                    .addComponent(BotaoVoltarMenu))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarProdutoActionPerformed
        p.setCod(Integer.parseInt(CodProdutoJTF.getText()));
        p.setPrecoVenda(Double.parseDouble(PrecoVendaProdutoJTF.getText()));
        p.setPrecoCompra(Double.parseDouble(PrecoCompraProdutoJTF.getText()));
        p.setNome(NomeProdutoJTF.getText());
        p.setMarca(MarcaProdutoJTF.getText());
        p.setQtdEstoque(Integer.parseInt(QtdEstoqueProdutoJTF.getText()));
        try {
            if (validarProduto(p)){
                pDao.alterar(Integer.parseInt(CodProdutoJTF.getText()), p);
                limparDados();
                definirCod();
                BotaoEditarProduto.setEnabled(false);
                BotaoCadastroProduto.setEnabled(true);
            }
        } catch (DaoException ex) {
            Logger.getLogger(ProdutoJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoEditarProdutoActionPerformed

    private void BotaoExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirProdutoActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", "Excluir Produto", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            try {
                pDao.excluir(Integer.parseInt(CodProdutoJTF.getText()));
                limparDados();
                definirCod();
                habilitarBotaoCadastrar();
            } catch (DaoException ex) {
                Logger.getLogger(ProdutoJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BotaoExcluirProdutoActionPerformed

    private void NomeProdutoJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeProdutoJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeProdutoJTFActionPerformed

    private void CodProdutoJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodProdutoJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodProdutoJTFActionPerformed

    private void BotaoCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastroProdutoActionPerformed

        p.setPrecoVenda(Double.parseDouble(PrecoVendaProdutoJTF.getText()));
        p.setPrecoCompra(Double.parseDouble(PrecoCompraProdutoJTF.getText()));
        p.setMarca(MarcaProdutoJTF.getText());
        p.setNome(NomeProdutoJTF.getText());
        p.setQtdEstoque(Integer.parseInt(QtdEstoqueProdutoJTF.getText()));
        try {
            if (validarProduto(p)){
                pDao.inserir(p);
                limparDados();
                definirCod();
                habilitarBotaoCadastrar();

            }
        } catch (DaoException ex) {
            Logger.getLogger(ProdutoJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoCadastroProdutoActionPerformed

    private void MarcaProdutoJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarcaProdutoJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MarcaProdutoJTFActionPerformed

    private void BotaoBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscarProdutoActionPerformed
        buscaProduto.setVisible(true);
        dispose();
        try {
            buscaProduto.consultarTodos();
        } catch (DaoException ex) {
            Logger.getLogger(ProdutoJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_BotaoBuscarProdutoActionPerformed

    private void BotaoVoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoVoltarMenuActionPerformed
        dispose();
    }//GEN-LAST:event_BotaoVoltarMenuActionPerformed

    private void PrecoCompraProdutoJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecoCompraProdutoJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecoCompraProdutoJTFActionPerformed

    private void QtdEstoqueProdutoJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QtdEstoqueProdutoJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QtdEstoqueProdutoJTFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoBuscarProduto;
    private javax.swing.JButton BotaoCadastroProduto;
    private javax.swing.JButton BotaoEditarProduto;
    private javax.swing.JButton BotaoExcluirProduto;
    private javax.swing.JButton BotaoVoltarMenu;
    private javax.swing.JTextField CodProdutoJTF;
    private javax.swing.JLabel CodProdutoLabel;
    private javax.swing.JTextField MarcaProdutoJTF;
    private javax.swing.JLabel MarcaProdutoLabel;
    private javax.swing.JTextField NomeProdutoJTF;
    private javax.swing.JLabel NomeProdutoLabel;
    private javax.swing.JTextField PrecoCompraProdutoJTF;
    private javax.swing.JLabel PrecoCompraProdutoLabel;
    private javax.swing.JTextField PrecoVendaProdutoJTF;
    private javax.swing.JLabel PrecoVendaProdutoLabel;
    private javax.swing.JTextField QtdEstoqueProdutoJTF;
    private javax.swing.JLabel QtdEstoqueProdutoLabel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    void desabilitarBotaoCadastrar() {
        BotaoCadastroProduto.setEnabled(false);
    }

    void desabilitarBotaoEditar() {
        BotaoEditarProduto.setEnabled(false);
    }

    void desabilitarBotaoExcluir() {
        BotaoExcluirProduto.setEnabled(false);
    }
    
    void habilitarBotaoCadastrar() {
        BotaoCadastroProduto.setEnabled(true);
    }

    void habilitarBotaoEditar() {
        BotaoEditarProduto.setEnabled(true);
    }

    void habilitarBotaoExcluir() {
        BotaoExcluirProduto.setEnabled(true);
    }

    void desabilitarJTF(){
        NomeProdutoJTF.setEnabled(false);
        MarcaProdutoJTF.setEnabled(false);
        QtdEstoqueProdutoJTF.setEnabled(false);
        PrecoCompraProdutoJTF.setEnabled(false);
        PrecoVendaProdutoJTF.setEnabled(false);
    }
    void habilitarJTF(){
        NomeProdutoJTF.setEnabled(true);
        MarcaProdutoJTF.setEnabled(true);
        QtdEstoqueProdutoJTF.setEnabled(true);
        PrecoCompraProdutoJTF.setEnabled(true);
        PrecoVendaProdutoJTF.setEnabled(true);
    }

     void exibirDados(Produto p) {
        NomeProdutoJTF.setText(p.getNome());
        CodProdutoJTF.setText(Integer.toString(p.getCod()));
        MarcaProdutoJTF.setText(p.getMarca());
        PrecoCompraProdutoJTF.setText(Double.toString(p.getPrecoCompra()));
        PrecoVendaProdutoJTF.setText(Double.toString(p.getPrecoVenda()));
        QtdEstoqueProdutoJTF.setText(Integer.toString(p.getQtdEstoque()));
        BotaoExcluirProduto.setEnabled(true);
    }

     void limparDados() {
        NomeProdutoJTF.setText("");
        CodProdutoJTF.setText("");
        MarcaProdutoJTF.setText("");
        PrecoCompraProdutoJTF.setText("");
        PrecoVendaProdutoJTF.setText("");
        QtdEstoqueProdutoJTF.setText("");
        BotaoExcluirProduto.setEnabled(false);
        BotaoCadastroProduto.setEnabled(false);
        BotaoEditarProduto.setEnabled(false);
    }
    
    void definirCod() throws DaoException{
        try {
            CodProdutoJTF.setText(Integer.toString(pDao.proximoCod()));
        } catch (DaoException ex) {
            Logger.getLogger(ProdutoJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean validarProduto(Produto p) {
        if (p.getNome().length()>=2 && 
        p.getMarca().length()>=2 && 
        p.getQtdEstoque()>0 &&
        p.getPrecoCompra()>0 &&
        p.getPrecoVenda()>0){
            return true;
        } else {
            return false;
        }
    }

   }
