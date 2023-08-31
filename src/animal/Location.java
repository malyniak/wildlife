package animal;

import java.util.*;

public class Location {
    int width;
    int height;

    public Location(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Map<Organism, Integer> map;

    public Map<Organism, Integer> getMap() {
        return map;
    }

    public void setMap() {
        map = new HashMap<>();
        Random random = new Random();
        Set<Organism> allSpecies = getAllSpecies();
        for (Organism organism : allSpecies) {
            int maxQuantityInLocation = organism.getMaxQuantityInLocation();
            map.put(organism, random.nextInt(maxQuantityInLocation));
        }


    }

    public Set getAllSpecies() {
        HashSet<Organism> organisms = new HashSet<>();
        organisms.add(new Wolf());
        organisms.add(new Boa());
        organisms.add(new Fox());
        organisms.add(new Bear());
        organisms.add(new Eagle());
        organisms.add(new Horse());
        organisms.add(new Deer());
        organisms.add(new Rabbit());
        organisms.add(new Mouse());
        organisms.add(new Goat());
        organisms.add(new Sheep());
        organisms.add(new Boar());
        organisms.add(new Buffalo());
        organisms.add(new Duck());
        organisms.add(new Gusin());
        organisms.add(new Plant());
        return organisms;
    }

}
