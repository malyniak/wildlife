package animals.herbivores;

import plant.*;

public class Buffalo extends Herbivore {
    private final String view = "\uD83D\uDC02";
    private final int weight = 700;
    private final int maxQuantityInLocation = 10;
    private final int speed = 3;
    private final int kgEnoughFood = 100;

    public Buffalo() {
        setView(view);
        setWeight(weight);
        setMaxQuantityInLocation(maxQuantityInLocation);
        setSpeed(speed);
        setKgEnoughFood(kgEnoughFood);
        initCanEat();
    }
    public void initCanEat() {
        getCanEat().put(Plant.class, 90);
    }

}
