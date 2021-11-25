package runner;

import javafx.geometry.Rectangle2D;

public class Mechant extends AnimatedThing {
private int counter;

    public Mechant() {

        super(800,200, 0, 0, 0, 2, 142, 125, 142, 387, "runner/flying_dragon-red.png");
        this.x = 800;
        this.y = 150;
        this.counter = 0;


    }

    public void update(long time){
        x=x-3;
        y=Math.sin(time/300000000)*40 + 205;
        if(counter==0)
                {
                    if (state >= maxIndex) {
                        state = 0;
                    }
                    else {
                        state++;
                    }
                    sprite.setViewport(new Rectangle2D(state * offsetx, offsety, w, h));
                }
        counter=(counter+1)%5;


    }

}
