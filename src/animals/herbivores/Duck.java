package animals.herbivores;

import animals.Animal;
import animals.EatAnimal;
import general.Menu;
import plant.Plant;
import java.util.List;
import java.util.Map;
import static general.Constants.*;

public class Duck extends Herbivore implements EatAnimal {
    private final String view = "\uD83E\uDD86";
    private final int weight = 1;
    private final int maxQuantityInLocation = 200;
    private final int speed = 4;
    private final double kgEnoughFood = 0.15;

    public Duck() {
        setView(view);
        setWeight(weight);
        setMaxQuantityInLocation(maxQuantityInLocation);
        setSpeed(speed);
        setKgEnoughFood(kgEnoughFood);
        initCanEat();
    }

    public void initCanEat() {
        getCanEat().putAll(Map.of(Gusin.class, 90, Plant.class, 100));
    }

    @Override
    public void eatAnimal() {
        List<Animal> animalsCanBeEaten = animalsForEat();
        Animal animal = animalsCanBeEaten.get(Menu.random.nextInt(animalsCanBeEaten.size()));
        if (Menu.random.nextInt(PERCENT + 1) <= getCanEat().get(animal.getClass())) {
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
        if(checkHealth()) {
            eat();
            generate();
            move();
        }
    }
}
