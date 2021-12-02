package pndg.v3.dao;

import pndg.v3.ihm.C;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DAOmemoire {
    public final static int MAX_LEVEL=4;

    public DAOmemoire(){    }

    public String getLevel(int noLevel) throws DAOmemoireException {
        if (noLevel>MAX_LEVEL){
            throw new DAOmemoireException("ERR: FIN des niveaux");
        }
        String retour= readLevel(noLevel);
        return retour;
    }

   public final static String NOM_FICHIER="Level";
   public final static String EXT_FICHIER=".txt";

   private String nomFichierBuilder(int noLevel){
       String nom=NOM_FICHIER;
       if(noLevel<10){
           nom+="0";
       }
       nom+=noLevel;
       nom+=EXT_FICHIER;
       return nom;
    }
   private String readLevel(int noLevel)  {
       String repertoire = System.getProperty("user.dir");
       String nomFichierLevel =repertoire+"/"+C.RESSOURCES+nomFichierBuilder(noLevel);

       String level="";
       try {
           BufferedReader buff = new BufferedReader(new FileReader(nomFichierLevel));
           String ligne="";
           while ((ligne = buff.readLine()) != null) {
               level+=ligne;
           }
       }catch (IOException ex){
           System.out.println("ERR: fichier non trouvé OU pbm de lecture !");
           System.exit(0);
       }
       return level;
   }


}
