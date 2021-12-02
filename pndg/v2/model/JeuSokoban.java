package pndg.v2.model;

import pndg.v2.dao.DAOmemoireException;

public class JeuSokoban {
    private boolean fini;

    private World leMonde;
    private int nbDeplacement;
    private int noLevel;

    public int getNbDeplacement() {
        return nbDeplacement;
    }

    public int getNoLevel() {
        return noLevel;
    }

    public JeuSokoban() throws DAOmemoireException {
        fini = false;
        nbDeplacement = 0;
        noLevel=1;
        leMonde = FabriqueMetier.creerMonde(noLevel);
    }

    public World getLeMonde(){
        return leMonde;
    }

    public boolean isFini() {
        return fini;
    }
    public void nextLevel() throws DAOmemoireException {
        noLevel++;
        fini = false;
        nbDeplacement = 0;

        leMonde = FabriqueMetier.creerMonde(noLevel);
    }

    public void addDeplacement(){
        nbDeplacement++;
    }
    public void clear(){
        nbDeplacement = 0;
        leMonde.clear();
        leMonde.initWorld();

    }
}
