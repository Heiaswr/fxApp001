package be.technifutur.mobile;

import be.technifutur.mobile.data.BeloteDao;
import be.technifutur.mobile.domain.Joueur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/views/main.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        Joueur joueur = new Joueur();
        Scanner sc = new Scanner(System.in);
        int choix;

        System.out.println("1. Inscription\n2.Connexion");
        choix=sc.nextInt();


        switch (choix)
        {
            case 1:
                joueur.inscription(joueur);
                BeloteDao beloteDao = new BeloteDao();
                beloteDao.insert(joueur);
                break;
            case 2:
                joueur.identification(joueur);
                break;
            default:
                break;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
