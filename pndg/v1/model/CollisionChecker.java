package pndg.v1.model;

import pndg.v1.ihm.C;

public class CollisionChecker {
    private World unMonde;

    public CollisionChecker(World leMonde){
        this.unMonde = leMonde;

    }

    public boolean checkBagCollision(int type) {

        switch (type) {
            case C.LEFT_COLLISION:
                for (int i = 0; i < unMonde.getBaggs().size(); i++) {
                    Baggage bag = unMonde.getBaggs().get(i);
                    if (unMonde.getSoko().isLeftCollision(bag)) {
                        for (int j = 0; j < unMonde.getBaggs().size(); j++) {
                            Baggage item = unMonde.getBaggs().get(j);
                            if (!bag.equals(item)) {
                                if (bag.isLeftCollision(item)) {
                                    return true;
                                }
                            }
                            if (checkWallCollision(bag, C.LEFT_COLLISION)) {
                                return true;
                            }
                        }
                        bag.move(-C.SPACE, 0);
                        //isCompleted();
                    }
                }
                return false;

            case C.RIGHT_COLLISION:
                for (int i = 0; i < unMonde.getBaggs().size(); i++) {
                    Baggage bag = unMonde.getBaggs().get(i);
                    if (unMonde.getSoko().isRightCollision(bag)) {
                        for (int j = 0; j < unMonde.getBaggs().size(); j++) {
                            Baggage item = unMonde.getBaggs().get(j);
                            if (!bag.equals(item)) {
                                if (bag.isRightCollision(item)) {
                                    return true;
                                }
                            }
                            if (checkWallCollision(bag, C.RIGHT_COLLISION)) {
                                return true;
                            }
                        }
                        bag.move(C.SPACE, 0);
                       //isCompleted();
                    }
                }
                return false;

            case C.TOP_COLLISION:
                for (int i = 0; i < unMonde.getBaggs().size(); i++) {
                    Baggage bag = unMonde.getBaggs().get(i);
                    if (unMonde.getSoko().isTopCollision(bag)) {
                        for (int j = 0; j < unMonde.getBaggs().size(); j++) {
                            Baggage item = unMonde.getBaggs().get(j);
                            if (!bag.equals(item)) {
                                if (bag.isTopCollision(item)) {
                                    return true;
                                }
                            }
                            if (checkWallCollision(bag, C.TOP_COLLISION)) {
                                return true;
                            }
                        }
                        bag.move(0, -C.SPACE);
                        //isCompleted();
                    }
                }
                return false;

            case C.BOTTOM_COLLISION:
                for (int i = 0; i <unMonde.getBaggs().size(); i++) {
                Baggage bag = unMonde.getBaggs().get(i);
                if (unMonde.getSoko().isBottomCollision(bag)) {
                    for (int j = 0; j < unMonde.getBaggs().size(); j++) {
                        Baggage item = unMonde.getBaggs().get(j);
                        if (!bag.equals(item)) {
                            if (bag.isBottomCollision(item)) {
                                return true;
                            }
                        }
                        if (checkWallCollision(bag,C.BOTTOM_COLLISION)) {
                            return true;
                        }
                    }
                    bag.move(0, C.SPACE);
                   // isCompleted();
                }
            }
            break;

            default:
                break;
        }

        return false;
    }
    public boolean checkWallCollision(Actor actor, int type) {

        switch (type) {
            case C.LEFT_COLLISION:
                for (int i = 0; i < unMonde.getWalls().size(); i++) {
                    Wall wall = unMonde.getWalls().get(i);
                    if (actor.isLeftCollision(wall)) {
                        return true;
                    }
                }
                return false;

            case C.RIGHT_COLLISION:
                for (int i = 0; i < unMonde.getWalls().size(); i++) {
                    Wall wall = unMonde.getWalls().get(i);
                    if (actor.isRightCollision(wall)) {
                        return true;
                    }
                }
                return false;

            case C.TOP_COLLISION:
                for (int i = 0; i < unMonde.getWalls().size(); i++) {
                    Wall wall = unMonde.getWalls().get(i);
                    if (actor.isTopCollision(wall)) {
                        return true;
                    }
                }
                return false;

            case C.BOTTOM_COLLISION:
                for (int i = 0; i <unMonde.getWalls().size(); i++) {
                    Wall wall = unMonde.getWalls().get(i);
                    if (actor.isBottomCollision(wall)) {
                        return true;
                    }
                }
                return false;

            default:
                break;
        }

        return false;
    }
}
