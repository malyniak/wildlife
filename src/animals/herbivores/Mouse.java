package animals.herbivores;

import animals.*;
import plant.Plant;
import java.util.*;
import static general.Constants.*;

public class Mouse extends Herbivore implements EatAnimal {
    private final String view= "\uD83D\uDC01";
    private final double weight = 0.05;
    private final int maxQuantityInLocation = 500;
    private final int speed = 1;
    private final double kgEnoughFood = 0.01;
    private double health = 50;

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public double getKgEnoughFood() {
        return (int) kgEnoughFood;
    }

    public Mouse() {
        initCanEat();
    }

    public void initCanEat() {
        getCanEat().put(Plant.class, 100);
        getCanEat().put(Gusin.class, 90);
    }
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

    @Override
    public int getSpeed() {
        return speed;
    }
    public double getWeight() {
        return (int) weight;
    }
    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }
    public String getView() {
        return view;
    }
}
