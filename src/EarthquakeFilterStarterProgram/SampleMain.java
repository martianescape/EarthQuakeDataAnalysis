package EarthquakeFilterStarterProgram;

/**
 * Created by revu on 2/26/17.
 */
public class SampleMain {
    public static void main(String []args){
        System.out.println("Yen samachara1!");
        Filter f = new MagnitudeFilter(5,10);
        EarthQuakeClient2 client2 = new EarthQuakeClient2();
        client2.testMatchAllFilter2();
        //client2.quakesWithFilter();
        //f.satisfies();
    }
}
