package animal;



public abstract class Animal extends Organism {
    private Location location;


    public void addHealth(int health) {
        this.health = health;
    }
    private double health=0;

    public void setHealth(double health) {
        this.health = health;
    }

    abstract void eat();
    abstract void move();


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
