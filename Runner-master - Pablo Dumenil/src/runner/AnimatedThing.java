package runner;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    protected double x;
    protected double y;
    protected ImageView sprite;
    protected int attitude;
    protected int state = 0;
    protected int duration;
    protected int maxIndex;
    protected double w;
    protected double h;
    protected double offsetx;
    protected double offsety;
    private Image image;


    public AnimatedThing(double x, double y, int attitude, int duration, int state, int maxIndex, double w, double h, double offsetx, double offsety, String fileName) {
        Image spriteSheet = new Image(fileName);
        sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(20, 0, 60, 100));
        sprite.setX(x);
        sprite.setY(y);
        this.maxIndex = maxIndex;
        this.attitude = attitude;
        this.duration = duration;
        this.offsetx = offsetx;
        this.offsety = offsety;
        this.w = w;
        this.h = h;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public ImageView getImageView() {
        return sprite;
    }


    public int getAttitude() {
        return attitude;
    }

    public void setAttitude(int attitude) {
        this.attitude = attitude;
    }

    public int getState() {
        return state;
    }

    public void setState(int index) {
        this.state = index;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public void setMaxIndex(int maxIndex) {
        this.maxIndex = maxIndex;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getOffsetx() {
        return offsetx;
    }

    public void setOffsetx(double offsetx) {
        this.offsetx = offsetx;
    }

    public double getOffsety() {
        return offsety;
    }

    public void setOffsety(double offsety) {
        this.offsety = offsety;
    }

    public boolean Hitbox(double xhitbox,double yhitbox, double sizex, double sizey) {
        Rectangle2D hitbox=new Rectangle2D(xhitbox,yhitbox,sizex,sizey);
        return hitbox.intersects(new Rectangle2D(x+30,y+60,w-40,h-10));
    }





    /*public void update(long time) {

        //run

        if ((this.getImageView().getY() >= 250) && (state == 0)) {
            state = state + 1;
        }

        if ((this.getImageView().getY() >= 250) && (state == 1)) {
            sprite.setViewport(new Rectangle2D(20, 0, 60, 100));
        }

        if ((this.getImageView().getY() >= 250) && (state == 2)) {
            sprite.setViewport(new Rectangle2D(95, 0, 70, 100));
        }

        if ((this.getImageView().getY() >= 250) && (state == 3)) {
            sprite.setViewport(new Rectangle2D(170, 10, 85, 90));
        }

        if ((this.getImageView().getY() >= 250) && (state == 4)) {
            sprite.setViewport(new Rectangle2D(270, 10, 65, 90));
        }

        if ((this.getImageView().getY() >= 250) && (state == 5)) {
            sprite.setViewport(new Rectangle2D(345, 0, 70, 100));
        }

        if ((this.getImageView().getY() >= 250) && (state == 6)) {
            sprite.setViewport(new Rectangle2D(425, 15, 80, 85));
        }
        state = (state + 1) % 7;

        //Jump

        if ((JumpOrder == 0) && (this.getImageView().getY() < 250)) {
            sprite.setViewport(new Rectangle2D(95, 160, 70, 105));
            this.getImageView().setY(this.getImageView().getY() + 17);
        }

        // remise de JumpOrder a 0

        if ((JumpOrder==1)&&(this.getImageView().getY() <= 30)) {
            JumpOrder=0;
        }

        //gravité

        if((JumpOrder==0)&&(this.getImageView().getY()<250)){
            sprite.setViewport(new Rectangle2D(95,160,70,105));
            this.getImageView().setY(this.getImageView().getY()+17);
        }
    }

*/
}
    /*public void update() {
        if ((this.getImageView().getY() >= 250) && (index == 0)) {
            state = state + 1;
        }

        if ((this.getImageView().getY() >= 250) && (state == 1)) {
            sprite.setViewport(new Rectangle2D(20, 0, 60, 100));
        }

        if ((this.getImageView().getY() >= 250) && (state == 2)) {
            sprite.setViewport(new Rectangle2D(95, 0, 70, 100));
        }

        if ((this.getImageView().getY() >= 250) && (state == 3)) {
            sprite.setViewport(new Rectangle2D(170, 10, 85, 90));
        }

        if ((this.getImageView().getY() >= 250) && (state == 4)) {
            sprite.setViewport(new Rectangle2D(270, 10, 65, 90));
        }

        if ((this.getImageView().getY() >= 250) && (state == 5)) {
            sprite.setViewport(new Rectangle2D(345, 0, 70, 100));
        }

        if ((this.getImageView().getY() >= 250) && (state == 6)) {
            sprite.setViewport(new Rectangle2D(425, 15, 80, 85));
        }
        state = (state + 1) % 7;
    }

}
*/


/*
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.*;

public class AnimatedThing {

    private Integer state;
    private double posInFenetreX;
    private double posInFenetreY;
    private ImageView imageView;
    private Image image;
    private Integer JumpOrder = 0;
    private double boostOrder = 0;


    public AnimatedThing(String fileName, double posInFenetreX, double posInFenetreY, Integer state) {
        this.state = state;
        this.JumpOrder = JumpOrder;
        this.boostOrder = boostOrder;
        Image heroimage = new Image(fileName);
        ImageView imghero = new ImageView(heroimage);
        imghero.setViewport(new Rectangle2D(20, 0, 60, 100));
        imghero.setX(posInFenetreX);
        imghero.setY(posInFenetreY);
        this.imageView = imghero;
        this.image = heroimage;

    }

    public void update() {

        //Saut
        if ((JumpOrder == 1) && (this.getImageView().getY() > 30)) {
            imageView.setViewport(new Rectangle2D(20, 160, 60, 105));
            this.getImageView().setY(this.getImageView().getY() - 35);
        }

        // remise du saut à 0
        if ((JumpOrder == 1) && (this.getImageView().getY() <= 30)) {
            JumpOrder = 0;
        }

        //gravité
        if ((JumpOrder == 0) && (this.getImageView().getY() < 250)) {
            imageView.setViewport(new Rectangle2D(95, 160, 70, 105));
            this.getImageView().setY(this.getImageView().getY() + 17);
        }

        //update run
        if ((this.getImageView().getY() >= 250) && (state == 0)) {
            state = state + 1;
        }

        if ((this.getImageView().getY() >= 250) && (state == 1)) {
            imageView.setViewport(new Rectangle2D(20, 0, 60, 100));
        }

        if ((this.getImageView().getY() >= 250) && (state == 2)) {
            imageView.setViewport(new Rectangle2D(95, 0, 70, 100));
        }

        if ((this.getImageView().getY() >= 250) && (state == 3)) {
            imageView.setViewport(new Rectangle2D(170, 10, 85, 90));
        }

        if ((this.getImageView().getY() >= 250) && (state == 4)) {
            imageView.setViewport(new Rectangle2D(270, 10, 65, 90));
        }

        if ((this.getImageView().getY() >= 250) && (state == 5)) {
            imageView.setViewport(new Rectangle2D(345, 0, 70, 100));
        }

        if ((this.getImageView().getY() >= 250) && (state == 6)) {
            imageView.setViewport(new Rectangle2D(425, 15, 80, 85));
        }
        state = (state + 1) % 7;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void jump() {
        this.JumpOrder = 1;
        System.out.println("JumpOrder=" + JumpOrder);
    }

    public void boost() {
        this.boostOrder = 1;
        System.out.println("boostorder=" + boostOrder);
    }

    public Image getImage() {
        return image;
    }

    public double getboostorder() {
        return boostOrder;
    }
}
*/