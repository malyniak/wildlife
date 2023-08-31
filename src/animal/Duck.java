package animal;

public class Duck extends Herbivore{
    private final int weight=1;
    private static final int maxQuantityInLocation=200;
    private final int speed=4;
    private final double kgEnoughFood=0.15;
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
