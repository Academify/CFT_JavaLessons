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
    private DefaultTableModel modeloTabela;
    private List<Produto> lista = new ArrayList();
    private Produto p = new Produto();
    
    public ProdutoJFrame() {
        initComponents();
        CodProdutoJTF.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotaoFiltrarProduto = new javax.swing.JButton();
        BotaoEditarProduto = new javax.swing.JButton();
        QtdEstoqueProdutoJTF = new javax.swing.JTextField();
        FiltroProdutoLabel = new javax.swing.JLabel();
        PrecoVendaProdutoLabel = new javax.swing.JLabel();
        BotaoExcluirProduto = new javax.swing.JButton();
        PrecoVendaProdutoJTF = new javax.swing.JTextField();
        FiltroProdutoCBox = new javax.swing.JComboBox<>();
        BotaoVoltarMenu = new javax.swing.JButton();
        NomeProdutoLabel = new javax.swing.JLabel();
        BotaoSelecionarProduto = new javax.swing.JButton();
        NomeProdutoJTF = new javax.swing.JTextField();
        CodProdutoLabel = new javax.swing.JLabel();
        CodProdutoJTF = new javax.swing.JTextField();
        PadraoFiltroProdutoLabel = new javax.swing.JLabel();
        ProdutoScrollPanel = new javax.swing.JScrollPane();
        TabelaProduto = new javax.swing.JTable();
        PadraoFiltroProdutoJTF = new javax.swing.JTextField();
        QtdEstoqueProdutoLabel = new javax.swing.JLabel();
        BotaoCadastroProduto = new javax.swing.JButton();
        MarcaProdutoLabel = new javax.swing.JLabel();
        MarcaProdutoJTF = new javax.swing.JTextField();
        PrecoCompraProdutoLabel = new javax.swing.JLabel();
        PrecoCompraProdutoJTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotaoFiltrarProduto.setText("Filtrar");
        BotaoFiltrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoFiltrarProdutoActionPerformed(evt);
            }
        });

        BotaoEditarProduto.setText("Salvar");
        BotaoEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarProdutoActionPerformed(evt);
            }
        });

        FiltroProdutoLabel.setText("Filtrar por:");

        PrecoVendaProdutoLabel.setText("Preço de Venda");

        BotaoExcluirProduto.setText("Excluir");
        BotaoExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluirProdutoActionPerformed(evt);
            }
        });

        FiltroProdutoCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Código", "Nome", "Marca" }));
        FiltroProdutoCBox.setToolTipText("");
        FiltroProdutoCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltroProdutoCBoxActionPerformed(evt);
            }
        });

        BotaoVoltarMenu.setText("Voltar");
        BotaoVoltarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoVoltarMenuActionPerformed(evt);
            }
        });

        NomeProdutoLabel.setText("Nome");

        BotaoSelecionarProduto.setText("Selecionar");
        BotaoSelecionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSelecionarProdutoActionPerformed(evt);
            }
        });

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

        PadraoFiltroProdutoLabel.setText("Igual a:");

        TabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Marca", "Qtd Estoque", "Preço Venda"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaProduto.setColumnSelectionAllowed(true);
        TabelaProduto.getTableHeader().setReorderingAllowed(false);
        ProdutoScrollPanel.setViewportView(TabelaProduto);
        TabelaProduto.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (TabelaProduto.getColumnModel().getColumnCount() > 0) {
            TabelaProduto.getColumnModel().getColumn(0).setResizable(false);
            TabelaProduto.getColumnModel().getColumn(1).setResizable(false);
            TabelaProduto.getColumnModel().getColumn(2).setResizable(false);
            TabelaProduto.getColumnModel().getColumn(3).setResizable(false);
            TabelaProduto.getColumnModel().getColumn(4).setResizable(false);
        }

        PadraoFiltroProdutoJTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PadraoFiltroProdutoJTFActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NomeProdutoLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CodProdutoLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 297, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(MarcaProdutoJTF, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(PrecoCompraProdutoLabel)
                                    .addComponent(PrecoCompraProdutoJTF))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PrecoVendaProdutoLabel)
                                    .addComponent(PrecoVendaProdutoJTF)))
                            .addComponent(NomeProdutoJTF)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BotaoCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotaoEditarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotaoExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CodProdutoJTF)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MarcaProdutoLabel)
                                .addGap(124, 124, 124)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(QtdEstoqueProdutoLabel)
                                    .addComponent(QtdEstoqueProdutoJTF, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FiltroProdutoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FiltroProdutoCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PadraoFiltroProdutoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PadraoFiltroProdutoJTF, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoFiltrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BotaoSelecionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(BotaoVoltarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ProdutoScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CodProdutoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CodProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NomeProdutoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NomeProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(MarcaProdutoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MarcaProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(QtdEstoqueProdutoLabel)
                                .addGap(8, 8, 8)
                                .addComponent(QtdEstoqueProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(PrecoVendaProdutoLabel)
                                .addGap(8, 8, 8)
                                .addComponent(PrecoVendaProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PrecoCompraProdutoLabel)
                                .addGap(8, 8, 8)
                                .addComponent(PrecoCompraProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FiltroProdutoCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FiltroProdutoLabel)
                            .addComponent(PadraoFiltroProdutoLabel)
                            .addComponent(PadraoFiltroProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoFiltrarProduto))
                        .addGap(18, 18, 18)
                        .addComponent(ProdutoScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoCadastroProduto)
                    .addComponent(BotaoEditarProduto)
                    .addComponent(BotaoExcluirProduto)
                    .addComponent(BotaoVoltarMenu)
                    .addComponent(BotaoSelecionarProduto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoFiltrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoFiltrarProdutoActionPerformed

        try {
            switch(FiltroProdutoCBox.getSelectedIndex()){
                case 0:
                preencherTabela(pDao.consultarTodos());
                break;
                case 1:
                lista.add(pDao.consultarPorCod(Integer.parseInt(PadraoFiltroProdutoJTF.getText())));
                preencherTabela(lista);
                lista.clear();
                break;
                case 2:
                preencherTabela(pDao.consultarPorNome(PadraoFiltroProdutoJTF.getText()));
                break;
                case 3:
                preencherTabela(pDao.consultarPorMarca(PadraoFiltroProdutoJTF.getText()));
            }
        } catch (DaoException ex) {
            Logger.getLogger(ProdutoJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoFiltrarProdutoActionPerformed

    private void BotaoEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarProdutoActionPerformed
        p.setCod(Integer.parseInt(CodProdutoJTF.getText()));
        p.setPrecoVenda(Double.parseDouble(PrecoVendaProdutoJTF.getText()));
        p.setNome(NomeProdutoJTF.getText());
        p.setQtdEstoque(Integer.parseInt(QtdEstoqueProdutoJTF.getText()));
        try {
            if (validarProduto(p)){
                pDao.alterar(Integer.parseInt(CodProdutoJTF.getText()), p);
                consultarTodos();
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
                consultarTodos();
                definirCod();
                habilitarBotaoCadastrar();
            } catch (DaoException ex) {
                Logger.getLogger(ProdutoJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BotaoExcluirProdutoActionPerformed

    private void FiltroProdutoCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroProdutoCBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltroProdutoCBoxActionPerformed

    private void BotaoVoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoVoltarMenuActionPerformed
        dispose();
    }//GEN-LAST:event_BotaoVoltarMenuActionPerformed

    private void BotaoSelecionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSelecionarProdutoActionPerformed
        try {
            p = pDao.consultarPorCod((int) TabelaProduto.getValueAt(TabelaProduto.getSelectedRow(), 0));
            exibirDados(p);
            habilitarJTF();
            BotaoCadastroProduto.setEnabled(false);
            BotaoEditarProduto.setEnabled(true);

        } catch (DaoException ex) {
            Logger.getLogger(ProdutoJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoSelecionarProdutoActionPerformed

    private void NomeProdutoJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeProdutoJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeProdutoJTFActionPerformed

    private void CodProdutoJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodProdutoJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodProdutoJTFActionPerformed

    private void PadraoFiltroProdutoJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PadraoFiltroProdutoJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PadraoFiltroProdutoJTFActionPerformed

    private void BotaoCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastroProdutoActionPerformed

        p.setPrecoVenda(Double.parseDouble(PrecoVendaProdutoJTF.getText()));
        p.setPrecoCompra(Double.parseDouble(PrecoCompraProdutoJTF.getText()));
        p.setMarca(MarcaProdutoJTF.getText());
        p.setNome(NomeProdutoJTF.getText());
        p.setQtdEstoque(Integer.parseInt(QtdEstoqueProdutoJTF.getText()));
        try {
            if (validarProduto(p)){
                pDao.inserir(p);
                consultarTodos();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCadastroProduto;
    private javax.swing.JButton BotaoEditarProduto;
    private javax.swing.JButton BotaoExcluirProduto;
    private javax.swing.JButton BotaoFiltrarProduto;
    private javax.swing.JButton BotaoSelecionarProduto;
    private javax.swing.JButton BotaoVoltarMenu;
    private javax.swing.JTextField CodProdutoJTF;
    private javax.swing.JLabel CodProdutoLabel;
    private javax.swing.JComboBox<String> FiltroProdutoCBox;
    private javax.swing.JLabel FiltroProdutoLabel;
    private javax.swing.JTextField MarcaProdutoJTF;
    private javax.swing.JLabel MarcaProdutoLabel;
    private javax.swing.JTextField NomeProdutoJTF;
    private javax.swing.JLabel NomeProdutoLabel;
    private javax.swing.JTextField PadraoFiltroProdutoJTF;
    private javax.swing.JLabel PadraoFiltroProdutoLabel;
    private javax.swing.JTextField PrecoCompraProdutoJTF;
    private javax.swing.JLabel PrecoCompraProdutoLabel;
    private javax.swing.JTextField PrecoVendaProdutoJTF;
    private javax.swing.JLabel PrecoVendaProdutoLabel;
    private javax.swing.JScrollPane ProdutoScrollPanel;
    private javax.swing.JTextField QtdEstoqueProdutoJTF;
    private javax.swing.JLabel QtdEstoqueProdutoLabel;
    private javax.swing.JTable TabelaProduto;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela(List<Produto> listaProduto) {
        TabelaProduto.setDefaultRenderer(Object.class, new CellRenderer());        
        modeloTabela = (DefaultTableModel) TabelaProduto.getModel();   
        while (modeloTabela.getRowCount() > 0) {
            modeloTabela.removeRow(0);
        }
        for (int i = 0; i<listaProduto.size(); i++) {
            modeloTabela.addRow(new Object[] { 
              listaProduto.get(i).getCod(),
              listaProduto.get(i).getNome(), 
              listaProduto.get(i).getMarca(), 
              listaProduto.get(i).getQtdEstoque(),
              listaProduto.get(i).getPrecoVenda(),
            });
        }
    }
    void desabilitarBotaoCadastrar() {
        BotaoCadastroProduto.setEnabled(false);
    }

    void desabilitarBotaoEditar() {
        BotaoEditarProduto.setEnabled(false);
    }

    void desabilitarBotaoExcluir() {
        BotaoExcluirProduto.setEnabled(false);
    }
    void desabilitarBotaoSelecionar() {
        BotaoSelecionarProduto.setEnabled(false);
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
    void habilitarBotaoSelecionar() {
        BotaoSelecionarProduto.setEnabled(true);
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

    void consultarTodos() throws DaoException {
        preencherTabela(pDao.consultarTodos());
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
