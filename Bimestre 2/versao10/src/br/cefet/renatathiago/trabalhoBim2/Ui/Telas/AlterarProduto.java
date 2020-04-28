package br.cefet.renatathiago.trabalhoBim2.Ui.Telas;

import br.cefet.renatathiago.trabalhoBim2.Dao.ProdutoDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Produto;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlterarProduto extends javax.swing.JDialog {

    ProdutoDao pDao = new ProdutoDao ();
    public AlterarProduto(java.awt.Frame parent, boolean modal, Produto p) {
        super(parent, modal);
        initComponents();
        limparCampos();
        CodTf.setEnabled(false);
        CodTf.setText(Integer.toString(p.getCod()));
        NomeTf.setText(p.getNome());
        MarcaTf.setText(p.getMarca());
        PrecoCompraTf.setText(Double.toString(p.getPrecoCompra()));
        PrecoVendaTf.setText(Double.toString(p.getPrecoVenda()));
        QtdTf.setText(Integer.toString(p.getQtdEstoque()));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        QtdTf = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        CancelarBtn = new javax.swing.JButton();
        SalvarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NomeTf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        MarcaTf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        PrecoCompraTf = new javax.swing.JTextField();
        PrecoVendaTf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CodTf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        QtdTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QtdTfActionPerformed(evt);
            }
        });

        CancelarBtn.setText("Cancelar");
        CancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(CancelarBtn);

        SalvarBtn.setText("Salvar");
        SalvarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(SalvarBtn);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel1.setText("Alterar Produto");

        jLabel2.setText("Nome:");

        jLabel3.setText("Marca:");

        jLabel4.setText("Preço de Compra:");

        NomeTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeTfActionPerformed(evt);
            }
        });

        jLabel5.setText("Preço de Venda:");

        MarcaTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarcaTfActionPerformed(evt);
            }
        });

        jLabel6.setText("Qtd em Estoque:");

        PrecoCompraTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecoCompraTfActionPerformed(evt);
            }
        });

        PrecoVendaTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecoVendaTfActionPerformed(evt);
            }
        });

        jLabel7.setText("Código:");

        CodTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodTfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)))
                                    .addGap(23, 23, 23))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(73, 73, 73)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(QtdTf, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(NomeTf)
                            .addComponent(PrecoCompraTf)
                            .addComponent(PrecoVendaTf)
                            .addComponent(MarcaTf, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(CodTf)))
                    .addComponent(jLabel1))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(CodTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NomeTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MarcaTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PrecoCompraTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PrecoVendaTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(QtdTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QtdTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QtdTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QtdTfActionPerformed

    private void CancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarBtnActionPerformed
        setVisible(false);
    }//GEN-LAST:event_CancelarBtnActionPerformed

    private void SalvarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarBtnActionPerformed
        Produto p = new Produto();
        p.setMarca(MarcaTf.getText());
        p.setNome(NomeTf.getText());
        p.setPrecoCompra(Double.parseDouble(PrecoCompraTf.getText()));
        p.setPrecoVenda(Double.parseDouble(PrecoVendaTf.getText()));
        p.setQtdEstoque(Integer.parseInt(QtdTf.getText()));
        try {
            pDao.alterar(Integer.parseInt(CodTf.getText()), p);
        } catch (DaoException ex) {
            Logger.getLogger(NovoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(false);
    }//GEN-LAST:event_SalvarBtnActionPerformed

    private void NomeTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeTfActionPerformed

    private void MarcaTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarcaTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MarcaTfActionPerformed

    private void PrecoCompraTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecoCompraTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecoCompraTfActionPerformed

    private void PrecoVendaTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecoVendaTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecoVendaTfActionPerformed

    private void CodTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodTfActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarBtn;
    private javax.swing.JTextField CodTf;
    private javax.swing.JTextField MarcaTf;
    private javax.swing.JTextField NomeTf;
    private javax.swing.JTextField PrecoCompraTf;
    private javax.swing.JTextField PrecoVendaTf;
    private javax.swing.JTextField QtdTf;
    private javax.swing.JButton SalvarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        NomeTf.setText("");
        MarcaTf.setText("");
        PrecoCompraTf.setText("");
        PrecoVendaTf.setText("");
        QtdTf.setText("");
        CodTf.setText("");
    }
}
