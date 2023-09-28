package general;

import animals.Animal;
import animals.herbivores.*;
import animals.predators.*;
import lombok.Getter;
import lombok.Setter;
import plant.Plant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Location {
    int width;
    int height;
    private List<Animal> animalList;
    private List<Plant> plantsList;

    public Location(int width, int height) {
        this.width = width;
        this.height = height;
        setAnimalList();
        setPlantsList();
    }

    public void setAnimalList() {
        animalList = new ArrayList<>();
        Set<Animal> allSpecies = getAllSpecies();
        for (Animal animal : allSpecies) {
            int maxQuantityInLocation = animal.getMaxQuantityInLocation();
            for (int i = 0; i < Menu.random.nextInt(maxQuantityInLocation + 1); i++) {
                if (animal.getClass() == Bear.class) {
                    animalList.add(new Bear());
                } else if (animal.getClass() == Boa.class) {
                    animalList.add(new Boa());
                } else if (animal.getClass() == Boar.class) {
                    animalList.add(new Boar());
                } else if (animal.getClass() == Buffalo.class) {
                    animalList.add(new Buffalo());
                } else if (animal.getClass() == Deer.class) {
                    animalList.add(new Deer());
                } else if (animal.getClass() == Duck.class) {
                    animalList.add(new Duck());
                } else if (animal.getClass() == Eagle.class) {
                    animalList.add(new Eagle());
                } else if (animal.getClass() == Fox.class) {
                    animalList.add(new Fox());
                } else if (animal.getClass() == Goat.class) {
                    animalList.add(new Goat());
                } else if (animal.getClass() == Gusin.class) {
                    animalList.add(new Gusin());
                } else if (animal.getClass() == Horse.class) {
                    animalList.add(new Horse());
                } else if (animal.getClass() == Mouse.class) {
                    animalList.add(new Mouse());
                } else if (animal.getClass() == Rabbit.class) {
                    animalList.add(new Rabbit());
                } else if (animal.getClass() == Sheep.class) {
                    animalList.add(new Sheep());
                } else if (animal.getClass() == Wolf.class) {
                    animalList.add(new Wolf());
                } else
                    break;

            }
        }

    }

    public void setPlantsList() {
        plantsList = new ArrayList<>();
        for (int i = 0; i < Menu.random.nextInt(Plant.MAX_QUANTITY_AT_LOCATION + 1); i++) {
            plantsList.add(new Plant());
        }
    }

    public Set<Animal> getAllSpecies() {
        HashSet<Animal> animals = new HashSet<>();
        animals.add(new Wolf());
        animals.add(new Boa());
        animals.add(new Fox());
        animals.add(new Bear());
        animals.add(new Eagle());
        animals.add(new Horse());
        animals.add(new Deer());
        animals.add(new Rabbit());
        animals.add(new Mouse());
        animals.add(new Goat());
        animals.add(new Sheep());
        animals.add(new Boar());
        animals.add(new Buffalo());
        animals.add(new Duck());
        animals.add(new Gusin());
        return animals;
    }

    @Override
    public String toString() {
        return "Location{" +
                "width=" + width +
                ", height=" + height +
                ", animalList size=" + animalList.size() +
                ", plantsList size=" + plantsList.size() +
                '}';
    }
}
