package plant;

import general.Organism;

public class Plant extends Organism {
    public static final int MAX_QUANTITY_AT_LOCATION = 200;
    private final String view="\uD83C\uDF33";
    private final int weight = 1;


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
    public double getWeight() {
        return weight;
    }

    @Override
    public void die() {
        getLocation().getPlantsList().remove(this);
        setAlive(false);
    }

    @Override
    public String getView() {
        return view;
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            generate();
            if (!isAlive())
                Thread.currentThread().interrupt();
        }

    }
}
