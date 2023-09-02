package animal;

import java.util.HashSet;
import java.util.Set;

public final class Constants {
   public static final Location[][] locations=new Location[100][20];
    public static final int MAX_HEALTH=100;
    public static final Location[][] AREA=new InitMenu().getLocation();
    public static final Set<Organism> ORGANISMS=new HashSet<>();
    {
        HashSet<Organism> organisms = new HashSet<>();
        organisms.add(new Wolf());
        organisms.add(new Boa());
        organisms.add(new Fox());
        organisms.add(new Bear());
        organisms.add(new Eagle());
        organisms.add(new Horse());
        organisms.add(new Deer());
        organisms.add(new Rabbit());
        organisms.add(new Mouse());
        organisms.add(new Goat());
        organisms.add(new Sheep());
        organisms.add(new Boar());
        organisms.add(new Buffalo());
        organisms.add(new Duck());
        organisms.add(new Gusin());
        organisms.add(new Plant());
    }
}
