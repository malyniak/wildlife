package animals.herbivores;

import animals.*;
import general.Menu;
import plant.*;

import java.util.*;

import static general.Constants.*;

public abstract class Herbivore extends Animal implements EatPlant {
    public void eatPlant() {
        if (getHealth() >= MAX_HEALTH & checkEatExists())
            return;
        List<Plant> plantsList = getLocation().getPlantsList();
        Plant plant = plantsList.get(Menu.random.nextInt(plantsList.size()));
        if (getCanEat().containsKey(plant.getClass())) {
            double newHealth = getHealth() + (plant.getWeight() * PERCENT / getKgEnoughFood());
            setHealth(newHealth > MAX_HEALTH ? MAX_HEALTH : newHealth);
            System.out.printf("%s ate %s\n", getView(), plant.getView());
            plant.die();
        }
    }

    public void run() {
<<<<<<< HEAD
            checkHealth();
            eatPlant();
            generate();
            move();
=======
        if (checkHealth()) {
            eatPlant();
            generate();
            move();
        }
>>>>>>> 7eefecf92e1bbf2ff87c6c088b515d287f4dcc82
    }

    public boolean checkEatExists() {
        return !getLocation().getPlantsList().isEmpty();
    }
}
