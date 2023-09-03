package animal;

import java.util.HashMap;
import java.util.Map;

public class Bear extends Predator{

    private int x=5;
    private int y=5;
    private final int weight=500;
    private static final int maxQuantityInLocation=5;
    private final int speed=2;
    private final int kgEnoughFood=80;
    private int kgFoodEaten=0;
    private double health=50;
    Location location;


 //   @Override
 //   void move() {
  //     setLocation(Constants.AREA[getLocation().width+speed][getLocation().height]);
  //  }

    public int getWeight() {
        return weight;
    }

    @Override
    public void setHealth(double health) {
        this.health=health;
    }

    public Bear() {
        initCanEat();

    }

    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

    public int getSpeed() {
        return speed;
    }

    public int getKgEnoughFood() {
        return kgEnoughFood;
    }

    public boolean isAlive() {
        return isAlive;
    }



    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public double getHealth() {
        return health;
    }




    public void initCanEat(){
        canEat.put(Boa.class, 80);
        canEat.put(Horse.class, 40);
        canEat.put(Deer.class, 80);
        canEat.put(Rabbit.class, 80);
        canEat.put(Mouse.class, 90);
        canEat.put(Goat.class, 70);
        canEat.put(Sheep.class, 70);
        canEat.put(Boar.class, 50);
        canEat.put(Buffalo.class, 20);
        canEat.put(Duck.class, 10);
    }

    public void run() {

    }
}

