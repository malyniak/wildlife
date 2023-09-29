package animals.predators;

import animals.Animal;
import animals.herbivores.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static general.Constants.*;

public class Wolf extends Predator {
    private final String view = "\uD83D\uDC3A";
    private final int weight = 50;
    private final int maxQuantityInLocation = 30;
    private final int speed = 3;
    private final int kgEnoughFood = 8;
    private List<Wolf> wolvesAtLocation;
    public Wolf() {
        setView(view);
        setWeight(weight);
        setMaxQuantityInLocation(maxQuantityInLocation);
        setSpeed(speed);
        setKgEnoughFood(kgEnoughFood);
        initCanEat();
    }
    public List<Wolf> getWolvesAtLocation() {
        wolvesAtLocation = new ArrayList<>();
        for (Animal animal : getLocation().getAnimalList()) {
            if (animal instanceof Wolf)
                wolvesAtLocation.add((Wolf) animal);
        }
        return wolvesAtLocation;
    }
    public void initCanEat() {
        getCanEat().putAll(Map.of(Horse.class, 10, Deer.class, 15, Rabbit.class, 60, Mouse.class, 80, Goat.class, 60,
                                  Sheep.class, 70, Boar.class, 15, Buffalo.class, 10, Duck.class, 40));
    }

    public void eatAnimal() {
        Random random = new Random();
        List<Animal> animalsToEat = animalsForEat();
            Animal animal = animalsToEat.get(random.nextInt(animalsToEat.size()));
            if (random.nextInt(PERCENT+1) <= getCanEat().get(animal.getClass())) {
                    double newHealth = getHealth() + (animal.getWeight() * PERCENT / getKgEnoughFood());
                    setHealth(newHealth > MAX_HEALTH ? MAX_HEALTH : newHealth);
                System.out.printf("%s ate %s\n", getView(), animal.getView());
                animal.die();
            }
        }
    @Override
    public void run() {
        if (getHealth() < MAX_HEALTH & checkEatExists()) {
            if(getWolvesAtLocation().size()>MIN_COUNT_FOR_WOLF_FLOCK) {
                WolfFlock wolfFlock = new WolfFlock(getWolvesAtLocation());
                wolfFlock.eat();
            } else eatAnimal();
        }
        generate();
        move();
    }
}

