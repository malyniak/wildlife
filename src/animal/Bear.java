package animal;

import java.util.HashMap;
import java.util.Map;

public class Bear extends Predator{
    private final int weight=500;
    private final int maxQuantityInLocation=5;
    private final int speed=2;
    private final int kgEnoughFood=80;

    private int health=100;
    Map<Organism, Integer> canEat=new HashMap<>();
    public int getWeight() {
        return weight;
    }

    public Bear() {
        initCanEat();
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



    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void addHealth(int health) {
        this.health+=health;
    }

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

    @Override
    public void run() {

    }
}

