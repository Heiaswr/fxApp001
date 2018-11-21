package be.technifutur.mobile.data;

import be.technifutur.mobile.domain.Joueur;

import java.sql.*;
import java.time.format.DateTimeFormatter;

public class BeloteDao {

    private String connectionStr = "jdbc:postgresql://localhost:5432/belotev001";
    private String user = "postgres";
    private String passwd = "postgres";


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
            String query = String.format("INSERT INTO joueur (mail, identifiant, mdp, pays, date_inscription, hp)" +
                            "VALUES ('%s', '%s', '%s', '%s', '%s', '%d')", joueur.getAdresseMail(), joueur.getIdentifiant(), joueur.getMdp(),
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

    public boolean mailVerificator(Joueur joueur) {

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
            String query = String.format("SELECT * FROM joueur WHERE mail = '%s'", joueur.getAdresseMail());


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

    public boolean identifiantVerificator(Joueur joueur) {

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
            String query = String.format("SELECT * FROM joueur WHERE identifiant = '%s'", joueur.getIdentifiant());


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
            String query = String.format("SELECT * FROM joueur WHERE identifiant = '%s' AND mdp = '%s'", username, pwd);


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


}
