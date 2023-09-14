package animals.herbivores;

import plant.*;
public class Goat extends Herbivore {
    private final String view= "\uD83D\uDC10";
    private final int weight=60;
    private final int maxQuantityInLocation=140;
    private final int speed=3;
    private final int kgEnoughFood=10;
    private double health=50;
    public Goat() {
        initCanEat();
    }
    public String getView() {
        return view;
    }
    @Override
    public double getWeight() {
        return weight;
    }
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
    public void initCanEat(){
        getCanEat().put(Plant.class, 100);
    }










}
