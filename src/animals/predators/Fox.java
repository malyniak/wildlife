package animals.predators;

import animals.herbivores.*;

public class Fox extends Predator {
    private final String view= "\uD83E\uDD8A";
    private final int weight = 8;
    private final int maxQuantityInLocation = 30;
    private final int speed = 2;
    private final int kgEnoughFood = 2;
    private double health = 50;

    public Fox() {
        initCanEat();
    }

    public String getView() {
        return view;
    }
    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }
    @Override
    public int getSpeed() {
        return speed;
    }
    @Override
    public double getKgEnoughFood() {
        return kgEnoughFood;
    }
    @Override
    public double getHealth() {
        return health;
    }
    public void initCanEat() {
        getCanEat().put(Rabbit.class, 70);
        getCanEat().put(Mouse.class, 90);
        getCanEat().put(Gusin.class, 40);
        getCanEat().put(Duck.class, 60);
    }







}
