package animals.herbivores;

import plant.*;

public class Buffalo extends Herbivore {
    private final String view = "\uD83D\uDC02";
    private final int weight = 700;
    private final int maxQuantityInLocation = 10;
    private final int speed = 3;
    private final int kgEnoughFood = 100;
    private double health = 50;

    public Buffalo() {
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
        getCanEat().put(Plant.class, 90);
    }

}
