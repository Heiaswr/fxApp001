package be.technifutur.mobile.domain;


import javafx.scene.image.Image;

public class Carte {

    private Valeur valeur;
    private Couleur couleur;
    private Image image;

    public Carte(Valeur valeur, Couleur couleur, Image image) {
        this.valeur = valeur;
        this.couleur = couleur;
        this.image = image;
    }

    public Valeur getValeur() {
        return valeur;
    }

    public void setValeur(Valeur valeur) {
        this.valeur = valeur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
