package animal;

import java.util.HashMap;
import java.util.Map;

public class Deer extends Herbivore{
    private final int weight=300;
    private static final int maxQuantityInLocation=10;
    private final int speed=4;
    private final int kgEnoughFood=50;
    private boolean isAlive=true;
    private int health=100;
    Map<Class<?>, Integer> canEat=new HashMap<>();
    @Override
    public double getHealth() {
        return 0;
    }

    public Deer() {
        initCanEat();
    }

    @Override
    public void generate() {

    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

    public void initCanEat(){
        canEat.put(Plant.class, 100);
    }
}
