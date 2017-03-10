
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

package RandomTextStarterProgram;
import edu.duke.*;
//import com.urakozz.week3.FileResource;

public class MarkovRunner {
	public static void main(String[] args){
		System.out.println("before calling runMarkovFour()");
		runMarkovN();
	}

	public static void runMarkovN() {
		String fileName = "/Users/revu/All_files/asu_courses/java/EarthQuake/src/RandomTextStarterProgram/data/confucius.txt";
		FileResource fr = new FileResource(fileName);
		System.out.println("file resource initialized");

		String st = fr.asString();
		//System.out.println("String is "+st);
		st = st.replace('\n', ' ');
		MarkovN markov = new MarkovN(5);
		markov.setRandom(42);
		markov.setTraining(st);
		for(int k=0; k < 1; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}
	public static void runMarkovFour() {
		String fileName = "/Users/revu/All_files/asu_courses/java/EarthQuake/src/RandomTextStarterProgram/data/confucius.txt";
		FileResource fr = new FileResource(fileName);
		System.out.println("file resource initialized");

		String st = fr.asString();
		//System.out.println("String is "+st);
		st = st.replace('\n', ' ');
		MarkovFour markov = new MarkovFour();
		markov.setRandom(25);
		markov.setTraining(st);
		for(int k=0; k < 1; k++){
			String text = markov.getRandomText(300);
			printOut(text);
		}
	}


	public static void runMarkovOne() {
		String fileName = "/Users/revu/All_files/asu_courses/java/EarthQuake/src/RandomTextStarterProgram/data/romeo.txt";
		FileResource fr = new FileResource(fileName);
		System.out.println("file resource initialized");

		String st = fr.asString();
		//System.out.println("String is "+st);
		st = st.replace('\n', ' ');
		MarkovOne markov = new MarkovOne();
		markov.setRandom(42);
		markov.setTraining(st);
		for(int k=0; k < 1; k++){
			String text = markov.getRandomText(300);
			printOut(text);
		}
	}

    public static void runMarkovZero() {
		String fileName = "/Users/revu/All_files/asu_courses/java/EarthQuake/src/RandomTextStarterProgram/data/romeo.txt";
		fileName = "/Users/revu/All_files/asu_courses/java/EarthQuake/src/RandomTextStarterProgram/data/confucius.txt";

		FileResource fr = new FileResource(fileName);
		System.out.println("file resource initialized");

		String st = fr.asString();
		//System.out.println("String is "+st);
		st = st.replace('\n', ' ');
		MarkovZero markov = new MarkovZero();
		markov.setRandom(42);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}
	
	private static void printOut(String s){
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
