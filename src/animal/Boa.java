package animal;

import javax.xml.stream.Location;

public class Boa extends Predator{
    private final int weight=15;
    private static final int maxQuantityInLocation=30;

    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

    public int getSpeed() {
        return speed;
    }


    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }


    private final int speed=1;
    private final int enoughFood=3;
    private boolean isAlive=true;
    private double health=50;


    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public int getKgEnoughFood() {
        return enoughFood;
    }

    public Boa() {
        initCanEat();
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setHealth(double health) {
    this.health=health;
    }

    public void initCanEat(){
        canEat.put(Fox.class, 15);
        canEat.put(Rabbit.class, 20);
        canEat.put(Mouse.class, 40);
        canEat.put(Duck.class, 10);
    }

}
