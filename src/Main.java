import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Location[][] locations = new LocationInitializer().getInitializeLocations(100, 20);
    //    for(int i=0; i<locations.length; i++) {
     //       for(int j=0; j<locations[i].length; j++) {
     //           locations[i][j].getAnimalList().forEach(Animal::run);
         //   }
    //    }
        ScheduledExecutorService executorService= Executors.newScheduledThreadPool(100);
        executorService.scheduleAtFixedRate(locations[2][3].animalList.get(50), 1, 10, TimeUnit.SECONDS);



    }


    }