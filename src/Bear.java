public class Bear extends Predator {
    private final int weight = 500;
    private final int maxQuantityInLocation = 5;
    private final int speed = 2;
    private final int kgEnoughFood = 80;
    private double health = 50;
    public double getWeight() {
        return weight;
    }
    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }
    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    public Bear() {
        initCanEat();
    }

    public void initCanEat() {
        canEat.put(Boa.class, 80);
        canEat.put(Horse.class, 40);
        canEat.put(Deer.class, 80);
        canEat.put(Rabbit.class, 80);
        canEat.put(Mouse.class, 90);
        canEat.put(Goat.class, 70);
        canEat.put(Sheep.class, 70);
        canEat.put(Boar.class, 50);
        canEat.put(Buffalo.class, 20);
        canEat.put(Duck.class, 10);
    }
    public int getSpeed() {
        return speed;
    }
    public double getKgEnoughFood() {
        return kgEnoughFood;
    }
    @Override
    public double getHealth() {
        return health;
    }


}

