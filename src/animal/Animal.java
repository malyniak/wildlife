package animal;


import java.util.HashMap;
import java.util.Map;

public abstract class Animal extends Organism {
    private Location location;

    Map<Class<?>, Integer> canEat=new HashMap<>();



    public abstract void move();


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
