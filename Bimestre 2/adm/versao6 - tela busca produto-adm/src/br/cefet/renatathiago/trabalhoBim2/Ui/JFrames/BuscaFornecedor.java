/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.renatathiago.trabalhoBim2.Ui.JFrames;
import br.cefet.renatathiago.trabalhoBim2.Controle.FornecedorControle;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Fornecedor;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import br.cefet.renatathiago.trabalhoBim2.Utilidades.CellRenderer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Thiago
 */
public class BuscaFornecedor extends javax.swing.JFrame {

   
    public BuscaFornecedor() {
        initComponents();
    }

   Fornecedor forn = new Fornecedor();
   FornecedorControle fControle = new FornecedorControle();
   DefaultTableModel modeloTabela = new DefaultTableModel();
   private List<Fornecedor> lista = new ArrayList();
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FiltroFornecedorCBox = new javax.swing.JComboBox<>();
        BotaoVoltarMenu = new javax.swing.JButton();
        BotaoSelecionarFornecedor = new javax.swing.JButton();
        PadraoFiltroFornecedorLabel = new javax.swing.JLabel();
        FornecedorScrollPanel = new javax.swing.JScrollPane();
        TabelaFornecedor = new javax.swing.JTable();
        PadraoFiltroFornecedorJTF = new javax.swing.JTextField();
        BotaoFiltrarFornecedor = new javax.swing.JButton();
        FiltroFornecedorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FiltroFornecedorCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Nome", "Código" }));
        FiltroFornecedorCBox.setToolTipText("");
        FiltroFornecedorCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltroFornecedorCBoxActionPerformed(evt);
            }
        });

        BotaoVoltarMenu.setText("Voltar");
        BotaoVoltarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoVoltarMenuActionPerformed(evt);
            }
        });

        BotaoSelecionarFornecedor.setText("Selecionar");
        BotaoSelecionarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSelecionarFornecedorActionPerformed(evt);
            }
        });

        PadraoFiltroFornecedorLabel.setText("Igual a:");

        TabelaFornecedor.setModel(new javax.swing.table.DefaultTableModel(
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
                "Código", "Nome", "Telefone", "Cnpj"
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
        TabelaFornecedor.setColumnSelectionAllowed(true);
        TabelaFornecedor.getTableHeader().setReorderingAllowed(false);
        FornecedorScrollPanel.setViewportView(TabelaFornecedor);

        PadraoFiltroFornecedorJTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PadraoFiltroFornecedorJTFActionPerformed(evt);
            }
        });

        BotaoFiltrarFornecedor.setText("Filtrar");
        BotaoFiltrarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoFiltrarFornecedorActionPerformed(evt);
            }
        });

        FiltroFornecedorLabel.setText("Filtrar por:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(FiltroFornecedorLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(FiltroFornecedorCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(PadraoFiltroFornecedorLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(PadraoFiltroFornecedorJTF, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(BotaoFiltrarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(BotaoSelecionarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(BotaoVoltarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(FornecedorScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGap(4, 4, 4)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FiltroFornecedorCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FiltroFornecedorLabel)
                        .addComponent(PadraoFiltroFornecedorLabel)
                        .addComponent(PadraoFiltroFornecedorJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotaoFiltrarFornecedor))
                    .addGap(18, 18, 18)
                    .addComponent(FornecedorScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotaoVoltarMenu)
                        .addComponent(BotaoSelecionarFornecedor))
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FiltroFornecedorCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroFornecedorCBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltroFornecedorCBoxActionPerformed

    private void BotaoVoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoVoltarMenuActionPerformed
        dispose();
    }//GEN-LAST:event_BotaoVoltarMenuActionPerformed

    private void BotaoSelecionarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSelecionarFornecedorActionPerformed
           CUDFornecedor fJF = new CUDFornecedor();

        
        try {
            forn = fControle.consultarPorCod((int) TabelaFornecedor.getValueAt(TabelaFornecedor.getSelectedRow(), 0));
            fJF.setVisible(true);
            fJF.exibirDados(forn);
            fJF.habilitarJTF();
            fJF.desabilitarBotaoCadastrar();
            fJF.habilitarBotaoEditar();
            

        } catch (DaoException ex) {
            Logger.getLogger(CUDFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoSelecionarFornecedorActionPerformed

    private void PadraoFiltroFornecedorJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PadraoFiltroFornecedorJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PadraoFiltroFornecedorJTFActionPerformed

    private void BotaoFiltrarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoFiltrarFornecedorActionPerformed

        try {
            switch(FiltroFornecedorCBox.getSelectedIndex()){
                case 0:
                preencherTabela(fControle.consultarTodos());
                break;
                case 1:
                preencherTabela(fControle.consultarPorNome(PadraoFiltroFornecedorJTF.getText()));
                break;
                case 2:
                lista.add(fControle.consultarPorCod(Integer.parseInt(PadraoFiltroFornecedorJTF.getText())));
                preencherTabela(lista);
                lista.clear();
                break;
            }
        } catch (DaoException ex) {
            Logger.getLogger(CUDFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoFiltrarFornecedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoFiltrarFornecedor;
    private javax.swing.JButton BotaoSelecionarFornecedor;
    private javax.swing.JButton BotaoVoltarMenu;
    private javax.swing.JComboBox<String> FiltroFornecedorCBox;
    private javax.swing.JLabel FiltroFornecedorLabel;
    private javax.swing.JScrollPane FornecedorScrollPanel;
    private javax.swing.JTextField PadraoFiltroFornecedorJTF;
    private javax.swing.JLabel PadraoFiltroFornecedorLabel;
    private javax.swing.JTable TabelaFornecedor;
    // End of variables declaration//GEN-END:variables

    void preencherTabela(List<Fornecedor> listaFornecedor) throws DaoException {
        
        TabelaFornecedor.setDefaultRenderer(Object.class, new CellRenderer());        
        modeloTabela = (DefaultTableModel)  TabelaFornecedor.getModel();   
        while (modeloTabela.getRowCount() > 0) {
            modeloTabela.removeRow(0);
        }
        for (int i = 0; i<listaFornecedor.size(); i++) {
            modeloTabela.addRow(new Object[] { 
              listaFornecedor.get(i).getCod(),
              listaFornecedor.get(i).getNome(), 
              listaFornecedor.get(i).getTelefone(), 
              listaFornecedor.get(i).getCnpj()
            });
        }
    } 

    void consultarTodos() throws DaoException {
        preencherTabela(fControle.consultarTodos());
    }
}
