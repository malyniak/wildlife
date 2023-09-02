package animal;

public class Duck extends Herbivore{
    private final int weight=1;
    private static final int maxQuantityInLocation=200;
    private final int speed=4;
    private final double kgEnoughFood=0.15;
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
        return (int) kgEnoughFood;
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
    public void initCanEat(){
        canEat.put(Gusin.class, 90);
        canEat.put(Plant.class, 100);
    }

    public Duck() {
        initCanEat();
    }

    @Override
    public void setHealth(double health) {
        this.health=health;
    }
}
