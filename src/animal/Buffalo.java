package animal;

public class Buffalo extends Herbivore {
    private final int weight=700;
    private static final int maxQuantityInLocation=10;
    private final int speed=3;
    private final int kgEnoughFood=100;
    private boolean isAlive=true;
    private int health=100;


    @Override
    public double getHealth() {
        return 0;
    }

    @Override
    public void generate() {

    }

    @Override
    public void die() {

    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }
}
