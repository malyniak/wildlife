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
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                executorService.scheduleAtFixedRate(locations[i][j].getAnimalList().get(0), 1, 10, TimeUnit.SECONDS);
               List<Animal> animals= locations[i][j].getAnimalList();
                animals.forEach(x->executorService.scheduleAtFixedRate(x, 1, 10, TimeUnit.SECONDS));
               consoleView.showCountAnimals();
            }
        }
    }
}