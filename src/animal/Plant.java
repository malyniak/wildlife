package animal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Plant extends Organism{
    public  boolean isAlive=true;
    private static final int maxQuantityInLocation = 200;
    double health=0;
    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public int getKgEnoughFood() {
        return 0;
    }

    @Override
    public void generate() {

    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public void die(Iterator iterator) {

    }




    @Override
    public int getWeight() {
        return 1;
    }

    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public void eat() {

    }

    @Override
    public void move() {

    }


}
