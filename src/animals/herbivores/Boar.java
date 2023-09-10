package animals.herbivores;

import animals.*;
import plant.*;
import java.util.*;
import static general.Constants.*;

public class Boar extends Herbivore implements EatAnimal {
    private final String view= "\uD83D\uDC17";
    private final int weight = 400;
    private final int maxQuantityInLocation = 50;
    private final int speed = 2;
    private final int kgEnoughFood = 50;
    private double health = 50;

    public Boar() {
        initCanEat();
    }

    public void initCanEat() {
        getCanEat().put(Mouse.class, 50);
        getCanEat().put(Gusin.class, 90);
        getCanEat().put(Plant.class, 100);
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public double getKgEnoughFood() {
        return kgEnoughFood;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public double getWeight() {
        return weight;
    }

    public String getView() {
        return view;
    }
    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }
    @Override
    public void eatAnimal() {
        Random random = new Random();
        List<Animal> animalsToEat = randomAnimalsToEat();
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
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            while (getHealth() < MAX_HEALTH) {
                eatPlant();
                eatAnimal();
            }
            move();
            generate();
            if (!isAlive())
                Thread.currentThread().interrupt();
        }
    }
}
