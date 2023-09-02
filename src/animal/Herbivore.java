package animal;

import java.util.*;

public abstract class Herbivore extends Animal{
    boolean isAlive=true;
    double health;
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
                    this.setHealth(newHealth);
                    System.out.println(getHealth());
                    System.out.println("eagle is eating");
                    organism.die(it);
                }
            }
        }

    }
    @Override
   public void move() {
    }
    public void die(Iterator it) {
      //  Location location = this.getLocation();
        it.remove();
        //    organisms.remove(this);
        isAlive = false;
        System.out.println("organism is not alive");

    }
    public abstract void setHealth(double x);

}
