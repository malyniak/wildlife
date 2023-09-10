package general;

public class ConsoleView{
    private Location[][] island;
    public ConsoleView(Location[][] island) {
        this.island=island;
    }
    public void showCountOrganismsAtLocation(Location location) {
        System.out.println("There are "+location.getAnimalList().size()+" animals at "+location);
        System.out.println("There are "+location.getPlantsList().size()+" plants at "+location);
    }
}
