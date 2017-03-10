package WordGramClassStarterProgram;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by revu on 3/9/17.
 */
public class MarkovWord implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    private int myOrder;

    public MarkovWord(int order) {
        myRandom = new Random();
        myOrder = order;
    }



    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String text){
        myText = text.split("\\s+");
    }

    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-1);  // random word to start with
        System.out.println("my text is"+myText.toString());
        //index = 0;
        WordGram kgram = new WordGram(myText, index, myOrder);
        //String key = myText[index];
        //System.out.println("key is "+key);

        sb.append(kgram.toString());
        sb.append(" ");
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(kgram);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            kgram = kgram.shiftAdd(next);
        }

        return sb.toString().trim();
    }

    private int indexOf(String[] words, WordGram target, int pos){
        //int index = -1;
        for(int i= pos; i<words.length - myOrder; i++){
            WordGram test = new WordGram(words, i, myOrder);
            if(target.equals(test)){
                return i+myOrder;
            }
        }
        return -1;
    }


    private ArrayList<String> getFollows(WordGram kGram) {

        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        while(pos<myText.length- myOrder){
            pos = indexOf(myText, kGram, pos);
            if(pos == -1){
                break;
            } else{
                if(pos < myText.length -1)
                    //System.out.println("position is "+pos);
                    follows.add(myText[pos]);
            }
            //pos+=1;
        }

        return follows;
    }

}
