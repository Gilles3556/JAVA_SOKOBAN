package pndg.v2.presenter;

import pndg.v2.dao.DAOmemoireException;
import pndg.v2.ihm.FabriqueIhm;
import pndg.v2.ihm.FenetreSokoban;
import pndg.v2.model.FabriqueMetier;
import pndg.v2.model.JeuSokoban;

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
