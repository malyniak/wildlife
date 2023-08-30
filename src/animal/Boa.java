package animal;

import javax.xml.stream.Location;

public class Boa extends Predator{
    private final int weight=15;
    private final int maxQuantityInLocation=30;
    private final int speed=1;
    private final int enoughFood=3;
    private boolean isAlive=true;
    private int health=100;

    @Override
    public double getHealth() {
        return 0;
    }

    @Override
    public int getWeight() {
        return 0;
    }
}
