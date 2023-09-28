package animals.herbivores;
import plant.*;

public class Horse extends Herbivore {
    private final String view= "\uD83D\uDC0E";
    private final int weight=400;
    private final int maxQuantityInLocation=20;
    private final int speed=3;
    private final int kgEnoughFood=1;
    public Horse() {
        setView(view);
        setWeight(weight);
        setMaxQuantityInLocation(maxQuantityInLocation);
        setSpeed(speed);
        setKgEnoughFood(kgEnoughFood);
        initCanEat();
    }
    public void initCanEat(){
        getCanEat().put(Plant.class, 100);
    }
}
