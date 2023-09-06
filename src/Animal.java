import java.util.*;

public abstract class Animal extends Organism {
    private Random random = new Random();
    private double health = 50;

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
        int steps = getRandom().nextInt(speed + 1);
        if (steps > 0) {
            for (int i = 0; i < steps; i++)
                changeLocation();
            setHealth(getHealth()-Constants.DECREASE_HEALTH_AFTER_MOVE);
            System.out.println(getHealth()+" "+ this.getClass().getSimpleName()+ " move on Location"+getLocation().toString());
        }
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void generate() {
        List<Animal> animals = animalsToGeneration();
        if (animals.size() < getMaxQuantityInLocation() && animals.size() > 1 && isCanGenerate()) {
            Animal animal = animals.get(random.nextInt(animals.size()));
            Animal child = getKinder(animal);
            getLocation().getAnimalList().add(child);
            child.setLocation(getLocation());
            child.setLocations(getLocations());
            setCanGenerate(false);
            animal.setCanGenerate(false);
            setHealth(getHealth()-Constants.DECREASE_HEALTH_AFTER_GENERATION);
            System.out.println(this.getClass().getSimpleName()+" hava a child");
        }
    }

    public List<Animal> animalsToGeneration() {
        List<Animal> animalsToGeneration = new ArrayList<>();
        for (Animal animal : getLocation().getAnimalList()) {
            if (animal.getClass().equals(this.getClass())) {
                animalsToGeneration.add(animal);
            }

        } return animalsToGeneration;
    }

    public int getCountOfAnimalKind(Location location, Organism organism) {
        int count = 0;
        for (Animal animal : location.getAnimalList()) {
            if (organism.getClass().equals(animal.getClass()))
                count++;
        }
        return count;
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
                if (height < getLocations().length && getCountOfAnimalKind(getLocations()[width][height + 1], this) < getMaxQuantityInLocation()) {
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
    public List<Animal> randomAnimalsToEat() {
        List<Animal> animals=new ArrayList<>();
        for(Animal animal:getLocation().getAnimalList()) {
            if(canEat.containsKey(animal.getClass())) {
                animals.add(animal);
            }
        } return animals;
    }

    public void run() {
        if (isAlive()) {
        }
        while (getHealth() < Constants.MAX_HEALTH) {
            eat();
        }
        move();
        generate();
    }

    @Override
    public void die() {
        getLocation().getAnimalList().remove(this);
        setAlive(false);
    }
}
