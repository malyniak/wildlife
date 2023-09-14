package general;

public class ConsoleView{
    private Location[][] island;
    public ConsoleView(Location[][] island) {
        this.island=island;
    }
    public void showCountAnimals() {
        for(int i=0; i<island.length; i++) {
            for (int j=0; j<island[i].length; j++) {
                System.out.println(island[i][j]);
            }
        }
    }
    public void showCountPlants() {
        for(int i=0; i<island.length; i++) {
            for (int j=0; j<island[i].length; j++) {
                System.out.println(island[i][j]);
            }
        }
    }
}
