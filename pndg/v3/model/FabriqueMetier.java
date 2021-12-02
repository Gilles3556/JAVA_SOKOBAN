package pndg.v3.model;

import pndg.v3.dao.DAOmemoire;
import pndg.v3.dao.DAOmemoireException;

public final class FabriqueMetier {
    private static DAOmemoire mem = new DAOmemoire();

    private FabriqueMetier(){
    }

    public static World creerMonde( int noLevel) throws DAOmemoireException{
        afficherLevel(noLevel);
        String strLevel = mem.getLevel(noLevel);
        return new World(strLevel);
    }

    public static JeuSokoban creerJeu() throws DAOmemoireException {
        return new JeuSokoban();
    }

    private static void afficherLevel(int no) throws DAOmemoireException {
        String strLevel = mem.getLevel(no);
        System.out.println("STRLEVEL="+strLevel);
        StringBuffer strbuff = new StringBuffer();

        for(int i=0;i<strLevel.length();i++){
            strbuff.append(strLevel.charAt(i));
        }
        strbuff.append(System.lineSeparator());

        System.out.println(strbuff.toString());
    }

}
