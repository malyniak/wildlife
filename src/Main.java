import animal.*;

import static animal.Constants.locations;

public class Main {
    public static void main(String[] args) {
        InitMenu initMenu = new InitMenu();
        initMenu.initLocations();
        for(Organism organism:locations[2][5].list) {
            organism.eat();
        }
        }

    }