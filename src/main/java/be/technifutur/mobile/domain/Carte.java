package be.technifutur.mobile.domain;

public class Carte {

    private Couleur couleur;
    private Valeur valeur;

    public Carte(Couleur couleur, Valeur valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Valeur getValeur() {
        return valeur;
    }

    public boolean isAtout (Couleur atout){
        return this.couleur.equals(atout);
    }
}
