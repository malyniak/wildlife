package general;

import animals.Animal;
import general.Location;
import plant.Plant;

public class LocationInitializer {
    public Location[][] getInitializeLocations(int width, int height) {
        Location[][] locations = new Location[width][height];
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                Location location = new Location(i, j);
                locations[i][j]=location;
                for (Animal animal : location.animalList) {
                    animal.setLocation(location);
                    animal.setLocations(locations);
                }
                for(Plant plant:location.getPlantsList()) {
                    plant.setLocation(location);
                    plant.setLocations(locations);
                }
            }
        } return locations;

    }
}
