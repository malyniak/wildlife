package animals.predators;

import animals.herbivores.*;

public class Wolf extends Predator {

    private final int weight=50;
    private final int maxQuantityInLocation=30;
    private final int speed=3;
    private final int kgEnoughFood=8;
    private double health=50;
    public Wolf() {
        initCanEat();
    }
    public void initCanEat(){
        getCanEat().put(Horse.class, 10);
        getCanEat().put(Deer.class, 15);
        getCanEat().put(Rabbit.class, 60);
        getCanEat().put(Mouse.class, 80);
        getCanEat().put(Goat.class, 60);
        getCanEat().put(Sheep.class, 70);
        getCanEat().put(Boar.class, 15);
        getCanEat().put(Buffalo.class, 10);
        getCanEat().put(Duck.class, 40);
    }
    public double getWeight() {
        return weight;
    }

    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

    public int getSpeed() {
        return speed;
    }

    public double getKgEnoughFood() {
        return kgEnoughFood;
    }
    @Override
    public double getHealth() {
        return health;
    }




}
