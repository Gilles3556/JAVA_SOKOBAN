package pndg.v1.presenter;

import pndg.v1.dao.DAOmemoireException;
import pndg.v1.ihm.FabriqueIhm;
import pndg.v1.ihm.FenetreSokoban;
import pndg.v1.model.FabriqueMetier;
import pndg.v1.model.JeuSokoban;

public class Presenter {

    private JeuSokoban jeu;
    private FenetreSokoban game;

    public Presenter() throws DAOmemoireException {
        // Metier
        jeu = FabriqueMetier.creerJeu();

        // IHM
        game = FabriqueIhm.creerFenetre(jeu);
    }

    public void exec(){
        game.jouer();
    }
}
