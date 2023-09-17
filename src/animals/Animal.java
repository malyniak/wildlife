package animals;

import exceptions.ClassNotExistException;
import general.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static general.Constants.ANIMAL_FOR_GENERATE;

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

    public void move() {
        int speed = getSpeed();
        int steps = Menu.random.nextInt(speed + 1);
        if (steps > 0) {
            for (int i = 0; i < steps; i++)
                changeLocation();
            setHealth(getHealth() - Constants.DECREASE_HEALTH_AFTER_MOVE);
            System.out.printf("%s move at %s\n", getView(), getLocation());
        }
    }
    public void generate() {
        long countThisKind = getLocation().getAnimalList().stream()
                .filter(x -> x.getClass().equals(this.getClass()))
                .count();
        if (countThisKind < getMaxQuantityInLocation() && countThisKind > ANIMAL_FOR_GENERATE && isCanGenerate()) {
            Animal animal = getLocation().getAnimalList().stream()
                    .skip(Menu.random.nextInt(getLocation().getAnimalList().size()-1))
                    .findFirst().get();
            Animal child = null;
            try {
                child =  new ChildrenFactory().getChild(animal.getClass());
            } catch (ClassNotExistException e) {
                throw new RuntimeException(e);
            }
            getLocation().getAnimalList().add(child);
            child.setLocation(getLocation());
            child.setIsland(getIsland());
            setCanGenerate(false);
            animal.setCanGenerate(false);
            setHealth(getHealth() - Constants.DECREASE_HEALTH_AFTER_GENERATION);
            System.out.printf("%s and %s have a child\n", getView(), animal.getView());
        }
    }


    public void changeLocation() {
        int height = getLocation().getHeight();
        int width = getLocation().getWidth();
        Direction direction = Direction.values()[Menu.random.nextInt(Direction.values().length)];
        long countOfThisKind = getIsland()[width][height - 1].getAnimalList().stream()
                .filter(x -> x.getClass().equals(this.getClass()))
                .count();
        switch (direction) {
            case UP -> {
                if (height > 0 && countOfThisKind < getMaxQuantityInLocation()) {
                    getIsland()[width][height].getAnimalList().remove(this);
                    setLocation(getIsland()[width][--height]);
                    getIsland()[width][height].getAnimalList().add(this);
                }
            }
            case DOWN -> {
                if (height < getIsland().length && countOfThisKind < getMaxQuantityInLocation()) {
                    getIsland()[width][height].getAnimalList().remove(this);
                    setLocation(getIsland()[width][++height]);
                    getIsland()[width][height].getAnimalList().add(this);
                }
            }
            case LEFT -> {
                if (width > 0 && countOfThisKind < getMaxQuantityInLocation()) {
                    getIsland()[width][height].getAnimalList().remove(this);
                    setLocation(getIsland()[--width][height]);
                    getIsland()[width][height].getAnimalList().add(this);
                }
            }
            case RIGHT -> {
                if (width < getIsland()[height].length && countOfThisKind < getMaxQuantityInLocation()) {
                    getIsland()[width][height].getAnimalList().remove(this);
                    setLocation(getIsland()[++width][height]);
                    getIsland()[width][height].getAnimalList().add(this);
                }
            }
            case STAY_OUT -> { return;
            }
        }
    }

    public List<Animal> animalsForEat() {
        return getLocation().getAnimalList().stream()
                .filter(x -> canEat.containsKey(x.getClass()))
                .collect(Collectors.toList());
    }

    @Override
    public void die() {
        getLocation().getAnimalList().remove(this);
        setAlive(false);
    }

    public void checkHealth() {
        if (getHealth() <= 0)
            die();
    }

}


