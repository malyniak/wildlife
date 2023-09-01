package animal;

import java.util.HashMap;
import java.util.Map;

public class Wolf extends Predator{

    private static final int weight=50;
    private static final int maxQuantityInLocation=30;
    private static final int speed=3;
    private static final int kgEnoughFood=8;
    private boolean isAlive=true;
   public Map<Class<?>, Integer> canEat=new HashMap<>();
    public int getWeight() {
        return weight;
    }

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

    public Wolf() {
        initCanEat();
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public double getHealth() {
        return health;
    }

    public void addHealth(int health) {
        this.health = health;
    }

    private int health=100;

    public void initCanEat(){
        canEat.put(Horse.class, 10);
        canEat.put(Deer.class, 15);
        canEat.put(Rabbit.class, 60);
        canEat.put(Mouse.class, 80);
        canEat.put(Goat.class, 60);
        canEat.put(Sheep.class, 70);
        canEat.put(Boar.class, 15);
        canEat.put(Buffalo.class, 10);
        canEat.put(Duck.class, 40);
    }

}
