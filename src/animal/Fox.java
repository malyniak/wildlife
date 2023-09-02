package animal;

import java.util.HashMap;
import java.util.Map;

public class Fox extends Herbivore {
    private final int weight = 8;
    private static final int maxQuantityInLocation = 30;
    private final int speed = 2;
    private final int kgEnoughFood = 2;
    private boolean isAlive = true;
    private double health = 50;

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

    @Override
    public void generate() {

    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

    public void initCanEat() {
        canEat.put(Rabbit.class, 70);
        canEat.put(Mouse.class, 90);
        canEat.put(Gusin.class, 40);
        canEat.put(Duck.class, 60);
    }

    @Override
    public void setHealth(double health) {
        this.health=health;
    }
}
