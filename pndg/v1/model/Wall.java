package pndg.v1.model;

import java.awt.*;

public class Wall extends Actor {

    private TypeActeur type=TypeActeur.WALL;

    private Image image;

    public Wall(int x, int y) {
        super(x, y);
    }

}
