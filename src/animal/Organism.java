package animal;

import java.util.Iterator;
import java.util.List;

public abstract class Organism {
    Location location;
    Organism pair;
    public boolean isCanGenerate=true;
    public abstract double getHealth();
    public abstract int getKgEnoughFood();


    public abstract void generate();
    public abstract   int getSpeed();

    public abstract void die(Iterator iterator);

    public abstract int getWeight();

    public abstract int getMaxQuantityInLocation();

    public abstract void eat();
    public abstract void move();
    public void setLocation(Location location) {
        this.location=location;
    }

}
