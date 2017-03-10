package WordGramClassStarterProgram;

/**
 * Created by revu on 3/9/17.
 */
public class SimpleMain {
    public static void main(String[] args){
        System.out.println("Yen samachara");
        MarkovRunner runner  = new MarkovRunner();
        runner.runMarkov();
        //WordGramTester wgt = new WordGramTester();
        //wgt.testWordGram();
        //wgt.testWordGramEquals();
    }
}
