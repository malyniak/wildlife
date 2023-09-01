package animal;

import java.util.HashMap;
import java.util.Map;

public class Plant extends Organism{
    public  boolean isAlive=true;
    private static final int maxQuantityInLocation = 200;
    Map<Organism, Integer> canEat=new HashMap<>();
    @Override
    public double getHealth() {
        return 0;
    }

    @Override
    public void generate() {

    }

    @Override
    public void die(Location location) {
        isAlive=false;
    }


    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

    @Override
    public void eat() {

    }


}
