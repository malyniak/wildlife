package animals.predators;

import animals.*;
import java.util.*;
import static general.Constants.*;

public abstract class Predator extends Animal implements EatAnimal {
    private double health = 50;
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
            eatAnimal();
            }
            move();
            generate();
            if (!isAlive())
                Thread.currentThread().interrupt();

        }
    }
}