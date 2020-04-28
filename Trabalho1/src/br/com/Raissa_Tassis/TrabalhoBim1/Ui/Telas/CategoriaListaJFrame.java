/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Raissa_Tassis.TrabalhoBim1.Ui.Telas;

import br.com.Raissa_Tassis.TrabalhoBim1.Controle.CategoriaControle;
import br.com.Raissa_Tassis.TrabalhoBim1.Dao.DaoException;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Categoria;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Douglas
 */
public class CategoriaListaJFrame extends javax.swing.JFrame {

    CategoriaControle caControle = CategoriaControle.getInstance();

    /**
     * Creates new form Teste2JFrame
     */
    public CategoriaListaJFrame() {
        initComponents();
        List<Categoria> cList = null;
        try {
            cList = caControle.consultaTudo();
        } catch (DaoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro no BD ", HEIGHT);
        }

        preencheTabela(cList);
        this.setTitle("Categorias");
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelButton = new javax.swing.JPanel();
        btExcluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btVisualizar = new javax.swing.JButton();
        PanelHead = new javax.swing.JPanel();
        PanelPesquisa = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();
        PanelAdd = new javax.swing.JPanel();
        BtAdicionar = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        CategoriaTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelButton.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Raissa_Tassis/TrabalhoBim1/Ui/Imagens/delete.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        panelButton.add(btExcluir);

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Raissa_Tassis/TrabalhoBim1/Ui/Imagens/pencil.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setEnabled(false);
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        panelButton.add(btAlterar);

        btVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Raissa_Tassis/TrabalhoBim1/Ui/Imagens/cursor.png"))); // NOI18N
        btVisualizar.setText("Visualizar");
        btVisualizar.setEnabled(false);
        btVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVisualizarActionPerformed(evt);
            }
        });
        panelButton.add(btVisualizar);

        getContentPane().add(panelButton, java.awt.BorderLayout.SOUTH);

        PanelHead.setLayout(new java.awt.BorderLayout());

        PanelPesquisa.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblNome.setText("Nome: ");
        PanelPesquisa.add(lblNome);

        tfPesquisa.setColumns(30);
        tfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPesquisaKeyPressed(evt);
            }
        });
        PanelPesquisa.add(tfPesquisa);

        PanelHead.add(PanelPesquisa, java.awt.BorderLayout.CENTER);

        BtAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Raissa_Tassis/TrabalhoBim1/Ui/Imagens/add.png"))); // NOI18N
        BtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAdicionarActionPerformed(evt);
            }
        });
        PanelAdd.add(BtAdicionar);

        PanelHead.add(PanelAdd, java.awt.BorderLayout.EAST);

        getContentPane().add(PanelHead, java.awt.BorderLayout.PAGE_START);

        CategoriaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        CategoriaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoriaTableMouseClicked(evt);
            }
        });
        jScrollPane.setViewportView(CategoriaTable);

        getContentPane().add(jScrollPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        int opt = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir", "Exclusão", WIDTH);
        List<Categoria> cList = null;
        if (opt == JOptionPane.OK_OPTION) {

            Categoria cat = getCategoriaFromTable();

            try {
                caControle.excluir(cat.getCdCategoria());

                int linha = CategoriaTable.getSelectedRow();
                DefaultTableModel m = (DefaultTableModel) CategoriaTable.getModel();
                m.removeRow(linha);
                desabilitarBotoes();

//                cList = caControle.consultaTudo();
//                preencheTabela(cList);
            } catch (DaoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro no BD ", HEIGHT);
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed
        CategoriaCadastroJDialog telaCadastro = new CategoriaCadastroJDialog(this, true);
        telaCadastro.setVisible(true);

        Categoria c = telaCadastro.getCategoria();

        if (c != null) {
            tfPesquisa.setText(c.getNmCategoria());
            consultaPorNome();
        }
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        Categoria cat = getCategoriaFromTable();

        CategoriaAlterarJDialog telaAlterar = new CategoriaAlterarJDialog(this, true, cat);
        telaAlterar.setVisible(true);

        cat = telaAlterar.getCategoria();

        if (cat != null) {
            int linha = CategoriaTable.getSelectedRow();
            CategoriaTable.setValueAt(cat.getNmCategoria(), linha, 1);     
        }

//        List<Categoria> cList = null;
//        try {
//            cList = caControle.consultaTudo();
//            consultaPorNome();
//        } catch (DaoException ex) {
//            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro no BD", 0);
//        }
//        preencheTabela(cList);
    }//GEN-LAST:event_btAlterarActionPerformed

    private void tfPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaKeyPressed
        //verifica se ? o Enter que foi pressionado
        if (evt.getKeyCode() == 10) {
            consultaPorNome();
        }
    }//GEN-LAST:event_tfPesquisaKeyPressed

    private void consultaPorNome() {
        List<Categoria> cList = null;
        try {
            cList = caControle.consultaPorNome(tfPesquisa.getText());
        } catch (DaoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro no BD ", HEIGHT);
        }
        preencheTabela(cList);
    }
    
    private void CategoriaTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoriaTableMouseClicked
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
        btVisualizar.setEnabled(true);
    }//GEN-LAST:event_CategoriaTableMouseClicked

    private void btVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVisualizarActionPerformed
        Categoria c = getCategoriaFromTable();
        CategoriaVisualizarJDialog telaVisu = new CategoriaVisualizarJDialog(this, true, c);
        telaVisu.setVisible(true);
    }//GEN-LAST:event_btVisualizarActionPerformed

    public Categoria getCategoriaFromTable() {
        Categoria catRet = null;

        int linha = CategoriaTable.getSelectedRow();

        if (linha >= 0) {
            TableModel m = CategoriaTable.getModel();
            String idStr = m.getValueAt(linha, 0).toString();
            int id = Integer.parseInt(idStr);

            catRet = new Categoria();
            catRet.setCdCategoria(id);
            catRet.setNmCategoria(m.getValueAt(linha, 1).toString());
        }
        return catRet;
    }

    public void preencheTabela(List<Categoria> cList) {
        if (cList != null) {
            String[] strVet = new String[]{"Cod.", "Nome"};
            String[][] strAMat = new String[cList.size()][2];

            for (int i = 0; i < cList.size(); i++) {
                Categoria c = cList.get(i);
                strAMat[i][0] = c.getCdCategoria() + "";
                strAMat[i][1] = c.getNmCategoria();
            }

            CategoriaTable.setModel(new DefaultTableModel(
                    strAMat, strVet));
        }
        desabilitarBotoes();
    }

    private void desabilitarBotoes() {
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
        btVisualizar.setEnabled(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CategoriaListaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CategoriaListaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CategoriaListaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CategoriaListaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CategoriaListaJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JTable CategoriaTable;
    private javax.swing.JPanel PanelAdd;
    private javax.swing.JPanel PanelHead;
    private javax.swing.JPanel PanelPesquisa;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btVisualizar;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel lblNome;
    private javax.swing.JPanel panelButton;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
}
