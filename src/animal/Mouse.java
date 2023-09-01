package animal;

import java.util.HashMap;
import java.util.Map;

public class Mouse extends Herbivore{
    private final double weight=0.05;
    private static final int maxQuantityInLocation=500;
    private final int speed=1;
    private final double kgEnoughFood=0.01;
    private boolean isAlive=true;
    private int health=100;
    Map<Class<?>, Integer> canEat=new HashMap<>();
    @Override
    public double getHealth() {
        return health;
    }

    public Mouse() {
        initCanEat();
    }

    @Override
    public void generate() {

    }

    public int getWeight() {
        return (int)  weight;
    }

    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

    public void initCanEat(){
        canEat.put(Plant.class, 100);
        canEat.put(Gusin.class, 90);
    }

}
