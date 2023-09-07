package animals.herbivores;

import animals.Animal;
import plant.Plant;
import java.util.List;
import java.util.Random;
import static general.Constants.MAX_HEALTH;
import static general.Constants.PERCENT;

public class Duck extends Herbivore {
    private final int weight=1;
    private final int maxQuantityInLocation=200;
    private final int speed=4;
    private final double kgEnoughFood=0.15;
    private double health=50;

    public Duck() {
        initCanEat();
    }
    public void initCanEat(){
        getCanEat().put(Gusin.class, 90);
        getCanEat().put(Plant.class, 100);
    }
    @Override
    public double getHealth() {
        return health;
    }
    @Override
    public double getKgEnoughFood() {
        return (int) kgEnoughFood;
    }

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

    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }
    @Override
    public void setHealth(double health) {
        this.health=health;
    }
}
