package animal;

import java.util.HashMap;
import java.util.Map;

public class Boar extends Herbivore{
    private final int weight=400;
    private final int maxQuantityInLocation=50;
    private final int speed=2;
    private final int kgEnoughFood=50;
    private boolean isAlive=true;
    private int health=100;
    Map<Organism, Integer> canEat=new HashMap<>();

    @Override
    public double getHealth() {
        return 0;
    }

    @Override
    public void generate() {

    }

    @Override
    public void die() {

    }

    public int getWeight() {
        return weight;
    }
    public void initCanEat() {
        canEat.put(new Mouse(), 50);
        canEat.put(new Gusin(), 90);
        canEat.put(new Plant(), 100);
    }


}
