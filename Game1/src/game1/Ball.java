
package game1;

public class Ball implements Object{
    
    Posn position;
    int type;
    boolean inPlay;
    
    Ball(Posn position, int type, Boolean inPlay){
            this.position = position;
            this.type = type;
            this.inPlay = inPlay;
                    }
    
    public Posn getPosn(){
        return this.position;
    }
    
    public Boolean inPlay(){
        return this.inPlay;
    }
    
    public int ballType(){
        return this.type;
    }
    
    public Boolean equalType(Ball b){
        return this.type == b.type;
    }
    
}
