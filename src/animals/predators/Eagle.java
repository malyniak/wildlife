package animals.predators;

import animals.herbivores.*;

public class Eagle extends Predator {
    private final String view= "\uD83E\uDD85";
    private final int weight=6;
    private final int maxQuantityInLocation=20;
    private final int speed=3;
    private final int kgEnoughFood=1;
    public Eagle() {
        setView(view);
        setWeight(weight);
        setMaxQuantityInLocation(maxQuantityInLocation);
        setSpeed(speed);
        setKgEnoughFood(kgEnoughFood);
        initCanEat();
    }
    public void initCanEat() {
        getCanEat().put(Fox.class, 10);
        getCanEat().put(Rabbit.class, 90);
        getCanEat().put(Mouse.class, 90);
        getCanEat().put(Duck.class, 80);
    }

}
