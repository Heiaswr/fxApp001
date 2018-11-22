package be.technifutur.mobile.domain;

import be.technifutur.mobile.data.BeloteDao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Joueur {

    private LocalDate dateInscription = LocalDate.now();
    BeloteDao beloteDao = new BeloteDao();
    private int id;
    private String adresseMail;
    private String identifiant;
    private String mdp;
    private String pays;
    private int hp;

    public Joueur() {
    }

    public Joueur(String adresseMail, String identifiant, String mdp, String pays) {

        this.adresseMail = adresseMail;
        this.identifiant = identifiant;
        this.mdp = mdp;
        this.pays = pays;
        this.hp = 100;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription=dateInscription;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "id=" + id +
                ", adresseMail='" + adresseMail + '\'' +
                ", identifiant='" + identifiant + '\'' +
                ", pays='" + pays + '\'' +
                ", dateInscription=" + dateInscription +
                ", hp=" + hp +
                '}';
    }


    public Joueur inscription(Joueur joueur) {

        Scanner sc = new Scanner(System.in);


        do
        {
            System.out.print("Mail: ");
            joueur.setAdresseMail(sc.nextLine());
        } while (!mailIsValid(joueur.getAdresseMail()));

        do
        {
            System.out.print("Identifiant: ");
            joueur.setIdentifiant(sc.nextLine());
        } while (!identifiantIsValid(joueur.getIdentifiant()));

        do
        {
            System.out.print("Mot de passe: ");
            joueur.setMdp(sc.nextLine());
        } while (!mdpIsValid(joueur.getMdp()));

        System.out.print("Pays: ");
        joueur.setPays(sc.nextLine());


        return joueur;


    }

    public boolean identification(Joueur joueur){

        boolean reponse;
        Scanner sc = new Scanner(System.in);
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Pwd: ");
        String pwd = sc.nextLine();

        if(!beloteDao.identificationIsValid(login, pwd))
        {
            reponse = false;
            System.out.println("Identifiant et/ou mot de passe incorrect");
        }

        else {
            reponse=true;
        }

        return reponse;






    }



    private boolean mailIsValid(String mail) {


        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(mail);
        if (!m.matches())
        {
            System.out.println("Adresse mail incorrecte.");
        }
        else if (beloteDao.mailNotUsed(mail))
        {
            System.out.println("Adresse mail déjà utilisée.");
            return false;
        }
        return m.matches();

    }

    private boolean mdpIsValid(String mdp) {

        String pattern = "(?=\\S+$).{8,}";

        if (mdp.matches(pattern))
        {
            return true;
        }
        else
        {
            System.out.println("Mot de passe incorrect. (Minimum: 8 caractères)");
            return false;
        }
    }

    private boolean identifiantIsValid(String identifiant) {

        String pattern = "(?=\\S+$).{4,}";

        if (beloteDao.usernameNotUsed(identifiant))
        {
            System.out.println("Identifiant déjà utilisée.");
            return false;
        }
        else if (identifiant.matches(pattern))
        {
            return true;
        }

        else
        {
            System.out.println("Identifiant incorrect. (Minimum: 4 caractères)");
            return false;
        }
    }

}
