package animals.predators;

import animals.herbivores.*;

public class Eagle extends Predator {
    private final String view= "\uD83E\uDD85";
    private final int weight=6;
    private final int maxQuantityInLocation=20;
    private final int speed=3;
    private final int kgEnoughFood=1;
    private double health=50;
    public Eagle() {
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
        getCanEat().put(Fox.class, 10);
        getCanEat().put(Rabbit.class, 90);
        getCanEat().put(Mouse.class, 90);
        getCanEat().put(Duck.class, 80);
    }







}
