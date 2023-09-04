import java.util.Iterator;

public abstract class Organism implements Runnable {
    private Location[][] locations;
    private Island island;

    public Island getIsland() {
        return island;
    }

    public void setIsland(Island island) {
        this.island = island;
    }

    public Location[][] getLocations() {
        return island.getLocations();
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }

    private Location location;
    private boolean isCanGenerate=true;
    private boolean isAlive=true;
    public abstract void generate();
    public abstract double getWeight();

    public abstract int getMaxQuantityInLocation();
    public void die(Iterator it) {
        it.remove();
        setAlive(false);
    }
    public boolean isCanGenerate() {
        return isCanGenerate;
    }
    public void setCanGenerate(boolean canGenerate) {
        isCanGenerate = canGenerate;
    }
    public boolean isAlive() {
        return isAlive;
    }

    public Location getLocation() {
        return location;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    public void setLocation(Location location) {
        this.location=location;
    }

}
