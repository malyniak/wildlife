package animal;

public class Buffalo extends Herbivore {
    private final int weight=700;
    private static final int maxQuantityInLocation=10;
    private final int speed=3;
    private final int kgEnoughFood=100;
    private boolean isAlive=true;
    private double health=50;

    public int getSpeed() {
        return speed;
    }


    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }




    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void generate() {

    }
    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }
    public void initCanEat() {
        canEat.put(Gusin.class, 90);
    }

    public int getKgEnoughFood() {
        return kgEnoughFood;
    }

    public Buffalo() {
        initCanEat();
    }

    @Override
    public void setHealth(double health) {
        this.health=health;
    }
}
