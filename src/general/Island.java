package general;

import animals.Animal;
import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Island {
    private Location[][] locations;
    private final ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(10);

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }

    public void start() {
        ConsoleView consoleView = new ConsoleView(locations);

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
<<<<<<< HEAD
                for (Animal animal : locations[i][j].getAnimalList()) {
                    final ScheduledFuture<?> future = executorService.scheduleWithFixedDelay(() -> {
                        if (animal.isAlive()) {
                         animal.run();
                        }
                    }, 1, 1, TimeUnit.SECONDS);

                }
            }
        }
           checkEndOfIsland(locations);

        }
        public void checkEndOfIsland (Location[][]locations){
            if (Arrays.stream(locations)
                    .map(row -> Arrays.stream(row)
                            .allMatch(x -> x.getAnimalList()
                                    .isEmpty()))
                    .isParallel()) {
                executorService.shutdown();
            }
        }
    }
=======
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
>>>>>>> 7eefecf92e1bbf2ff87c6c088b515d287f4dcc82
