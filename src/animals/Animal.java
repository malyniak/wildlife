package animals;

import animals.herbivores.*;
import animals.predators.*;
import general.*;
import java.util.*;

public abstract class Animal extends Organism {
    private Random random = new Random();
    private double health = 50;

    public Random getRandom() {
        return random;
    }

    private Map<Class<?>, Integer> canEat = new HashMap<>();

    public Map<Class<?>, Integer> getCanEat() {
        return canEat;
    }

    public abstract double getHealth();
    public abstract int getMaxQuantityInLocation();

    public abstract double getKgEnoughFood();

    public abstract int getSpeed();

    public Animal getKinder(Animal animal) {
        if (animal.getClass().equals(Bear.class))
            return new Bear();
        else if (animal.getClass().equals(Boa.class))
            return new Boa();
        else if (animal.getClass().equals(Buffalo.class)) {
            return new Buffalo();
        } else if (animal.getClass().equals(Boar.class))
            return new Boar();
        else if (animal.getClass().equals(Deer.class))
            return new Deer();
        else if (animal.getClass().equals(Duck.class))
            return new Duck();
        else if (animal.getClass().equals(Eagle.class))
            return new Eagle();
        else if (animal.getClass().equals(Fox.class))
            return new Fox();
        else if (animal.getClass().equals(Goat.class))
            return new Goat();
        else if (animal.getClass().equals(Gusin.class))
            return new Gusin();
        else if (animal.getClass().equals(Horse.class))
            return new Horse();
        else if (animal.getClass().equals(Mouse.class))
            return new Mouse();
        else if (animal.getClass().equals(Rabbit.class))
            return new Rabbit();
        else if (animal.getClass().equals(Sheep.class))
            return new Sheep();
        else if (animal.getClass().equals(Wolf.class))
            return new Wolf();
        else return null; // must be exception in future

    }


    public void move() {
        int speed = getSpeed();
        int steps = getRandom().nextInt(speed + 1);
        if (steps > 0) {
            for (int i = 0; i < steps; i++)
                changeLocation();
            setHealth(getHealth() - Constants.DECREASE_HEALTH_AFTER_MOVE);
            System.out.println(this.getClass().getSimpleName() + " move on general.Location" + getLocation().toString());
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
            child.setIsland(getIsland());
            setCanGenerate(false);
            animal.setCanGenerate(false);
            setHealth(getHealth() - Constants.DECREASE_HEALTH_AFTER_GENERATION);
            System.out.println(this.getClass().getSimpleName() + " hava a child");
        }
    }

    public List<Animal> animalsToGeneration() {
        List<Animal> animalsToGeneration = new ArrayList<>();
        for (Animal animal : getLocation().getAnimalList()) {
            if (animal.getClass().equals(this.getClass())) {
                animalsToGeneration.add(animal);
            }

        }
        return animalsToGeneration;
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
        int height = getLocation().getHeight();
        int width = getLocation().getWidth();
        Direction direction = Direction.values()[getRandom().nextInt(Direction.values().length)];
        switch (direction) {
            case UP:
                if (height > 0 && getCountOfAnimalKind(getIsland()[width][height - 1], this) < getMaxQuantityInLocation()) {
                    getIsland()[width][height].animalList.remove(this);
                    setLocation(getIsland()[width][--height]);
                    getIsland()[width][height].animalList.add(this);
                }
                break;
            case DOWN:
                if (height < getIsland().length && getCountOfAnimalKind(getIsland()[width][height + 1], this) < getMaxQuantityInLocation()) {
                    getIsland()[width][height].animalList.remove(this);
                    setLocation(getIsland()[width][++height]);
                    getIsland()[width][height].animalList.add(this);
                }
                break;
            case LEFT:
                if (width > 0 && getCountOfAnimalKind(getIsland()[width - 1][height], this) < getMaxQuantityInLocation()) {
                    getIsland()[width][height].animalList.remove(this);
                    setLocation(getIsland()[--width][height]);
                    getIsland()[width][height].animalList.add(this);
                }
                break;
            case RIGHT:
                if (width < getIsland()[height].length && getCountOfAnimalKind(getIsland()[width + 1][height], this) < getMaxQuantityInLocation()) {
                    getIsland()[width][height].animalList.remove(this);
                    setLocation(getIsland()[++width][height]);
                    getIsland()[width][height].animalList.add(this);
                }
                break;
            case STAY_OUT:
                break;
        }
    }

    public List<Animal> randomAnimalsToEat() {
        List<Animal> animals = new ArrayList<>();
        for (Animal animal : getLocation().getAnimalList()) {
            if (canEat.containsKey(animal.getClass())) {
                animals.add(animal);
            }
        }
        return animals;
    }
    @Override
    public void die() {
        getLocation().getAnimalList().remove(this);
        setAlive(false);
        System.out.println(getView() +"die");
        Thread.currentThread().interrupt();

    }
}


