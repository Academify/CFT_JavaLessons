package br.cefet.renatathiago.trabalhoBim2.Ui.Telas;

import br.cefet.renatathiago.trabalhoBim2.Dao.AdministradorDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Administrador;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlterarAdm extends javax.swing.JDialog {

    AdministradorDao cDao = new AdministradorDao ();
    
    public AlterarAdm(java.awt.Frame parent, boolean modal, Administrador p) {
        super(parent, modal);
        initComponents();
        limparCampos();
        CodTf.setEnabled(false);
        CodTf.setText(Integer.toString(p.getCod()));
        NomeTf.setText(p.getNome());
        Telefone.setText(p.getTelefone());
        EnderecoTf.setText(p.getEndereco());
        CpfTf.setText(p.getCpf());
        EmailTf.setText(p.getEmail());
        SenhaTf.setText(p.getSenha());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EmailTf = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        CancelarBtn = new javax.swing.JButton();
        SalvarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NomeTf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Telefone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        EnderecoTf = new javax.swing.JTextField();
        CpfTf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CodTf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        SenhaTf = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        EmailTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailTfActionPerformed(evt);
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
        jLabel1.setText("Alterar Administrador");

        jLabel2.setText("Nome:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("Endereço:");

        NomeTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeTfActionPerformed(evt);
            }
        });

        jLabel5.setText("Cpf:");

        Telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelefoneActionPerformed(evt);
            }
        });

        jLabel6.setText("Email:");

        EnderecoTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnderecoTfActionPerformed(evt);
            }
        });

        CpfTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CpfTfActionPerformed(evt);
            }
        });

        jLabel7.setText("Código:");

        CodTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodTfActionPerformed(evt);
            }
        });

        jLabel8.setText("Senha:");

        SenhaTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SenhaTfActionPerformed(evt);
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
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EmailTf, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(NomeTf)
                            .addComponent(EnderecoTf)
                            .addComponent(CpfTf)
                            .addComponent(Telefone, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(CodTf)
                            .addComponent(SenhaTf))))
                .addContainerGap(14, Short.MAX_VALUE))
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
                            .addComponent(Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EnderecoTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CpfTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(EmailTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(SenhaTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarBtnActionPerformed
        setVisible(false);
    }//GEN-LAST:event_CancelarBtnActionPerformed

    private void SalvarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarBtnActionPerformed
        Administrador a = new Administrador();
        a.setTelefone(Telefone.getText());
        a.setNome(NomeTf.getText());
        a.setEndereco(EnderecoTf.getText());
        a.setCpf(CpfTf.getText());
        a.setEmail(EmailTf.getText());
        a.setSenha(SenhaTf.getText());
        try {
            cDao.alterar(Integer.parseInt(CodTf.getText()), a);
        } catch (DaoException ex) {
            Logger.getLogger(NovoAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(false);
    }//GEN-LAST:event_SalvarBtnActionPerformed

    private void CodTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodTfActionPerformed

    private void CpfTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CpfTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CpfTfActionPerformed

    private void EnderecoTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnderecoTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnderecoTfActionPerformed

    private void TelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelefoneActionPerformed

    private void NomeTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeTfActionPerformed

    private void EmailTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailTfActionPerformed

    private void SenhaTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SenhaTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SenhaTfActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarBtn;
    private javax.swing.JTextField CodTf;
    private javax.swing.JTextField CpfTf;
    private javax.swing.JTextField EmailTf;
    private javax.swing.JTextField EnderecoTf;
    private javax.swing.JTextField NomeTf;
    private javax.swing.JButton SalvarBtn;
    private javax.swing.JPasswordField SenhaTf;
    private javax.swing.JTextField Telefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        NomeTf.setText("");
        Telefone.setText("");
        EnderecoTf.setText("");
        CpfTf.setText("");
        EmailTf.setText("");
        CodTf.setText("");
        SenhaTf.setText("");
    }
}
