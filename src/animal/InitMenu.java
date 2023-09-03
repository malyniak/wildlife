package animal;

import static animal.Constants.locations;

public class InitMenu {
  public static int getCountOfAnimalKind(Location location, Organism organism) {
      int count=0;
      for(Organism org:location.list) {
          if(organism.getClass().equals(org.getClass()))
              count++;
      } return count;
   }
   public void initLocations() {
        for (int i=0; i<locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location(i, j);
                locations[i][j].setMap();
                Location location = locations[i][j];
                location.setMap();

                for (Organism organism : location.getList()) {
                    organism.setLocation(location);
                    //    organism.eat();

                }
            }
        }
    }

}
