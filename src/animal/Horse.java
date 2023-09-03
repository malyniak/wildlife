package animal;

import java.util.HashMap;
import java.util.Map;

public class Horse extends Herbivore{
    private final int weight=400;
    private static final int maxQuantityInLocation=20;

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    private final int speed=3;
    private final int kgEnoughFood=1;
    private boolean isAlive=true;
    private double health=50;
    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public int getKgEnoughFood() {
        return kgEnoughFood;
    }

    public Horse() {
        initCanEat();
    }

    @Override
    public void generate() {

    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

    public void initCanEat(){
        canEat.put(Plant.class, 100);
    }

    @Override
    public void setHealth(double health) {
        this.health=health;
    }
}
