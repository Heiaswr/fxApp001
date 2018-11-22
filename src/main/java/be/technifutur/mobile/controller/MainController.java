package be.technifutur.mobile.controller;

import be.technifutur.mobile.Main;
import be.technifutur.mobile.util.NavigationMessenger;
import be.technifutur.mobile.util.Page;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MainController implements EventHandler<MouseEvent> {

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;


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

        loginButton.setOnMouseClicked(this);
        registerButton.setOnMouseClicked(this);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        if (mouseEvent.getSource() == loginButton)
        {
            System.out.println("Login !");
            NavigationMessenger.getInstance().navigateTo(Page.LOGIN);

        }
        if(mouseEvent.getSource() == registerButton){
            System.out.println("Register !");


            NavigationMessenger.getInstance().navigateTo(Page.REGISTER);

        }

        else
        {
            System.out.println("Clic non géré");
        }
    }

}

         /*   joueur.inscription(joueur);
            BeloteDao beloteDao = new BeloteDao();
            beloteDao.insert(joueur);

            joueur.identification(joueur);*/

