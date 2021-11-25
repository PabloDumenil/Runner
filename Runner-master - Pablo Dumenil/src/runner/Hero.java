package runner;

import javafx.geometry.Rectangle2D;


public class Hero extends AnimatedThing{
    private double ay;
    private double vy;
    private double g;
    private int counter;
    private int index;
    private int counterJump;
    private int invincibility;

    public Hero() {
        super(20, 250, 0, 33, 0, 5, 80, 100, 85,163,"C:\\Users\\pabdu\\IdeaProjects\\Runner-master\\src\\runner\\heros.png");
        this.counter = 0;
        this.counterJump = 0;
        this.index = 0; //court
        this.g = 10;
        this.invincibility=0;

    }
    public double getvy() { return vy; }
    public int getInvincibility() {return invincibility;}

    public void setInvincibility(int invincibility) {
        this.invincibility = invincibility;
    }

    public void update(long time){
        if(counter==0)
         {
            switch (index) {
                case 0 -> { //perso court
                    if (state >= maxIndex) {
                        state = 0;
                    }
                    else {
                        state++;
                    }
                    sprite.setViewport(new Rectangle2D(state * offsetx, attitude * offsety, w, h));
                }
                case 1 -> { //perso saut vers le haut
                    sprite.setViewport(new Rectangle2D(0,offsety,w,h));
                }
                case 2 ->
                    sprite.setViewport(new Rectangle2D(offsetx,offsety,w,h));



            }


        }
        counter=(counter+1)%5;
        if (y<250) {
            ay = ay - g;
            double deltavy = ay * 0.016;
            vy = vy - deltavy;
            double deltay = vy * 0.016;
            y = y + deltay;
            if (vy > 0) {
                index=2;

            }

        }
        else {
            index=0;
            y = 250;
            counterJump=0;
        }
    }
    public void jump(){

        if (counterJump<2) {
            index=1;
            vy=-200;
            ay=25;
            y=y-1;
            counterJump++;
        }
        //System.out.println("JumpOrder="+JumpOrder);
    }

}

