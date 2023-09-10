package general;

import animals.Animal;
import plant.*;

public class LocationInitializer {
    public Location[][] getInitializeLocations(int width, int height) {
        Location[][] island = new Location[width][height];
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                Location location = new Location(i, j);
                island[i][j]=location;
                for (Animal animal : location.animalList) {
                    animal.setLocation(location);
                    animal.setIsland(island);
                }
                for(Plant plant:location.getPlantsList()) {
                    plant.setLocation(location);
                    plant.setIsland(island);
                }
            }
        } return island;

    }
}
