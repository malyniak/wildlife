package animal;

public class Gusin extends Herbivore{
    private final double weight=0.01;
    private static final int maxQuantityInLocation=1000;
    private final int speed=0;
    private final int kgEnoughFood=0;
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

    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }
    public void initCanEat(){
        canEat.put(Plant.class, 100);
    }
}
