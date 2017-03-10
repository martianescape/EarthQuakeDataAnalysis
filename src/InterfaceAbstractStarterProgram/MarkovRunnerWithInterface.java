
//package InterfaceAbstractStarterProgram;
//import RandomTextStarterProgram.*;
//*/
/**
// * Write a description of class MarkovRunner here.
// *
// * @author Duke Software
// * @version 1.0
// */

package InterfaceAbstractStarterProgram;

import edu.duke.*;

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setRandom(seed);
        markov.setTraining(text);
        System.out.println("running with " + markov.toString());
        for(int k=0; k < 1; k++){
			String st= markov.getRandomText(size);
			printOut(st);
		}
    }

    public void runMarkov() {
        String fileName = "/Users/revu/All_files/asu_courses/java/EarthQuake/src/RandomTextStarterProgram/data/confucius.txt";
        FileResource fr = new FileResource(fileName);

        //FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 200;
        System.out.println("markov zero");
        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size, 100);

        System.out.println("markov One");

        MarkovOne mOne = new MarkovOne();
        //runModel(mOne, st, size);

        System.out.println("markov N");

        MarkovN mThree = new MarkovN(3);
        runModel(mThree, st, size,200);

        System.out.println("markov four");

        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size,42);

    }

	private void printOut(String s){
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}

}

