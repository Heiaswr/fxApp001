package be.technifutur.mobile.controller;

import be.technifutur.mobile.domain.Joueur;
import be.technifutur.mobile.util.NavigationMessenger;
import be.technifutur.mobile.util.Page;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class LoggedMenuController implements EventHandler<MouseEvent>, NavigationMessenger.Listener{

    @FXML
    private Label usernameLabel;

    @FXML
    private Button soloButton;
    @FXML
    private Button multiplayerButton;
    @FXML
    private Button optionsButton;
    @FXML
    private Button loggedLoggoffButton;

    private Joueur joueur;


    public void initialize() {

        System.out.println("initialize()");


//        loginButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                System.out.println("Clicked !");
//                loginButton.setText("Already clicked");
//                loginButton.setDisable(true);
//            }
//        });


        NavigationMessenger.getInstance().register(this);
        soloButton.setOnMouseClicked(this);
        multiplayerButton.setOnMouseClicked(this);
        optionsButton.setOnMouseClicked(this);
        loggedLoggoffButton.setOnMouseClicked(this);


    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        if (mouseEvent.getSource() == soloButton)
        {
            System.out.println("Solo !");
            NavigationMessenger.getInstance().navigateTo(Page.SOLO, joueur);

        }
        if (mouseEvent.getSource() == multiplayerButton)
        {
            System.out.println("Multi !");




        }
        if (mouseEvent.getSource() == optionsButton)
        {
            System.out.println("Options !");

        }
        if (mouseEvent.getSource() == loggedLoggoffButton)
        {
            System.out.println("LOGG OFF");

            NavigationMessenger.getInstance().navigateTo(Page.MAIN);
        }
        else
        {
            System.out.println("Clic non géré");
        }
    }

    @Override
    public void onNavigateTo(Page page, Object data) {
        if (page == Page.LOGGEDMENU){

            joueur = (Joueur) data;
            System.out.println(joueur);
            usernameLabel.setText(joueur.getIdentifiant());
        }
    }
}
