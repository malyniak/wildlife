package animals.herbivores;
import plant.*;

public class Sheep extends Herbivore {
    private final String view= "\uD83D\uDC11";
    private final int weight = 70;
    private final int maxQuantityInLocation = 140;
    private final int speed = 3;
    private final int kgEnoughFood = 15;
    private double health = 50;

    public Sheep() {
        initCanEat();
    }
    public String getView() {
        return view;
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
    public int getSpeed() {
        return speed;
    }
    @Override
    public double getKgEnoughFood() {
        return kgEnoughFood;
    }
    @Override
    public double getHealth() {
        return health;
    }
    public void initCanEat() {
        getCanEat().put(Plant.class, 100);
    }











}