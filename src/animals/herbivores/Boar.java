package animals.herbivores;

import animals.Animal;
import animals.EatAnimal;
import general.Menu;
import plant.Plant;
import java.util.List;
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
        getCanEat().put(Mouse.class, 50);
        getCanEat().put(Gusin.class, 90);
        getCanEat().put(Plant.class, 100);
    }

    @Override
    public void eatAnimal() {
        List<Animal> animalsToEat = animalsForEat();
        Animal animal = animalsToEat.get(Menu.random.nextInt(animalsToEat.size()));
        if (Menu.random.nextInt(PERCENT) <= getCanEat().get(animal.getClass())) {
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
        eat();
        generate();
        move();
    }
}
