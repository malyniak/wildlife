package general;

public abstract class Organism implements Runnable {
    private Location[][] island;

    public Location[][] getIsland() {
        return island;
    }

    public void setIsland(Location[][] island) {
        this.island = island;
    }

    private Location location;
    private boolean isCanGenerate=true;
    private boolean isAlive=true;
    public abstract void generate();
    public abstract double getWeight();
    public abstract void die();
    public abstract String getView();
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