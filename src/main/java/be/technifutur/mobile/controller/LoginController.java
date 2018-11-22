package be.technifutur.mobile.controller;

import be.technifutur.mobile.data.BeloteDao;
import be.technifutur.mobile.domain.Joueur;
import be.technifutur.mobile.util.NavigationMessenger;
import be.technifutur.mobile.util.Page;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class LoginController implements EventHandler<MouseEvent> {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button valider;

    @FXML
    private Label InvalidMatch;

    @FXML
    private Hyperlink loginBackHL;


    public void initialize() {

        System.out.println("RegisterInitialize()");


//        loginButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                System.out.println("Clicked !");
//                loginButton.setText("Already clicked");
//                loginButton.setDisable(true);
//            }
//        });
        valider.setOnMouseClicked(this);

        loginBackHL.setOnMouseClicked(this);

        password.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode().getCode() == 10){
                    validationBouton();

                }
            }
        });

        username.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode().getCode() == 10){
                    validationBouton();

                }
            }
        });

    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getSource() == valider){
            validationBouton();
        }
        if (mouseEvent.getSource() == loginBackHL)
        {
            System.out.println("LOGIN BACK");

            NavigationMessenger.getInstance().navigateTo(Page.MAIN);
        }


    }

    private void validationBouton() {
        Joueur joueur;
        BeloteDao beloteDao = new BeloteDao();
        InvalidMatch.setVisible(false);

        if(!beloteDao.identificationIsValid(username.getText(), password.getText())){
        InvalidMatch.setVisible(true);
        }
        else{
            System.out.println("Identification réussie !");
            joueur =beloteDao.loginWhenMatches(username.getText());
            NavigationMessenger.getInstance().navigateTo(Page.LOGGEDMENU, joueur);

        }
    }


}
