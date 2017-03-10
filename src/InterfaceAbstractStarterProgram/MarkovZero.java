
/**
 * Write a description of class MarkovZero here.
 * 
 * @author Duke Software
 * @version 1.0
 */
package InterfaceAbstractStarterProgram;

import java.util.Random;

public class MarkovZero extends AbstractMarkovModel{
    //private String myText;
	//private Random myRandom;
	
	public MarkovZero() {
		myRandom = new Random();
	}
	

	public void setTraining(String s){
		myText = s.trim();
	}
	
	public String getRandomText(int numChars){
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(int k=0; k < numChars; k++){
			int index = myRandom.nextInt(myText.length());
			sb.append(myText.charAt(index));
		}
		
		return sb.toString();
	}
	public String toString(){
		String str = "Markov of order "+ 0;
		//System.out.println("Markov of order "+nVal);
		return str;
	}
}
