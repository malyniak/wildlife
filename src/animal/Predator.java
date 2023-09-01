package animal;


import java.util.*;

public abstract class Predator extends Animal{
    boolean isAlive=true;

    @Override
    public void generate() {
        Integer numberOfThisAnimal = getLocation().map.get(this);
        if(numberOfThisAnimal>1)
            getLocation().map.put(this, numberOfThisAnimal+2);
    }

    @Override
    public void eat() {
        Set<Organism> organisms = getLocation().map.keySet();
        for(Organism organism:organisms) {
            if(canEat.containsKey(organism.getClass())) {
                if (getHealth() < Constants.MAX_HEALTH) {
                    addHealth(organism.getWeight());
                    System.out.println("eagle is eating");
                    organism.die(this.getLocation());
                }
            }
            }

        }



    public void die(Location location) {
        Integer integer = location.map.get(this);
            location.map.put(this, --integer);
          isAlive = false;
          System.out.println("organism is not alive");

    }


    public abstract int getWeight();
    public void move() {

    }

}
