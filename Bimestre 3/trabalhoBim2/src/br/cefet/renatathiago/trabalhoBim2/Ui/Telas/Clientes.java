package br.cefet.renatathiago.trabalhoBim2.Ui.Telas;

import br.cefet.renatathiago.trabalhoBim2.Ui.Telas.NovoCliente;
import br.cefet.renatathiago.trabalhoBim2.Ui.Telas.AlterarCliente;
import br.cefet.renatathiago.trabalhoBim2.Dao.ClienteDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Cliente;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Clientes extends javax.swing.JFrame {

    ClienteDao cDao = new ClienteDao();
    
    public Clientes() {
        initComponents();
        try {
            preencherTabela(cDao.consultarTodos());
        } catch (DaoException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
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
        FiltrosCBB = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        FiltroTf = new javax.swing.JTextField();
        FiltrarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel1.setText("Clientes");

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

        jLabel2.setText("Filtro:");
        FiltroPnl.add(jLabel2);

        FiltrosCBB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Código", "Nome" }));
        FiltroPnl.add(FiltrosCBB);

        jLabel3.setText("Igual a:");
        FiltroPnl.add(jLabel3);

        FiltroTf.setColumns(8);
        FiltroTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FiltroTfKeyPressed(evt);
            }
        });
        FiltroPnl.add(FiltroTf);

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
            .addComponent(FiltroPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(BotoesPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(FiltroPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(BotoesPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FiltroTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FiltroTfKeyPressed
      if (evt.getKeyCode()==10){
           List<Cliente> lista = new ArrayList();

            try {
            
            switch(FiltrosCBB.getSelectedIndex()){
                case 0:
            {
                try {
                    preencherTabela(cDao.consultarTodos());
                } catch (DaoException ex) {
                    Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
                case 1:
                lista.add(cDao.consultarPorCod(Integer.parseInt(FiltroTf.getText())));
                preencherTabela(lista);
                lista.clear();
                break;
                case 2:
                preencherTabela(cDao.consultarPorNome(FiltroTf.getText()));
                break;
            }
        } catch (DaoException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }//GEN-LAST:event_FiltroTfKeyPressed

    private void FiltrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarBtnActionPerformed
       List<Cliente> lista = new ArrayList();

            try {
            
            switch(FiltrosCBB.getSelectedIndex()){
                case 0:
            {
                try {
                    preencherTabela(cDao.consultarTodos());
                } catch (DaoException ex) {
                    Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
                case 1:
                lista.add(cDao.consultarPorCod(Integer.parseInt(FiltroTf.getText())));
                preencherTabela(lista);
                lista.clear();
                break;
                case 2:
                preencherTabela(cDao.consultarPorNome(FiltroTf.getText()));
                break;
            }
        } catch (DaoException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_FiltrarBtnActionPerformed

    private void NovoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoBtnActionPerformed
        NovoCliente n = new NovoCliente(this, true);
        n.setVisible(true);
        try {
            preencherTabela(cDao.consultarTodos());
        } catch (DaoException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NovoBtnActionPerformed

    private void AlterarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarBtnActionPerformed
        Cliente p = new Cliente();
        try {
            p = getItemSelecionado();
        } catch (DaoException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        AlterarCliente a = new AlterarCliente(this, true, p);
        a.setVisible(true);
        try {
            preencherTabela(cDao.consultarTodos());
        } catch (DaoException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AlterarBtnActionPerformed

    private void ExcluirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirBtnActionPerformed
        try {
            Cliente p = getItemSelecionado();
            cDao.excluir(p.getCod());
            preencherTabela(cDao.consultarTodos());
        } catch (DaoException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ExcluirBtnActionPerformed

    private void VoltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarBtnActionPerformed
        setVisible(false);
    }//GEN-LAST:event_VoltarBtnActionPerformed

    private void RelatorioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RelatorioBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlterarBtn;
    private javax.swing.JPanel BotoesPnl;
    private javax.swing.JButton ExcluirBtn;
    private javax.swing.JButton FiltrarBtn;
    private javax.swing.JPanel FiltroPnl;
    private javax.swing.JTextField FiltroTf;
    private javax.swing.JComboBox<String> FiltrosCBB;
    private javax.swing.JButton NovoBtn;
    private javax.swing.JButton RelatorioBtn;
    private javax.swing.JButton VoltarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela(List<br.cefet.renatathiago.trabalhoBim2.Entidade.Cliente> lista) {
        if (lista != null){
            String[] vetor = new String[6];
            vetor [0]= "Cod";
            vetor [1]= "Nome";
            vetor [2]= "Telefone";
            vetor [3] = "Endereço";
            vetor [4] = "Tipo";
            vetor [5] = "Documento";
            String [][] matriz = new String[lista.size()][6];
            
            for (int i = 0; i<lista.size(); i++){
                  matriz [i][0]=lista.get(i).getCod()+"";
                  matriz [i][1]=lista.get(i).getNome();
                  matriz [i][2]=lista.get(i).getTelefone();
                  matriz [i][3]=lista.get(i).getEndereco();
                  matriz [i][4]=lista.get(i).getTipoCliente();
                  matriz [i][5]=lista.get(i).getDocumento();
            }
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
         matriz, vetor));
        }
    }

    private Cliente getItemSelecionado() throws DaoException {
        int l = jTable1.getSelectedRow();
        int num = Integer.parseInt((String) jTable1.getValueAt(l, 0));
        return cDao.consultarPorCod(num);
    }
}
