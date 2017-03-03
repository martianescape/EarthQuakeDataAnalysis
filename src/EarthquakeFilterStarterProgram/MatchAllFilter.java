package EarthquakeFilterStarterProgram;
import java.util.*;
/**
 * Created by revu on 2/26/17.
 */
public class MatchAllFilter implements Filter {
    private ArrayList<Filter> allFilters;
    MatchAllFilter(){
        allFilters = new ArrayList<Filter>();
    }

    public void addFilter(Filter f){
        allFilters.add(f);
    }

    public String getName(){
        String allFilterNames = "";
        for(Filter f : allFilters){
            allFilterNames += " "+ f.getName();
        }
        return allFilterNames;
    }

    public boolean satisfies(QuakeEntry qe){
        boolean retCondition =true;
        for(Filter f: allFilters){
            if(!retCondition)
                break;
            retCondition =  f.satisfies(qe);
        }
        return retCondition;
    }
}
