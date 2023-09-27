package animals.predators;

import animals.herbivores.*;

import java.util.Map;

public class Boa extends Predator {
    private final String view = "\uD83D\uDC0D";
    private final int weight = 15;
    private final int maxQuantityInLocation = 30;
    private final int speed = 1;
    private final int kgEnoughFood = 3;

    public Boa() {
        setView(view);
        setWeight(weight);
        setMaxQuantityInLocation(maxQuantityInLocation);
        setSpeed(speed);
        setKgEnoughFood(kgEnoughFood);
        initCanEat();
    }
    public void initCanEat() {
        getCanEat().putAll(Map.of(Fox.class, 15, Rabbit.class, 20, Mouse.class, 40, Duck.class, 10));
    }


}
