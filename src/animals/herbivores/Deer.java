package animals.herbivores;

import plant.*;
public class Deer extends Herbivore {
    private final String view= "\uD83E\uDD8C";
    private final int weight=300;
    private final int maxQuantityInLocation=10;
    private final int speed=4;
    private final int kgEnoughFood=50;
    private double health=50;
    @Override
    public double getHealth() {
        return health;
    }
    @Override
    public double getKgEnoughFood() {
        return kgEnoughFood;
    }
    public Deer() {
        initCanEat();
    }
    public void initCanEat(){
        getCanEat().put(Plant.class, 100);
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }
    public String getView() {
        return view;
    }

}
