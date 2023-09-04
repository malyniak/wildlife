public class Horse extends Herbivore {
    private final int weight=400;
    private final int maxQuantityInLocation=20;
    private final int speed=3;
    private final int kgEnoughFood=1;
    private double health=50;
    @Override
    public double getHealth() {
        return health;
    }
    @Override
    public double getKgEnoughFood() {
        return kgEnoughFood;
    }

    public Horse() {
        initCanEat();
    }

    public void initCanEat(){
        canEat.put(Plant.class, 100);
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
    }
    @Override
    public void setHealth(double health) {
        this.health=health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
}
