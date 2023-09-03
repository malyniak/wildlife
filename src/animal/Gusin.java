package animal;

public class Gusin extends Herbivore{
    private final double weight=0.01;
    private static final int maxQuantityInLocation=1000;
    private final int speed=0;
    private final int kgEnoughFood=0;
    private boolean isAlive=true;
    private double health=50;


    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public int getKgEnoughFood() {
        return kgEnoughFood;
    }

    @Override
    public void generate() {

    }

    @Override
    public int getSpeed() {
        return speed;
    }


    @Override
    public int getWeight() {
        return 0;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }
    public void initCanEat(){
        canEat.put(Plant.class, 100);
    }

    @Override
    public void setHealth(double health) {
        this.health=health;
    }
}
