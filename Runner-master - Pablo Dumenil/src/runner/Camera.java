package runner;

/*public class Camera {
    private int x;
    private int y;
    private Hero hero;

    public Camera(int x, int y, Hero hero){
        this.x=x;
        this.y=y;
        this.hero = hero;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void update(long time){
        
    }

    @Override
    public String toString() {
        return "X: " + x + '\'' +
                ", Y: " + y + '\'';

    }
}
*/

public class Camera {
    private double x;
    private double y;
    private double km=1;
    private double fm=1.2;
    private double vx=0;
    private double ax=-300;
    private long past=0;

    public Camera(double x,double y){
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void update(long now,double xhero){
        long dt=now-past;
        ax=km*(xhero-x)+fm*vx;
        double dvx=ax*dt;
        double dx=vx*dt;
        x+=dx;
        vx+=dvx;
        past=now;
        System.out.println(x);
        System.out.println(vx);
    }

    @Override
    public String toString() {
        return "X: " + x + '\'' +
                ", Y: " + y + '\'';

    }
}
