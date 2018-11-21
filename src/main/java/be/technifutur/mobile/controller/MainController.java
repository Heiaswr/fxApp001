package be.technifutur.mobile.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MainController implements EventHandler<MouseEvent> {

    @FXML
    private Button loginButton;

    public void initialize() {

        System.out.println("initialize()");

        loginButton.setText("Texte modifié en Java");

//        loginButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                System.out.println("Clicked !");
//                loginButton.setText("Already clicked");
//                loginButton.setDisable(true);
//            }
//        });

        loginButton.setOnMouseClicked(this);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        if (mouseEvent.getSource() == loginButton) {
            System.out.println("Clicked !");
            loginButton.setText("Already clicked");
            loginButton.setDisable(true);
        } else {
            System.out.println("Clic non géré");
        }
    }
}
