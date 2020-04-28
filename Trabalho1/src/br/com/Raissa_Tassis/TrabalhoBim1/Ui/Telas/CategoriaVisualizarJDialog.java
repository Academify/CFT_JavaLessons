/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Raissa_Tassis.TrabalhoBim1.Ui.Telas;

import br.com.Raissa_Tassis.TrabalhoBim1.Controle.ObraControle;
import br.com.Raissa_Tassis.TrabalhoBim1.Dao.DaoException;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Categoria;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Obra;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author José Fernandes
 */
public class CategoriaVisualizarJDialog extends javax.swing.JDialog {

    /**
     * Creates new form CategoriaVisualizarJDialog
     */
    public CategoriaVisualizarJDialog(java.awt.Frame parent, boolean modal, Categoria c) {
        super(parent, modal);
        initComponents();
        tfNome.setText(c.getNmCategoria());
        this.setTitle("Visualizar Categoria");
        this.setLocationRelativeTo(null);
        
        ObraControle obControle = ObraControle.getInstance();
        List<Obra> oList = null;
        try {
            oList = obControle.consultaPorCategoria(c.getCdCategoria());
        } catch (DaoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro no BD ", HEIGHT);
        }
        preencheTabela(oList);
    }

    public void preencheTabela(List<Obra> oList) {
        if (oList != null) {
            String[] strVet = new String[]{"Cod.", "Nome", "Lançamento"};
            String[][] strAMat = new String[oList.size()][3];

            for (int i = 0; i < oList.size(); i++) {
                Obra o = oList.get(i);
                strAMat[i][0] = o.getCdObra()+ "";
                strAMat[i][1] = o.getNmObra();
                strAMat[i][2] = o.getDtLancamento()+"";
            }

            tbObra.setModel(new DefaultTableModel(
                    strAMat, strVet));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbObra = new javax.swing.JTable();
        panelButton = new javax.swing.JPanel();
        btVoltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        lblObras = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tbObra.setModel(new javax.swing.table.DefaultTableModel(
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
        tbObra.setEnabled(false);
        jScrollPane1.setViewportView(tbObra);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Raissa_Tassis/TrabalhoBim1/Ui/Imagens/resultset_previous.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        panelButton.add(btVoltar);

        getContentPane().add(panelButton, java.awt.BorderLayout.SOUTH);

        lblNome.setText("Nome:");

        tfNome.setEditable(false);
        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        lblObras.setText("Obras");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblObras)
                .addGap(166, 166, 166))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblObras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed

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
            java.util.logging.Logger.getLogger(CategoriaVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CategoriaVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CategoriaVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CategoriaVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CategoriaVisualizarJDialog dialog = new CategoriaVisualizarJDialog(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblObras;
    private javax.swing.JPanel panelButton;
    private javax.swing.JTable tbObra;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
