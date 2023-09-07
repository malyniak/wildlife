package plant;

import general.Organism;

public class Plant extends Organism {
    private final int weight = 1;
    private final int maxQuantityInLocation = 200;

    @Override
    public void generate() {
        if (isCanGenerate() && getLocation().getPlantsList().size() < getMaxQuantityInLocation()) {
            Plant plant = new Plant();
          plant.setLocation(getLocation());
            getLocation().getPlantsList().add(plant);
            setCanGenerate(false);
        }
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

    @Override
    public void die() {
        getLocation().getPlantsList().remove(this);
        setAlive(false);
    }

    @Override
    public void run() {

    }
}
