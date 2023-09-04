import java.util.Iterator;
import java.util.List;

public class Mouse extends Herbivore {
    private final double weight=0.05;
    private final int maxQuantityInLocation=500;
    private final int speed=1;
    private final double kgEnoughFood=0.01;
    private double health=50;
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
    public void initCanEat(){
        canEat.put(Plant.class, 100);
        canEat.put(Gusin.class, 90);
    }
    public void run() {}
    public void eat() {
        List<Plant> plantsList = getLocation().getPlantsList();
        Iterator iterator=plantsList.iterator();
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
        for(Animal animal: animalList) {
            if(canEat.containsKey(animal.getClass())) {
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
    public int getSpeed() {
        return speed;
    }

    public double getWeight() {
        return (int)  weight;
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
