package be.technifutur.mobile.controller;

import be.technifutur.mobile.domain.Carte;
import be.technifutur.mobile.domain.Joueur;
import be.technifutur.mobile.domain.Partie;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class SoloController implements EventHandler<MouseEvent> {




    @FXML
    private ImageView carteJouerJoueur1;
    @FXML
    private ImageView carteJouerJoueur2;
    @FXML
    private ImageView carteJouerJoueur3;
    @FXML
    private ImageView carteJouerJoueur4;
    @FXML
    private ImageView carteRetourne;

    private List<ImageView> cartesJouees;

    @FXML
    private Label partir;
    @FXML
    private Button oui;
    @FXML
    private Button non;
    @FXML
    private Label atoutPris;
    @FXML
    private ImageView couleur;

    @FXML
    private GridPane grid;
    @FXML
    private GridPane grid2;
    @FXML
    private GridPane grid3;
    @FXML
    private GridPane grid4;
    @FXML
    private GridPane gridTable;

    private List<GridPane> grids;

    private Partie partie;

//endregion

    public void initialize() {

        System.out.println("initialize()");

        cartesJouees = Arrays.asList(carteJouerJoueur1, carteJouerJoueur2, carteJouerJoueur3, carteJouerJoueur4);
        grids = Arrays.asList(grid, grid2, grid3, grid4);



        partie = new Partie();
        partie.ajouterJoueur(new Joueur("Joueur1"));
        partie.ajouterJoueur(new Joueur("Joueur2"));
        partie.ajouterJoueur(new Joueur("Joueur3"));
        partie.ajouterJoueur(new Joueur("Joueur4"));

        premiereDistribution();
        dispositionCartes();

        carteRetourne.setImage(partie.getCartes().get(0).getImage());
        oui.setOnMouseClicked(this);
        non.setOnMouseClicked(this);
    }

    private void dispositionCartes() {

        ArrayList<Joueur> joueurs = partie.getJoueurs();

        for (int i = 0; i < joueurs.size(); i++) {

            Joueur joueur = joueurs.get(i);
            GridPane grid = grids.get(i);

            if (i == 0) {
                disposition(joueur, grid, true);
            } else {
                disposition(joueur, grid, false);
            }
        }
    }


    private void disposition(Joueur joueur, GridPane grid, boolean isPlayer) {

        for (Carte carte : joueur.getCartes()) {

            if (isPlayer) {
                ImageView imageView = new ImageView();
                imageView.setImage(carte.getImage());
                imageView.setFitWidth(60);
                imageView.setFitHeight(97.5);
                imageView.setOnMouseClicked(this);
                grid.add(imageView, joueur.getCartes().indexOf(carte), 0);

            }

            if (!isPlayer) {
                ImageView imageViewDos = new ImageView();
                imageViewDos.setImage(new Image("/image/DosDeCArte.jpg"));
                imageViewDos.setFitWidth(60);
                imageViewDos.setFitHeight(97.5);
                grid.add(imageViewDos, joueur.getCartes().indexOf(carte), 0);
            }
        }
    }

    private void premiereDistribution() {
        tourDistribution(3);
        tourDistribution(2);
    }

    private void tourDistribution(int nbrDeCartesADonner) {
        for (Joueur joueur : partie.getJoueurs()) {
            for (int i = 0; i < nbrDeCartesADonner; i++) {
                joueur.getCartes().add(partie.getCartes().remove(0));
            }
        }
    }

    private void deuxiemeDistribution() {
        for (Joueur joueur : partie.getJoueurs()) {

            if (joueur.getCartes().size() == 6) {
                joueur.getCartes().add(partie.getCartes().remove(0));
                joueur.getCartes().add(partie.getCartes().remove(0));
            } else {
                joueur.getCartes().add(partie.getCartes().remove(0));
                joueur.getCartes().add(partie.getCartes().remove(0));
                joueur.getCartes().add(partie.getCartes().remove(0));
            }

        }
    }

    private void deuxiemeDisposition() {

        for (int j = 5; j < 8; j++) {

            ImageView imageView = new ImageView();
            imageView.setImage(partie.getJoueurs().get(0).getCartes().get(j).getImage());
            imageView.setFitWidth(60);
            imageView.setFitHeight(97.5);
            imageView.setOnMouseClicked(this);
            grid.add(imageView, j, 0);

            for (int i = 1; i < 4; i++) {
                GridPane grid = grids.get(i);
                ImageView imageViewDos = new ImageView();
                imageViewDos.setImage(new Image("/image/DosDeCArte.jpg"));
                imageViewDos.setFitWidth(60);
                imageViewDos.setFitHeight(97.5);
                grid.add(imageViewDos, j, 0);
            }
        }
    }

    public void handle(MouseEvent mouseEvent) {

       if (mouseEvent.getSource() == oui || mouseEvent.getSource() == non) {

            switch (partie.getCartes().get(0).getCouleur()) {
                case PIQUE:
                    couleur.setImage(new Image("/image/Pique1.png"));
                    couleur.setVisible(true);
                    atoutPris.setVisible(true);
                    atoutPris.setTextFill(Color.BLACK);
                    break;
                case COEUR:
                    couleur.setImage(new Image("/image/Coeur.png"));
                    couleur.setVisible(true);
                    atoutPris.setVisible(true);
                    atoutPris.setTextFill(Color.RED);
                    break;
                case TREFLE:
                    couleur.setImage(new Image("/image/Trefle.png"));
                    couleur.setVisible(true);
                    atoutPris.setVisible(true);
                    atoutPris.setTextFill(Color.BLACK);
                    break;
                case CARREAU:
                    couleur.setImage(new Image("/image/Carreau.png"));

                    couleur.setVisible(true);
                    atoutPris.setVisible(true);
                    atoutPris.setTextFill(Color.RED);
                    break;
                default:
                    break;

            }

            if (mouseEvent.getSource() == oui) {
                partie.getJoueurs().get(0).getCartes().add(partie.getCartes().remove(0));
                carteRetourne.setVisible(false);
                partir.setVisible(false);
                gridTable.getChildren().remove(oui);
                gridTable.getChildren().remove(non);

            } else {
                Random rdm = new Random();
                int hasard = rdm.nextInt(2) + 1;
                partie.getJoueurs().get(hasard).getCartes().add(partie.getCartes().remove(0));
                carteRetourne.setVisible(false);
                partir.setVisible(false);
                gridTable.getChildren().remove(oui);
                gridTable.getChildren().remove(non);

            }
            deuxiemeDistribution();
            deuxiemeDisposition();
        } else {

            for (Joueur joueur : partie.getJoueurs()) {
                int indexJoueur = partie.getJoueurs().indexOf(joueur);
                if (indexJoueur == 0) {
                    GridPane grid = grids.get(indexJoueur);
                    for (Node child : grid.getChildren()) {
                        if (mouseEvent.getSource() == child) {
                            ImageView iv = ((ImageView) mouseEvent.getSource());
                            iv.setVisible(false);
                            cartesJouees.get(indexJoueur).setImage(iv.getImage());
                        }
                    }
                } else {

                    Random random = new Random();
                    Carte carte = joueur.getCartes().get(random.nextInt(joueur.getCartes().size()));
                    int indexCarte = joueur.getCartes().indexOf(carte);
                    joueur.getCartes().remove(carte);

                    GridPane grid = grids.get(indexJoueur);
                    ImageView iv = ((ImageView) grid.getChildren().get(indexCarte));
                    iv.setVisible(false);
                    grid.getChildren().remove(iv);
                    cartesJouees.get(indexJoueur).setImage(carte.getImage());
                }
            }
        }
    }
}
