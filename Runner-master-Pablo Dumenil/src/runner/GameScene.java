package runner;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class GameScene extends Scene {
    private Camera camera;
    private staticThing right;
    private staticThing left;
    private staticThing start;
    private Hero hero;
    private staticThing heart1;
    private staticThing heart2;
    private staticThing heart3;
    private int numberOfLives=3;
    private int updateCounter=0;
    private int counterVictory=0;
    private Mechant mechant;
    private Mechant mechant2;
    private Mechant mechant3;
    private Mechant mechant4;
    private Mechant mechant5;
    private staticThing gameover;
    private staticThing victory;

    public GameScene(Pane pane, double v, double v1) {
        super(pane, v, v1);
        this.background();
        this.placeHero();
        this.placeHearts();
        this.placeDragon();
        this.placeStart();
        this.placeVictory();
        this.placeGameover();
        this.display(pane);

        timer.start();
    }

    public void background(){
         left=new staticThing(0,0,500,0,300,400,"runner/desert.png");
         right=new staticThing(300,0,0,200,300,0,"runner/desert.png");
    }

    public void placeHero(){
        hero=new Hero();
    }

    public void placeStart() {start=new staticThing(110,100,40,75,385,80,"runner/start.png");}

    public void placeGameover() {gameover= new staticThing(-130,-50,0,0,1,1,"runner/game over.png");}

    public void placeVictory() {victory=new staticThing(-20,-20,0,0,1,1,"runner/th.png");}

    public AnimationTimer getTimer() {return timer;}

    public void placeDragon(){
        mechant=new Mechant();
        mechant.setHauteur(200);
        mechant2=new Mechant();
        mechant2.setX(2000);
        mechant2.setHauteur(190);
        mechant3=new Mechant();
        mechant3.setX(3000);
        mechant3.setHauteur(100);
        mechant4= new Mechant();
        mechant4.setX(4000);
        mechant4.setHauteur(180);
        mechant5=new Mechant();
        mechant5.setX(5000);
        mechant5.setHauteur(190);

    }



    public Hero getHero() {
        return hero;
    }

    public void placeHearts(){
        heart1=new staticThing(10, 10, 1, 5, 28, 27, "runner/heart.png");
        heart2=new staticThing(40, 10, 1, 5, 28, 27, "runner/heart.png");
        heart3=new staticThing(70, 10, 1, 5, 28, 27, "runner/heart.png");

    }

    public void display(Pane pane){
        pane.getChildren().add(right.getImageView());
        pane.getChildren().add(left.getImageView());
        pane.getChildren().add(hero.getImageView());
        pane.getChildren().add(heart1.getImageView());
        pane.getChildren().add(heart2.getImageView());
        pane.getChildren().add(heart3.getImageView());
        pane.getChildren().add(start.getImageView());
        pane.getChildren().add(victory.getImageView());
        pane.getChildren().add(mechant.getImageView());
        pane.getChildren().add(mechant2.getImageView());
        pane.getChildren().add(mechant3.getImageView());
        pane.getChildren().add(mechant4.getImageView());
        pane.getChildren().add(mechant5.getImageView());
        pane.getChildren().add(gameover.getImageView());
    }



    public void update(long time){
        updateCounter=(updateCounter+10)%800;
        counterVictory=counterVictory+1;
        left.getImageView().setViewport(new Rectangle2D(updateCounter, 0,800-updateCounter,400));
        right.getImageView().setViewport(new Rectangle2D(right.getX(), 0, updateCounter,400));
        right.getImageView().setX(800-updateCounter);
        hero.getImageView().setY(hero.getY());
        mechant.getImageView().setY(mechant.getY());
        mechant.getImageView().setX(mechant.getX());
        mechant2.getImageView().setY(mechant2.getY());
        mechant2.getImageView().setX(mechant2.getX());
        mechant3.getImageView().setY(mechant3.getY());
        mechant3.getImageView().setX(mechant3.getX());
        mechant4.getImageView().setY(mechant4.getY());
        mechant4.getImageView().setX(mechant4.getX());
        mechant5.getImageView().setY(mechant5.getY());
        mechant5.getImageView().setX(mechant5.getX());


       if (updateCounter >= 790) {
            start.getImageView().setViewport(new Rectangle2D(0,0,1,1));
        }

        if (  (mechant.Hitbox(hero.getX(),hero.getY(),hero.getW(),hero.getH()) | mechant2.Hitbox(hero.getX(),hero.getY(),hero.getW(),hero.getH())| mechant3.Hitbox(hero.getX(),hero.getY(),hero.getW(),hero.getH())| mechant4.Hitbox(hero.getX(),hero.getY(),hero.getW(),hero.getH())| mechant5.Hitbox(hero.getX(),hero.getY(),hero.getW(),hero.getH())) && hero.getInvincibility()<=0) {

            numberOfLives=numberOfLives-1;
            hero.setInvincibility(100);
            if (numberOfLives==2) {
                heart3.getImageView().setViewport(new Rectangle2D(0,0,1,1));
            }
            if (numberOfLives==1) {
                heart2.getImageView().setViewport(new Rectangle2D(0,0,1,1));
            }
            if (numberOfLives==0) {
                heart1.getImageView().setViewport(new Rectangle2D(0,0,1,1));
                gameover.getImageView().setViewport(new Rectangle2D(0,0,842,480));
            }
        }

        else {
            hero.setInvincibility(hero.getInvincibility()-1);

        }

        if (counterVictory>1850){
            victory.getImageView().setViewport(new Rectangle2D(0,0,639,480));
        }





    }


    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            hero.update(time);
            mechant.update(time);
            mechant2.update(time);
            mechant3.update(time);
            mechant4.update(time);
            mechant5.update(time);
            update(time);
        }


    };


}




