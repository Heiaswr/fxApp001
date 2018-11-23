package be.technifutur.mobile;

import be.technifutur.mobile.util.NavigationMessenger;
import be.technifutur.mobile.util.Page;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application implements NavigationMessenger.Listener{

    private Stage primaryStage;


    @Override
    public void onNavigateTo(Page page, Object data) {

        switch (page) {
            case MAIN:
                goToFirstScene();
                break;
            case LOGIN:
                goToLoginScene();
                break;
            case REGISTER:
                goToRegisterScene();
                break;
            case LOGGEDMENU:
                goToLoggedMenuScene();
                break;
            case SOLO:
                goToSoloScene();
                break;
            default:
                System.err.println("Unknown page : " + page);
                break;
        }
    }

    private void goToLoggedMenuScene() {
        try
        {
            Parent root = FXMLLoader.load(Main.class.getResource("/views/loggedmenu.fxml"));
            primaryStage.setScene(new Scene(root, 800, 800));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void goToLoginScene() {
        try
        {
            Parent root = FXMLLoader.load(Main.class.getResource("/views/login.fxml"));
            primaryStage.setScene(new Scene(root, 800, 800));
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }


    public void goToFirstScene() {
        try
        {
            Parent root = FXMLLoader.load(Main.class.getResource("/views/main.fxml"));
            primaryStage.setScene(new Scene(root, 800, 800));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void goToRegisterScene() {
        try
        {
            Parent root = FXMLLoader.load(Main.class.getResource("/views/register.fxml"));
            primaryStage.setScene(new Scene(root, 800, 800));
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void goToSoloScene() {
        try
        {
            Parent root = FXMLLoader.load(Main.class.getResource("/views/solo.fxml"));
            primaryStage.setScene(new Scene(root, 800, 800));
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;

        primaryStage.setTitle("Belote de la mort qui tue");
        goToFirstScene();
        primaryStage.show();

        NavigationMessenger.getInstance().register(this);

    }
}
