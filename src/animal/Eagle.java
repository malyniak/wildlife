package animal;

import java.util.HashMap;
import java.util.Map;

public class Eagle extends Predator {
    private final int weight=6;
    private static final int maxQuantityInLocation=20;
    private final int speed=3;
    private final int kgEnoughFood=1;
    private boolean isAlive=true;
    private double health=50;
    @Override
    public double getHealth() {
        return health;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public int getKgEnoughFood() {
        return kgEnoughFood;
    }

    public Eagle() {
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

    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

    public void initCanEat(){
        canEat.put(Fox.class, 10);
        canEat.put(Rabbit.class, 90);
        canEat.put(Mouse.class, 90);
        canEat.put(Duck.class, 80);
    }


}
