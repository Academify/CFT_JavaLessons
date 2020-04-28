/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Raissa_Tassis.TrabalhoBim1.Ui.Controller;

import br.com.Raissa_Tassis.TrabalhoBim1.Controle.ControleException;
import br.com.Raissa_Tassis.TrabalhoBim1.Controle.ControleLogin;
import br.com.Raissa_Tassis.TrabalhoBim1.Controle.UsuarioControle;
import br.com.Raissa_Tassis.TrabalhoBim1.Dao.DaoException;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Usuario;
import br.com.Raissa_Tassis.TrabalhoBim1.Ui.Telas.UsuarioCadastroJDialog;
import br.com.Raissa_Tassis.TrabalhoBim1.Ui.UiPrincipal;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author aluno
 */
public class LoginFXMLController implements Initializable {

    ControleLogin coLogin = new ControleLogin();
    UiPrincipal uiPrin = new UiPrincipal();

    @FXML
    private BorderPane borderPane = new BorderPane();

    @FXML
    private GridPane gridPane = new GridPane();

    @FXML
    private ImageView imgLogo = new ImageView();

    @FXML
    private Label lblLogin = new Label();

    @FXML
    private JFXTextField tfEmail = new JFXTextField();

    @FXML
    private JFXPasswordField tfSenha = new JFXPasswordField();

    @FXML
    private JFXButton btEntrar = new JFXButton();

    @FXML
    private ImageView imgEmail = new ImageView();

    @FXML
    private ImageView imgSenha = new ImageView();

    @FXML
    private JFXButton btCadastrar = new JFXButton();

    @FXML
    private Label lblCadastrar = new Label();

    Alert alert = new Alert(Alert.AlertType.ERROR);

    @FXML
    private void handleButtonAction(ActionEvent event) {
        UsuarioControle uControle = UsuarioControle.getInstance();
        Usuario uLogado;
        System.out.println("Logado com Sucesso!");
        String email = tfEmail.getText();
        String senha = tfSenha.getText();
        if (email.length() != 0 && senha.length() != 0) {
            try {
                if (coLogin.fazerLogin(email, senha)) {
                    Alert alertCerto = new Alert(Alert.AlertType.INFORMATION);
                    alertCerto.setTitle("Login");
                    alertCerto.setHeaderText("Usuario autenticado com sucesso");
                    alertCerto.setContentText("Bem-vindo ao sistema!");
                    alertCerto.showAndWait();  
                    uLogado = uControle.consultaPorEmail(email);
                    uiPrin.fecharStage();
                    uiPrin.iniciar(uLogado);
                } else {
                    alert.setTitle("Erro no login");
                    alert.setHeaderText("Erro no login");
                    alert.setContentText("Dados invalidos");
                    alert.showAndWait();                 
                }
            } catch (DaoException ex) {
                alert.setTitle("Erro no login");
                alert.setHeaderText("Erro no login");
                alert.setContentText("Dados invalidos");
                alert.showAndWait();
            }
        } else {
            alert.setTitle("Erro no login");
            alert.setHeaderText("Erro no login");
            alert.setContentText("Dados invalidos");
            alert.showAndWait();
        }
    }

    @FXML
    private void cadastrarButton(ActionEvent event) {
//        try {
            UsuarioCadastroJDialog uTela = new UsuarioCadastroJDialog(null, true);
            uTela.setVisible(true);
//            alert.setAlertType(Alert.AlertType.CONFIRMATION);
//            alert.setHeaderText("Sucesso");
//            alert.setContentText("Usuario cadastrado com sucesso!");
//            alert.showAndWait();
//        } catch (DaoException ex) {
//            alert.setTitle("Erro no cadastro");
//            alert.setHeaderText("Falha no cadastro do usuario");
//            alert.setContentText("Erro no BD: " + ex.getCause());
//            alert.showAndWait();
//        } catch (ControleException ex) {
//            alert.setTitle("Erro no cadastro");
//            alert.setHeaderText("Falha no cadastro do usuario");
//            alert.setContentText("Dados invalidos: " + ex.getCause());
//            alert.showAndWait();
//        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        btEntrar.setDefaultButton(true);

//        File file = new File("..\\Imagens\\logoTransparente.png");
        Image image = new Image(getClass().getResource("..\\Imagens\\logoTransparente.png").toExternalForm());
        imgLogo.setImage(image);

//        file = new File("..\\Imagens\\user.png");
        image = new Image(getClass().getResource("..\\Imagens\\user.png").toExternalForm());
        imgEmail.setImage(image);

//        file = new File("..\\Imagens\\password.png");
        image = new Image(getClass().getResource("..\\Imagens\\password.png").toExternalForm());
        imgSenha.setImage(image);

    }

}
