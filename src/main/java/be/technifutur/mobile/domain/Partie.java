package be.technifutur.mobile.domain;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Random;

public class Partie {

    private ArrayList<Carte> cartes;
    private ArrayList<Joueur> joueurs;

    private int melangeur = 0;

    Random rdm = new Random();

    public Partie() {
        this.cartes = generateCard();
        this.joueurs = new ArrayList<>();
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(ArrayList<Carte> cartes) {
        this.cartes = cartes;
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public ArrayList<Carte> generateCard(){

        ArrayList<Carte> listCarte = new ArrayList<>();
        ArrayList<Carte> pique = new ArrayList<>();
        ArrayList<Carte> coeur = new ArrayList<>();
        ArrayList<Carte> trefle = new ArrayList<>();
        ArrayList<Carte> carreau = new ArrayList<>();

        pique.add(new Carte(Valeur.AS, Couleur.PIQUE,new Image("/image/AsPique.jpg")));
        pique.add(new Carte(Valeur.DIX, Couleur.PIQUE,new Image("/image/DixPique.jpg")));
        pique.add(new Carte(Valeur.ROI, Couleur.PIQUE,new Image("/image/RoiPique.jpg")));
        pique.add(new Carte(Valeur.DAME, Couleur.PIQUE,new Image("/image/DamePique.jpg")));
        pique.add(new Carte(Valeur.VALET, Couleur.PIQUE,new Image("/image/ValetPique.jpg")));
        pique.add(new Carte(Valeur.NEUF, Couleur.PIQUE,new Image("/image/NeufPique.jpg")));
        pique.add(new Carte(Valeur.HUIT, Couleur.PIQUE,new Image("/image/HuitPique.jpg")));
        pique.add(new Carte(Valeur.SEPT, Couleur.PIQUE,new Image("/image/SeptPique.jpg")));

        coeur.add(new Carte(Valeur.AS, Couleur.COEUR,new Image("/image/AsCoeur.jpg")));
        coeur.add(new Carte(Valeur.DIX, Couleur.COEUR,new Image("/image/DixCoeur.jpg")));
        coeur.add(new Carte(Valeur.ROI, Couleur.COEUR,new Image("/image/RoiCoeur.jpg")));
        coeur.add(new Carte(Valeur.DAME, Couleur.COEUR,new Image("/image/DameCoeur.jpg")));
        coeur.add(new Carte(Valeur.VALET, Couleur.COEUR,new Image("/image/ValetCoeur.jpg")));
        coeur.add(new Carte(Valeur.NEUF, Couleur.COEUR,new Image("/image/NeufCoeur.jpg")));
        coeur.add(new Carte(Valeur.HUIT, Couleur.COEUR,new Image("/image/HuitCoeur.jpg")));
        coeur.add(new Carte(Valeur.SEPT, Couleur.COEUR,new Image("/image/SeptCoeur.jpg")));

        trefle.add(new Carte(Valeur.AS, Couleur.TREFLE,new Image("/image/AsTrefle.jpg")));
        trefle.add(new Carte(Valeur.DIX, Couleur.TREFLE,new Image("/image/DixTrefle.jpg")));
        trefle.add(new Carte(Valeur.ROI, Couleur.TREFLE,new Image("/image/RoiTrefle.jpg")));
        trefle.add(new Carte(Valeur.DAME, Couleur.TREFLE,new Image("/image/DameTrefle.jpg")));
        trefle.add(new Carte(Valeur.VALET, Couleur.TREFLE,new Image("/image/ValetTrefle.jpg")));
        trefle.add(new Carte(Valeur.NEUF, Couleur.TREFLE,new Image("/image/NeufTrefle.jpg")));
        trefle.add(new Carte(Valeur.HUIT, Couleur.TREFLE,new Image("/image/HuitTrefle.jpg")));
        trefle.add(new Carte(Valeur.SEPT, Couleur.TREFLE,new Image("/image/SeptTrefle.jpg")));

        carreau.add(new Carte(Valeur.AS, Couleur.CARREAU,new Image("/image/AsCarreau.jpg")));
        carreau.add(new Carte(Valeur.DIX, Couleur.CARREAU,new Image("/image/DixCarreau.jpg")));
        carreau.add(new Carte(Valeur.ROI, Couleur.CARREAU,new Image("/image/RoiCarreau.jpg")));
        carreau.add(new Carte(Valeur.DAME, Couleur.CARREAU,new Image("/image/DameCarreau.jpg")));
        carreau.add(new Carte(Valeur.VALET, Couleur.CARREAU,new Image("/image/ValetCarreau.jpg")));
        carreau.add(new Carte(Valeur.NEUF, Couleur.CARREAU,new Image("/image/NeufCarreau.jpg")));
        carreau.add(new Carte(Valeur.HUIT, Couleur.CARREAU,new Image("/image/HuitCarreau.jpg")));
        carreau.add(new Carte(Valeur.SEPT, Couleur.CARREAU,new Image("/image/SeptCarreau.jpg")));

        int a, a1, j1 = 0, a2, j2 = 0, a3, j3 = 0, a4, j4 = 0;
        while (pique.size() != 0 || carreau.size() != 0 || coeur.size() != 0 || trefle.size() != 0) {
            a = rdm.nextInt(4);
            if (a == 0 && pique.size() != 0) {

                a1 = rdm.nextInt(8 - j1);
                listCarte.add(pique.get(a1));
                pique.remove(a1);
                j1++;

            } else if (a == 1 && coeur.size() != 0) {
                a2 = rdm.nextInt(8 - j2);
                listCarte.add(coeur.get(a2));
                coeur.remove(a2);
                j2++;

            } else if (a == 2 && carreau.size() != 0) {

                a3 = rdm.nextInt(8 - j3);
                listCarte.add(carreau.get(a3));
                carreau.remove(a3);
                j3++;
            } else if (a == 3 && trefle.size() != 0) {
                a4 = rdm.nextInt(8 - j4);
                listCarte.add(trefle.get(a4));
                trefle.remove(a4);
                j4++;
            }
        }

        return listCarte;
    }

    public void ajouterJoueur(Joueur joueur) {
        this.joueurs.add(joueur);
    }
}
