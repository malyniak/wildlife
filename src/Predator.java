import java.util.*;

public abstract class Predator extends Animal {
    private double health=50;
    @Override
    public void eat() {
        Random random=new Random();
        List<Animal> animalsToEat = randomAnimalsToEat();
        Animal animal = animalsToEat.get(random.nextInt(animalsToEat.size()));
        if(random.nextInt(Constants.PERCENT)<=canEat.get(animal .getClass())) {
                   if (getHealth() < Constants.MAX_HEALTH) {
                       double newHealth = getHealth() + (animal.getWeight() * 100 / getKgEnoughFood());
                       setHealth(newHealth > Constants.MAX_HEALTH ? Constants.MAX_HEALTH : newHealth);
                       System.out.println(this.getClass().getSimpleName() + " ate " + animal.getClass().getSimpleName());
                       animal.die();
                   }
               }

            }

    public abstract void setHealth(double health);
}
