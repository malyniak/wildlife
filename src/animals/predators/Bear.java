package animals.predators;
import animals.herbivores.*;

public class Bear extends Predator {
    private final String view= "\uD83D\uDC3B";
    private final int weight = 500;
    private final int maxQuantityInLocation = 5;
    private final int speed = 2;
    private final int kgEnoughFood = 80;
    private double health=50;
    public Bear() {
        initCanEat();
    }
    public String getView() {
        return view;
    }
    public double getWeight() {
        return weight;
    }
    @Override
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
    public void initCanEat() {
        getCanEat().put(Boa.class, 80);
        getCanEat().put(Horse.class, 40);
        getCanEat().put(Deer.class, 80);
        getCanEat().put(Rabbit.class, 80);
        getCanEat().put(Mouse.class, 90);
        getCanEat().put(Goat.class, 70);
        getCanEat().put(Sheep.class, 70);
        getCanEat().put(Boar.class, 50);
        getCanEat().put(Buffalo.class, 20);
        getCanEat().put(Duck.class, 10);
    }




}

