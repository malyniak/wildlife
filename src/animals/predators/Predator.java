package animals.predators;

import animals.*;
import general.Menu;
import java.util.*;
import static general.Constants.*;

public abstract class Predator extends Animal implements EatAnimal {
    @Override
    public void eatAnimal() {
        if (getHealth() >= MAX_HEALTH & checkEatExists())
            return;
        else if (getHealth() <= 0) {
            die();
            return;
        }
        List<Animal> animalsToEat = animalsForEat();
        Animal animal = animalsToEat.get(Menu.random.nextInt(animalsToEat.size()));
        if (Menu.random.nextInt(PERCENT + 1) <= getCanEat().get(animal.getClass())) {
            double newHealth = getHealth() + (animal.getWeight() * PERCENT / getKgEnoughFood());
            setHealth(newHealth > MAX_HEALTH ? MAX_HEALTH : newHealth);
            System.out.printf("%s ate %s\n", getView(), animal.getView());
            animal.die();
        }
    }

    public boolean checkEatExists() {
        List<Animal> animals = getLocation().getAnimalList();
        for (Animal animal : animals) {
            if (animal.getClass() == this.getClass())
                return true;
        }
        return false;
    }
    public void run() {
            eatAnimal();
            generate();
            move();
            setHealth(getHealth()-DECREASE_HEALTH_OF_HUNGER);
    }
}