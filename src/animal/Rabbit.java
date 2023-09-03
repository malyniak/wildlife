package animal;

import java.util.HashMap;
import java.util.Map;

public class Rabbit extends Herbivore{
    private final int weight=2;
    private static final int maxQuantityInLocation=150;
    private final int speed=2;
    private final double kgEnoughFood= 0.45;
    private boolean isAlive=true;
    private double health=50;

    public Rabbit() {
        initCanEat();
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public int getKgEnoughFood() {
        return (int) kgEnoughFood;
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
