package animals.predators;
import animals.herbivores.*;

import java.util.Map;

public class Bear extends Predator {
    private final String view= "\uD83D\uDC3B";
    private final int weight = 500;
    private final int maxQuantityInLocation = 5;
    private final int speed = 2;
    private final int kgEnoughFood = 80;
    public Bear() {
        setView(view);
        setWeight(weight);
        setMaxQuantityInLocation(maxQuantityInLocation);
        setSpeed(speed);
        setKgEnoughFood(kgEnoughFood);
        initCanEat();
    }
    public void initCanEat() {
        getCanEat().putAll(Map.of(Boa.class, 80, Horse.class, 40, Deer.class, 80, Rabbit.class, 80, Mouse.class, 90,
                           Goat.class, 70, Sheep.class, 70, Boar.class, 50, Buffalo.class, 20, Duck.class, 10));

    }

}

