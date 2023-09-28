package animals.herbivores;

import plant.*;
public class Deer extends Herbivore {
    private final String view= "\uD83E\uDD8C";
    private final int weight=300;
    private final int maxQuantityInLocation=10;
    private final int speed=4;
    private final int kgEnoughFood=50;
    public Deer() {
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
