package animals.predators;

import animals.herbivores.*;

public class Eagle extends Predator {
    private final int weight=6;
    private final int maxQuantityInLocation=20;
    private final int speed=3;
    private final int kgEnoughFood=1;
    private double health=50;
    public Eagle() {
        initCanEat();
    }
    public void initCanEat() {
        getCanEat().put(Fox.class, 10);
        getCanEat().put(Rabbit.class, 90);
        getCanEat().put(Mouse.class, 90);
        getCanEat().put(Duck.class, 80);
    }
    @Override
    public double getHealth() {
        return health;
    }
    @Override
    public double getKgEnoughFood() {
        return kgEnoughFood;
    }
    @Override
    public int getSpeed() {
        return speed;
    }
    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

}
