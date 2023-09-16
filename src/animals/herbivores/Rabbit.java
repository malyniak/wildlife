package animals.herbivores;
import plant.*;

public class Rabbit extends Herbivore {
    private final String view= "\uD83D\uDC07";
    private final int weight = 2;
    private final int maxQuantityInLocation = 150;
    private final int speed = 2;
    private final double kgEnoughFood = 0.45;
    public Rabbit() {
        setView(view);
        setWeight(weight);
        setMaxQuantityInLocation(maxQuantityInLocation);
        setSpeed(speed);
        setKgEnoughFood(kgEnoughFood);
        initCanEat();
    }
    public void initCanEat() {
        getCanEat().put(Plant.class, 100);
    }

}
