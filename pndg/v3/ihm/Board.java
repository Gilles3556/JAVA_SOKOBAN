package pndg.v3.ihm;

import pndg.v3.ihm.FabriqueIhm;
import pndg.v3.dao.DAOmemoireException;
import pndg.v3.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel {
    private FenetreSokoban fenParent;

    private KeyAdapter keyAdapter;
    private JeuSokoban leJeu;

    private int w;
    private int h;

    private boolean isCompleted = false;

    public void setFenParent( FenetreSokoban fenParent ) {
        this.fenParent = fenParent;
    }

    public Board( JeuSokoban leJeu) {
        this.leJeu = leJeu;
        w = leJeu.getLeMonde().getW()*2;
        h = leJeu.getLeMonde().getH();

        initBoard();
    }

    private void initBoard() {
        keyAdapter = new KeyAdapter(){
            final CollisionChecker colChecker = new CollisionChecker(leJeu.getLeMonde());

            @Override
            public void keyPressed(KeyEvent e) {
                if (isCompleted) {
                    return;
                }

                int key = e.getKeyCode();

                switch (key) {
                    case KeyEvent.VK_LEFT:

                        deplacer();
                        if (colChecker.checkWallCollision(leJeu.getLeMonde().getSoko(),
                                C.LEFT_COLLISION)) {
                            return;
                        }
                        if (colChecker.checkBagCollision(C.LEFT_COLLISION)) {
                            return;
                        }
                        leJeu.getLeMonde().getSoko().move(-C.SPACE, 0);
                        break;

                    case KeyEvent.VK_RIGHT:
                        deplacer();
                        if (colChecker.checkWallCollision(leJeu.getLeMonde().getSoko(), C.RIGHT_COLLISION)) {
                            return;
                        }
                        if (colChecker.checkBagCollision(C.RIGHT_COLLISION)) {
                            return;
                        }
                        leJeu.getLeMonde().getSoko().move(C.SPACE, 0);
                        break;

                    case KeyEvent.VK_UP:
                        deplacer();
                        if (colChecker.checkWallCollision(leJeu.getLeMonde().getSoko(), C.TOP_COLLISION)) {
                            return;
                        }
                        if (colChecker.checkBagCollision(C.TOP_COLLISION)) {
                            return;
                        }
                        leJeu.getLeMonde().getSoko().move(0, -C.SPACE);
                        break;

                    case KeyEvent.VK_DOWN:
                        deplacer();
                        if (colChecker.checkWallCollision(leJeu.getLeMonde().getSoko(), C.BOTTOM_COLLISION)) {
                            return;
                        }
                        if (colChecker.checkBagCollision(C.BOTTOM_COLLISION)) {
                            return;
                        }
                        leJeu.getLeMonde().getSoko().move(0, C.SPACE);
                        break;

                    case KeyEvent.VK_R:
                        restartLevel();
                        break;

                    default:
                        break;
                }
                // fin des niveaux
                try {
                    isCompleted();
                    repaint();
                } catch (DAOmemoireException ex) {
                   // System.out.println(ex.getMessage());

                }


            }
        };

        addKeyListener(keyAdapter);
        setFocusable(true);
    }
   private void deplacer(){
        leJeu.addDeplacement();
        fenParent.majTitre(leJeu.getNbDeplacement());
   }
    public int getBoardWidth() {
        return this.w;
    }

    public int getBoardHeight() {
        return this.h;
    }

    private void drawWorld( Graphics g) {

        g.setColor(new Color(250, 240, 170));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        for (int i = 0; i < leJeu.getLeMonde().getWorldAll().size(); i++) {
            Image uneImage =null;
            Actor item = leJeu.getLeMonde().getWorldAll().get(i);

            // System.out.println(item.getClass().getSimpleName()+" y="+item.y()+" : x="+item.x());
            if (item instanceof Player || item instanceof Baggage) {
                if (item instanceof Player){
                    uneImage = FabriqueIhm.getImageForActeur(TypeActeur.PLAYER);
                }else{
                    uneImage = FabriqueIhm.getImageForActeur(TypeActeur.BAGGAGE);
                }
                g.drawImage(uneImage, item.x() + 2, item.y() + 2, this);
            } else {
                if (item instanceof Area){
                    uneImage = FabriqueIhm.getImageForActeur(TypeActeur.AREA);
                }else{
                    uneImage = FabriqueIhm.getImageForActeur(TypeActeur.WALL);
                }
                g.drawImage(uneImage, item.x(), item.y(), this);
            }
            //Fin des niveaux
            if (isCompleted) {
                g.setColor(new Color(0, 0, 0));
                g.drawString("BRAVO: Fin des niveaux", 25, 20);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawWorld(g);
    }

    public void isCompleted() throws DAOmemoireException {

        int nOfBags = leJeu.getLeMonde().getBaggs().size();
        int finishedBags = 0;

        for (int i = 0; i < nOfBags; i++) {
            Baggage bag = leJeu.getLeMonde().getBaggs().get(i);
            for (int j = 0; j < nOfBags; j++) {
                Area area =  leJeu.getLeMonde().getAreas().get(j);
                if (bag.x() == area.x() && bag.y() == area.y()) {
                    finishedBags += 1;
                }
            }
        }

        if (finishedBags == nOfBags) {
            try {
                this.nextLevel();
            }catch(Exception ex){
                isCompleted =true;

            }
        }
    }
    private void nextLevel()  {
        removeKeyListener(keyAdapter);
        isCompleted = false;

        //fin => niveau suivant ?
        try {
            leJeu.nextLevel();
            w = leJeu.getLeMonde().getW()*2;
            h = leJeu.getLeMonde().getH();

            initBoard();

        } catch (DAOmemoireException e) {
            isCompleted = true;
        }
        repaint();
    }
    private void restartLevel() {
        System.out.println(">>BOARD.restartLevel()");
        removeKeyListener(keyAdapter);
        isCompleted = false;

        leJeu.clear();

        w = leJeu.getLeMonde().getW()*2;
        h = leJeu.getLeMonde().getH();


        initBoard();
        repaint();
    }
}
