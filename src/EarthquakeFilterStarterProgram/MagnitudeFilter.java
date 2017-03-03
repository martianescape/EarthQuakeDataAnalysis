package EarthquakeFilterStarterProgram;

//import SearchingEarthQuakeDataStarterProgram.QuakeEntry;

/**
 * Write a description of class MinMaxFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MagnitudeFilter implements Filter {
    private double min;
    private double max;
    private String filterName;

    public MagnitudeFilter(double min, double max) {
        this.min = min;
        this.max = max;
        this.filterName = "MagnitudeFilter";
    }
    public String getName(){
        return filterName;
    }

    public boolean satisfies(QuakeEntry qe) {
//        System.out.println("quake magnitude is"+qe.getMagnitude());
//        System.out.println(" quake min"+min + ":"+ (qe.getMagnitude()>=min));
//        System.out.println("quake max"+max + ":"+ (qe.getMagnitude()<=max));
        return qe.getMagnitude() >=min && qe.getMagnitude() <= max ;
    }

}
