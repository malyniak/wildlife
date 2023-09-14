import general.Island;
import general.Menu;

public class OrganismLife {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.getDataFromUser();
        Island island= new Island();
        menu.initIsland(island);
        island.start();
    }
}
