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
<<<<<<< HEAD
        List<Animal> animalsCanBeEaten = animalsForEat();
        Animal animal = animalsCanBeEaten.get(Menu.random.nextInt(animalsCanBeEaten.size()));
=======
        else if (getHealth() <= 0) {
            die();
            return;
        }
        List<Animal> animalsToEat = animalsForEat();
        Animal animal = animalsToEat.get(Menu.random.nextInt(animalsToEat.size()));
>>>>>>> 2e05f0b7ebcdfb4ec7abc153d769734015ee72d3
        if (Menu.random.nextInt(PERCENT + 1) <= getCanEat().get(animal.getClass())) {
            double newHealth = getHealth() + (animal.getWeight() * PERCENT / getKgEnoughFood());
            setHealth(newHealth > MAX_HEALTH ? MAX_HEALTH : newHealth);
            System.out.printf("%s ate %s\n", getView(), animal.getView());
            animal.die();
        }
    }

    public boolean checkEatExists() {
        return !animalsForEat().isEmpty();
    }
    public void run() {
            eatAnimal();
            generate();
            move();
            setHealth(getHealth()-DECREASE_HEALTH_OF_HUNGER);
    }
}