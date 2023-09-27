package general;

import animals.Animal;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Island {
    private Location[][] locations;

    public Location[][] getLocations() {
        return locations;
    }
    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }
    public void start() {
        ConsoleView consoleView=new ConsoleView(locations);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                List<Animal> animals = locations[i][j].getAnimalList();
                for (Animal animal : animals) {
                    animals.forEach(x -> executorService.scheduleAtFixedRate(() -> {
                        if (animal.isAlive()) {
                            animal.run();
                        }
                    }, 1, 5, TimeUnit.SECONDS));
                    consoleView.showCountAnimals();
                    consoleView.showCountPlants();
                }
            }
        }
    }

}