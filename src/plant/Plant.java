package plant;

import general.Location;
import general.Organism;
import lombok.Getter;

@Getter
public class Plant extends Organism {
    public static final int MAX_QUANTITY_AT_LOCATION = 200;
    private Location[][] island;
    private Location location;
    private final String view = "\uD83C\uDF33";
    private final int weight = 1;
    private boolean isCanGenerate=true;
    private boolean isAlive=true;
    public void setIsland(Location [][] island) {
        this.island = island;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public void setCanGenerate(boolean canGenerate) {
        isCanGenerate = canGenerate;
    }
    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    @Override
    public void generate() {
        if (getLocation().getPlantsList().size() < MAX_QUANTITY_AT_LOCATION) {
            Plant plant = new Plant();
            plant.setLocation(getLocation());
            getLocation().getPlantsList().add(plant);
            setCanGenerate(false);
        }
    }
    @Override
    public void die() {
        getLocation().getPlantsList().remove(this);
        setAlive(false);
    }
    public void run() {
        if (isAlive) {
            generate();
        }
    }
}
