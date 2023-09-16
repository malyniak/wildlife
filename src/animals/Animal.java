package animals;

import animals.herbivores.*;
import animals.predators.*;
import exceptions.ClassNotExistException;
import general.*;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static general.Constants.*;
@Getter
@Setter
public abstract class Animal extends Organism {
    private Location[][] island;
    private Location location;
    private double health = 50;
    private boolean isCanGenerate = true;
    private boolean isAlive = true;
    private final Map<Class<?>, Integer> canEat = new HashMap<>();
    private String view;
    private double weight;
    private int maxQuantityInLocation;
    private double kgEnoughFood;
    private int speed;
    public abstract boolean checkEatExists();
    @NotNull
    public Animal getKinder(Animal animal) throws ClassNotExistException {
        if (animal.getClass().equals(Bear.class))
            return new Bear();
        if (animal.getClass().equals(Boa.class))
            return new Boa();
        if (animal.getClass().equals(Buffalo.class))
            return new Buffalo();
        if (animal.getClass().equals(Boar.class))
            return new Boar();
        if (animal.getClass().equals(Deer.class))
            return new Deer();
        if (animal.getClass().equals(Duck.class))
            return new Duck();
        if (animal.getClass().equals(Eagle.class))
            return new Eagle();
        if (animal.getClass().equals(Fox.class))
            return new Fox();
        if (animal.getClass().equals(Goat.class))
            return new Goat();
        if (animal.getClass().equals(Gusin.class))
            return new Gusin();
        if (animal.getClass().equals(Horse.class))
            return new Horse();
        if (animal.getClass().equals(Mouse.class))
            return new Mouse();
        if (animal.getClass().equals(Rabbit.class))
            return new Rabbit();
        if (animal.getClass().equals(Sheep.class))
            return new Sheep();
        if (animal.getClass().equals(Wolf.class))
            return new Wolf();
        else throw new ClassNotExistException(CLASS_NOT_ANIMAL);
    }
    public void move() {
        int speed = getSpeed();
        int steps = Menu.random.nextInt(speed + 1);
        if (steps > 0) {
            for (int i = 0; i < steps; i++)
                changeLocation();
            setHealth(getHealth() - Constants.DECREASE_HEALTH_AFTER_MOVE);
            System.out.println(this.getClass().getSimpleName() + " move at " + getLocation());
        }
    }

    public void generate() {
        List<Animal> animals = animalsToGeneration();
        if (animals.size() < getMaxQuantityInLocation() && animals.size() > ANIMAL_FOR_GENERATE && isCanGenerate()) {
            Animal animal = animals.get(Menu.random.nextInt(animals.size()));
            Animal child = null;
            try {
                child = getKinder(animal);
            } catch (ClassNotExistException e) {
                throw new RuntimeException(e);
            }
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
        Direction direction = Direction.values()[Menu.random.nextInt(Direction.values().length)];
        switch (direction) {
            case UP:
                if (height > 0 && getCountOfAnimalKind(getIsland()[width][height - 1], this) < getMaxQuantityInLocation()) {
                    getIsland()[width][height].getAnimalList().remove(this);
                    setLocation(getIsland()[width][--height]);
                    getIsland()[width][height].getAnimalList().add(this);
                }
                break;
            case DOWN:
                if (height < getIsland().length && getCountOfAnimalKind(getIsland()[width][height + 1], this) < getMaxQuantityInLocation()) {
                    getIsland()[width][height].getAnimalList().remove(this);
                    setLocation(getIsland()[width][++height]);
                    getIsland()[width][height].getAnimalList().add(this);
                }
                break;
            case LEFT:
                if (width > 0 && getCountOfAnimalKind(getIsland()[width - 1][height], this) < getMaxQuantityInLocation()) {
                    getIsland()[width][height].getAnimalList().remove(this);
                    setLocation(getIsland()[--width][height]);
                    getIsland()[width][height].getAnimalList().add(this);
                }
                break;
            case RIGHT:
                if (width < getIsland()[height].length && getCountOfAnimalKind(getIsland()[width + 1][height], this) < getMaxQuantityInLocation()) {
                    getIsland()[width][height].getAnimalList().remove(this);
                    setLocation(getIsland()[++width][height]);
                    getIsland()[width][height].getAnimalList().add(this);
                }
                break;
            case STAY_OUT:
                break;
        }
    }

    public List<Animal> animalsForEat() {
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
        System.out.println(getView() + "die");
    }
    public void checkHealth() {
        if (getHealth() == 0)
            die();
    }

}


