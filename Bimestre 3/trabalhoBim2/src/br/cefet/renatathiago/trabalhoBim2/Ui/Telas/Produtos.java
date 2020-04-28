/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.renatathiago.trabalhoBim2.Ui.Telas;

import br.cefet.renatathiago.trabalhoBim2.Dao.ProdutoDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Produto;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import br.cefet.renatathiago.trabalhoBim2.Relatorios.ProdutoRelatorio;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Produtos extends javax.swing.JFrame {

    ProdutoDao pDao = new ProdutoDao();
    ProdutoRelatorio prel = new ProdutoRelatorio();
    private List<Produto> itensTabela;
    
    public Produtos() {
        initComponents();
        try {
            preencherTabela(pDao.consultarTodos());
        } catch (DaoException ex) {
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BotoesPnl = new javax.swing.JPanel();
        VoltarBtn = new javax.swing.JButton();
        NovoBtn = new javax.swing.JButton();
        AlterarBtn = new javax.swing.JButton();
        ExcluirBtn = new javax.swing.JButton();
        RelatorioBtn = new javax.swing.JButton();
        FiltroPnl = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        FiltroMarca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        FiltroNome = new javax.swing.JTextField();
        FiltrarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel1.setText("Produtos");

        VoltarBtn.setText("Voltar");
        VoltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBtnActionPerformed(evt);
            }
        });
        BotoesPnl.add(VoltarBtn);

        NovoBtn.setText("Novo");
        NovoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoBtnActionPerformed(evt);
            }
        });
        BotoesPnl.add(NovoBtn);

        AlterarBtn.setText("Alterar");
        AlterarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarBtnActionPerformed(evt);
            }
        });
        BotoesPnl.add(AlterarBtn);

        ExcluirBtn.setText("Excluir");
        ExcluirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirBtnActionPerformed(evt);
            }
        });
        BotoesPnl.add(ExcluirBtn);

        RelatorioBtn.setText("Relatório");
        RelatorioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioBtnActionPerformed(evt);
            }
        });
        BotoesPnl.add(RelatorioBtn);

        jLabel2.setText("Marca:");
        FiltroPnl.add(jLabel2);

        FiltroMarca.setColumns(8);
        FiltroMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FiltroMarcaKeyPressed(evt);
            }
        });
        FiltroPnl.add(FiltroMarca);

        jLabel5.setText("Nome:");
        FiltroPnl.add(jLabel5);

        FiltroNome.setColumns(8);
        FiltroNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FiltroNomeKeyPressed(evt);
            }
        });
        FiltroPnl.add(FiltroNome);

        FiltrarBtn.setText("Filtrar");
        FiltrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarBtnActionPerformed(evt);
            }
        });
        FiltroPnl.add(FiltrarBtn);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotoesPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(FiltroPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(FiltroPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(BotoesPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FiltroMarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FiltroMarcaKeyPressed
      if (evt.getKeyCode()==10){
           List<Produto> lista = new ArrayList();

            try {
                String marca = FiltroMarca.getText();
                String nome = FiltroNome.getText();
                if (marca.equals("") && nome.equals("")){
                    preencherTabela(pDao.consultarTodos());
                } else if (marca.equals("")){
                    preencherTabela(pDao.consultarPorNome(nome));
                } else if (nome.equals("")){
                    preencherTabela(pDao.consultarPorMarca(marca));
                } else {
                    preencherTabela(pDao.consultarPorMarcaNome(marca, nome));
                }           
        } catch (DaoException ex) {
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }//GEN-LAST:event_FiltroMarcaKeyPressed

    private void FiltrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarBtnActionPerformed
       List<Produto> lista = new ArrayList();

            try {
            
            String marca = FiltroMarca.getText();
                String nome = FiltroNome.getText();
                if (marca.equals("") && nome.equals("")){
                    preencherTabela(pDao.consultarTodos());
                } else if (marca.equals("")){
                    preencherTabela(pDao.consultarPorNome(nome));
                } else if (nome.equals("")){
                    preencherTabela(pDao.consultarPorMarca(marca));
                } else {
                    preencherTabela(pDao.consultarPorMarcaNome(marca, nome));
                }
                
        } catch (DaoException ex) {
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_FiltrarBtnActionPerformed

    private void NovoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoBtnActionPerformed
        NovoProduto n = new NovoProduto(this, true);
        n.setVisible(true);
        try {
            preencherTabela(pDao.consultarTodos());
        } catch (DaoException ex) {
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NovoBtnActionPerformed

    private void AlterarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarBtnActionPerformed
        Produto p = new Produto();
        try {
            p = getItemSelecionado();
        } catch (DaoException ex) {
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }
        AlterarProduto a = new AlterarProduto(this, true, p);
        a.setVisible(true);
        try {
            preencherTabela(pDao.consultarTodos());
        } catch (DaoException ex) {
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AlterarBtnActionPerformed

    private void ExcluirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirBtnActionPerformed
        try {
            Produto p = getItemSelecionado();
            pDao.excluir(p.getCod());
            preencherTabela(pDao.consultarTodos());
        } catch (DaoException ex) {
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ExcluirBtnActionPerformed

    private void VoltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarBtnActionPerformed
        setVisible(false);
    }//GEN-LAST:event_VoltarBtnActionPerformed

    private void FiltroNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FiltroNomeKeyPressed
        if (evt.getKeyCode()==10){
           List<Produto> lista = new ArrayList();

            try {
                String marca = FiltroMarca.getText();
                String nome = FiltroNome.getText();
                if (marca.equals("") && nome.equals("")){
                    preencherTabela(pDao.consultarTodos());
                } else if (marca.equals("")){
                    preencherTabela(pDao.consultarPorNome(nome));
                } else if (nome.equals("")){
                    preencherTabela(pDao.consultarPorMarca(marca));
                } else {
                    preencherTabela(pDao.consultarPorMarcaNome(marca, nome));
                }           
        } catch (DaoException ex) {
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

    }//GEN-LAST:event_FiltroNomeKeyPressed

    private void RelatorioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioBtnActionPerformed
        ProdutoRelatorio prel = new ProdutoRelatorio();
        prel.emitirRelatorio(itensTabela);
    }//GEN-LAST:event_RelatorioBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlterarBtn;
    private javax.swing.JPanel BotoesPnl;
    private javax.swing.JButton ExcluirBtn;
    private javax.swing.JButton FiltrarBtn;
    private javax.swing.JTextField FiltroMarca;
    private javax.swing.JTextField FiltroNome;
    private javax.swing.JPanel FiltroPnl;
    private javax.swing.JButton NovoBtn;
    private javax.swing.JButton RelatorioBtn;
    private javax.swing.JButton VoltarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela(List<br.cefet.renatathiago.trabalhoBim2.Entidade.Produto> lista) {
        if (lista != null){
            String[] vetor = new String[6];
            vetor [0]= "Cod";
            vetor [1]= "Nome";
            vetor [2]= "Marca";
            vetor [3] = "Preço Compra";
            vetor [4] = "Preço Venda";
            vetor [5] = "Qtd em Estoque";
            String [][] matriz = new String[lista.size()][6];
            
            for (int i = 0; i<lista.size(); i++){
                  matriz [i][0]=lista.get(i).getCod()+"";
                  matriz [i][1]=lista.get(i).getNome();
                  matriz [i][2]=lista.get(i).getMarca();
                  matriz [i][3]=lista.get(i).getPrecoCompra()+"";
                  matriz [i][4]=lista.get(i).getPrecoVenda()+"";
                  matriz [i][5]=lista.get(i).getQtdEstoque()+"";
            }
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
         matriz, vetor));
        itensTabela = lista;
        }
    }

    private Produto getItemSelecionado() throws DaoException {
        int l = jTable1.getSelectedRow();
        int num = Integer.parseInt((String) jTable1.getValueAt(l, 0));
        return pDao.consultarPorCod(num);
    }
}
