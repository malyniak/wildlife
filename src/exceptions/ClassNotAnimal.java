package exceptions;

public class ClassNotAnimal extends RuntimeException {
    public ClassNotAnimal(String message) {
        super(message);
    }
}
