import java.util.*;

public abstract class Predator extends Animal {
    private double health=50;
    @Override
    public void eat() {
        Random random=new Random();
        List<Animal> animals = getLocation().getAnimalList();
        Iterator it = animals.iterator();
        while (it.hasNext()) {
            Animal animal = (Animal) it.next();
            if (canEat.containsKey(animal.getClass())) {
                int сhanceEat = canEat.get(animal.getClass());
               if(random.nextInt(Constants.PERCENT)<=сhanceEat) {
                   if (getHealth() < Constants.MAX_HEALTH) {
                       double newHealth = getHealth() + (animal.getWeight() * 100 / getKgEnoughFood());
                       setHealth(newHealth > Constants.MAX_HEALTH ? Constants.MAX_HEALTH : newHealth);
                       System.out.println(this.getClass().getSimpleName() + " ate " + animal.getClass().getSimpleName());
                       animal.die(it);
                   }
               }

            }
        }
    }
    public abstract void setHealth(double health);
}
