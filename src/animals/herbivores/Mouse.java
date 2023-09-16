package animals.herbivores;

import animals.*;
import general.Menu;
import plant.Plant;
import java.util.*;
import static general.Constants.*;

public class Mouse extends Herbivore implements EatAnimal {
    private final String view= "\uD83D\uDC01";
    private final double weight = 0.05;
    private final int maxQuantityInLocation = 500;
    private final int speed = 1;
    private final double kgEnoughFood = 0.01;

    public Mouse() {
        setView(view);
        setWeight(weight);
        setMaxQuantityInLocation(maxQuantityInLocation);
        setSpeed(speed);
        setKgEnoughFood(kgEnoughFood);
        initCanEat();
    }
    public void initCanEat() {
        getCanEat().put(Plant.class, 100);
        getCanEat().put(Gusin.class, 90);
    }
    public void eatAnimal() {
        List<Animal> animalsToEat = animalsForEat();
        Animal animal = animalsToEat.get(Menu.random.nextInt(animalsToEat.size()));
        if (Menu.random.nextInt(PERCENT+1) <= getCanEat().get(animal.getClass())) {
                double newHealth = getHealth() + (animal.getWeight() * PERCENT / getKgEnoughFood());
                setHealth(newHealth > MAX_HEALTH ? MAX_HEALTH : newHealth);
                System.out.println(getView() + " ate " + animal.getView());
                animal.die();
        }
    }
    public void eat() {
        if (getHealth() >= MAX_HEALTH & checkEatExists())
            return;
        if (Menu.random.nextInt(VARIANTS_TO_EAT)==0) {
            eatAnimal();
        } else
            eatPlant();
    }

    public void run() {
        checkHealth();
        eat();
        generate();
        move();
    }
}
