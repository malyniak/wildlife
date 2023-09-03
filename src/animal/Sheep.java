package animal;

public class Sheep extends Herbivore{
    private final int weight=70;
    private static final int maxQuantityInLocation=140;
    private final int speed=3;
    private final int kgEnoughFood=15;
    private boolean isAlive=true;
    private double health=50;

    @Override
    public double getHealth() {
        return health;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
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
        return weight;
    }

    public Sheep() {
        initCanEat();
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
