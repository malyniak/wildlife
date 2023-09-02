package animal;

import java.util.*;

public class Location {
    int width;
    int height;

    public Location(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public List<Organism > list;

    public List<Organism> getList() {
        return list;
    }

    public void addToList (Organism organism) {
       list.add(organism);
    }

    public void setMap() {
        list = new ArrayList<>();
        Random random = new Random();
        Set<Organism> allSpecies = getAllSpecies();
        for (Organism organism : allSpecies) {
            int maxQuantityInLocation = organism.getMaxQuantityInLocation();
           for(int i=0; i<random.nextInt(maxQuantityInLocation); i++) {
               if (organism instanceof Bear) {
                   list.add(new Bear());
               } else if (organism instanceof Boa) {
                   list.add(new Boa());
               } else if (organism instanceof Boar) {
                   list.add(new Boar());
               } else if (organism instanceof Buffalo) {
                   list.add(new Buffalo());
               } else if (organism instanceof Deer) {
                   list.add(new Deer());

               } else if (organism instanceof Duck) {
                   list.add(new Duck());
               } else if (organism instanceof Eagle) {
                   list.add(new Eagle());
               } else if (organism instanceof Fox) {
                   list.add(new Fox());
               } else if (organism instanceof Goat) {
                   list.add(new Goat());
               } else if (organism instanceof Gusin) {
                   list.add(new Gusin());
               } else if (organism instanceof Horse) {
                   list.add(new Horse());
               } else if (organism instanceof Mouse) {
                   list.add(new Mouse());
               } else if (organism instanceof Plant) {
                   list.add(new Plant());
               } else if (organism instanceof Rabbit) {
                   list.add(new Rabbit());
               } else if (organism instanceof Sheep) {
                   list.add(new Sheep());
               } else if (organism instanceof Wolf) {
                   list.add(new Wolf());
               } else
                   break;

           }
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
