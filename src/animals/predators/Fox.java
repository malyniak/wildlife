package animals.predators;

import animals.herbivores.*;

import java.util.Map;

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
        getCanEat().putAll(Map.of(Rabbit.class, 70, Mouse.class, 90, Gusin.class, 40, Duck.class, 60));
    }

}
