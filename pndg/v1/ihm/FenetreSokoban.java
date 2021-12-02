package pndg.v1.ihm;

import pndg.v1.model.JeuSokoban;

import javax.swing.*;

public class FenetreSokoban extends JFrame {
    private JeuSokoban leJeu ;

    public FenetreSokoban(JeuSokoban j) {
        leJeu = j;
        initUI();
    }

    private void initUI() {
        Board board = FabriqueIhm.creerBoard(leJeu);
        add(board);

        setTitle("Sokoban");
        
        setSize(board.getBoardWidth() + C.OFFSET,
                board.getBoardHeight() + 2 * C.OFFSET);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        board.setFenParent(this);
    }

    public void jouer(){
        this.setVisible(true);
    }

    public void majTitre(int ctr){
        setTitle("Sokoban: mvt="+ctr);
    }
}
