package animal;

import java.util.HashMap;
import java.util.Map;

public class Wolf extends Predator{

    private static final int weight=50;
    private static final int maxQuantityInLocation=30;
    private static final int speed=3;
    private static final int kgEnoughFood=8;
    private boolean isAlive=true;
   public Map<Organism, Integer> canEat=new HashMap<>();
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
        canEat.put(new Boa(), 80);
        canEat.put(new Horse(), 40);
        canEat.put(new Deer(), 80);
        canEat.put(new Rabbit(), 80);
        canEat.put(new Mouse(), 90);
        canEat.put(new Goat(), 70);
        canEat.put(new Sheep(), 70);
        canEat.put(new Boar(), 50);
        canEat.put(new Buffalo(), 20);
        canEat.put(new Duck(), 10);
    }

}
