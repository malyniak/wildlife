public class Island {
    private Location location;
    private Location[][] area=new Location [location.height][location.width];

    public boolean isEmptyPlace(int x, int y) {
        return area[x][y]==null;
    }
}
