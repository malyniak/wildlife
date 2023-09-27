package animals;

import animals.herbivores.*;
import animals.predators.*;
import exceptions.ClassNotExistException;
import static general.Constants.CLASS_NOT_ANIMAL;
public class ChildrenFactory {
    public Animal getChild(Class<?extends Animal> animal) throws ClassNotExistException {
        if (animal.equals(Bear.class))
            return new Bear();
        if (animal.equals(Boa.class))
            return new Boa();
        if (animal.equals(Buffalo.class))
            return new Buffalo();
        if (animal.equals(Boar.class))
            return new Boar();
        if (animal.equals(Deer.class))
            return new Deer();
        if (animal.equals(Duck.class))
            return new Duck();
        if (animal.equals(Eagle.class))
            return new Eagle();
        if (animal.equals(Fox.class))
            return new Fox();
        if (animal.equals(Goat.class))
            return new Goat();
        if (animal.equals(Gusin.class))
            return new Gusin();
        if (animal.equals(Horse.class))
            return new Horse();
        if (animal.equals(Mouse.class))
            return new Mouse();
        if (animal.equals(Rabbit.class))
            return new Rabbit();
        if (animal.equals(Sheep.class))
            return new Sheep();
        if (animal.equals(Wolf.class))
            return new Wolf();
        else throw new ClassNotExistException(CLASS_NOT_ANIMAL);

    }
}
