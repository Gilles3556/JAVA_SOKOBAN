package pndg.v3.model;

public class Baggage extends Actor {

    private TypeActeur type= TypeActeur.BAGGAGE;

    public Baggage(int x, int y) {
        super(x, y);

    }
    


    public void move(int x, int y) {
        
        int dx = x() + x;
        int dy = y() + y;
        
        setX(dx);
        setY(dy);
    }
}
