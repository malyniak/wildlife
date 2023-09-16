package animals.herbivores;
import plant.*;

public class Sheep extends Herbivore {
    private final String view= "\uD83D\uDC11";
    private final int weight = 70;
    private final int maxQuantityInLocation = 140;
    private final int speed = 3;
    private final int kgEnoughFood = 15;

    public Sheep() {
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