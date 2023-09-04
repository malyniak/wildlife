

public class Main {
    public static void main(String[] args) {
        Island island = new Island(100, 20);
        for(int i=0; i<island.getLocations().length; i++) {
            for(int j=0; j<island.getLocations()[i].length; j++) {
                for(Animal animal:island.getLocations()[i][j].animalList) {
                    animal.setLocation(island.getLocations()[i][j]);
                    animal.run();
                }
            }
        }
    }
}