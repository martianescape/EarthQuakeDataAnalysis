package RandomTextStarterProgram;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by revu on 3/6/17.
 */
public class MarkovFour {
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        myText = s.trim();
    }

    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        System.out.println("get Markov four random");
        //myText = "this is a test yes this is a test.";
        //getFollows("t");
        int index = myRandom.nextInt(myText.length()-1);
        String key = myText.substring(index,index+4);
        System.out.println("Keys is  "+key);

        StringBuilder sb = new StringBuilder();
        sb.append(key);
        for(int k=0; k < numChars - 1; k++){
            System.out.println("k = "+k);
            ArrayList<String> follows = getFollows(key);
            System.out.println("new key "+key);
            System.out.println(follows);
            if(follows.size() == 0){
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1)+next;
        }

        return sb.toString();
    }

    private String myText;
    private Random myRandom;

    public MarkovFour() {
        myRandom = new Random();
    }

    public ArrayList<String> getFollows(String key){
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
