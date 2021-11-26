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

    public boolean Hitbox(double xhitbox, double yhitbox, double sizex, double sizey) {
        Rectangle2D hitbox = new Rectangle2D(xhitbox, yhitbox, sizex, sizey);
        return hitbox.intersects(new Rectangle2D(x + 30, y + 60, w - 80, h - 90));
    }


}