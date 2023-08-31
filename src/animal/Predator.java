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
    void eat() {
        Set<Organism> organisms = getLocation().map.keySet();
        for(Organism organism:organisms) {
            if(canEat.containsKey(organism)) {
                if(getHealth()<Constants.MAX_HEALTH) {
                   addHealth(organism.getWeight());
                    organism.die();
                }
            }

        }
    }

    @Override
    public void die() {
        if(getHealth()==0) {
            Integer integer = getLocation().map.get(this);
            getLocation().map.put(this, --integer);
          isAlive = false;
        }
    }


    public abstract int getWeight();
    public void move() {

    }

}
