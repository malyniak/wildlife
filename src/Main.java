import animal.Boa;
import animal.Location;

public class Main {
    public static void main(String[] args) {
        Location[][] locations=new Location[100][20];
        for(int i=0; i<locations.length; i++) {
            for(int j=0; j<locations[i].length; j++) {
                Location location = new Location(i, j);
                location.setMap();
                locations[i][j]=location;

            }
        }

    }
}