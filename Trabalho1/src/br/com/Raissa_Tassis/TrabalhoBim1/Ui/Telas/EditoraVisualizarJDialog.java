/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Raissa_Tassis.TrabalhoBim1.Ui.Telas;

import br.com.Raissa_Tassis.TrabalhoBim1.Controle.ObraControle;
import br.com.Raissa_Tassis.TrabalhoBim1.Dao.DaoException;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Editora;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Obra;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author José Fernandes
 */
public class EditoraVisualizarJDialog extends javax.swing.JDialog {

    /**
     * Creates new form EditoraVisualizarJDialog
     */
    public EditoraVisualizarJDialog(java.awt.Frame parent, boolean modal, Editora e) {
        super(parent, modal);
        initComponents();
        
        tfNome.setText(e.getNmEditora());
        this.setTitle("Visualizar Editora");
        this.setLocationRelativeTo(null);
        
        ObraControle obControle = ObraControle.getInstance();
        List<Obra> oList = null;
        try {
            oList = obControle.consultaPorEditora(e.getCdEditora());
        } catch (DaoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro no BD ", HEIGHT);
        }
        preencheTabela(oList);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbObra = new javax.swing.JTable();
        lblObras = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Raissa_Tassis/TrabalhoBim1/Ui/Imagens/resultset_previous.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(btVoltar);

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

        lblObras.setText("Obras");

        lblNome.setText("Nome:");

        tfNome.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 32, Short.MAX_VALUE)
                .addComponent(lblNome)
                .addGap(18, 18, 18)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(lblObras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addGap(18, 18, 18)
                .addComponent(lblObras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(EditoraVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditoraVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditoraVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditoraVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditoraVisualizarJDialog dialog = new EditoraVisualizarJDialog(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JTable tbObra;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
