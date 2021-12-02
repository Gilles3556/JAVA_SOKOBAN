package pndg.v3.model;

import pndg.v3.ihm.C;

public class Actor {

    private int x;
    private int y;

    public Actor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLeftCollision( Actor actor) {
        return (x() - C.SPACE == actor.x() && y() == actor.y());
    }

    public boolean isRightCollision( Actor actor) {
        return x() + C.SPACE == actor.x() && y() == actor.y();
    }

    public boolean isTopCollision( Actor actor) {
        return y() - C.SPACE == actor.y() && x() == actor.x();
    }

    public boolean isBottomCollision( Actor actor) {
        return y() + C.SPACE == actor.y() && x() == actor.x();
    }

}
