package animal;


import java.util.HashMap;
import java.util.Map;

public abstract class Animal extends Organism {
    private Location location;
    private double health=0;
    Map<Class<?>, Integer> canEat=new HashMap<>();

    public void addHealth(int health) {
        this.health += health;
    }


    public void setHealth(double health) {
        this.health = health;
    }


     void move() {}


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
