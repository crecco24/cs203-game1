package game1;

public class Ball implements Object {

    Posn position;
    int type;
    boolean inPlay;
    double radius = 2;

    Ball(Posn position, int type, Boolean inPlay) {
        this.position = position;
        this.type = type;
        this.inPlay = inPlay;
    }

    public Posn getPosn() {
        return this.position;
    }

    public Boolean inPlay() {
        return this.inPlay;
    }

    public int ballType() {
        return this.type;
    }

    public Boolean equalType(Ball b) {
        return this.type == b.type;
    }

    public Boolean touching(Ball b) {
        if (this.position.x + radius > b.position.x - radius
                && this.position.x + radius < b.position.x + radius) {
            return (this.position.y + radius > b.position.y - radius
                    && this.position.y + radius < b.position.y + radius)
                    || (this.position.y - radius > b.position.y - radius
                    && this.position.y - radius < b.position.y + radius);
        } else if (this.position.x - radius > b.position.x - radius
                && this.position.x - radius < b.position.x + radius) {
            return (this.position.y + radius > b.position.y - radius
                    && this.position.y + radius < b.position.y + radius)
                    || (this.position.y - radius > b.position.y - radius
                    && this.position.y - radius < b.position.y + radius);
        } else {
            return false;
        }
    }
    
    //unfinished method, must think more thoroughly about how to move
    // ball over small iterations, checking to see if it comes in contact
    // with a wall or ball forcing a stop.
    public Ball move(Posn p){
        return new Ball(p, this.type, true);
    }
}
