public class Wolf extends Predator {

    private final int weight=50;
    private final int maxQuantityInLocation=30;
    private final int speed=3;
    private final int kgEnoughFood=8;
    private double health=50;
    public Wolf() {
        initCanEat();
    }
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
    public double getWeight() {
        return weight;
    }

    @Override
    public void setHealth(double health) {
        this.health=health;
    }

    public int getMaxQuantityInLocation() {
        return maxQuantityInLocation;
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
