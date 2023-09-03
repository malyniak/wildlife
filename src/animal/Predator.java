package animal;


import java.util.*;

import static animal.Constants.locations;

public abstract class Predator extends Animal{
    Random random=new Random();
    double health;
    boolean isAlive=true;

    @Override
    public void generate() {
        int countOfThisSpecies=0;
        Organism organism = null;
        for(Organism animal: getLocation().getList()) {
            organism=animal;
            if(animal.getClass().equals(this.getClass())) {

            }
   ////!!!!!
        if(countOfThisSpecies<getMaxQuantityInLocation() && countOfThisSpecies>1) {
            getLocation().getList().add(getKinder(organism));
            this.isCanGenerate = false;
            organism.isCanGenerate = false;

        }
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

        int speed = getSpeed();
        int steps = random.nextInt(speed);
        if(steps>0) {
            for (int i = 0; i < steps; i++) {
                changeLocation();
            }


        }


    }
        public abstract void setHealth ( double health);
    public void changeLocation() {
        if (!isAlive)
            return;
        int height = getLocation().height;
        int width = getLocation().width;

        Direction direction = Direction.values()[random.nextInt(Direction.values().length)];
        switch (direction) {
            case UP:
                if (height > 0 && InitMenu.getCountOfAnimalKind(locations[width][height - 1], this) < getMaxQuantityInLocation()) {
                    setLocation(locations[width][--height]);
                    System.out.println(this.getLocation());
                }
                break;
            case DOWN:
                if (height < locations.length && InitMenu.getCountOfAnimalKind(locations[width][height + 1], this) < getMaxQuantityInLocation()) {
                    setLocation(locations[width][++height]);
                    System.out.println(this.getLocation());
                }
                break;
            case LEFT:
                if (width > 0 && InitMenu.getCountOfAnimalKind(locations[width - 1][height], this) < getMaxQuantityInLocation()) {
                    setLocation(locations[--width][height]);
                    System.out.println(this.getLocation());
                }
                break;
            case RIGHT:
                if (width < locations[height].length && InitMenu.getCountOfAnimalKind(locations[width + 1][height], this) < getMaxQuantityInLocation()) {
                    setLocation(locations[++width][height]);
                    System.out.println(this.getLocation());
                }
                break;
            case STAY_OUT:
                break;
        }
        System.out.println(this.getLocation());
    }
    public Organism getKinder(Organism organism) {
      if(organism instanceof Bear)
          return new Bear();
      else if(organism instanceof Boa)
          return new Boa();
      else if(organism instanceof Buffalo) {
          return new Buffalo();
        }
      else if(organism instanceof Boar)
          return new Boar();
      else if(organism instanceof Deer)
          return new Deer();
      else if(organism instanceof Duck)
          return new Duck();
      else if(organism instanceof Eagle)
          return new Eagle();
      else if(organism instanceof Fox)
          return new Fox();
      else if(organism instanceof Goat)
          return new Goat();
      else if(organism instanceof Gusin)
          return new Gusin();
      else if(organism instanceof Horse)
          return new Horse();
      else if(organism instanceof Mouse)
          return new Mouse();
      else if(organism instanceof Plant)
          return new Plant();
      else if(organism instanceof Rabbit)
          return new Rabbit();
      else if(organism instanceof Sheep)
          return new Sheep();
      else if(organism instanceof Wolf)
          return new Wolf();
      else return null;
    }

}
