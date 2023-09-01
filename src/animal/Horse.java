package animal;

import java.util.HashMap;
import java.util.Map;

public class Horse extends Herbivore{
    private final int weight=400;
    private static final int maxQuantityInLocation=20;
    private final int speed=3;
    private final int kgEnoughFood=1;
    private boolean isAlive=true;
    private int health=100;
    Map<Class<?>, Integer> canEat=new HashMap<>();
    @Override
    public double getHealth() {
        return health;
    }

    public Horse() {
        initCanEat();
    }

    @Override
    public void generate() {

    }
    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

    public void initCanEat(){
        canEat.put(Plant.class, 100);
    }
}
