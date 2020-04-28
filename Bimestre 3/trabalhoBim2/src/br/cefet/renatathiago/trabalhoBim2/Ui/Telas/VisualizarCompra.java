package br.cefet.renatathiago.trabalhoBim2.Ui.Telas;

import br.cefet.renatathiago.trabalhoBim2.Controle.CompraControle;
import br.cefet.renatathiago.trabalhoBim2.Dao.CompraDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Produto;
import br.cefet.renatathiago.trabalhoBim2.Entidade.ProdutoCV;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VisualizarCompra extends javax.swing.JDialog {

    CompraDao cDao = new CompraDao();
    CompraControle cControle = new CompraControle();
    SelecionarProduto s = new SelecionarProduto(this, true);
    
    public VisualizarCompra(java.awt.Frame parent, boolean modal, Compra c) throws DaoException {
        super(parent, modal);
        initComponents();
        limparCampos();
        fornTf.setEnabled(false);
        dataTf.setEnabled(false);
        valorTf.setEnabled(false);
        formaPgTf.setEnabled(false);
        
        fornTf.setText(Integer.toString(c.getCodFornecedor()));
        dataTf.setText(c.getData());
        valorTf.setText(Double.toString(c.getValorTotal()));
        formaPgTf.setText(c.getFormaPg());
        preencherTabela(cControle.consultarProdutos(c.getCod()));        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        CancelarBtn = new javax.swing.JButton();
        fornTf = new javax.swing.JTextField();
        dataTf = new javax.swing.JTextField();
        valorTf = new javax.swing.JTextField();
        formaPgTf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel1.setText("Info Compra");

        jLabel3.setText("Fornecedor");

        jLabel4.setText("Data");

        jLabel5.setText("Valor");

        jLabel6.setText("Forma de Pagamento");

        CancelarBtn.setText("Voltar");
        CancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(CancelarBtn);

        fornTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fornTfActionPerformed(evt);
            }
        });

        dataTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataTfActionPerformed(evt);
            }
        });

        valorTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorTfActionPerformed(evt);
            }
        });

        formaPgTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formaPgTfActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Marca", "Preço Compra", "Preço Venda", "Qtd Estoque", "Qtd"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(21, 21, 21)
                            .addComponent(valorTf, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(19, 19, 19)
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(formaPgTf, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(fornTf, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dataTf, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fornTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(dataTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(valorTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(formaPgTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fornTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fornTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fornTfActionPerformed

    private void dataTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataTfActionPerformed

    private void valorTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTfActionPerformed

    private void formaPgTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formaPgTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formaPgTfActionPerformed

    private void CancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarBtnActionPerformed
        setVisible(false);
    }//GEN-LAST:event_CancelarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarBtn;
    private javax.swing.JTextField dataTf;
    private javax.swing.JTextField formaPgTf;
    private javax.swing.JTextField fornTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField valorTf;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        fornTf.setText("");
        dataTf.setText("");
        valorTf.setText("");
        formaPgTf.setText("");
        jTable1.removeAll();
    }
    
    List<ProdutoCV> getProdutos(){
        if (jTable1.getValueAt(0,0)!=null){
        ProdutoCV p = new ProdutoCV();
        List<ProdutoCV> lista;
        lista = new ArrayList();
        for (int i = 0; i<jTable1.getRowCount();i++){
            p.setCod(Integer.parseInt((String) jTable1.getValueAt(i, 0)));
            p.setNome( (String) jTable1.getValueAt(i, 1));
            p.setMarca((String) jTable1.getValueAt(i, 2));
            p.setPrecoCompra(Double.parseDouble((String) jTable1.getValueAt(i, 3)));
            p.setPrecoVenda(Double.parseDouble((String) jTable1.getValueAt(i, 4)));
            p.setQtdEstoque(Integer.parseInt((String) jTable1.getValueAt(i, 5)));
            p.setQtd(Integer.parseInt((String) jTable1.getValueAt(i, 6)));
            lista.add(p);
        }
        return lista;
        }else {
            return null;
        }
        
    }
    
    private void preencherTabela(List<br.cefet.renatathiago.trabalhoBim2.Entidade.ProdutoCV> lista) {
        if (lista != null){
            String[] vetor = new String[7];
            vetor [0]= "Cod";
            vetor [1]= "Nome";
            vetor [2]= "Marca";
            vetor [3] = "Preço Compra";
            vetor [4] = "Preço Venda";
            vetor [5] = "Qtd em Estoque";
            vetor [6] = "Quantidade";
            String [][] matriz = new String[lista.size()][7];
            
            for (int i = 0; i<lista.size(); i++){
                  matriz [i][0]=lista.get(i).getCod()+"";
                  matriz [i][1]=lista.get(i).getNome();
                  matriz [i][2]=lista.get(i).getMarca();
                  matriz [i][3]=lista.get(i).getPrecoCompra()+"";
                  matriz [i][4]=lista.get(i).getPrecoVenda()+"";
                  matriz [i][5]=lista.get(i).getQtdEstoque()+"";
                  matriz [i][6]=lista.get(i).getQtd()+"";
            }
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
         matriz, vetor));
        }
    }
}
