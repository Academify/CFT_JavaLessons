package br.cefet.renatathiago.trabalhoBim2.Ui.JFrames;

import br.cefet.renatathiago.trabalhoBim2.Controle.AdministradorControle;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Administrador;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import br.cefet.renatathiago.trabalhoBim2.Utilidades.CellRenderer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CUDAdm extends javax.swing.JFrame {
    
    private AdministradorControle admControle = new AdministradorControle();
    private DefaultTableModel modeloTabela;
    private List<Administrador> lista = new ArrayList();
    private Administrador adm = new Administrador();
    private BuscaAdm buscaAdm = new BuscaAdm();


    public CUDAdm() {
        initComponents();
        CodAdmJTF.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CodAdmJTF = new javax.swing.JTextField();
        BotaoCadastroAdm = new javax.swing.JButton();
        BotaoEditarAdm = new javax.swing.JButton();
        BotaoExcluirAdm = new javax.swing.JButton();
        NomeAdmLabel = new javax.swing.JLabel();
        NomeAdmJTF = new javax.swing.JTextField();
        FoneAdmLabel = new javax.swing.JLabel();
        FoneAdmJTF = new javax.swing.JTextField();
        CpfAdmLabel = new javax.swing.JLabel();
        CpfAdmJTF = new javax.swing.JTextField();
        RuaAdmLabel = new javax.swing.JLabel();
        RuaAdmJTF = new javax.swing.JTextField();
        NumAdmLabel = new javax.swing.JLabel();
        NumAdmJTF = new javax.swing.JTextField();
        BairroAdmLabel = new javax.swing.JLabel();
        BairroAdmJTF = new javax.swing.JTextField();
        CidadeAdmLabel = new javax.swing.JLabel();
        CidadeAdmJTF = new javax.swing.JTextField();
        EmailAdmLabel = new javax.swing.JLabel();
        EmailAdmJTF = new javax.swing.JTextField();
        SenhaAdmLabel = new javax.swing.JLabel();
        CodAdmLabel = new javax.swing.JLabel();
        ConfirmarSenhaLabel = new javax.swing.JLabel();
        SenhaAdmJPwdF = new javax.swing.JPasswordField();
        ConfirmarSenhaAdmJPwdF = new javax.swing.JPasswordField();
        TituloCUDAdm = new javax.swing.JLabel();
        BotaoBuscarAdm = new javax.swing.JButton();
        BotaoVoltarMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CodAdmJTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodAdmJTFActionPerformed(evt);
            }
        });

        BotaoCadastroAdm.setText("Cadastrar");
        BotaoCadastroAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastroAdmActionPerformed(evt);
            }
        });

        BotaoEditarAdm.setText("Salvar");
        BotaoEditarAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarAdmActionPerformed(evt);
            }
        });

        BotaoExcluirAdm.setText("Excluir");
        BotaoExcluirAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluirAdmActionPerformed(evt);
            }
        });

        NomeAdmLabel.setText("Nome Completo");

        NomeAdmJTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeAdmJTFActionPerformed(evt);
            }
        });

        FoneAdmLabel.setText("Telefone");

        CpfAdmLabel.setText("CPF");

        RuaAdmLabel.setText("Rua");

        NumAdmLabel.setText("Número");

        BairroAdmLabel.setText("Bairro");

        CidadeAdmLabel.setText("Cidade");

        EmailAdmLabel.setText("Email");

        EmailAdmJTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailAdmJTFActionPerformed(evt);
            }
        });

        SenhaAdmLabel.setText("Senha");

        CodAdmLabel.setText("Código");

        ConfirmarSenhaLabel.setText("Confirmar Senha");

        ConfirmarSenhaAdmJPwdF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarSenhaAdmJPwdFActionPerformed(evt);
            }
        });

        TituloCUDAdm.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        TituloCUDAdm.setText("Tela de Administradores");

        BotaoBuscarAdm.setText("Buscar Adm");
        BotaoBuscarAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscarAdmActionPerformed(evt);
            }
        });

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
                    .addComponent(EmailAdmJTF)
                    .addComponent(NomeAdmJTF)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(FoneAdmJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CpfAdmLabel)
                            .addComponent(CpfAdmJTF)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EmailAdmLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BairroAdmLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BairroAdmJTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CidadeAdmLabel)
                            .addComponent(CidadeAdmJTF)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CodAdmJTF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoBuscarAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotaoCadastroAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoEditarAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoExcluirAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotaoVoltarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RuaAdmLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NumAdmLabel)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RuaAdmJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(NumAdmJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(NomeAdmLabel)
                            .addComponent(FoneAdmLabel)
                            .addComponent(CodAdmLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SenhaAdmJPwdF, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SenhaAdmLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ConfirmarSenhaLabel)
                                    .addComponent(ConfirmarSenhaAdmJPwdF, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(TituloCUDAdm))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(TituloCUDAdm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(CodAdmLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CodAdmJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoBuscarAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(NomeAdmLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NomeAdmJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FoneAdmLabel)
                    .addComponent(CpfAdmLabel))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FoneAdmJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CpfAdmJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RuaAdmLabel)
                    .addComponent(NumAdmLabel))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RuaAdmJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumAdmJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BairroAdmLabel)
                    .addComponent(CidadeAdmLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BairroAdmJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CidadeAdmJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(EmailAdmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(EmailAdmJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SenhaAdmLabel)
                    .addComponent(ConfirmarSenhaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SenhaAdmJPwdF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConfirmarSenhaAdmJPwdF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoCadastroAdm)
                    .addComponent(BotaoEditarAdm)
                    .addComponent(BotaoExcluirAdm)
                    .addComponent(BotaoVoltarMenu))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CodAdmJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodAdmJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodAdmJTFActionPerformed

    private void BotaoCadastroAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastroAdmActionPerformed

        adm.setCpf(CpfAdmJTF.getText());
        adm.setEmail(EmailAdmJTF.getText());
        adm.setNome(NomeAdmJTF.getText());
        adm.setSenha(SenhaAdmJPwdF.getText());
        adm.setTelefone(FoneAdmJTF.getText());
        try {
          if (validarAdm(adm)){
            admControle.inserirAdministrador(adm);
            limparDados();
            definirCod();
            habilitarBotaoCadastrar();
            }
        } catch (DaoException ex) {
            Logger.getLogger(CUDAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoCadastroAdmActionPerformed

    private void NomeAdmJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeAdmJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeAdmJTFActionPerformed

    private void ConfirmarSenhaAdmJPwdFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarSenhaAdmJPwdFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmarSenhaAdmJPwdFActionPerformed

    private void EmailAdmJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailAdmJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailAdmJTFActionPerformed

    private void BotaoExcluirAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirAdmActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", "Excluir Administrador", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            try {
                admControle.excluirAdministrador(Integer.parseInt(CodAdmJTF.getText()));
                limparDados();
                definirCod();
                habilitarBotaoCadastrar();
            } catch (DaoException ex) {
                Logger.getLogger(CUDAdm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BotaoExcluirAdmActionPerformed

    private void BotaoEditarAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarAdmActionPerformed
        adm.setCod(Integer.parseInt(CodAdmJTF.getText()));
        adm.setCpf(CpfAdmJTF.getText());
        adm.setEmail(EmailAdmJTF.getText());
        adm.setNome(NomeAdmJTF.getText());
        adm.setSenha(SenhaAdmJPwdF.getText());
        adm.setTelefone(FoneAdmJTF.getText());
        try {
            if (validarAdm(adm)){
                admControle.alterarAdministrador(Integer.parseInt(CodAdmJTF.getText()), adm);
                limparDados();
                habilitarBotaoCadastrar();
                desabilitarBotaoExcluir();
                desabilitarBotaoEditar();
                definirCod();
            }
        } catch (DaoException ex) {
            Logger.getLogger(CUDAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoEditarAdmActionPerformed

    private void BotaoBuscarAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscarAdmActionPerformed
        buscaAdm.setVisible(true);
        dispose();
        try {
            buscaAdm.consultarTodos();
        } catch (DaoException ex) {
            Logger.getLogger(CUDProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BotaoBuscarAdmActionPerformed

    private void BotaoVoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoVoltarMenuActionPerformed
        dispose();
    }//GEN-LAST:event_BotaoVoltarMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BairroAdmJTF;
    private javax.swing.JLabel BairroAdmLabel;
    private javax.swing.JButton BotaoBuscarAdm;
    private javax.swing.JButton BotaoCadastroAdm;
    private javax.swing.JButton BotaoEditarAdm;
    private javax.swing.JButton BotaoExcluirAdm;
    private javax.swing.JButton BotaoVoltarMenu;
    private javax.swing.JTextField CidadeAdmJTF;
    private javax.swing.JLabel CidadeAdmLabel;
    private javax.swing.JTextField CodAdmJTF;
    private javax.swing.JLabel CodAdmLabel;
    private javax.swing.JPasswordField ConfirmarSenhaAdmJPwdF;
    private javax.swing.JLabel ConfirmarSenhaLabel;
    private javax.swing.JTextField CpfAdmJTF;
    private javax.swing.JLabel CpfAdmLabel;
    private javax.swing.JTextField EmailAdmJTF;
    private javax.swing.JLabel EmailAdmLabel;
    private javax.swing.JTextField FoneAdmJTF;
    private javax.swing.JLabel FoneAdmLabel;
    private javax.swing.JTextField NomeAdmJTF;
    private javax.swing.JLabel NomeAdmLabel;
    private javax.swing.JTextField NumAdmJTF;
    private javax.swing.JLabel NumAdmLabel;
    private javax.swing.JTextField RuaAdmJTF;
    private javax.swing.JLabel RuaAdmLabel;
    private javax.swing.JPasswordField SenhaAdmJPwdF;
    private javax.swing.JLabel SenhaAdmLabel;
    private javax.swing.JLabel TituloCUDAdm;
    // End of variables declaration//GEN-END:variables

    void desabilitarBotaoCadastrar() {
        BotaoCadastroAdm.setEnabled(false);
    }

    void desabilitarBotaoEditar() {
        BotaoEditarAdm.setEnabled(false);
    }

    void desabilitarBotaoExcluir() {
        BotaoExcluirAdm.setEnabled(false);
    }
    
    void habilitarBotaoCadastrar() {
        BotaoCadastroAdm.setEnabled(true);
    }

    void habilitarBotaoEditar() {
        BotaoEditarAdm.setEnabled(true);
    }

    void habilitarBotaoExcluir() {
        BotaoExcluirAdm.setEnabled(true);
    }

    void desabilitarJTF(){
        NomeAdmJTF.setEnabled(false);
        FoneAdmJTF.setEnabled(false);
        CpfAdmJTF.setEnabled(false);
        EmailAdmJTF.setEnabled(false);
        SenhaAdmJPwdF.setEnabled(false);
        ConfirmarSenhaAdmJPwdF.setEnabled(false);
    }
    void habilitarJTF(){
        NomeAdmJTF.setEnabled(true);
        FoneAdmJTF.setEnabled(true);
        CpfAdmJTF.setEnabled(true);
        EmailAdmJTF.setEnabled(true);
        SenhaAdmJPwdF.setEnabled(true);
        ConfirmarSenhaAdmJPwdF.setEnabled(true);
    }

    void exibirDados(Administrador a) {
        NomeAdmJTF.setText(a.getNome());
        CodAdmJTF.setText(Integer.toString(a.getCod()));
        FoneAdmJTF.setText(a.getTelefone());
        CpfAdmJTF.setText(a.getCpf());
        EmailAdmJTF.setText(a.getEmail());
        SenhaAdmJPwdF.setText(a.getSenha());
        ConfirmarSenhaAdmJPwdF.setText(a.getSenha());
        BotaoExcluirAdm.setEnabled(true);
    }

    void limparDados() {
        NomeAdmJTF.setText("");
        CodAdmJTF.setText("");
        FoneAdmJTF.setText("");
        CpfAdmJTF.setText("");
        EmailAdmJTF.setText("");
        SenhaAdmJPwdF.setText("");
        ConfirmarSenhaAdmJPwdF.setText("");
        BotaoExcluirAdm.setEnabled(false);
        BotaoCadastroAdm.setEnabled(false);
        BotaoEditarAdm.setEnabled(false);
    }
    
    void definirCod() throws DaoException{
        try {
            CodAdmJTF.setText(Integer.toString(admControle.proximoCod()));
        } catch (DaoException ex) {
            Logger.getLogger(CUDAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean validarAdm(Administrador a) {
        if (a.getNome().length()>=2 && 
        a.getCpf().length()>=11 && 
        a.getEmail().length()>7 && 
        a.getSenha().length()>=8 && 
        a.getTelefone().length()>=8 &&
        a.getSenha().equals(ConfirmarSenhaAdmJPwdF.getText())){
            return true;
        } else {
            return false;
        }
    }
}
