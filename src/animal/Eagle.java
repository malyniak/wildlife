package animal;

import java.util.HashMap;
import java.util.Map;

public class Eagle extends Predator {
    private final int weight=6;
    private static final int maxQuantityInLocation=20;
    private final int speed=3;
    private final int kgEnoughFood=1;
    private boolean isAlive=true;
    private int health=100;
    Map<Organism, Integer> canEat=new HashMap<>();
    @Override
    public double getHealth() {
        return 0;
    }

    public Eagle() {
        initCanEat();
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
        canEat.put(new Rabbit(), 70);
        canEat.put(new Mouse(), 90);
        canEat.put(new Gusin(), 40);
        canEat.put(new Duck(), 60);
    }

}
