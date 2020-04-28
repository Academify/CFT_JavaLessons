/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Raissa_Tassis.TrabalhoBim1.Ui.Telas;

import br.com.Raissa_Tassis.TrabalhoBim1.Controle.EditoraControle;
import br.com.Raissa_Tassis.TrabalhoBim1.Dao.DaoException;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Categoria;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Editora;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author José Fernandes
 */
public class EditoraListaJFrame extends javax.swing.JFrame {

    /**
     * Creates new form EditoraListaJFrame
     */
    private EditoraControle eControle = EditoraControle.getInstance();

    public EditoraListaJFrame() {
        initComponents();

        List<Editora> eList = null;
        try {
            eList = eControle.consultaTudo();
        } catch (DaoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro no BD ", HEIGHT);
        }

        preencheTabela(eList);
        this.setTitle("Editoras");
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

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btAddEditora = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEditora = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btExcluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btVisualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setLayout(new java.awt.BorderLayout());

        lblNome.setText("Nome:");
        jPanel3.add(lblNome);

        tfPesquisa.setColumns(35);
        tfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPesquisaKeyPressed(evt);
            }
        });
        jPanel3.add(tfPesquisa);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        btAddEditora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Raissa_Tassis/TrabalhoBim1/Ui/Imagens/add.png"))); // NOI18N
        btAddEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddEditoraActionPerformed(evt);
            }
        });
        jPanel4.add(btAddEditora);

        jPanel2.add(jPanel4, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        tbEditora.setModel(new javax.swing.table.DefaultTableModel(
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
        tbEditora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEditoraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEditora);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Raissa_Tassis/TrabalhoBim1/Ui/Imagens/delete.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btExcluir);

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Raissa_Tassis/TrabalhoBim1/Ui/Imagens/pencil.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setEnabled(false);
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btAlterar);

        btVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Raissa_Tassis/TrabalhoBim1/Ui/Imagens/cursor.png"))); // NOI18N
        btVisualizar.setText("Visualizar");
        btVisualizar.setEnabled(false);
        btVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVisualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btVisualizar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaKeyPressed
        //verifica se ? o Enter que foi pressionado
        if (evt.getKeyCode() == 10) {
            consultaPorNome();
        }
    }//GEN-LAST:event_tfPesquisaKeyPressed

    private void btAddEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddEditoraActionPerformed
        EditoraCadastroJDialog telaCadastro = new EditoraCadastroJDialog(this, true);
        telaCadastro.setVisible(true);

        Editora e = telaCadastro.getEditora();

        if (e != null) {
            tfPesquisa.setText(e.getNmEditora());
            consultaPorNome();
        }
    }//GEN-LAST:event_btAddEditoraActionPerformed

    private void tbEditoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEditoraMouseClicked
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
        btVisualizar.setEnabled(true);
    }//GEN-LAST:event_tbEditoraMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int opt = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir", "Exclusão", WIDTH);
        List<Editora> cList = null;
        if (opt == JOptionPane.OK_OPTION) {

            Editora ed = getEditoraFromTable();

            try {
                eControle.excluir(ed.getCdEditora());

                int linha = tbEditora.getSelectedRow();
                DefaultTableModel m = (DefaultTableModel) tbEditora.getModel();
                m.removeRow(linha);
                desabilitarBotoes();

//                cList = caControle.consultaTudo();
//                preencheTabela(cList);
            } catch (DaoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro no BD ", HEIGHT);
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        Editora ed = getEditoraFromTable();

        EditoraAlterarJDialog telaAlterar = new EditoraAlterarJDialog(this, true, ed);
        telaAlterar.setVisible(true);

        ed = telaAlterar.getEditora();

        if (ed != null) {
            int linha = tbEditora.getSelectedRow();
            tbEditora.setValueAt(ed.getNmEditora(), linha, 1);
        }
        
//        try {
//            List<Editora> eList = eControle.consultaTudo();
//            preencheTabela(eList);
//        } catch (DaoException ex) {
//            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro no BD ", HEIGHT);
//        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVisualizarActionPerformed
        Editora e = getEditoraFromTable();
        EditoraVisualizarJDialog telaVisu = new EditoraVisualizarJDialog(this, true, e);
        telaVisu.setVisible(true);
    }//GEN-LAST:event_btVisualizarActionPerformed

    private void consultaPorNome() {
        List<Editora> eList = null;
        try {
            eList = eControle.consultaPorNome(tfPesquisa.getText());
        } catch (DaoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro no BD ", HEIGHT);
        }
        preencheTabela(eList);
    }

    public Editora getEditoraFromTable() {
        Editora catRet = null;

        int linha = tbEditora.getSelectedRow();

        if (linha >= 0) {
            TableModel m = tbEditora.getModel();
            String idStr = m.getValueAt(linha, 0).toString();
            int id = Integer.parseInt(idStr);

            catRet = new Editora();
            catRet.setCdEditora(id);
            catRet.setNmEditora(m.getValueAt(linha, 1).toString());
        }
        return catRet;
    }

    public void preencheTabela(List<Editora> eList) {
        if (eList != null) {
            String[] strVet = new String[]{"Cod.", "Nome"};
            String[][] strAMat = new String[eList.size()][2];

            for (int i = 0; i < eList.size(); i++) {
                Editora c = eList.get(i);
                strAMat[i][0] = c.getCdEditora() + "";
                strAMat[i][1] = c.getNmEditora();
            }

            tbEditora.setModel(new DefaultTableModel(
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
            java.util.logging.Logger.getLogger(EditoraListaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditoraListaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditoraListaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditoraListaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditoraListaJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddEditora;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btVisualizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tbEditora;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
}