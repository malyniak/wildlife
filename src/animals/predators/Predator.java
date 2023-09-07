package animals.predators;

import animals.Animal;

import java.util.*;

import static general.Constants.MAX_HEALTH;
import static general.Constants.PERCENT;

public abstract class Predator extends Animal {
    private double health = 50;

    @Override
    public void eat() {
        Random random = new Random();
        List<Animal> animalsToEat = randomAnimalsToEat();
        Animal animal = animalsToEat.get(random.nextInt(animalsToEat.size()));
        if (random.nextInt(PERCENT) <= getCanEat().get(animal.getClass())) {
            if (getHealth() < MAX_HEALTH) {
                double newHealth = getHealth() + (animal.getWeight() * 100 / getKgEnoughFood());
                setHealth(newHealth > MAX_HEALTH ? MAX_HEALTH : newHealth);
                System.out.println(getClass().getSimpleName() + " ate " + animal.getClass().getSimpleName());
                animal.die();
            }
        }

    }
}