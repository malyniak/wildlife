package animals.herbivores;

import animals.Animal;
import plant.Plant;

import java.util.*;

import static general.Constants.MAX_HEALTH;

public abstract class Herbivore extends Animal {
   private double health=50;

    @Override
    public void eat() {
        Random random = new Random();
        List<Plant> plantsList = getLocation().getPlantsList();
            Plant plant = plantsList.get(random.nextInt(plantsList.size()));
            if (getCanEat().containsKey(plant.getClass())) {
                if (getHealth() < MAX_HEALTH) {
                    double newHealth = getHealth() + (plant.getWeight() * 100 / getKgEnoughFood());
                    setHealth(newHealth > MAX_HEALTH ? MAX_HEALTH : newHealth);
                    System.out.println(getClass().getSimpleName() + " ate " + plant.getClass().getSimpleName());
                    plant.die();
            }
        }
    }

}
