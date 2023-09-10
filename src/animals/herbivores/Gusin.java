package animals.herbivores;

import plant.*;

public class Gusin extends Herbivore {
    private final String view= "\uD83D\uDC1B";
    private final double weight=0.01;
    private final int maxQuantityInLocation=1000;
    private final int speed=0;
    private final int kgEnoughFood=0;
    private double health=50;
    public Gusin() {
        initCanEat();
    }
    public void initCanEat(){
        getCanEat().put(Plant.class, 100);
    }
    @Override
    public double getHealth() {
        return health;
    }
    @Override
    public double getKgEnoughFood() {
        return kgEnoughFood;
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
