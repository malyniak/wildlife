package animals.herbivores;

import animals.*;
import plant.*;
import java.util.*;
import static general.Constants.*;

public abstract class Herbivore extends Animal implements EatPlant {
    private double health = 50;

    public void eatPlant() {
        Random random = new Random();
        List<Plant> plantsList = getLocation().getPlantsList();
        Plant plant = plantsList.get(random.nextInt(plantsList.size()));
        if (getCanEat().containsKey(plant.getClass())) {
            if (getHealth() < MAX_HEALTH) {
                double newHealth = getHealth() + (plant.getWeight() * 100 / getKgEnoughFood());
                setHealth(newHealth > MAX_HEALTH ? MAX_HEALTH : newHealth);
                System.out.println(getView() + " ate " + plant.getView());
                plant.die();
            }
        }
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            while (getHealth() < MAX_HEALTH) {
            eatPlant();
            }
            move();
            generate();
            if (!isAlive())
                Thread.currentThread().interrupt();


        }
    }

}
