import general.*;
import java.util.concurrent.*;
public class Island {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        Location[][] locations = new LocationInitializer().getInitializeLocations(100, 20);
        for (int i = 0; i < locations.length; i++) {;
            for (int j = 0; j < locations[i].length; j++) {
                new ConsoleView(locations).showCountOrganismsAtLocation(locations[i][j]);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                executorService.scheduleAtFixedRate(locations[i][j].animalList.get(50), 1, 10, TimeUnit.SECONDS);
            }
        }

    }


}