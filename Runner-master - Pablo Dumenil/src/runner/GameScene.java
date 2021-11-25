package runner;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class GameScene extends Scene {
    private Camera camera;
    private staticThing right;
    private staticThing left;
    private Hero hero;
    private staticThing heart1;
    private staticThing heart2;
    private staticThing heart3;
    private int numberOfLives=3;
    private int updateCounter=0;
    private Mechant mechant;

    public GameScene(Pane pane, double v, double v1) {
        super(pane, v, v1);
        this.background();
        this.placeHero();
        this.placeHearts();
        this.placeDragon();
        this.display(pane);

        timer.start();
    }

    public void background(){
         left=new staticThing(0,0,500,0,300,400,"C:\\Users\\pabdu\\IdeaProjects\\Runner-master\\src\\runner\\desert.png");
         right=new staticThing(300,0,0,200,300,0,"C:\\Users\\pabdu\\IdeaProjects\\Runner-master\\src\\runner\\desert.png");
    }
    public void placeHero(){
        hero=new Hero();
    }
    public void placeDragon(){
        mechant =new Mechant();
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
        pane.getChildren().add(mechant.getImageView());
    }

    public void update(long time){
        updateCounter=(updateCounter+10)%800;
        left.getImageView().setViewport(new Rectangle2D(updateCounter, 0,800-updateCounter,400));
        right.getImageView().setViewport(new Rectangle2D(right.getX(), 0, updateCounter,400));
        right.getImageView().setX(800-updateCounter);
        hero.getImageView().setY(hero.getY());
        mechant.getImageView().setY(mechant.getY());
        mechant.getImageView().setX(mechant.getX());

        if (mechant.Hitbox(hero.getX(),hero.getY(),hero.getW(),hero.getH()) && hero.getInvincibility()<=0) {

            numberOfLives=numberOfLives-1;
            hero.setInvincibility(100);
            System.out.println("touché!");
            if (numberOfLives==2) {
                heart3.getImageView().setViewport(new Rectangle2D(0,0,1,1));
            }
            if (numberOfLives==1) {
                heart2.getImageView().setViewport(new Rectangle2D(0,0,1,1));
            }
            if (numberOfLives==0) {
                heart1.getImageView().setViewport(new Rectangle2D(0,0,1,1));
            }
        }

        else {
            hero.setInvincibility(hero.getInvincibility()-1);
            System.out.println(hero.getInvincibility());

        }


    }


    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            hero.update(time);
            mechant.update(time);
            //camera.update(time,hero.getX());
            update(time);
        }


    };

    /* this.setOnKeyPressed(new EventHandler<KeyEvent>() {
        @Override
        public void handle(javafx.scene.input.KeyEvent keyEvent) {
            if (keyEvent.getCode() == KeyCode.UP) {
                hero.jump();
                System.out.println("jump");
            }

        }
    });

*/

}




