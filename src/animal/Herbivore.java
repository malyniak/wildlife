package animal;

import java.util.*;

import static animal.Constants.locations;

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
    public void die(Iterator it) {
      //  Location location = this.getLocation();
        it.remove();
        //    organisms.remove(this);
        isAlive = false;
        System.out.println("organism is not alive");

    }
    public void move() {
        System.out.println(this.getLocation());
        if (!isAlive)
            return;
        int height =getLocation().height;
        int width=getLocation().width;
        Random random=new Random();
        Direction direction = Direction.values()[random.nextInt(Direction.values().length)];
        switch (direction) {
            case UP:
                if(height>0 && InitMenu.getCountOfAnimalKind(locations[height-1][width], this) <getMaxQuantityInLocation())
                { setLocation(locations[height-1][width]); }
            case DOWN:
                if(height<locations.length && InitMenu.getCountOfAnimalKind(locations[height+1][width], this) <getMaxQuantityInLocation())
                { setLocation(locations[height+1][width]); }
            case LEFT:
                if(width>0 && InitMenu.getCountOfAnimalKind(locations[height][width-1], this) <getMaxQuantityInLocation())
                { setLocation(locations[height][width-1]); }
            case RIGHT:
                if(width<locations[height].length && InitMenu.getCountOfAnimalKind(locations[height][width+1], this) <getMaxQuantityInLocation())
                { setLocation(locations[height][width+1]); }
            case STAY_OUT:
                break;
        }
        System.out.println(this.getLocation());



    }
    public abstract void setHealth(double x);

}
