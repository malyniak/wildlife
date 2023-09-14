package animals.herbivores;

import plant.*;
public class Deer extends Herbivore {
    private final String view= "\uD83E\uDD8C";
    private final int weight=300;
    private final int maxQuantityInLocation=10;
    private final int speed=4;
    private final int kgEnoughFood=50;
    private double health=50;
    public Deer() {
        initCanEat();
    }
    @Override
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
    @Override
    public int getSpeed() {
        return speed;
    }
    @Override
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
