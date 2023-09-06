import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Boar extends Herbivore {
    private final int weight = 400;
    private final int maxQuantityInLocation = 50;
    private final int speed = 2;
    private final int kgEnoughFood = 50;
    private double health = 50;

    public Boar() {
        initCanEat();
    }

    public void initCanEat() {
        canEat.put(Mouse.class, 50);
        canEat.put(Gusin.class, 90);
        canEat.put(Plant.class, 100);
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public double getKgEnoughFood() {
        return kgEnoughFood;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public double getWeight() {
        return weight;
    }

    public void eat() {
        Random random = new Random();
        List<Animal> animalsToEat = randomAnimalsToEat();
        Animal animal = animalsToEat.get(random.nextInt(animalsToEat.size()));
        if (random.nextInt(Constants.PERCENT) <= canEat.get(animal.getClass())) {
            if (getHealth() < Constants.MAX_HEALTH) {
                double newHealth = getHealth() + (animal.getWeight() * 100 / getKgEnoughFood());
                setHealth(newHealth > Constants.MAX_HEALTH ? Constants.MAX_HEALTH : newHealth);
                System.out.println(this.getClass().getSimpleName() + " ate " + animal.getClass().getSimpleName());
                animal.die();
            }
        } else {
            List<Plant> plantsList = getLocation().getPlantsList();
            Plant plant = plantsList.get(random.nextInt(plantsList.size()));
            if (canEat.containsKey(plant.getClass())) {
                if (getHealth() < Constants.MAX_HEALTH) {
                    double newHealth = getHealth() + (plant.getWeight() * 100 / getKgEnoughFood());
                    setHealth(newHealth > Constants.MAX_HEALTH ? Constants.MAX_HEALTH : newHealth);
                    System.out.println(this.getClass().getSimpleName() + " ate " + plant.getClass().getSimpleName());
                    plant.die();
                }
            }
        }
    }

    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }
}
