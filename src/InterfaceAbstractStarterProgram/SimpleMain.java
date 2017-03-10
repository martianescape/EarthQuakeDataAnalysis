package InterfaceAbstractStarterProgram;

/**
 * Created by revu on 3/8/17.
 */
public class SimpleMain {
    public static void main(String[] args){
        System.out.println("Yen samachaara");
        MarkovRunnerWithInterface mrunner = new MarkovRunnerWithInterface();
        mrunner.runMarkov();
    }
}
