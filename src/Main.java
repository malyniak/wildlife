import animal.*;

import static animal.Constants.locations;

public class Main {
    public static void main(String[] args) {

        for(int i=0; i<locations.length; i++) {
            for(int j=0; j<locations[i].length; j++) {
                Location location = new Location(i, j);
                location.setMap();
                locations[i][j]=location;
                for(Organism organism:location.getList()) {
                    organism.setLocation(location);
                        organism.eat();
                    }
                }
            }
        }

    }