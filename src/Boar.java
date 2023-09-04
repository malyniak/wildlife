import java.util.Iterator;
import java.util.List;

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
        List<Plant> plantsList = getLocation().getPlantsList();
        Iterator iterator = plantsList.iterator();
        while (iterator.hasNext()) {
            Plant plant = (Plant) iterator.next();
            if (canEat.containsKey(plant.getClass())) {
                if (getHealth() < Constants.MAX_HEALTH) {
                    double weight = plant.getWeight();
                    double kgen = getKgEnoughFood();
                    double newHealth = getHealth() + (weight * 100 / kgen);
                    this.setHealth(newHealth > 100 ? Constants.MAX_HEALTH : newHealth);
                    System.out.println(getHealth());
                    System.out.println("eagle is eating plant");
                    plant.die(iterator);
                }
            }
        }
        List<Animal> animalList = getLocation().getAnimalList();
        for (Animal animal : animalList) {
            if (canEat.containsKey(animal.getClass())) {
                if (getHealth() < Constants.MAX_HEALTH) {
                    double weight = animal.getWeight();
                    double kgen = getKgEnoughFood();
                    double newHealth = getHealth() + (weight * 100 / kgen);
                    this.setHealth(newHealth > 100 ? Constants.MAX_HEALTH : newHealth);
                    System.out.println(getHealth());
                    System.out.println("eagle is eating plant");
                    animal.die(iterator);
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
