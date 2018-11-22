package be.technifutur.mobile.controller;

import be.technifutur.mobile.data.BeloteDao;
import be.technifutur.mobile.domain.Joueur;
import be.technifutur.mobile.util.NavigationMessenger;
import be.technifutur.mobile.util.Page;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class RegisterController implements EventHandler<MouseEvent> {
    @FXML
    private PasswordField loginPassword;
    @FXML
    private TextField loginUsername;
    @FXML
    private TextField loginMail;
    @FXML
    private TextField loginCountry;
    @FXML
    private Button valider;

    @FXML
    private Label loginInvalidUsername;

    @FXML
    private Label loginUsedUsername;

    @FXML
    private Label loginInvalidMail;

    @FXML
    private Label loginUsedMail;

    @FXML
    private Label loginInvalidPassword;

    @FXML
    private Hyperlink registerBackHL;


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

        registerBackHL.setOnMouseClicked(this);


    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        BeloteDao beloteDao = new BeloteDao();
        Joueur joueur;
        boolean isValid=true;
        loginUsedUsername.setVisible(false);
        loginInvalidUsername.setVisible(false);
        loginUsedMail.setVisible(false);
        loginInvalidMail.setVisible(false);
        loginInvalidPassword.setVisible(false);

        if(mouseEvent.getSource() == registerBackHL){
            System.out.println("REGISTER BACK");

            NavigationMessenger.getInstance().navigateTo(Page.MAIN);

        }


        if (beloteDao.usernameNotUsed(loginUsername.getText()))
        {
            System.out.println("Username used !");
            loginUsedUsername.setVisible(true);
            isValid=false;

        }

        else if (!beloteDao.usernameValidator(loginUsername.getText()))
        {
            System.out.println("Invalid username");
            loginInvalidUsername.setVisible(true);
            isValid=false;
        }
        if (beloteDao.mailNotUsed(loginMail.getText()))
        {
            System.out.println("Mail used !");
            loginUsedMail.setVisible(true);
            isValid=false;
        }
        else if (!beloteDao.mailValidator(loginMail.getText()))
        {
            System.out.println("Invalid mail");
            loginInvalidMail.setVisible(true);
            isValid=false;
        }

        if (!beloteDao.passwordVerificator(loginPassword.getText()))
        {
            System.out.println("Invalid password");
            loginInvalidPassword.setVisible(true);
            isValid=false;
        }


        if (isValid)
        {

            if (mouseEvent.getSource() == valider)
            {
                joueur = new Joueur(loginMail.getText(), loginUsername.getText(), loginPassword.getText(), loginCountry.getText());
                beloteDao.insert(joueur);
                System.out.println("Valider !");
                NavigationMessenger.getInstance().navigateTo(Page.LOGGEDMENU, joueur);
            }
        }


    }

}
