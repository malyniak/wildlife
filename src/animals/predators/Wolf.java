package animals.predators;

import animals.Animal;
import animals.herbivores.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static general.Constants.*;

public class Wolf extends Predator {
    private final String view = "\uD83D\uDC3A";
    private final int weight = 50;
    private final int maxQuantityInLocation = 30;
    private final int speed = 3;
    private final int kgEnoughFood = 8;
    private double health = 50;
    private List<Wolf> wolvesAtLocation;
    public Wolf() {
        initCanEat();
    }

    public void initCanEat() {
        getCanEat().put(Horse.class, 10);
        getCanEat().put(Deer.class, 15);
        getCanEat().put(Rabbit.class, 60);
        getCanEat().put(Mouse.class, 80);
        getCanEat().put(Goat.class, 60);
        getCanEat().put(Sheep.class, 70);
        getCanEat().put(Boar.class, 15);
        getCanEat().put(Buffalo.class, 10);
        getCanEat().put(Duck.class, 40);
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

    public int getSpeed() {
        return speed;
    }

    public double getKgEnoughFood() {
        return kgEnoughFood;
    }

    @Override
    public double getHealth() {
        return health;
    }

    public String getView() {
        return view;
    }
    public List<Wolf> getWolvesAtLocation() {
        wolvesAtLocation = new ArrayList<>();
        for (Animal animal : getLocation().animalList) {
            if (animal instanceof Wolf)
                wolvesAtLocation.add((Wolf) animal);
        }
        return wolvesAtLocation;
    }

    public void eatAnimal() {
        Random random = new Random();
        List<Animal> animalsToEat = randomAnimalsToEat();
        if (getWolvesAtLocation().size() > MIN_COUNT_FOR_WOLF_FLOCK) {
         WolfFlock wolfFlock=new WolfFlock(getWolvesAtLocation());
          wolfFlock.eat();

        } else {
            Animal animal = animalsToEat.get(random.nextInt(animalsToEat.size()));
            if (random.nextInt(PERCENT) <= getCanEat().get(animal.getClass())) {
                if (getHealth() < MAX_HEALTH) {
                    double newHealth = getHealth() + (animal.getWeight() * 100 / getKgEnoughFood());
                    setHealth(newHealth > MAX_HEALTH ? MAX_HEALTH : newHealth);
                    System.out.println(getView() + " ate " + animal.getView());
                    animal.die();
                }
            }
        }
    }

    @Override
    public void die() {
        getLocation().getAnimalList().remove(this);
        setAlive(false);
        Thread.currentThread().interrupt();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            while (getHealth() < MAX_HEALTH) {
                eatAnimal();
            }
            move();
            generate();
            if (!isAlive())
                Thread.currentThread().interrupt();

        }
    }
}

