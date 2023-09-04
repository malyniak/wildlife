import java.util.*;
public class Location {
    private  Random random=new Random();
    int width;
    int height;

    public Location(int width, int height) {
        this.width = width;
        this.height = height;
        setListOfAnimals();
        setPlantsList();
    }

    public List<Animal> animalList;
    private List<Plant> plantsList=new ArrayList<>();
    public List<Plant> getPlantsList() {
        return plantsList;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setListOfAnimals() {
        animalList = new ArrayList<>();
        Set<Organism> allSpecies = getAllSpecies();
        for (Organism organism : allSpecies) {
            int maxQuantityInLocation = organism.getMaxQuantityInLocation();
           for(int i=0; i<random.nextInt(maxQuantityInLocation); i++) {
               if (organism instanceof Bear) {
                   animalList.add(new Bear());
               } else if (organism instanceof Boa) {
                   animalList.add(new Boa());
               } else if (organism instanceof Boar) {
                   animalList.add(new Boar());
               } else if (organism instanceof Buffalo) {
                   animalList.add(new Buffalo());
               } else if (organism instanceof Deer) {
                   animalList.add(new Deer());

               } else if (organism instanceof Duck) {
                   animalList.add(new Duck());
               } else if (organism instanceof Eagle) {
                   animalList.add(new Eagle());
               } else if (organism instanceof Fox) {
                   animalList.add(new Fox());
               } else if (organism instanceof Goat) {
                   animalList.add(new Goat());
               } else if (organism instanceof Gusin) {
                   animalList.add(new Gusin());
               } else if (organism instanceof Horse) {
                   animalList.add(new Horse());
               } else if (organism instanceof Mouse) {
                   animalList.add(new Mouse());
               } else if (organism instanceof Plant) {
                   plantsList.add(new Plant());}
               else if (organism instanceof Rabbit) {
                   animalList.add(new Rabbit());
               } else if (organism instanceof Sheep) {
                   animalList.add(new Sheep());
               } else if (organism instanceof Wolf) {
                   animalList.add(new Wolf());
               } else
                   break;

           }
        }

    }
    public void setPlantsList() {
        plantsList = new ArrayList<>();
        Set<Organism> allSpecies = getAllSpecies();
        for (Organism organism : allSpecies) {
         if(organism instanceof Plant) {
             int maxQuantityInLocation = organism.getMaxQuantityInLocation();
            for(int i=0; i<random.nextInt(maxQuantityInLocation); i++) {
                plantsList.add(new Plant());
            }
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
