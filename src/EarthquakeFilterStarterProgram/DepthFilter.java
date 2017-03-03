package EarthquakeFilterStarterProgram;

/**
 * Created by revu on 2/26/17.
 */
public class DepthFilter implements Filter {
    private double minDepth;
    private double maxDepth;
    private String filterName;
    DepthFilter(double min, double max){
        this.minDepth = min;
        this.maxDepth = max;
        filterName = "DepthFilter";
    }
    public String getName(){
        return filterName;
    }
    public boolean satisfies(QuakeEntry qe){
        return qe.getDepth()>=minDepth && qe.getDepth()<=maxDepth;
    }
}
