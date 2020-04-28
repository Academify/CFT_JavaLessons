package br.cefet.renatathiago.trabalhoBim2.Ui.Telas;

import br.cefet.renatathiago.trabalhoBim2.Dao.CompraDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlterarCompra extends javax.swing.JDialog {

    CompraDao cDao = new CompraDao ();
    public AlterarCompra(java.awt.Frame parent, boolean modal, Compra c) {
        super(parent, modal);
        initComponents();
        limparCampos();
        codTf.setEnabled(false);
        codTf.setText(Integer.toString(c.getCod()));
        fornTf.setText(Integer.toString(c.getCodFornecedor()));
        dataTf.setText(c.getData());
        valorTf.setText(Double.toString(c.getValorTotal()));
        formaPgTf.setText(c.getFormaPg());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        codTf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fornTf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dataTf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        valorTf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        formaPgTf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        CancelarBtn = new javax.swing.JButton();
        SalvarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel1.setText("Alterar Compra");

        codTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codTfActionPerformed(evt);
            }
        });

        jLabel2.setText("Código");

        fornTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fornTfActionPerformed(evt);
            }
        });

        jLabel3.setText("Fornecedor");

        dataTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataTfActionPerformed(evt);
            }
        });

        jLabel4.setText("Data");

        valorTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorTfActionPerformed(evt);
            }
        });

        jLabel5.setText("Valor");

        formaPgTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formaPgTfActionPerformed(evt);
            }
        });

        jLabel6.setText("Forma de Pagamento");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(formaPgTf, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(codTf)
                                .addComponent(dataTf)
                                .addComponent(valorTf)
                                .addComponent(fornTf, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fornTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formaPgTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codTfActionPerformed

    private void fornTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fornTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fornTfActionPerformed

    private void dataTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataTfActionPerformed

    private void valorTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTfActionPerformed

    private void formaPgTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formaPgTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formaPgTfActionPerformed

    private void CancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarBtnActionPerformed
        setVisible(false);
    }//GEN-LAST:event_CancelarBtnActionPerformed

    private void SalvarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarBtnActionPerformed
        Compra c = new Compra();
        c.setCodFornecedor(Integer.parseInt(fornTf.getText()));
        c.setCod(Integer.parseInt(codTf.getText()));
        c.setData(dataTf.getText());
        c.setValorTotal(Double.parseDouble(valorTf.getText()));
        c.setFormaPg(formaPgTf.getText());
        try {
            cDao.alterar(Integer.parseInt(codTf.getText()), c);
        } catch (DaoException ex) {
            Logger.getLogger(NovoCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(false);
    }//GEN-LAST:event_SalvarBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarBtn;
    private javax.swing.JButton SalvarBtn;
    private javax.swing.JTextField codTf;
    private javax.swing.JTextField dataTf;
    private javax.swing.JTextField formaPgTf;
    private javax.swing.JTextField fornTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField valorTf;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {        
        codTf.setText("");
        codTf.setText("");
        fornTf.setText("");
        dataTf.setText("");
        valorTf.setText("");
        formaPgTf.setText("");
    }
}
