package animal;


import java.util.*;

import static animal.Constants.locations;

public abstract class Predator extends Animal{

    double health;
    boolean isAlive=true;

    @Override
    public void generate() {
        int countOfThisSpecies=0;
        Organism organism = null;
        for(Organism animal: getLocation().getList()) {
            organism=animal;
            if(animal.getClass().equals(this.getClass()))
            countOfThisSpecies++;
        }

        if(countOfThisSpecies<getMaxQuantityInLocation() && countOfThisSpecies>1) {
        getLocation().getList().add(organism);
        this.isCanGenerate=false;
        organism.isCanGenerate=false;


        }
    }

    @Override
    public void eat() {
        List<Organism> organisms = getLocation().getList();
        Iterator it=organisms.iterator();
        while (it.hasNext()) {
            Organism organism = (Organism) it.next();
            if(canEat.containsKey(organism.getClass())) {
                if (getHealth() < Constants.MAX_HEALTH) {
                  int weight= organism.getWeight();
                  int kgen=getKgEnoughFood();
                  double newHealth=getHealth()+(weight*100/kgen);
                  this.setHealth(newHealth>100? Constants.MAX_HEALTH:newHealth);
                    System.out.println(getHealth());
                    System.out.println("eagle is eating");
                    organism.die(it);
                }
            }
            }

        }



    public void die(Iterator it) {
            it.remove();
          isAlive = false;
          System.out.println("organism is not alive");
    }


    public abstract int getWeight();
    public void move() {
        if (!isAlive)
            return;
        int height =getLocation().height;
        int width=getLocation().width;
        Random random=new Random();
        Direction direction = Direction.values()[random.nextInt(Direction.values().length)];
        switch (direction) {
            case UP:
             !!!!   if(height>0 && locations[height-1][width].list.size()<getMaxQuantityInLocation())
             { this.setLocation(locations[height-1][width]); }
            case DOWN:

        }



    }
        public abstract void setHealth ( double health);

}
