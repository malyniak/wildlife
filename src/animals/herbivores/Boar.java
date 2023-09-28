package animals.herbivores;

import animals.Animal;
import animals.EatAnimal;
import general.Menu;
import plant.Plant;

import java.util.List;
import java.util.Map;

import static general.Constants.*;

public class Boar extends Herbivore implements EatAnimal {
    private final String view = "\uD83D\uDC17";
    private final int weight = 400;
    private final int maxQuantityInLocation = 50;
    private final int speed = 2;
    private final int kgEnoughFood = 50;

    public Boar() {
        setView(view);
        setWeight(weight);
        setMaxQuantityInLocation(maxQuantityInLocation);
        setSpeed(speed);
        setKgEnoughFood(kgEnoughFood);
        initCanEat();
    }

    public void initCanEat() {
        getCanEat().putAll(Map.of(Mouse.class, 50, Gusin.class, 90, Plant.class, 100));
    }

    @Override
    public void eatAnimal() {
<<<<<<< HEAD
        List<Animal> animalsCanBeEaten = animalsForEat();
        Animal animal = animalsCanBeEaten.get(Menu.random.nextInt(animalsCanBeEaten.size()));
        if (Menu.random.nextInt(PERCENT) <= getCanEat().get(animal.getClass())) {
=======
        if (getHealth() >= MAX_HEALTH & checkEatExists())
            return;
        if (getHealth() <= 0) {
            die();
            return;
        }
        List<Animal> animalsToEat = animalsForEat();
        Animal animal = animalsToEat.get(Menu.random.nextInt(animalsToEat.size()));
        if (Menu.random.nextInt(PERCENT + 1) <= getCanEat().get(animal.getClass())) {
>>>>>>> 2e05f0b7ebcdfb4ec7abc153d769734015ee72d3
            double newHealth = getHealth() + (animal.getWeight() * PERCENT / getKgEnoughFood());
            setHealth(newHealth > MAX_HEALTH ? MAX_HEALTH : newHealth);
            System.out.printf("%s ate %s\n", getView(), animal.getView());
            animal.die();
        }
    }

    public void eat() {
        if (getHealth() >= MAX_HEALTH & checkEatExists())
            return;
        if (Menu.random.nextInt(VARIANTS_TO_EAT) == 0) {
            eatAnimal();
        } else
            eatPlant();
    }

    public void run() {
<<<<<<< HEAD
<<<<<<< HEAD
        checkHealth();
        eat();
        generate();
        move();
=======
       if(checkHealth()) {
           eat();
           generate();
           move();
       }
>>>>>>> 7eefecf92e1bbf2ff87c6c088b515d287f4dcc82
=======
        eat();
        generate();
        move();
        setHealth(getHealth() - DECREASE_HEALTH_OF_HUNGER);
>>>>>>> 2e05f0b7ebcdfb4ec7abc153d769734015ee72d3
    }
}
