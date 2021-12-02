package pndg.v3.presenter;

import pndg.v3.dao.DAOmemoireException;
import pndg.v3.ihm.FabriqueIhm;
import pndg.v3.ihm.FenetreSokoban;
import pndg.v3.model.FabriqueMetier;
import pndg.v3.model.JeuSokoban;

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
