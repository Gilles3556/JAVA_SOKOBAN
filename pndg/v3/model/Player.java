package pndg.v3.model;

public class Player extends Actor {

    private TypeActeur type= TypeActeur.PLAYER;

    public Player(int x, int y) {
        super(x, y);

    }


    public void move(int x, int y) {

        int dx = x() + x;
        int dy = y() + y;
        
        setX(dx);
        setY(dy);
    }
}
