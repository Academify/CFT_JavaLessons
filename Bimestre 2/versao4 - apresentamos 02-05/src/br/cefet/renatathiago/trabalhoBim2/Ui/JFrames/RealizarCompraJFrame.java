package br.cefet.renatathiago.trabalhoBim2.Ui.JFrames;

import br.cefet.renatathiago.trabalhoBim2.Controle.CompraControle;
import br.cefet.renatathiago.trabalhoBim2.Controle.FornecedorControle;
import br.cefet.renatathiago.trabalhoBim2.Dao.ProdutoDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Fornecedor;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Produto;
import br.cefet.renatathiago.trabalhoBim2.Entidade.ProdutoCV;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import br.cefet.renatathiago.trabalhoBim2.Utilidades.CellRenderer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RealizarCompraJFrame extends javax.swing.JFrame {

    FornecedorControle fControle = new FornecedorControle();
    ProdutoDao pDao = new ProdutoDao();
    CompraControle cControle = new CompraControle();
    FornecedorJFrame fornecedorJFrame = new FornecedorJFrame();
    ProdutoJFrame produtoJFrame = new ProdutoJFrame();
    List<Fornecedor> listaFornecedor = new ArrayList();
    List<Produto> listaProduto = new ArrayList();
    List<ProdutoCV> listaProdutoCompra = new ArrayList();
    DefaultTableModel modeloTabelaFornecedor;
    DefaultTableModel modeloTabelaProduto;
    DefaultTableModel modeloTabelaProdutoCompra;
    Compra c = new Compra();

    
    
    public RealizarCompraJFrame() {
        initComponents();
        CodCompraJTF.setEnabled(false);
        CodFornecedorJTF.setEnabled(false);
        NomeFornecedorJTF.setEnabled(false);
        FormaPgDinheiroRB.setSelected(true);
        ValorTotalCompraJFTF.setText("0");
        ValorTotalCompraJFTF.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CodCompraLabel = new javax.swing.JLabel();
        CodCompraJTF = new javax.swing.JTextField();
        DataCompraLabel = new javax.swing.JLabel();
        CodFornecedorLabel = new javax.swing.JLabel();
        DataCompraJFTF = new javax.swing.JFormattedTextField();
        BotaoSelecionarFornecedor = new javax.swing.JButton();
        PadraoFiltroFornecedorLabel = new javax.swing.JLabel();
        FornecedorScrollPanel = new javax.swing.JScrollPane();
        TabelaFornecedor = new javax.swing.JTable();
        PadraoFiltroFornecedorJTF = new javax.swing.JTextField();
        BotaoFiltrarFornecedor = new javax.swing.JButton();
        FiltroFornecedorLabel = new javax.swing.JLabel();
        FiltroFornecedorCBox = new javax.swing.JComboBox<>();
        BotaoSelecionarProduto = new javax.swing.JButton();
        CodFornecedorJTF = new javax.swing.JTextField();
        NomeFornecedorLabel = new javax.swing.JLabel();
        NomeFornecedorJTF = new javax.swing.JTextField();
        ValorTotalCompraJFTF = new javax.swing.JFormattedTextField();
        ValorTotalCompraLabel = new javax.swing.JLabel();
        BotaoCadastrarFornecedor = new javax.swing.JButton();
        BotaoCadastrarProduto = new javax.swing.JButton();
        ProdutoScrollPanel = new javax.swing.JScrollPane();
        TabelaProduto = new javax.swing.JTable();
        PadraoFiltroProdutoJTF = new javax.swing.JTextField();
        FiltroProdutoCBox = new javax.swing.JComboBox<>();
        BotaoFiltrarProduto = new javax.swing.JButton();
        FiltroProdutoLabel = new javax.swing.JLabel();
        PadraoFiltroProdutoLabel = new javax.swing.JLabel();
        BotaoConfirmarCompra = new javax.swing.JButton();
        BotaoCancelarCompra = new javax.swing.JButton();
        FormaPgLabel = new javax.swing.JLabel();
        FormaPgDinheiroRB = new javax.swing.JRadioButton();
        FormaPgCartaoRB = new javax.swing.JRadioButton();
        ProdutoCompraScrollPane = new javax.swing.JScrollPane();
        TabelaProdutoCompra = new javax.swing.JTable();
        BotaoVoltarMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CodCompraLabel.setText("Código");

        DataCompraLabel.setText("Data da Compra");

        CodFornecedorLabel.setText("Cod. Fornecedor");

        DataCompraJFTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        DataCompraJFTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataCompraJFTFActionPerformed(evt);
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
        TabelaFornecedor.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

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

        FiltroFornecedorCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Nome", "Código" }));
        FiltroFornecedorCBox.setToolTipText("");
        FiltroFornecedorCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltroFornecedorCBoxActionPerformed(evt);
            }
        });

        BotaoSelecionarProduto.setText("Selecionar");
        BotaoSelecionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSelecionarProdutoActionPerformed(evt);
            }
        });

        CodFornecedorJTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodFornecedorJTFActionPerformed(evt);
            }
        });

        NomeFornecedorLabel.setText("Nome do Fornecedor");

        ValorTotalCompraJFTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        ValorTotalCompraJFTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorTotalCompraJFTFActionPerformed(evt);
            }
        });

        ValorTotalCompraLabel.setText("Valor Total");

        BotaoCadastrarFornecedor.setText("Novo Fornecedor");
        BotaoCadastrarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastrarFornecedorActionPerformed(evt);
            }
        });

        BotaoCadastrarProduto.setText("Novo Produto");
        BotaoCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastrarProdutoActionPerformed(evt);
            }
        });

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
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Marca", "Qtd Estoque", "Preço Compra"
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

        PadraoFiltroProdutoJTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PadraoFiltroProdutoJTFActionPerformed(evt);
            }
        });

        FiltroProdutoCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Código", "Nome", "Marca" }));
        FiltroProdutoCBox.setToolTipText("");
        FiltroProdutoCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltroProdutoCBoxActionPerformed(evt);
            }
        });

        BotaoFiltrarProduto.setText("Filtrar");
        BotaoFiltrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoFiltrarProdutoActionPerformed(evt);
            }
        });

        FiltroProdutoLabel.setText("Filtrar por:");

        PadraoFiltroProdutoLabel.setText("Igual a:");

        BotaoConfirmarCompra.setText("Confirmar");
        BotaoConfirmarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoConfirmarCompraActionPerformed(evt);
            }
        });

        BotaoCancelarCompra.setText("Cancelar");
        BotaoCancelarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCancelarCompraActionPerformed(evt);
            }
        });

        FormaPgLabel.setText("Forma de Pagamento");

        FormaPgDinheiroRB.setText("Dinheiro");
        FormaPgDinheiroRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FormaPgDinheiroRBActionPerformed(evt);
            }
        });

        FormaPgCartaoRB.setText("Cartão de Débito");
        FormaPgCartaoRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FormaPgCartaoRBActionPerformed(evt);
            }
        });

        TabelaProdutoCompra.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Marca", "Preço", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaProdutoCompra.setColumnSelectionAllowed(true);
        TabelaProdutoCompra.getTableHeader().setReorderingAllowed(false);
        TabelaProdutoCompra.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                TabelaProdutoCompraInputMethodTextChanged(evt);
            }
        });
        ProdutoCompraScrollPane.setViewportView(TabelaProdutoCompra);
        TabelaProdutoCompra.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (TabelaProdutoCompra.getColumnModel().getColumnCount() > 0) {
            TabelaProdutoCompra.getColumnModel().getColumn(0).setResizable(false);
            TabelaProdutoCompra.getColumnModel().getColumn(1).setResizable(false);
            TabelaProdutoCompra.getColumnModel().getColumn(2).setResizable(false);
            TabelaProdutoCompra.getColumnModel().getColumn(3).setResizable(false);
        }

        BotaoVoltarMenu.setText("Voltar");
        BotaoVoltarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoVoltarMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(FormaPgDinheiroRB, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FormaPgCartaoRB, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(FormaPgLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ValorTotalCompraLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(ValorTotalCompraJFTF)))
                    .addComponent(ProdutoCompraScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CodFornecedorJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CodCompraJTF)
                            .addComponent(CodCompraLabel)
                            .addComponent(CodFornecedorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NomeFornecedorLabel)
                            .addComponent(DataCompraLabel)
                            .addComponent(NomeFornecedorJTF)
                            .addComponent(DataCompraJFTF, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BotaoVoltarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotaoCancelarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoConfirmarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BotaoCadastrarFornecedor)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoSelecionarFornecedor))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(FiltroFornecedorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FiltroFornecedorCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PadraoFiltroFornecedorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PadraoFiltroFornecedorJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoFiltrarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(FiltroProdutoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FiltroProdutoCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PadraoFiltroProdutoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PadraoFiltroProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoFiltrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BotaoCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoSelecionarProduto))
                    .addComponent(ProdutoScrollPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FornecedorScrollPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DataCompraLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CodCompraLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CodCompraJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DataCompraJFTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CodFornecedorLabel)
                            .addComponent(NomeFornecedorLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CodFornecedorJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NomeFornecedorJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ProdutoCompraScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(FormaPgLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(FormaPgDinheiroRB)
                                    .addComponent(FormaPgCartaoRB)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ValorTotalCompraLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ValorTotalCompraJFTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotaoConfirmarCompra)
                            .addComponent(BotaoCancelarCompra)
                            .addComponent(BotaoVoltarMenu))
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FiltroFornecedorCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FiltroFornecedorLabel)
                            .addComponent(PadraoFiltroFornecedorLabel)
                            .addComponent(PadraoFiltroFornecedorJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoFiltrarFornecedor))
                        .addGap(18, 34, Short.MAX_VALUE)
                        .addComponent(FornecedorScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotaoSelecionarFornecedor)
                            .addComponent(BotaoCadastrarFornecedor))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FiltroProdutoCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FiltroProdutoLabel)
                            .addComponent(PadraoFiltroProdutoLabel)
                            .addComponent(PadraoFiltroProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoFiltrarProduto))
                        .addGap(18, 18, 18)
                        .addComponent(ProdutoScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotaoCadastrarProduto)
                            .addComponent(BotaoSelecionarProduto))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DataCompraJFTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataCompraJFTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DataCompraJFTFActionPerformed

    private void BotaoSelecionarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSelecionarFornecedorActionPerformed
        
        try {
            exibirDadosFornecedor(fControle.consultarPorCod((int) TabelaFornecedor.getValueAt(TabelaFornecedor.getSelectedRow(), 0)));
            
        } catch (DaoException ex) {
            Logger.getLogger(FornecedorJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoSelecionarFornecedorActionPerformed

    private void PadraoFiltroFornecedorJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PadraoFiltroFornecedorJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PadraoFiltroFornecedorJTFActionPerformed

    private void BotaoFiltrarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoFiltrarFornecedorActionPerformed

        try {
            switch(FiltroFornecedorCBox.getSelectedIndex()){
                case 0:
                preencherTabelaFornecedor(fControle.consultarTodos());
                break;
                case 1:
                preencherTabelaFornecedor(fControle.consultarPorNome(PadraoFiltroFornecedorJTF.getText()));
                break;
                case 2:
                listaFornecedor.add(fControle.consultarPorCod(Integer.parseInt(PadraoFiltroFornecedorJTF.getText())));
                preencherTabelaFornecedor(listaFornecedor);
                listaFornecedor.clear();
                break;
            }
        } catch (DaoException ex) {
            Logger.getLogger(FornecedorJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoFiltrarFornecedorActionPerformed

    private void FiltroFornecedorCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroFornecedorCBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltroFornecedorCBoxActionPerformed

    private void CodFornecedorJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodFornecedorJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodFornecedorJTFActionPerformed

    private void ValorTotalCompraJFTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorTotalCompraJFTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorTotalCompraJFTFActionPerformed

    private void PadraoFiltroProdutoJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PadraoFiltroProdutoJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PadraoFiltroProdutoJTFActionPerformed

    private void FiltroProdutoCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroProdutoCBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltroProdutoCBoxActionPerformed

    private void BotaoFiltrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoFiltrarProdutoActionPerformed

        try {
            switch(FiltroProdutoCBox.getSelectedIndex()){
                case 0:
                preencherTabelaProduto(pDao.consultarTodos());
                break;
                case 1:
                listaProduto.add(pDao.consultarPorCod(Integer.parseInt(PadraoFiltroProdutoJTF.getText())));
                preencherTabelaProduto(listaProduto);
                listaProduto.clear();
                break;
                case 2:
                preencherTabelaProduto(pDao.consultarPorNome(PadraoFiltroProdutoJTF.getText()));
                break;
                case 3:
                preencherTabelaProduto(pDao.consultarPorMarca(PadraoFiltroProdutoJTF.getText()));
            }
        } catch (DaoException ex) {
            Logger.getLogger(ProdutoJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoFiltrarProdutoActionPerformed

    private void BotaoConfirmarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoConfirmarCompraActionPerformed
        c.setData(DataCompraJFTF.getText());
        c.setCodFornecedor(Integer.parseInt(CodFornecedorJTF.getText()));
        c.setFormaPg(verificarFormaPg());
        c.setValorTotal(Double.parseDouble(ValorTotalCompraJFTF.getText()));
        listaProdutoCompra.clear();
        listaProdutoCompra = preencherListProdutoCV();
        if (validarCompra(c)){
            try {
                cControle.inserirCompra(c, listaProdutoCompra);
            } catch (DaoException ex) {
                Logger.getLogger(RealizarCompraJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_BotaoConfirmarCompraActionPerformed

    private void BotaoCadastrarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastrarFornecedorActionPerformed
        fornecedorJFrame.setVisible(true);
        fornecedorJFrame.habilitarBotaoCadastrar();
        fornecedorJFrame.desabilitarBotaoExcluir();
        fornecedorJFrame.desabilitarBotaoEditar();
        fornecedorJFrame.habilitarBotaoSelecionar();
        try {
            fornecedorJFrame.definirCod();
        } catch (DaoException ex) {
            Logger.getLogger(TelaCadastroJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fornecedorJFrame.consultarTodos();
        } catch (DaoException ex) {
            Logger.getLogger(TelaCadastroJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoCadastrarFornecedorActionPerformed

    private void BotaoCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastrarProdutoActionPerformed
        produtoJFrame.setVisible(true);
        produtoJFrame.habilitarBotaoCadastrar();
        produtoJFrame.desabilitarBotaoExcluir();
        produtoJFrame.desabilitarBotaoEditar();
        produtoJFrame.habilitarBotaoSelecionar();
        try {
            produtoJFrame.definirCod();
        } catch (DaoException ex) {
            Logger.getLogger(TelaCadastroJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            produtoJFrame.consultarTodos();
        } catch (DaoException ex) {
            Logger.getLogger(TelaCadastroJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoCadastrarProdutoActionPerformed

    private void FormaPgDinheiroRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormaPgDinheiroRBActionPerformed
       if (FormaPgDinheiroRB.isSelected()){
           FormaPgCartaoRB.setSelected(false);
       }
    }//GEN-LAST:event_FormaPgDinheiroRBActionPerformed

    private void FormaPgCartaoRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormaPgCartaoRBActionPerformed
       if (FormaPgCartaoRB.isSelected()){
           FormaPgDinheiroRB.setSelected(false);
       }
    }//GEN-LAST:event_FormaPgCartaoRBActionPerformed

    private void BotaoSelecionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSelecionarProdutoActionPerformed
        try {
            adicionarProduto(pDao.consultarPorCod((int) TabelaProduto.getValueAt(TabelaProduto.getSelectedRow(), 0)));
            
        } catch (DaoException ex) {
            Logger.getLogger(FornecedorJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            acrescerValorTotal((pDao.consultarPorCod((int) TabelaProduto.getValueAt(TabelaProduto.getSelectedRow(), 0))).getPrecoCompra(), 1);
        } catch (DaoException ex) {
            Logger.getLogger(RealizarCompraJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoSelecionarProdutoActionPerformed

    private void TabelaProdutoCompraInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_TabelaProdutoCompraInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_TabelaProdutoCompraInputMethodTextChanged

    private void BotaoCancelarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelarCompraActionPerformed
        limparDados();
    }//GEN-LAST:event_BotaoCancelarCompraActionPerformed

    private void BotaoVoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoVoltarMenuActionPerformed
       dispose();
    }//GEN-LAST:event_BotaoVoltarMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCadastrarFornecedor;
    private javax.swing.JButton BotaoCadastrarProduto;
    private javax.swing.JButton BotaoCancelarCompra;
    private javax.swing.JButton BotaoConfirmarCompra;
    private javax.swing.JButton BotaoFiltrarFornecedor;
    private javax.swing.JButton BotaoFiltrarProduto;
    private javax.swing.JButton BotaoSelecionarFornecedor;
    private javax.swing.JButton BotaoSelecionarProduto;
    private javax.swing.JButton BotaoVoltarMenu;
    private javax.swing.JTextField CodCompraJTF;
    private javax.swing.JLabel CodCompraLabel;
    private javax.swing.JTextField CodFornecedorJTF;
    private javax.swing.JLabel CodFornecedorLabel;
    private javax.swing.JFormattedTextField DataCompraJFTF;
    private javax.swing.JLabel DataCompraLabel;
    private javax.swing.JComboBox<String> FiltroFornecedorCBox;
    private javax.swing.JLabel FiltroFornecedorLabel;
    private javax.swing.JComboBox<String> FiltroProdutoCBox;
    private javax.swing.JLabel FiltroProdutoLabel;
    private javax.swing.JRadioButton FormaPgCartaoRB;
    private javax.swing.JRadioButton FormaPgDinheiroRB;
    private javax.swing.JLabel FormaPgLabel;
    private javax.swing.JScrollPane FornecedorScrollPanel;
    private javax.swing.JTextField NomeFornecedorJTF;
    private javax.swing.JLabel NomeFornecedorLabel;
    private javax.swing.JTextField PadraoFiltroFornecedorJTF;
    private javax.swing.JLabel PadraoFiltroFornecedorLabel;
    private javax.swing.JTextField PadraoFiltroProdutoJTF;
    private javax.swing.JLabel PadraoFiltroProdutoLabel;
    private javax.swing.JScrollPane ProdutoCompraScrollPane;
    private javax.swing.JScrollPane ProdutoScrollPanel;
    private javax.swing.JTable TabelaFornecedor;
    private javax.swing.JTable TabelaProduto;
    private javax.swing.JTable TabelaProdutoCompra;
    private javax.swing.JFormattedTextField ValorTotalCompraJFTF;
    private javax.swing.JLabel ValorTotalCompraLabel;
    // End of variables declaration//GEN-END:variables

    void preencherTabelaFornecedor (List<Fornecedor> listaFornecedor) throws DaoException {
        
        TabelaFornecedor.setDefaultRenderer(Object.class, new CellRenderer());        
        modeloTabelaFornecedor = (DefaultTableModel) TabelaFornecedor.getModel();   
        while (modeloTabelaFornecedor.getRowCount() > 0) {
            modeloTabelaFornecedor.removeRow(0);
        }
        for (int i = 0; i<listaFornecedor.size(); i++) {
            modeloTabelaFornecedor.addRow(new Object[] { 
              listaFornecedor.get(i).getCod(),
              listaFornecedor.get(i).getNome(), 
              listaFornecedor.get(i).getTelefone(), 
              listaFornecedor.get(i).getCnpj()
            });
        }
    }
    
    void preencherTabelaProduto (List<Produto> listaProduto) throws DaoException {
        
        TabelaProduto.setDefaultRenderer(Object.class, new CellRenderer());        
        modeloTabelaProduto = (DefaultTableModel) TabelaProduto.getModel();   
        while (modeloTabelaProduto.getRowCount() > 0) {
            modeloTabelaProduto.removeRow(0);
        }
        for (int i = 0; i<listaProduto.size(); i++) {
            modeloTabelaProduto.addRow(new Object[] { 
              listaProduto.get(i).getCod(),
              listaProduto.get(i).getNome(), 
              listaProduto.get(i).getMarca(), 
              listaProduto.get(i).getQtdEstoque(), 
              listaProduto.get(i).getPrecoCompra()
            });
        }
    }
    
    private void preencherTabelaProdutoCompra(List<ProdutoCV> listaProdutoCompra){
        
        TabelaProdutoCompra.setDefaultRenderer(Object.class, new CellRenderer());        
        modeloTabelaProdutoCompra = (DefaultTableModel) TabelaProdutoCompra.getModel();   
        while (modeloTabelaProdutoCompra.getRowCount() > 0) {
            modeloTabelaProdutoCompra.removeRow(0);
        }
        for (int i = 0; i<listaProdutoCompra.size(); i++) {
            modeloTabelaProdutoCompra.addRow(new Object[] { 
              listaProdutoCompra.get(i).getCod(),
              listaProdutoCompra.get(i).getNome(), 
              listaProdutoCompra.get(i).getMarca(), 
              listaProdutoCompra.get(i).getPrecoCompra(), 
              listaProdutoCompra.get(i).getQtd()
            });
        }
    }
    
    void definirCod(){
        try {
            CodCompraJTF.setText(Integer.toString(cControle.proximoCod()));
        } catch (DaoException ex) {
            Logger.getLogger(FornecedorJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean validarCompra(Compra c) {
        if (c.getValorTotal()>0 && 
        (c.getFormaPg().equals("D") || c.getFormaPg().equals("C"))){
            return true;
        } else {
            return false;
        }
    }

    void preencherTabelaProdutoFornecedor() throws DaoException {
        try {
            preencherTabelaFornecedor(fControle.consultarTodos());
            preencherTabelaProduto(pDao.consultarTodos());
        } catch (DaoException ex) {
            Logger.getLogger(RealizarCompraJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void habilitarBotaoConfirmar() {
        BotaoConfirmarCompra.setEnabled(true);
    }

    void habilitarBotaoCancelar() {
        BotaoCancelarCompra.setEnabled(true);
    }
    
    void desabilitarBotaoConfirmar() {
        BotaoConfirmarCompra.setEnabled(false);
    }

    void desabilitarBotaoCancelar() {
        BotaoCancelarCompra.setEnabled(false);
    }

    void limparDados() {
        CodCompraJTF.setText("");
        DataCompraJFTF.setText("");
        CodFornecedorJTF.setText("");
        NomeFornecedorJTF.setText("");
        FormaPgDinheiroRB.setSelected(true);
        FormaPgCartaoRB.setSelected(false);
        listaProdutoCompra.clear();
        preencherTabelaProdutoCompra(listaProdutoCompra);
    }

    private void exibirDadosFornecedor(Fornecedor f) {
        CodFornecedorJTF.setText(Integer.toString(f.getCod()));
        NomeFornecedorJTF.setText(f.getNome());
    }

    private void adicionarProduto(Produto p) throws DaoException {
       listaProdutoCompra.add(pDao.deProdutoParaProdutoCVCompra(p, 1));
       preencherTabelaProdutoCompra(listaProdutoCompra);
       listaProdutoCompra.clear(); 
    } 

    private String verificarFormaPg() {
        if (FormaPgCartaoRB.isSelected()){
            return "C";
        } else {
            return "D";
        }
    }
    private List<ProdutoCV> preencherListProdutoCV() {
        List<ProdutoCV> lista = new ArrayList();
        for (int i = 0; i< TabelaProdutoCompra.getRowCount(); i++){
            try {
                lista.add(pDao.deProdutoParaProdutoCVCompra(pDao.consultarPorCod((int) TabelaProdutoCompra.getValueAt(i,0)), (int) TabelaProdutoCompra.getValueAt(i,4)));
            } catch (DaoException ex) {
                Logger.getLogger(RealizarCompraJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    private void acrescerValorTotal(double preco, int qtd) {
        ValorTotalCompraJFTF.setText(Double.toString(qtd*preco+Double.parseDouble(ValorTotalCompraJFTF.getText())));
    }
}
