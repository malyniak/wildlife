package animals.herbivores;
import plant.*;

public class Rabbit extends Herbivore {
    private final String view= "\uD83D\uDC07";
    private final int weight = 2;
    private final int maxQuantityInLocation = 150;
    private final int speed = 2;
    private final double kgEnoughFood = 0.45;
    private double health = 50;

    public Rabbit() {
        initCanEat();
    }

    public void initCanEat() {
        getCanEat().put(Plant.class, 100);
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public double getKgEnoughFood() {
        return kgEnoughFood;
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
    public String getView() {
        return view;
    }
}
