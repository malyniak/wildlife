package animals.predators;

import animals.herbivores.*;

public class Fox extends Predator {
    private final String view= "\uD83E\uDD8A";
    private final int weight = 8;
    private final int maxQuantityInLocation = 30;
    private final int speed = 2;
    private final int kgEnoughFood = 2;

    public Fox() {
        setView(view);
        setWeight(weight);
        setMaxQuantityInLocation(maxQuantityInLocation);
        setSpeed(speed);
        setKgEnoughFood(kgEnoughFood);
        initCanEat();
    }

    public void initCanEat() {
        getCanEat().put(Rabbit.class, 70);
        getCanEat().put(Mouse.class, 90);
        getCanEat().put(Gusin.class, 40);
        getCanEat().put(Duck.class, 60);
    }

}
