package animal;

import java.util.HashMap;
import java.util.Map;

public class Deer extends Herbivore{
    private final int weight=300;
    private static final int maxQuantityInLocation=10;
    private final int speed=4;
    private final int kgEnoughFood=50;
    private boolean isAlive=true;

    public void setAlive(boolean alive) {
        isAlive = alive;
    }


    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public int getKgEnoughFood() {
        return kgEnoughFood;
    }

    public Deer() {
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
