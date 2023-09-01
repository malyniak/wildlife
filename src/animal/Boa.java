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

    public int getEnoughFood() {
        return enoughFood;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    private final int speed=1;
    private final int enoughFood=3;
    private boolean isAlive=true;
    private int health=100;

    @Override
    public double getHealth() {
        return 0;
    }

    public Boa() {
        initCanEat();
    }

    @Override
    public int getWeight() {
        return 0;
    }

    public void initCanEat(){
        canEat.put(Fox.class, 15);
        canEat.put(Rabbit.class, 20);
        canEat.put(Mouse.class, 40);
        canEat.put(Duck.class, 10);
    }

}
