package be.technifutur.mobile.data;

import be.technifutur.mobile.domain.Joueur;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BeloteDao {

    private String connectionStr = "jdbc:postgresql://localhost:5432/belotev001";
    private String user = "postgres";
    private String passwd = "postgres";

    /*

CREATE TABLE joueur(
    id_joueur SERIAL NOT NULL,
    mail character varying(50) COLLATE pg_catalog."default" NOT NULL,
    identifiant character varying(25) COLLATE pg_catalog."default" NOT NULL,
    mdp character varying(100) COLLATE pg_catalog."default" NOT NULL,
    pays character varying(25) COLLATE pg_catalog."default",
    date_inscription date,
    hp integer,
    CONSTRAINT joueur_pkey PRIMARY KEY (id_joueur)
)

     */


    public void insert(Joueur joueur) {

        try (Connection connection = DriverManager.getConnection(connectionStr, user, passwd);
             // statement.executeUpdate(...) INSERT, UPDATE, DELETE
             // statement.executeQuery(...) SELECT
             Statement statement = connection.createStatement();
             // SELECT id, nom FROM jeu
        )
        {

            /*CREATE TABLE joueur (id_joueur SERIAL not null,
                mail VARCHAR(50) not null,
                identifiant VARCHAR(25) not null,
                pays VARCHAR(25),
                date_inscription Date,
                hp INT, PRIMARY KEY(id_joueur))*/
            String pwd = BCrypt.hashpw(joueur.getMdp(), BCrypt.gensalt());
            String query = String.format("INSERT INTO joueur (mail, identifiant, mdp, pays, date_inscription, hp)" +
                            "VALUES ('%s', '%s', '%s', '%s', '%s', '%d')", joueur.getAdresseMail(), joueur.getIdentifiant(), pwd,
                    joueur.getPays(), joueur.getDateInscription().format(DateTimeFormatter.ISO_LOCAL_DATE), joueur.getHp());


            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next())
            {
                joueur.setId(rs.getInt(1));

            }
            rs.close();

        } catch (SQLException e)
        {
            System.err.println("Erreur avec la DB: " + e.getMessage());
        }


    }

    public boolean mailNotUsed(String mail) {

        boolean bool = true;

        try (Connection connection = DriverManager.getConnection(connectionStr, user, passwd);
             // statement.executeUpdate(...) INSERT, UPDATE, DELETE
             // statement.executeQuery(...) SELECT
             Statement statement = connection.createStatement();
             // SELECT id, nom FROM jeu
        )
        {

            /*CREATE TABLE joueur (id_joueur SERIAL not null,
                mail VARCHAR(50) not null,
                identifiant VARCHAR(25) not null,
                pays VARCHAR(25),
                date_inscription Date,
                hp INT, PRIMARY KEY(id_joueur))*/
            String query = String.format("SELECT * FROM joueur WHERE mail = '%s'", mail);


            statement.execute(query);
            ResultSet rs = statement.executeQuery(query);
            bool = rs.next();
            rs.close();


        } catch (SQLException e)
        {
            System.err.println("Erreur avec la DB: " + e.getMessage());
        }
        return bool;


    }

    public boolean usernameNotUsed(String username) {

        boolean bool = true;

        try (Connection connection = DriverManager.getConnection(connectionStr, user, passwd);
             // statement.executeUpdate(...) INSERT, UPDATE, DELETE
             // statement.executeQuery(...) SELECT
             Statement statement = connection.createStatement();
             // SELECT id, nom FROM jeu
        )
        {

            /*CREATE TABLE joueur (id_joueur SERIAL not null,
                mail VARCHAR(50) not null,
                identifiant VARCHAR(25) not null,
                pays VARCHAR(25),
                date_inscription Date,
                hp INT, PRIMARY KEY(id_joueur))*/
            String query = String.format("SELECT * FROM joueur WHERE identifiant = '%s'", username);


            statement.execute(query);
            ResultSet rs = statement.executeQuery(query);
            bool = rs.next();
            rs.close();


        } catch (SQLException e)
        {
            System.err.println("Erreur avec la DB: " + e.getMessage());
        }
        return bool;


    }


    public boolean identificationIsValid(String username, String pwd) {

        boolean bool = true;
        try (Connection connection = DriverManager.getConnection(connectionStr, user, passwd);
             // statement.executeUpdate(...) INSERT, UPDATE, DELETE
             // statement.executeQuery(...) SELECT
             Statement statement = connection.createStatement();
             // SELECT id, nom FROM jeu
        )
        {

            /*CREATE TABLE joueur (id_joueur SERIAL not null,
                mail VARCHAR(50) not null,
                identifiant VARCHAR(25) not null,
                pays VARCHAR(25),
                date_inscription Date,
                hp INT, PRIMARY KEY(id_joueur))*/

            String query = String.format("SELECT * FROM joueur WHERE identifiant = '%s'", username);


            statement.execute(query);
            ResultSet rs = statement.executeQuery(query);

            if(rs.next()){
                if (BCrypt.checkpw(pwd, rs.getString("mdp"))){
                    return true;
                }
            }


            rs.close();


        } catch (SQLException e)
        {
            System.err.println("Erreur avec la DB: " + e.getMessage());
        }

        return false;


    }

    public Joueur loginWhenMatches(String username){

        Joueur joueur = new Joueur();

        try (Connection connection = DriverManager.getConnection(connectionStr, user, passwd);
             // statement.executeUpdate(...) INSERT, UPDATE, DELETE
             // statement.executeQuery(...) SELECT
             Statement statement = connection.createStatement();
             // SELECT id, nom FROM jeu
        )
        {

            /*CREATE TABLE joueur (id_joueur SERIAL not null,
                mail VARCHAR(50) not null,
                identifiant VARCHAR(25) not null,
                pays VARCHAR(25),
                date_inscription Date,
                hp INT, PRIMARY KEY(id_joueur))*/
            String query = String.format("SELECT * FROM joueur WHERE identifiant = '%s'", username);




            statement.execute(query);
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
            joueur.setId(rs.getInt("id_joueur"));
            joueur.setAdresseMail(rs.getString("mail"));
            joueur.setIdentifiant(rs.getString("identifiant"));
            joueur.setMdp(rs.getString("mdp"));
            joueur.setPays(rs.getString("pays"));
            joueur.setDateInscription(LocalDate.parse(rs.getString("date_inscription"), DateTimeFormatter.ISO_LOCAL_DATE));
            joueur.setHp(rs.getInt("hp"));
            }



            rs.close();


        } catch (SQLException e)
        {
            System.err.println("Erreur avec la DB: " + e.getMessage());
        }



        return joueur;




    }


    public boolean usernameValidator(String username) {

        String pattern = "(?=\\S+$).{4,}";

        if (username.matches(pattern))
        {
            return true;
        }

        else return false;
    }

    public boolean mailValidator(String mail) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(mail);
        if (!m.matches())
        {
            System.out.println("Adresse mail incorrecte.");
        }

        return m.matches();
    }

    public boolean passwordVerificator(String mdp) {
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
}
