package br.com.Raissa_Tassis.TrabalhoBim1.Ui;

import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Usuario;
import br.com.Raissa_Tassis.TrabalhoBim1.Ui.Telas.MainJFrame;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UiPrincipal extends Application {

    private static Stage stage;
    private static Scene loginScene;

    public void iniciar(Usuario uLogado) {
        MainJFrame mainMenu = new MainJFrame(uLogado);
        mainMenu.setVisible(true);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        primaryStage.setTitle("Login");

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("Fxml/LoginFXML.fxml"));
        loginScene = new Scene(fxmlLogin);

        primaryStage.setScene(loginScene);
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public void fecharStage(){
        stage.close();
    }
}
