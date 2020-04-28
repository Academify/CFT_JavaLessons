package br.cefet.renatathiago.trabalhoBim2.Ui;

public class AdmJFrame extends javax.swing.JFrame {
    
    public AdmJFrame() {
        initComponents();
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
        AdmScrollPanel = new javax.swing.JScrollPane();
        TabelaAdm = new javax.swing.JTable();
        FiltroAdmLabel = new javax.swing.JLabel();
        FiltroAdmCBox = new javax.swing.JComboBox<>();
        PadraoFiltroAdmLabel = new javax.swing.JLabel();
        PadraoFiltroAdmJTF = new javax.swing.JTextField();
        BotaoFiltrarAdm = new javax.swing.JButton();
        ConfirmarSenhaLabel = new javax.swing.JLabel();
        SenhaJPwdF = new javax.swing.JPasswordField();
        ConfirmarSenhaJPwdF = new javax.swing.JPasswordField();
        BotaoVoltarMenu = new javax.swing.JButton();
        BotaoSelecionarAdm = new javax.swing.JButton();

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

        BotaoExcluirAdm.setText("Excluir");

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

        TabelaAdm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Telefone", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaAdm.setColumnSelectionAllowed(true);
        TabelaAdm.getTableHeader().setReorderingAllowed(false);
        AdmScrollPanel.setViewportView(TabelaAdm);
        TabelaAdm.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (TabelaAdm.getColumnModel().getColumnCount() > 0) {
            TabelaAdm.getColumnModel().getColumn(0).setResizable(false);
            TabelaAdm.getColumnModel().getColumn(0).setHeaderValue("Código");
            TabelaAdm.getColumnModel().getColumn(1).setHeaderValue("Nome");
            TabelaAdm.getColumnModel().getColumn(2).setResizable(false);
            TabelaAdm.getColumnModel().getColumn(2).setHeaderValue("Telefone");
            TabelaAdm.getColumnModel().getColumn(3).setHeaderValue("Email");
        }

        FiltroAdmLabel.setText("Filtrar por:");

        FiltroAdmCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Código", "Cidade" }));
        FiltroAdmCBox.setToolTipText("");
        FiltroAdmCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltroAdmCBoxActionPerformed(evt);
            }
        });

        PadraoFiltroAdmLabel.setText("Igual a:");

        BotaoFiltrarAdm.setText("Filtrar");
        BotaoFiltrarAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoFiltrarAdmActionPerformed(evt);
            }
        });

        ConfirmarSenhaLabel.setText("Confirmar Senha");

        ConfirmarSenhaJPwdF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarSenhaJPwdFActionPerformed(evt);
            }
        });

        BotaoVoltarMenu.setText("Voltar");
        BotaoVoltarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoVoltarMenuActionPerformed(evt);
            }
        });

        BotaoSelecionarAdm.setText("Selecionar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NomeAdmLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FoneAdmLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RuaAdmLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CodAdmLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NomeAdmJTF)
                            .addComponent(CodAdmJTF)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(FoneAdmJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CpfAdmLabel)
                                    .addComponent(CpfAdmJTF)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(RuaAdmJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NumAdmLabel)
                                    .addComponent(NumAdmJTF)))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(EmailAdmJTF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(SenhaJPwdF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ConfirmarSenhaJPwdF))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(SenhaAdmLabel)
                                            .addGap(123, 123, 123)
                                            .addComponent(ConfirmarSenhaLabel))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(BotaoCadastroAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(BotaoEditarAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(BotaoExcluirAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FiltroAdmLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FiltroAdmCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PadraoFiltroAdmLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PadraoFiltroAdmJTF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoFiltrarAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BotaoSelecionarAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(BotaoVoltarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(AdmScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CodAdmLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CodAdmJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SenhaJPwdF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ConfirmarSenhaJPwdF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FiltroAdmCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FiltroAdmLabel)
                            .addComponent(PadraoFiltroAdmLabel)
                            .addComponent(PadraoFiltroAdmJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoFiltrarAdm))
                        .addGap(18, 18, 18)
                        .addComponent(AdmScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoCadastroAdm)
                    .addComponent(BotaoEditarAdm)
                    .addComponent(BotaoExcluirAdm)
                    .addComponent(BotaoVoltarMenu)
                    .addComponent(BotaoSelecionarAdm))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CodAdmJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodAdmJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodAdmJTFActionPerformed

    private void BotaoCadastroAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastroAdmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoCadastroAdmActionPerformed

    private void BotaoFiltrarAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoFiltrarAdmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoFiltrarAdmActionPerformed

    private void NomeAdmJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeAdmJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeAdmJTFActionPerformed

    private void ConfirmarSenhaJPwdFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarSenhaJPwdFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmarSenhaJPwdFActionPerformed

    private void BotaoVoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoVoltarMenuActionPerformed
        setVisible(false);
    }//GEN-LAST:event_BotaoVoltarMenuActionPerformed

    private void EmailAdmJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailAdmJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailAdmJTFActionPerformed

    private void FiltroAdmCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroAdmCBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltroAdmCBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane AdmScrollPanel;
    private javax.swing.JTextField BairroAdmJTF;
    private javax.swing.JLabel BairroAdmLabel;
    private javax.swing.JButton BotaoCadastroAdm;
    private javax.swing.JButton BotaoEditarAdm;
    private javax.swing.JButton BotaoExcluirAdm;
    private javax.swing.JButton BotaoFiltrarAdm;
    private javax.swing.JButton BotaoSelecionarAdm;
    private javax.swing.JButton BotaoVoltarMenu;
    private javax.swing.JTextField CidadeAdmJTF;
    private javax.swing.JLabel CidadeAdmLabel;
    private javax.swing.JTextField CodAdmJTF;
    private javax.swing.JLabel CodAdmLabel;
    private javax.swing.JPasswordField ConfirmarSenhaJPwdF;
    private javax.swing.JLabel ConfirmarSenhaLabel;
    private javax.swing.JTextField CpfAdmJTF;
    private javax.swing.JLabel CpfAdmLabel;
    private javax.swing.JTextField EmailAdmJTF;
    private javax.swing.JLabel EmailAdmLabel;
    private javax.swing.JComboBox<String> FiltroAdmCBox;
    private javax.swing.JLabel FiltroAdmLabel;
    private javax.swing.JTextField FoneAdmJTF;
    private javax.swing.JLabel FoneAdmLabel;
    private javax.swing.JTextField NomeAdmJTF;
    private javax.swing.JLabel NomeAdmLabel;
    private javax.swing.JTextField NumAdmJTF;
    private javax.swing.JLabel NumAdmLabel;
    private javax.swing.JTextField PadraoFiltroAdmJTF;
    private javax.swing.JLabel PadraoFiltroAdmLabel;
    private javax.swing.JTextField RuaAdmJTF;
    private javax.swing.JLabel RuaAdmLabel;
    private javax.swing.JLabel SenhaAdmLabel;
    private javax.swing.JPasswordField SenhaJPwdF;
    private javax.swing.JTable TabelaAdm;
    // End of variables declaration//GEN-END:variables
}
