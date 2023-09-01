package animal;

public abstract class Organism {
    Location location;
    public abstract double getHealth();

    public abstract void generate();

    public abstract void die(Location location);

    public abstract int getWeight();

    public abstract int getMaxQuantityInLocation();

    public abstract void eat();
    public void setLocation(Location location) {
        this.location=location;
    }

}
