public class Buffalo extends Herbivore {
    private final int weight=700;
    private final int maxQuantityInLocation=10;
    private final int speed=3;
    private final int kgEnoughFood=100;
    private double health = 50;
    public Buffalo() {
        initCanEat();
    }
    public void initCanEat() {
        canEat.put(Plant.class, 90);
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public double getHealth() {
        return health;
    }
    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }

    public double getKgEnoughFood() {
        return kgEnoughFood;
    }
    @Override
    public void setHealth(double health) {
        this.health=health;
    }
}
