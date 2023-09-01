package animal;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Herbivore extends Animal{
    boolean isAlive=true;
    @Override
    public void eat() {
        Set<Organism> organisms = getLocation().map.keySet();
        for(Organism organism:organisms) {
            if(canEat.containsKey(organism)) {
                if(getHealth()<Constants.MAX_HEALTH) {
                    addHealth(organism.getWeight());
                    System.out.println("eagle is eating");
                    organism.die(this.getLocation());
                }
            }

        }
    }

    @Override
   public void move() {
    }
    public void die(Location location) {
        Integer integer = location.map.get(this);
      location.map.put(this, --integer);
        isAlive = false;
        System.out.println("organism is alive");
    }

}
