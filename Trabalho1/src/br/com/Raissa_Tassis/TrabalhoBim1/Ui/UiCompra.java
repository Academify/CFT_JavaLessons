//package br.com.Raissa_Tassis.TrabalhoBim1.Ui;
//
//import br.com.Raissa_Tassis.TrabalhoBim1.Controle.CompraControle;
//import br.com.Raissa_Tassis.TrabalhoBim1.Controle.HqControle;
//import br.com.Raissa_Tassis.TrabalhoBim1.Controle.UsuarioControle;
//import br.com.Raissa_Tassis.TrabalhoBim1.Dao.DaoException;
//import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Compra;
//import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Hq;
//import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Usuario;
//import br.com.Raissa_Tassis.TrabalhoBim1.Utils.Util;
//import br.com.Raissa_Tassis.TrabalhoBim1.Utils.DateParse;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JOptionPane;
//
//public class UiCompra {
//
//	private static UiCompra instance;
//	private CompraControle coControle;
//	private UsuarioControle uControle;
//	private HqControle hqControle;
//	private UiHq uiHq;
//	private UiUsuario uiUsuario;
//
//	public static UiCompra getInstance() {
//		if (instance == null) {
//			instance = new UiCompra();
//		}
//		return instance;
//	}
//
//	int opcao = -1;
//	Scanner scn = new Scanner(System.in);
//	Scanner scs = new Scanner(System.in);
//	Scanner sci = new Scanner(System.in);
//
//	public void iniciar() {
//		opcao = -1;
//		while (opcao != 0) {
//			// System.out.println("----- Menu Compras -----");
//			// System.out.println("0 - Sair");
//			// System.out.println("1 - Realizar compra");
//			// System.out.println("2 - Consultar compras");
//			// System.out.println("3 - Consultar por código");
//			// System.out.println("------------------------");
//			//
//			// opcao = sci.nextInt();
//
//			try {
//				opcao = Integer.parseInt(JOptionPane.showInputDialog(null, " Menu Compras \n" + "0 - Sair\n"
//						+ "1 - Realizar Compra\n" + "2 - Consultar Compras\n" + "3 - Consultar por código"));
//
//			} catch (NumberFormatException e) {
//				JOptionPane.showMessageDialog(null, "Tipos incompat�veis");
//				opcao = 9;
//			}
//
//			switch (opcao) {
//			case 0:
//				JOptionPane.showMessageDialog(null, "Aperte OK para retornar ao menu principal");
//				break;
//
//			case 1:
//				Util.limpaTela();
//				try {
//
//					realizarCompra();
//				} catch (DaoException ex) {
//					JOptionPane.showMessageDialog(null, ex.getMessage());
//				}
//				break;
//
//			case 2:
//				Util.limpaTela();
//				System.out.println("------ Todas as compras ------");
//				coControle = CompraControle.getInstance();
//
//				try {
//					List<Compra> cs = coControle.consultaTudo();
//					listarCompras(cs);
//				} catch (DaoException ex) {
//					JOptionPane.showMessageDialog(null, ex.getMessage());
//					JOptionPane.showMessageDialog(null, ex.getCause());
//				}
//				break;
//
//			case 3:
//				Util.limpaTela();
//				// System.out.println("------ Consultar por cd ------");
//				// System.out.println("Informe o código da compra: ");
//				// cd = sci.nextInt();
//				coControle = CompraControle.getInstance();
//
//				Compra c;
//				try {
//					int cd = Integer.parseInt(
//							JOptionPane.showInputDialog("   Consultar por cd     \n" + "Informe o código da compra: "));
//					c = coControle.consultaPorCd(cd);
//					ListarCompra(c);
//				} catch (DaoException ex) {
//					JOptionPane.showMessageDialog(null, ex.getMessage());
//					JOptionPane.showMessageDialog(null, ex.getCause());
//					// System.out.println(ex.getMessage());
//					// System.out.println(ex.getCause());
//				} catch (NumberFormatException ex) {
//					JOptionPane.showMessageDialog(null, "código inválido");
//				}
//				break;
//
//			default:
//				JOptionPane.showMessageDialog(null, "Valor inválido");
//				break;
//			}
//		}
//	}
//
//	public void ListarCompra(Compra c) {
//		uiHq = UiHq.getInstance();
//		if (c == null) {
//			// System.out.println("Nenhuma compra encontrada");
//			JOptionPane.showMessageDialog(null, "Nenhuma compra encontrada");
//		} else {
//			System.out.println("Num - Data - Valor --  Vendedor -- Comprador");
//			String data = DateParse.dateToString(c.getDtCompra());
//			System.out.println(c.getCdCompra() + " - " + data + " - " + c.getValorCompra() + " -- "
//					+ c.getVendedor().getNmUsuario() + " -- " + c.getComprador().getNmUsuario());
//			System.out.println("HQs compradas: ");
//			uiHq.listar(c.getHqsCompra());
//
//		}
//	}
//
//	public void listarCompras(List<Compra> cs) {
//		uiHq = UiHq.getInstance();
//		if (cs.isEmpty()) {
//			JOptionPane.showMessageDialog(null, "Nenhuma compra encontrada");
//		} else {
//			System.out.println("Num - Data - Valor --  Vendedor -- Comprador");
//			for (int i = 0; i < cs.size(); i++) {
//				System.out.println("\n\n");
//				System.out.println("Compra");
//				String data = DateParse.dateToString(cs.get(i).getDtCompra());
//				System.out.println(cs.get(i).getCdCompra() + " - " + data + " - " + cs.get(i).getValorCompra() + " -- "
//						+ cs.get(i).getVendedor().getNmUsuario() + " -- " + cs.get(i).getComprador().getNmUsuario());
//				System.out.println("HQs compradas: ");
//				uiHq.listar(cs.get(i).getHqsCompra());
//			}
//		}
//
//	}
//
//	public void realizarCompra() throws DaoException {
//		boolean statusHq;
//		uControle = UsuarioControle.getInstance();
//		coControle = CompraControle.getInstance();
//		uiHq = UiHq.getInstance();
//		hqControle = HqControle.getInstance();
//		uiUsuario = UiUsuario.getInstance();
//
//		List<Hq> hqsCompra;
//		hqsCompra = new ArrayList<Hq>();
//		int hqescolha;
//		Hq hq;
//		Double valor = 0.0;
//		Compra c = new Compra();
//		Usuario vendedor;
//		Usuario comprador;
//
//		List<Usuario> usuarios = uControle.consultaTudo();
//		try {
//
//			if (usuarios.isEmpty()) {
//				JOptionPane.showMessageDialog(null, "     Realizar Compra  \n" + "Nenhum Usuário encontrado");
//			} else {
//				uiUsuario.listar(usuarios);
//				int cdComprador = Integer.parseInt(JOptionPane.showInputDialog(null,
//						"     Realizar Compra  \n" + "Qual Usuário ir� realizar a compra?"));
//
//				comprador = uiUsuario.localizaPorId(cdComprador, usuarios);
//				if (comprador != null) {
//					usuarios = uControle.consultaTudoExceto(comprador.getCdUsuario());
//					int sair = -1;
//					int userEscolha;
//					if (usuarios.isEmpty()) {
//						JOptionPane.showMessageDialog(null, "     Impossivel realizar compra ");
//					} else {
//
//						uiUsuario.listarVendaHqsUsuarios(comprador);
//						userEscolha = Integer.parseInt(JOptionPane.showInputDialog(null,
//								"     Realizar Compra  \n" + "Escolha de qual Usuário deseja comprar uma HQ?"));
//
//						// System.out.println("Escolha de qual Usuário
//						// deseja comprar uma HQ:");
//						// userEscolha = sci.nextInt();
//						vendedor = uiUsuario.localizaPorId(userEscolha, usuarios);
//						while (sair != 0) {
//							if (vendedor != null) {
//								vendedor.setHqs(hqControle.consultaVendaUsuario(vendedor));
//								
//								if (vendedor.getHqs().isEmpty()) {
//									JOptionPane.showMessageDialog(null, "Nenhuma HQ nesse Usuário ");
//									// System.out.println("Nenhuma HQ nesse
//									// Usuário");
//									// System.out.println("-------------------------------");
//									sair = 0;
//								} else {
//									uiUsuario.listarUsuarioHqs(vendedor);
//									hqescolha = Integer
//											.parseInt(JOptionPane.showInputDialog(null, "Qual HQ deseja comprar?"));
//									// System.out.println("Qual HQ deseja
//									// comprar?");
//									// hqescolha = sci.nextInt();
//									hq = uiHq.localizaHqPorIdUsuario(vendedor, hqescolha);
//
//									if (hq != null) {
//										statusHq = localidaHqCompra(hq, c);
//										if (statusHq) {
//											hqsCompra.add(hq);
//											c.setHqsCompra(hqsCompra);
//											c.setDtCompra(new Date());
//											c.setVendedor(vendedor);
//											c.setComprador(comprador);
//											valor += hq.getPreco();
//											c.setValorCompra(valor);
//											
//											
//
//											sair = Integer.parseInt(JOptionPane.showInputDialog(null,
//													"Deseja comprar outra HQ? \n" + "0- não \n" + "1- Sim"));
//										} else {
//											JOptionPane.showMessageDialog(null, " HQ inválida ");
//											// System.out.println("HQ
//											// inválida");
//											sair = 0;
//										}
//									} else {
//										JOptionPane.showMessageDialog(null, " HQ inválida ");
//										// System.out.println("HQ inválida");
//										sair = 0;
//									}
//								}
//
//							} else {
//								JOptionPane.showMessageDialog(null, " Usuario inválido ");
//								// System.out.println("Usuario invalido");
//								sair = 0;
//							}
//
//						}
//						int retorno = -1;
//						if (c.getHqsCompra() != null) {
//							retorno = coControle.inserir(c);
//						}
//						if (retorno != -1) {
//							JOptionPane.showMessageDialog(null,
//									" Compra realizada com sucesso! \n" + "Valor total: " + c.getValorCompra());
//						} else {
//							JOptionPane.showMessageDialog(null, "Erro ao efetivar compra");
//							// System.out.println(" Erro ao efetivar compra ");
//							// System.out.println("-------------------------------");
//						}
//					}
//				} else {
//					JOptionPane.showMessageDialog(null, "Usuário não encontrado");
//					// System.out.println(" Usuário não encontrado ");
//					// System.out.println("-------------------------------");
//				}
//			}
//		} catch (NumberFormatException ex) {
//			JOptionPane.showMessageDialog(null, "código inválido");
//		}
//	}
//
//	private boolean localidaHqCompra(Hq hq, Compra c) {
//
//		if (c.getHqsCompra() != null) {
//			if (c.getHqsCompra().isEmpty()) {
//				return true;
//			} else {
//				for (int i = 0; i < c.getHqsCompra().size(); i++) {
//					if (c.getHqsCompra().get(i).getCdHq() == hq.getCdHq()) {
//						return false;
//					}
//				}
//			}
//		} else {
//			return true;
//		}
//		return true;
//	}
//
//	public static void main(String[] args) {
//		UiCompra ui = UiCompra.getInstance();
//		ui.iniciar();
//		// Date d = new Date();
//		// System.out.println(d);
//	}
//
//}
