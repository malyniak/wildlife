package animals.herbivores;

import animals.*;
import plant.Plant;
import java.util.List;
import java.util.Random;
import static general.Constants.*;

public class Duck extends Herbivore implements EatAnimal {
    private final String view= "\uD83E\uDD86";
    private final int weight = 1;
    private final int maxQuantityInLocation = 200;
    private final int speed = 4;
    private final double kgEnoughFood = 0.15;
    private double health = 50;

    public Duck() {
        initCanEat();
    }
    @Override
    public String getView() {
        return view;
    }

    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }
    @Override
    public int getSpeed() {
        return speed;
    }
    @Override
    public double getKgEnoughFood() {
        return  kgEnoughFood;
    }
    @Override
    public double getHealth() {
        return health;
    }

    public void initCanEat() {
        getCanEat().put(Gusin.class, 90);
        getCanEat().put(Plant.class, 100);
    }
    @Override
    public void eatAnimal() {
        Random random = new Random();
        List<Animal> animalsToEat = randomAnimalsToEat();
        Animal animal = animalsToEat.get(random.nextInt(animalsToEat.size()));
        if (random.nextInt(PERCENT) <= getCanEat().get(animal.getClass())) {
                double newHealth = getHealth() + (animal.getWeight() * 100 / getKgEnoughFood());
                setHealth(newHealth > MAX_HEALTH ? MAX_HEALTH : newHealth);
                System.out.println(getView() + " ate " + animal.getView());
                animal.die();
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
