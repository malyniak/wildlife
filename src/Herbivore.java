import java.util.*;

public abstract class Herbivore extends Animal {
    double health;

    @Override
    public void eat() {
        Random random = new Random();
        List<Plant> plantsList = getLocation().getPlantsList();
        Iterator iterator = plantsList.iterator();
        while (iterator.hasNext()) {
            Plant plant = (Plant) iterator.next();
            if (canEat.containsKey(plant.getClass())) {
                if (getHealth() < Constants.MAX_HEALTH) {
                    double newHealth = getHealth() + (plant.getWeight() * 100 / getKgEnoughFood());
                    setHealth(newHealth > Constants.MAX_HEALTH ? Constants.MAX_HEALTH : newHealth);
                    System.out.println(this.getClass().getSimpleName() + " ate " + plant.getClass().getSimpleName());
                    plant.die(iterator);
                }
            }
        }
    }

    public abstract void setHealth(double health);

}
