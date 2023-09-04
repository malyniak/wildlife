import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Animal extends Organism {
    private boolean willEat=false;



    private Random random = new Random();
    private Location location;

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }
    public boolean isWillEat() {
        return willEat;
    }

    public void setWillEat(boolean willEat) {
        this.willEat = willEat;
    }

    public Random getRandom() {
        return random;
    }

    Map<Class<?>, Integer> canEat = new HashMap<>();

    public abstract void eat();

    public abstract double getHealth();

    public abstract double getKgEnoughFood();

    public abstract int getSpeed();
    public Animal getKinder(Animal animal) {
        if (animal instanceof Bear)
            return new Bear();
        else if (animal instanceof Boa)
            return new Boa();
        else if (animal instanceof Buffalo) {
            return new Buffalo();
        } else if (animal instanceof Boar)
            return new Boar();
        else if (animal instanceof Deer)
            return new Deer();
        else if (animal instanceof Duck)
            return new Duck();
        else if (animal instanceof Eagle)
            return new Eagle();
        else if (animal instanceof Fox)
            return new Fox();
        else if (animal instanceof Goat)
            return new Goat();
        else if (animal instanceof Gusin)
            return new Gusin();
        else if (animal instanceof Horse)
            return new Horse();
        else if (animal instanceof Mouse)
            return new Mouse();
        else if (animal instanceof Rabbit)
            return new Rabbit();
        else if (animal instanceof Sheep)
            return new Sheep();
        else if (animal instanceof Wolf)
            return new Wolf();
        else return null; // must be exception in future
    }
    public void move() {
        int speed = getSpeed();
        int steps = getRandom().nextInt(speed+1);
        if (steps > 0) {
            for (int i = 0; i < steps; i++)
                changeLocation();
        }
    }
    public void generate() {
        int countOfThisSpecies = 0;
         for (Animal animal : getLocation().getAnimalList()) {
            if (animal.getClass().equals(this.getClass()))
                countOfThisSpecies++;

            if (countOfThisSpecies < getMaxQuantityInLocation() && countOfThisSpecies > 1 && isCanGenerate()) {
                getLocation().getAnimalList().add(getKinder(animal));
                animal.setLocation(getLocation());
                setCanGenerate(false);
                animal.setCanGenerate(false);

            }
        }
    }

    public int getCountOfAnimalKind(Location location, Organism organism) {
        int count=0;
        for(Animal animal:location.getAnimalList()) {
            if(organism.getClass().equals(animal.getClass()))
                count++;
        } return count;
    }
    public void changeLocation() {
        int height = getLocation().height;
        int width = getLocation().width;
        Direction direction = Direction.values()[getRandom().nextInt(Direction.values().length)];
        switch (direction) {
            case UP:
                if (height > 0 && getCountOfAnimalKind(getLocations()[width][height - 1], this) < getMaxQuantityInLocation()) {
                   getLocations()[width][height].animalList.remove(this);
                    setLocation(getLocations()[width][--height]);
                    getLocations()[width][height].animalList.add(this);
                }
                break;
            case DOWN:
                if (height < getLocations().length && getCountOfAnimalKind( getLocations()[width][height + 1], this) < getMaxQuantityInLocation()) {
                   getLocations()[width][height].animalList.remove(this);
                    setLocation(getLocations()[width][++height]);
                   getLocations()[width][height].animalList.add(this);
                }
                break;
            case LEFT:
                if (width > 0 && getCountOfAnimalKind(getLocations()[width - 1][height], this) < getMaxQuantityInLocation()) {
                   getLocations()[width][height].animalList.remove(this);
                    setLocation(getLocations()[--width][height]);
                   getLocations()[width][height].animalList.add(this);
                }
                break;
            case RIGHT:
                if (width < getLocations()[height].length && getCountOfAnimalKind(getLocations()[width + 1][height], this) < getMaxQuantityInLocation()) {
                   getLocations()[width][height].animalList.remove(this);
                    setLocation(getLocations()[++width][height]);
                    getLocations()[width][height].animalList.add(this);
                }
                break;
            case STAY_OUT:
                break;
        }
    }
    public void run() {
        eat();
        move();
        generate();
    }

}
