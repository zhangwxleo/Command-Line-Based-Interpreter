package hk.edu.polyu.comp.comp2021.simple;


import java.util.Scanner;

import static hk.edu.polyu.comp.comp2021.simple.model.InputProcessing.*;



/**
 * this is the entrance of the project, the Main class shows the selection of the function of each input
 */
public class Main {

    /**
     * @param args this is the main function, processing user input
     */
    public static void main(String[] args){
        while (true){
            System.out.print(">");
            Scanner scanner = new Scanner(System.in);
            String com= scanner.nextLine();
            String[] inputlist = com.split(" ");
            switch (inputlist[0]) {
                case "vardef" -> vardefChecking(com);
                case "binexpr" -> binexprChecking(com);
                case "unexpr" -> unexprChecking(com);
                case "assign" -> assignChecking(com);
                case "print" -> printChecking(com);
                case "skip" -> skipChecking(com);
                case "block" -> blockChecking(com);
                case "if" -> ifChecking(com);
                case "while" -> whileChecking(com);
                case "program" -> programChecking(com);
                case "execute" -> executeChecking(com);
                case "list" -> listChecking(com);
                case "store" -> storeChecking(com);
                case "load" -> loadChecking(com);
                case "quit" -> quitChecking(com);
                case "togglebreakpoint" -> togglebreakpointChecking(com);
                case "debug" -> debugChecking(com);
                case "instrument" -> instrumentChecking(com);
                default -> System.out.println("Wrong keyword.");
            }
        }
    }
}
