
public class Main {
    public static void main(String[] args) {
        Location[][] locations = new LocationInitializer().getInitializeLocations(100, 20);
        for(int i=0; i<locations.length; i++) {
            for(int j=0; j<locations[i].length; j++) {
                locations[i][j].getAnimalList().forEach(Animal::run);
            }
        }
    }
    }