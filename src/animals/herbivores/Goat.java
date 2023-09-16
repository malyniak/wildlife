package animals.herbivores;

import plant.*;
public class Goat extends Herbivore {
    private final String view= "\uD83D\uDC10";
    private final int weight=60;
    private final int maxQuantityInLocation=140;
    private final int speed=3;
    private final int kgEnoughFood=10;

    public Goat() {
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
