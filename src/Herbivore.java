import java.util.*;

public abstract class Herbivore extends Animal {
   private double health=50;

    @Override
    public void eat() {
        Random random = new Random();
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
    public abstract void setHealth(double health);

}
