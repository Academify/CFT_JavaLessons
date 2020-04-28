package br.cefet.renatathiago.trabalhoBim2.Ui.Telas;

import br.cefet.renatathiago.trabalhoBim2.Dao.AdministradorDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Administrador;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NovoAdm extends javax.swing.JDialog {

    AdministradorDao aDao = new AdministradorDao();
    public NovoAdm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        limparCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        CancelarBtn = new javax.swing.JButton();
        SalvarBtn = new javax.swing.JButton();
        NomeTf = new javax.swing.JTextField();
        TelefoneTf = new javax.swing.JTextField();
        EnderecoTf = new javax.swing.JTextField();
        CpfTf = new javax.swing.JTextField();
        EmailTf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        SenhaPf = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel1.setText("Novo Administrador");

        jLabel2.setText("Nome:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("Endereço:");

        jLabel5.setText("Cpf:");

        jLabel6.setText("Email:");

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

        NomeTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeTfActionPerformed(evt);
            }
        });

        TelefoneTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelefoneTfActionPerformed(evt);
            }
        });

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

        EmailTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailTfActionPerformed(evt);
            }
        });

        jLabel7.setText("Senha:");

        SenhaPf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SenhaPfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EmailTf, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(NomeTf)
                            .addComponent(EnderecoTf)
                            .addComponent(CpfTf)
                            .addComponent(TelefoneTf, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(SenhaPf))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NomeTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TelefoneTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(SenhaPf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NomeTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeTfActionPerformed

    private void TelefoneTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelefoneTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelefoneTfActionPerformed

    private void EnderecoTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnderecoTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnderecoTfActionPerformed

    private void CpfTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CpfTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CpfTfActionPerformed

    private void EmailTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailTfActionPerformed

    private void SalvarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarBtnActionPerformed
        Administrador a = new Administrador();
        a.setTelefone(TelefoneTf.getText());
        a.setNome(NomeTf.getText());
        a.setEndereco(EnderecoTf.getText());
        a.setCpf(CpfTf.getText());
        a.setEmail(EmailTf.getText());
        a.setSenha(SenhaPf.getText());
        try {
            aDao.inserir(a);
        } catch (DaoException ex) {
            Logger.getLogger(NovoAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(false);
    }//GEN-LAST:event_SalvarBtnActionPerformed

    private void CancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarBtnActionPerformed
        setVisible(false);
    }//GEN-LAST:event_CancelarBtnActionPerformed

    private void SenhaPfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SenhaPfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SenhaPfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarBtn;
    private javax.swing.JTextField CpfTf;
    private javax.swing.JTextField EmailTf;
    private javax.swing.JTextField EnderecoTf;
    private javax.swing.JTextField NomeTf;
    private javax.swing.JButton SalvarBtn;
    private javax.swing.JPasswordField SenhaPf;
    private javax.swing.JTextField TelefoneTf;
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
        TelefoneTf.setText("");
        EnderecoTf.setText("");
        CpfTf.setText("");
        EmailTf.setText("");
        SenhaPf.setText("");
    }
}
