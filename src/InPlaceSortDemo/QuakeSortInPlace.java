package InPlaceSortDemo;

import java.util.ArrayList;

/**
 * Created by revu on 2/28/17.
 */
public class QuakeSortInPlace {
    public QuakeEntry getSmallestMagnitude(ArrayList<QuakeEntry> quakes) {
        QuakeEntry min = quakes.get(0);
        for(QuakeEntry q: quakes) {
            if (q.getMagnitude() < min.getMagnitude()) {
                min = q;
            }
        }
        return min;
    }

    public int getLargestDepth(ArrayList<QuakeEntry> quakes, int index){
        int largest = index;
        for(int i = index; i< quakes.size();i++){
            if(quakes.get(largest).getDepth() < quakes.get(i).getDepth()){
                largest = i;
            }
        }
        return largest;
    }

    public ArrayList<QuakeEntry> sortByDepth(ArrayList<QuakeEntry> in){
        for(int i =0; i<in.size(); i++){
            int largest = getLargestDepth(in, i);
            QuakeEntry currEntry = in.get(i);
            QuakeEntry largestEntry = in.get(largest);
            in.set(i, largestEntry);
            in.set(largest, currEntry);
        }
        return in;
    }

    public void onePassBubbleSort(ArrayList<QuakeEntry> quakes, int numSorted){
        //int currElement = numSorted;
        for(int currElement = 0; currElement < (quakes.size() - numSorted -1);currElement++){
            if(quakes.get(currElement).getMagnitude() > quakes.get(currElement+1).getMagnitude()){
                QuakeEntry currEntry = quakes.get(currElement);
                QuakeEntry nextEntry = quakes.get(currElement+1);
                quakes.set(currElement, nextEntry);
                quakes.set(currElement+1, currEntry);
            }
        }
    }

    public ArrayList<QuakeEntry> sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in){
        for(int i=0; i< in.size();i++){
            onePassBubbleSort(in,i);
        }
        return in;
    }

    public ArrayList<QuakeEntry> sortByMagnitudeWithBubbleSortwithCheck(ArrayList<QuakeEntry> in){
        for(int i=0; i< in.size();i++){
            System.out.println("result after passes: "+i+1);
            if(checkInSortedOrder(in)){
                System.out.println("number of passes "+(i+1));
                break;
            }
            onePassBubbleSort(in,i);
            for(QuakeEntry qe:in){
                System.out.println(qe);
            }
        }
        return in;
    }
    public boolean checkInSortedOrder(ArrayList<QuakeEntry> in){
        //boolean sorted = true;
        for(int i = 0;i< in.size()-1; i++){
            if(in.get(i).getMagnitude() > in.get(i+1).getMagnitude()){
                return false;
            }
        }
        return true;
    }

    public ArrayList<QuakeEntry> sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in) {
        //out starts as empty ArrayList
        ArrayList<QuakeEntry> out = new ArrayList<QuakeEntry>();
        //As long as in is not empty
        while(!in.isEmpty()) {
            //Find smallest element in in (minElement)
            QuakeEntry minElement = getSmallestMagnitude(in);
            //Remove minElement from in
            in.remove(minElement);
            //Add minElement to out
            out.add(minElement);
        }
        //out is the answer
        return out;
    }

    public ArrayList<QuakeEntry> sortByMagnitude(ArrayList<QuakeEntry> in) {
        //out starts as empty ArrayList
        ArrayList<QuakeEntry> out = new ArrayList<QuakeEntry>();
        //As long as in is not empty
        while(!in.isEmpty()) {
            //Find smallest element in in (minElement)
            QuakeEntry minElement = getSmallestMagnitude(in);
            //Remove minElement from in
            in.remove(minElement);
            //Add minElement to out
            out.add(minElement);
        }
        //out is the answer
        return out;
    }

    /* tester method to use in BlueJ */
    public void testSort(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/earthQuakeDataDec6sample1.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        //list = sortByMagnitude(list);
        list = sortByDepth(list);
        //list = sortByMagnitudeWithBubbleSortwithCheck(list);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
    }

}
