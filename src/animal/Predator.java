package animal;


import java.util.*;

public abstract class Predator extends Animal{
    private final int weight=500;
    private final int maxQuantityInLocation=5;
    private final int speed=2;
    private final int kgEnoughFood=80;

    private int health=100;
    Map<Organism, Integer> canEat=new HashMap<>();

    boolean isAlive=true;

    @Override
    public void generate() {

    }

    @Override
    void eat() {
        Set<Organism> organisms = getLocation().map.keySet();
        for(Organism organism:organisms) {
            if(canEat.containsKey(organism)) {
                if(kgEnoughFood!=getHealth()) {
                   addHealth(organism.getWeight());
                    organism.die();
                }
            }

        }
    }

    @Override
    void move() {

    }

    @Override
    public void die() {
        Integer integer = getLocation().map.get(this);
        getLocation().map.put(this, --integer);
        this.isAlive=false;
    }


    public abstract int getWeight();


}
