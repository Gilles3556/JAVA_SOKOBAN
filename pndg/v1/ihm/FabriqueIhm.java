package pndg.v1.ihm;

import pndg.v1.model.JeuSokoban;
import pndg.v1.model.TypeActeur;

import javax.swing.*;
import java.awt.*;

public class FabriqueIhm {

    public static FenetreSokoban creerFenetre( JeuSokoban leJeu){
        FenetreSokoban fen = new FenetreSokoban(leJeu);
        return fen;
    }
    public static Board creerBoard(JeuSokoban leJeu){
        Board b = new Board(leJeu);
        return b;
    }

    public static Image getImageForActeur( TypeActeur leType ){
        ImageIcon iicon=null;
        Image uneImage=null;

        if (leType==TypeActeur.AREA){
            iicon = new ImageIcon("src/resources/area.png");
            uneImage = iicon.getImage();
        }
        if(leType==TypeActeur.BAGGAGE){
            iicon = new ImageIcon("src/resources/baggage.png");
            uneImage = iicon.getImage();
        }
        if(leType==TypeActeur.PLAYER){
            iicon = new ImageIcon("src/resources/sokoban.png");
            uneImage = iicon.getImage();
        }
       if(leType==TypeActeur.WALL){
           iicon = new ImageIcon("src/resources/wall.png");
           uneImage = iicon.getImage();
       }
        return uneImage;
    }
}
