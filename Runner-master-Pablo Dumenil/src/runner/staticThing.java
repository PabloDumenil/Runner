package runner;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class staticThing {
    private double x;
    private double y;
    private ImageView imageView;

    public staticThing(double posx,double posy,double rect_posX,double rect_posY,double rect_largeur,double rect_hauteur,String fileName){
        Image spriteSheet = new Image(fileName);
        imageView = new ImageView(spriteSheet);
        imageView.setViewport(new Rectangle2D(rect_posX,rect_posY,rect_largeur,rect_hauteur));
        imageView.setX(posx);
        imageView.setY(posy);
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
        return imageView;
    }
}
