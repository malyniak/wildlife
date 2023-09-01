package animal;

public class Goat extends Herbivore{
    private final int weight=60;
    private static final int maxQuantityInLocation=140;
    private final int speed=3;
    private final int kgEnoughFood=10;

    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

    public int getSpeed() {
        return speed;
    }

    public int getKgEnoughFood() {
        return kgEnoughFood;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setHealth(int health) {
        this.health = health;
    }

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
    public int getWeight() {
        return 0;
    }
    public void initCanEat(){
        canEat.put(Plant.class, 100);
    }
}
