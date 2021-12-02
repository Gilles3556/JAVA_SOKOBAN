package pndg.v1.model;

import pndg.v1.ihm.C;

import java.util.ArrayList;

public class World {
    private int no;
    private String level;

    private ArrayList<Actor> worldAll = new ArrayList<>();

    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private ArrayList<Baggage> baggs= new ArrayList<Baggage>();
    private ArrayList<Area> areas= new ArrayList<Area>();
    private Player soko;

    private int w=0;
    private int h=0;

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public void setWorldAll( ArrayList<Actor> worldAll ) {
        this.worldAll = worldAll;
    }

    public ArrayList<Wall> getWalls() {
        return walls;
    }

    public void setWalls( ArrayList<Wall> walls ) {
        this.walls = walls;
    }

    public ArrayList<Baggage> getBaggs() {
        return baggs;
    }

    public void setBaggs( ArrayList<Baggage> baggs ) {
        this.baggs = baggs;
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }

    public void setAreas( ArrayList<Area> areas ) {
        this.areas = areas;
    }

    public Player getSoko() {
        return soko;
    }

    public void setSoko( Player soko ) {
        this.soko = soko;
    }

    public int getNo() {
        return no;
    }

    public ArrayList<Actor> getWorldAll(){
        return worldAll;
    }

    public World(String level){
        this.level = level;
        no=1;
        initWorld();
    }

    public  void initWorld() {
        int x = C.OFFSET;
        int y = C.OFFSET;

        Wall wall;
        Baggage b;
        Area a;

        for (int i = 0; i < level.length(); i++) {
            char item = level.charAt(i);

            switch (item) {

                case '\n':
                    y += C.SPACE;
                    if (w < x) {
                        w = x;
                    }
                    x = C.OFFSET;
                    break;

                case '#':
                    wall = new Wall(x, y);
                    walls.add(wall);
                    x += C.SPACE;
                    break;

                case '$':
                    b = new Baggage(x, y);
                    baggs.add(b);
                    x += C.SPACE;
                    break;

                case '.':
                    a = new Area(x, y);
                    areas.add(a);
                    x += C.SPACE;
                    break;

                case '@':
                    soko = new Player(x, y);
                    x += C.SPACE;
                    break;

                case ' ':
                    x += C.SPACE;
                    break;

                default:
                    break;
            }
            h = y;
        }

        //MAJ du monde
        worldAll.addAll(walls);
        worldAll.addAll(areas);
        worldAll.addAll(baggs);
        worldAll.add(soko);
    }

    public void clear(){
        areas.clear();
        baggs.clear();
        walls.clear();
        worldAll=new ArrayList<>();
    }

    public void nextLevel(){
      no++;
      initWorld();
    }

}
