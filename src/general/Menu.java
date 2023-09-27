package general;

import animals.Animal;
import exceptions.IncorrectSizeIslandException;
import plant.Plant;
import java.io.*;
import java.util.Random;
import static general.Constants.*;

public class Menu {
    public static volatile Random random = new Random();
    private int width;
    private int height;

    public void getDataFromUser() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(SELECT_WIDTH);
            width = Integer.parseInt(reader.readLine());
            if (width <= 0)
                throw new IncorrectSizeIslandException(INCORRECT_HEIGHT);
            System.out.println(SELECT_HEIGHT);
            height = Integer.parseInt(reader.readLine());
            if (height <= 0)
                throw new IncorrectSizeIslandException(INCORRECT_WIDTH);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void initIsland(Island island) {
        Location[][] locations = new Location[width][height];
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                Location location = new Location(i, j);
                locations[i][j] = location;
                for (Animal animal : location.getAnimalList()) {
                    animal.setLocation(location);
                    animal.setIsland(locations);
                }
                for (Plant plant : location.getPlantsList()) {
                    plant.setLocation(location);
                    plant.setIsland(locations);
                }
            }
        }
        island.setLocations(locations);
    }
}


