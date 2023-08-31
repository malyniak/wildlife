package animal;

import java.util.HashMap;
import java.util.Map;

public class Mouse extends Herbivore{
    private final double weight=0.05;
    private static final int maxQuantityInLocation=500;
    private final int speed=1;
    private final double kgEnoughFood=0.01;
    private boolean isAlive=true;
    private int health=100;
    Map<Organism, Integer> canEat=new HashMap<>();
    @Override
    public double getHealth() {
        return 0;
    }

    public Mouse() {
        initCanEat();
    }

    @Override
    public void generate() {

    }

    @Override
    public void die() {

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
        canEat.put(new Plant(), 100);
        canEat.put(new Gusin(), 90);
    }

}
