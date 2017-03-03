package EarthquakeFilterStarterProgram;


import java.util.*;


public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) {
            if (f.satisfies(qe)) {
                answer.add(qe);
            }
        }
        
        return answer;
    }

    public void testMatchAllFilter(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";

        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        MatchAllFilter maf = new MatchAllFilter();
        Filter magFilter = new MagnitudeFilter(1.0, 4.0);
        Filter depthFilter = new DepthFilter(-180000.0,-30000.0);
        Filter phraseFilter = new PhraseFilter("any", "o");
        maf.addFilter(magFilter);
        maf.addFilter(depthFilter);
        maf.addFilter(phraseFilter);
        ArrayList<QuakeEntry>m7 = filter(list, maf);
        for (QuakeEntry qe: m7) {
            //System.out.println("distn : "+ qe.getLocation().distanceTo(tokyo));

            System.out.println(qe);
        }
        System.out.println("total results found"+m7.size());

    }

    public void testMatchAllFilter2(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";

        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        MatchAllFilter maf = new MatchAllFilter();
        Filter magFilter = new MagnitudeFilter(0.0, 3.0);
        Filter phraseFilter = new PhraseFilter("any", "e");
        Location denmark  = new Location(55.7308, 9.1153);
        Location okla = new Location(36.1314, -95.9372);
        Filter distanceFilter = new DistanceFilter(denmark, 3000000);

        maf.addFilter(magFilter);
        //maf.addFilter(depthFilter);
        maf.addFilter(distanceFilter);
        maf.addFilter(phraseFilter);
        System.out.println("filters used in this are: "+ maf.getName());
        ArrayList<QuakeEntry>m7 = filter(list, maf);

        for (QuakeEntry qe: m7) {
            //System.out.println("distn : "+ qe.getLocation().distanceTo(tokyo));

            System.out.println(qe);
        }
        System.out.println("total results found"+m7.size());

    }


    public void quakesWithFilter() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";

        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        Filter magFilter = new MagnitudeFilter(3.5, 4.5);
//        Filter depthFilter = new DepthFilter(-35000.0, -12000.0);
        Filter depthFilter = new DepthFilter(-55000.0, -20000.0);
        Location tokyo = new Location(35.42, 139.43);
        Location denver = new Location(39.7392, -104.9903);
        Filter distanceFilter = new DistanceFilter(denver, 10000000);
        //Filter
        Filter phraseFilter = new PhraseFilter("end","a");
        ArrayList<QuakeEntry> m7 = filter(list, magFilter);// =  filter(list, magFilter);//filter(list, distanceFilter);//=
        m7 = filter(m7, depthFilter);
        //m7 = filter(m7, phraseFilter);
        System.out.println(m7.size());
        for (QuakeEntry qe: m7) {
            System.out.println("distn : "+ qe.getLocation().distanceTo(tokyo));

            System.out.println(qe);
        }
        System.out.println("entries read "+m7.size());

    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

}
