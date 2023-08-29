package animal;

import javax.xml.stream.Location;

public abstract class Animal {
    private Location location;
    abstract void generate();
    abstract void eat();
    abstract void move();
    abstract void die();

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
