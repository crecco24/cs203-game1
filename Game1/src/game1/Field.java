package game1;

import java.util.ArrayList;
import java.util.Random;
import javalib.funworld.World;
import javalib.worldimages.*;

public class Field extends World {

    int counter;
    int leftBound;
    int rightBound;
    int upperBound;
    int lowerBound;
    int ballsPerRow = 10;
    int ballsPerColumn = 5;
    //Ball[][] balls = new Ball[ballsPerRow][ballsPerColumn];
    ArrayList<Ball> balls = new ArrayList();
    int radius = 25;

    public Field(int l, int r, int u, int lo) {
        this.leftBound = l;
        this.rightBound = r;
        this.upperBound = u;
        this.lowerBound = lo;

        for (int i = 0; i < ballsPerRow; i++) {
            for (int j = 0; j < ballsPerColumn; j++) {
                int posX = (this.leftBound + radius) + ((2 * i) * radius);
                int posY = (this.lowerBound + radius) + ((2 * j) * radius);
                this.balls.add(new Ball(new Posn(posX, posY), randInt(1, 3), true));
            }
        }
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public WorldImage makeImage() {
        OverlayImages img = new OverlayImages(new DiskImage(this.balls.get(0).position, this.balls.get(0).radius, this.balls.get(0).randColor(this.balls.get(0).type)),
                new DiskImage(this.balls.get(1).position, this.balls.get(1).radius, this.balls.get(1).randColor(this.balls.get(1).type)));

        for (int i = 0; i < balls.size(); i++) {
                img = new OverlayImages(img, new DiskImage(this.balls.get(i).position, this.balls.get(i).radius, this.balls.get(i).randColor(this.balls.get(i).type)));
            }
        
        
        img = new OverlayImages(img, new DiskImage(new Posn((this.leftBound + this.rightBound)/2, (this.upperBound - this.radius)), this.radius, java.awt.Color.BLUE));
        return img;
    }
    
    public Field launch(Field f, Posn p, Ball b, Posn pp){
        Posn cbp = new Posn(p.x+ (pp.x/(pp.x-p.x)), p.y + (pp.y/(pp.y-p.y)));
        Ball bally = new Ball(cbp, b.radius, true);
        
        while(f.stopHuh(bally)!= true){
            launch(f, cbp, b, pp);
        }
        
        Field field = new Field(this.leftBound, this.rightBound, this.upperBound, this.lowerBound);
        field.balls.add(new Ball(cbp, b.type, true));
        return field;
    }
    
    public Boolean stopHuhHelper(Ball b, int i){
        if(b.touching(balls.get(i))){
            return true;
        } else if(stopHuhHelper(b, i + 1)){
            return true;
        } else return false;
    }
    
    public Boolean stopHuh(Ball b){
        return stopHuhHelper(b, 0);
    }
    
    
}
