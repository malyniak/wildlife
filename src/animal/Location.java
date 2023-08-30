package animal;

import java.util.HashMap;
import java.util.Map;

public class Location {
   int x;
   int y;
  public Map<Organism,Integer> map=new HashMap<>();

   public Map<Organism, Integer> getMap() {
      return map;
   }

   public void setMap(Map<Organism, Integer> map) {
      this.map = map;
   }
}
