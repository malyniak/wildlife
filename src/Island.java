public class Island {
    private int width;
    private int height;
    private Location[][] locations;

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLocation(Location[][] locations) {
        this.locations = locations;
    }

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        locations=getLocations();
        initialize();

    }

    public Location[][] getLocations() {
        if(locations==null) {
            locations = new Location[width][height];
        }
        return locations;
    }

    public void initialize() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                Location location=new Location(i, j);
                location.setListOfAnimals();
                location.setPlantsList();
                locations[i][j]=location;
                for (Animal animal : location.getAnimalList()) {
                    animal.setLocation(location);
                }
                for (Plant plant : location.getPlantsList()) {
                    plant.setLocation(location);
                }
            }
        }

    }
}
