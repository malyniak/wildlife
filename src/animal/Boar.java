package animal;

import java.util.HashMap;
import java.util.Map;

public class Boar extends Herbivore{
    private final int weight=400;
    private static final int maxQuantityInLocation=50;
    private final int speed=2;
    private final int kgEnoughFood=50;
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

    @Override
    public void generate() {

    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

    public void initCanEat() {
        canEat.put(Mouse.class, 50);
        canEat.put(Gusin.class, 90);
        canEat.put(Plant.class, 100);
    }

    public Boar() {
        initCanEat();
    }

    @Override
    public void setHealth(double x) {
        this.health=x;
    }
}
