package animals.predators;

import animals.Animal;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static general.Constants.*;
@Getter
public class WolfFlock {
    private final String view= "\uD83D\uDC3A\uD83D\uDC3A\uD83D\uDC3A";
    private List<Wolf> wolves;
    private Map<Class<?>, Integer> canEat = new HashMap<>();
    public WolfFlock(List<Wolf> wolves) {
        this.wolves = wolves;
    }
    public void eat() {
        Random random = new Random();
        for (Animal animal : wolves.get(0).getLocation().getAnimalList()) {
            while (wolves.size() > MIN_COUNT_FOR_WOLF_FLOCK) {
                if (animal.getClass() != Wolf.class) {
                    double animalWeight = animal.getWeight();
                    System.out.printf("%s ate %s\n", getView(), animal.getView());
                    animal.die();
                    for (Wolf wolf : wolves) {
                        double newHealth = wolf.getHealth() + animalWeight / wolves.size() * PERCENT / wolf.getKgEnoughFood();
                        wolf.setHealth(newHealth > MAX_HEALTH ? MAX_HEALTH : newHealth);
                        if (random.nextInt(PERCENT + 1) < PROBABILITY_DEATH_WOLF_AT_FLOCK)
                            wolf.die();
                    }
                }
            }
        }
    }
}
