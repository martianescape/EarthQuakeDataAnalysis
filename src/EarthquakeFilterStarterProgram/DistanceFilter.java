package EarthquakeFilterStarterProgram;

/**
 * Created by revu on 2/26/17.
 */
public class DistanceFilter implements Filter{
    private Location loc;
    private double maxDistance;
    private String filterName;
    DistanceFilter(Location loc, double max){
        this.loc = loc;
        this.maxDistance = max;
        filterName = "DistanceFilter";
    }
    public String getName(){
        return filterName;
    }

    public boolean satisfies(QuakeEntry qe){
        //System.out.println(qe);
        return qe.getLocation().distanceTo(loc) <= maxDistance;
        //return true;
    }

}
