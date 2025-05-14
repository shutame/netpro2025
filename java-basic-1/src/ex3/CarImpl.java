package ex3;
public class CarImpl implements IDrivable {
    public int speed; //privateでは動かなかった。

    @Override
    public void drive(int speed) {
        this.speed = speed;
        System.out.println("Driving at " + this.speed + " kilometers per hour.");
    }

    @Override
    public void stop(int withintime) {
        System.out.println("Stopping in " + withintime + " seconds.");
    }

    @Override
    public int speedUp(int upspeed) {
        this.speed += upspeed;
        return this.speed;
    }

    @Override
    public int speedDown(int dwnspeed) {
        this.speed -= dwnspeed;
        return this.speed;
    }
    
}
