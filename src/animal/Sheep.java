package animal;

public class Sheep extends Herbivore{
    private final int weight=70;
    private static final int maxQuantityInLocation=140;
    private final int speed=3;
    private final int kgEnoughFood=15;
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
}
