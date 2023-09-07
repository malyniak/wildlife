import general.Location;
import general.LocationInitializer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Island {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(100);
        Location[][] locations = new LocationInitializer().getInitializeLocations(100, 20);
       for (int i = 0; i < locations.length; i++) {
           for (int j = 0; j < locations[i].length; j++) {
               executorService.scheduleAtFixedRate(locations[i][j].animalList.get(50), 1, 10, TimeUnit.SECONDS);

            }
        }
     //   executorService.scheduleAtFixedRate(locations[2][3].animalList.get(5), 1, 10, TimeUnit.SECONDS);
    }



}