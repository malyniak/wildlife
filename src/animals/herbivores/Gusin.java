package animals.herbivores;

import plant.*;

public class Gusin extends Herbivore {
    private final String view= "\uD83D\uDC1B";
    private final double weight=0.01;
    private final int maxQuantityInLocation=1000;
    private final int speed=0;
    private final int kgEnoughFood=0;
    public Gusin() {
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
