package animals.predators;

import animals.herbivores.*;

public class Boa extends Predator {
    private final String view= "\uD83D\uDC0D";
    private final int weight=15;
    private final int maxQuantityInLocation=30;
    private final int speed=1;
    private final int enoughFood=3;
    private double health=50;

    public Boa() {
        initCanEat();
    }
    public void initCanEat(){
        getCanEat().put(Fox.class, 15);
        getCanEat().put(Rabbit.class, 20);
        getCanEat().put(Mouse.class, 40);
        getCanEat().put(Duck.class, 10);
    }
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public double getKgEnoughFood() {
        return enoughFood;
    }

    @Override
    public double getWeight() {
        return weight;
    }
    public String getView() {
        return view;
    }
}
