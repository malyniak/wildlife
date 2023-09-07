package animals.herbivores;

import animals.Animal;
import plant.Plant;
import java.util.List;
import java.util.Random;
import static general.Constants.MAX_HEALTH;
import static general.Constants.PERCENT;

public class Mouse extends Herbivore {
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

    public void eat() {
        Random random = new Random();
        List<Animal> animalsToEat = randomAnimalsToEat();
        Animal animal = animalsToEat.get(random.nextInt(animalsToEat.size()));
        if (random.nextInt(PERCENT) <= getCanEat().get(animal.getClass())) {
            if (getHealth() < MAX_HEALTH) {
                double newHealth = getHealth() + (animal.getWeight() * 100 / getKgEnoughFood());
                setHealth(newHealth > MAX_HEALTH ? MAX_HEALTH : newHealth);
                System.out.println(this.getClass().getSimpleName() + " ate " + animal.getClass().getSimpleName());
                animal.die();
            }
        } else {
            List<Plant> plantsList = getLocation().getPlantsList();
            Plant plant = plantsList.get(random.nextInt(plantsList.size()));
            if (getCanEat().containsKey(plant.getClass())) {
                if (getHealth() < MAX_HEALTH) {
                    double newHealth = getHealth() + (plant.getWeight() * 100 / getKgEnoughFood());
                    setHealth(newHealth > MAX_HEALTH ? MAX_HEALTH : newHealth);
                    System.out.println(this.getClass().getSimpleName() + " ate " + plant.getClass().getSimpleName());
                    plant.die();
                }
            }
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
}
