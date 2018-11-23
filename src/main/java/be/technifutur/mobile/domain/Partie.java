package be.technifutur.mobile.domain;

/**
 * Une partie contient quatre joueurs
 * Chaque joueur va recevoir 3 cartes, puis deux cartes
 * Ensuite, la première carte du paquet va être retournée et montrée au premier joueur
 * L'ordre des joueurs se fait dans le sens des aiguilles d'une montre. Le premier joueur est celui qui se trouve juste après le distributeur.
 * Le distributeur change à chaque partie
 * Dans le premier tour, chaque joueur va, à tour de rôle, dire s'il souhaite prendre la carte (la couleur de cette carte sera l'atout).
 * Si personne n'a pris au premier tour, on passe au second tour et chaque joueur va, à tour de rôle, pouvoir choisir une des trois autres couleurs.
 * S'il souhaite choisir l'atout, il doit prendre la carte sur la table.
 * Une fois l'atout choisi, le distributeur distribue 3 cartes à chaque joueur et deux au joueur ayant pris la carte sur la table.
 * Une fois les huit cartes en main, le premier joueur lance une carte et doit être suivi par les autres joueurs.
 */

public class Partie {
}
