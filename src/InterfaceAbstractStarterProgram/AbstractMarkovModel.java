
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
package InterfaceAbstractStarterProgram;
import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    abstract public String getRandomText(int numChars);

    protected ArrayList<String> getFollows(String key){
        ArrayList<String> followChar = new ArrayList<String>();
        String currString = myText;
        int index = currString.indexOf(key);
        while(index >= 0 && index+key.length() < currString.length()) {
            followChar.add(String.valueOf(currString.charAt(index+key.length())));

            currString = currString.substring(index+1);
            index = currString.indexOf(key);
            //System.out.println(followChar);
        }
        //System.out.println(followChar);
        return followChar;

    }
}
