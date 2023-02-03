package hk.edu.polyu.comp.comp2021.simple.model;

public class InputProcessing {
    public static void vardefChecking(String com){
        String[] inputlist = com.split(" ");
        if (inputlist.length!=5) {
            System.out.println("Invalid command:"+com);
        }else if (!ErrorChecking.NameChecking(inputlist[1])){
            System.out.println("Invalid statement name:"+inputlist[1]);
        }else if (!(inputlist[2].equals("int")||inputlist[2].equals("bool"))){
            System.out.println("Invalid datatype:"+inputlist[2]);
        }else if ((inputlist[2].equals("int"))&&(!((ErrorChecking.NameChecking(inputlist[4]))||(Checking.isNumeric(inputlist[4]))))){
            System.out.println("Not correct int expression reference:"+inputlist[4]);
        }else if ((inputlist[2].equals("bool"))&&(!((ErrorChecking.NameChecking(inputlist[4]))||(Checking.isBoolean(inputlist[4]))))){
            System.out.println("Not correct bool expression reference:"+inputlist[4]);
        }else if (!ErrorChecking.NameChecking(inputlist[3])){
            System.out.println("Not valid variable name:"+inputlist[3]);
        }else if (setHashMap.getStatementMap().containsKey(inputlist[1])){
            System.out.println("This statement name has already been stored:"+inputlist[1]);
        }
        else {
            setHashMap.getStatementMap().put(inputlist[1], new varDef(com));
        }
    }
    public static void binexprChecking(String com){
        String[] inputlist = com.split(" ");
        if (inputlist.length!=5){
            System.out.println("Invalid command:"+com);
        }else if (!ErrorChecking.NameChecking(inputlist[1])){
            System.out.println("Invalid statement name:"+inputlist[1]);
        }else if (!(inputlist[3].equals("&&")||inputlist[3].equals("||")||inputlist[3].equals("==")||inputlist[3].equals("!=")||inputlist[3].equals("+")||inputlist[3].equals("-")||inputlist[3].equals("*")||inputlist[3].equals("/")||inputlist[3].equals(">")||inputlist[3].equals(">=")||inputlist[3].equals("%")||inputlist[3].equals("<")||inputlist[3].equals("<=")||inputlist[3].equals("==")||inputlist[3].equals("!="))){
            System.out.println("Invalid operator:"+inputlist[3]);
        }else if (inputlist[3].equals("&&")||inputlist[3].equals("||")){
            if (!((Checking.isBoolean(inputlist[2])||ErrorChecking.NameChecking(inputlist[2]))&&(Checking.isBoolean(inputlist[4])||ErrorChecking.NameChecking(inputlist[4])))){
                System.out.println("Expression Error:"+inputlist[2]+" "+inputlist[4]);
            }else if (setHashMap.getExpressionMap().containsKey(inputlist[1])){
                System.out.println("This expression name has already been stored:"+inputlist[1]);
            }
            else {
                setHashMap.getExpressionMap().put(inputlist[1], new binaryExp(com));
            }
        }else if (inputlist[3].equals("+")||inputlist[3].equals("-")||inputlist[3].equals("*")||inputlist[3].equals("/")||inputlist[3].equals(">")||inputlist[3].equals(">=")||inputlist[3].equals("%")||inputlist[3].equals("<")||inputlist[3].equals("<=")) {
            if (!((Checking.isNumeric(inputlist[2]) || ErrorChecking.NameChecking(inputlist[2])) && (Checking.isNumeric(inputlist[4]) || ErrorChecking.NameChecking(inputlist[4])))) {
                System.out.println("Expression Error:" + inputlist[2] + " " + inputlist[4]);
            }else if (setHashMap.getExpressionMap().containsKey(inputlist[1])){
                System.out.println("This expression name has already been stored:"+inputlist[1]);
            }
            else {
                setHashMap.getExpressionMap().put(inputlist[1], new binaryExp(com));
            }
        }else{
            if ((Checking.isBoolean(inputlist[2])&&Checking.isNumeric(inputlist[4]))||(Checking.isNumeric(inputlist[2])&&Checking.isBoolean(inputlist[4]))){
                System.out.println("Expression Error:" + inputlist[2] + " " + inputlist[4]);
            }else if (setHashMap.getExpressionMap().containsKey(inputlist[1])){
                System.out.println("This expression name has already been stored:"+inputlist[1]);
            }
            else {
                setHashMap.getExpressionMap().put(inputlist[1], new binaryExp(com));
            }
        }
    }public static void unexprChecking(String com){
        String[] inputlist = com.split(" ");
        if (inputlist.length!=4){
            System.out.println("Invalid command:"+com);
        }else if (!ErrorChecking.NameChecking(inputlist[1])){
            System.out.println("Invalid statement name:"+inputlist[1]);
        }else if (!(inputlist[2].equals("#")||inputlist[2].equals("~")||inputlist[2].equals("!"))){
            System.out.println("Invalid operator:"+inputlist[2]);
        }else if (inputlist[2].equals("!")){
            if (!(Checking.isBoolean(inputlist[3])||ErrorChecking.NameChecking(inputlist[3]))){
                System.out.println("Expression Error:"+inputlist[3]);
            }else if (setHashMap.getExpressionMap().containsKey(inputlist[1])){
                System.out.println("This expression name has already been stored:"+inputlist[1]);
            }
            else setHashMap.getExpressionMap().put(inputlist[1], new unaryExp(com));
        }else{
            if (!(Checking.isNumeric(inputlist[3])||ErrorChecking.NameChecking(inputlist[3]))){
                System.out.println("Expression Error:"+inputlist[3]);
            }else if (setHashMap.getExpressionMap().containsKey(inputlist[1])){
                System.out.println("This expression name has already been stored:"+inputlist[1]);
            }
            else setHashMap.getExpressionMap().put(inputlist[1], new unaryExp(com));
        }
    }public static void assignChecking(String com) {
        String[] inputlist = com.split(" ");
        if (inputlist.length != 4) {
            System.out.println("Invalid command:" + com);
        } else if (!ErrorChecking.NameChecking(inputlist[1])) {
            System.out.println("Invalid statement name:" + inputlist[1]);
        } else if (!ErrorChecking.NameChecking(inputlist[2])) {
            System.out.println("Invalid Variable name:" + inputlist[2]);
        } else if (!(Checking.isNumeric(inputlist[3]) || Checking.isBoolean(inputlist[3]) || ErrorChecking.NameChecking(inputlist[3]))) {
            System.out.println("Invalid expression reference:" + inputlist[3]);
        } else if (setHashMap.getStatementMap().containsKey(inputlist[1])){
            System.out.println("This statement name has already been stored:"+inputlist[1]);
        }
        else {
            setHashMap.getStatementMap().put(inputlist[1], new Assign(com));
        }
    }public static void printChecking(String com) {
        String[] inputlist = com.split(" ");
        if (inputlist.length != 3) {
            System.out.println("Invalid command:" + com);
        } else if (!ErrorChecking.NameChecking(inputlist[1])) {
            System.out.println("Invalid statement name:" + inputlist[1]);
        } else if (!(Checking.isNumeric(inputlist[2]) || Checking.isBoolean(inputlist[2]) || ErrorChecking.NameChecking(inputlist[2]))) {
            System.out.println("Invalid expression reference:" + inputlist[2]);
        } else if (setHashMap.getStatementMap().containsKey(inputlist[1])){
            System.out.println("This statement name has already been stored:"+inputlist[1]);
        }
        else {
            setHashMap.getStatementMap().put(inputlist[1], new Print(com));
        }
    }public static void skipChecking(String com) {
        String[] inputlist = com.split(" ");
        if (inputlist.length != 2) {
            System.out.println("Invalid command:" + com);
        } else if (!ErrorChecking.NameChecking(inputlist[1])) {
            System.out.println("Invalid statement name:" + inputlist[1]);
        } else if (setHashMap.getStatementMap().containsKey(inputlist[1])){
            System.out.println("This statement name has already been stored:"+inputlist[1]);
        }
        else {
            setHashMap.getStatementMap().put(inputlist[1], new Skip(com));
        }
    }public static void blockChecking(String com) {
        String[] inputlist = com.split(" ");
        boolean valid = true;
        for (int i = 1; i < inputlist.length; i++) {
            if (!ErrorChecking.NameChecking(inputlist[i])) {
                valid = false;
                break;
            }
        }
        if (valid == true) {
            if (setHashMap.getStatementMap().containsKey(inputlist[1])){
                System.out.println("This statement name has already been stored:"+inputlist[1]);
            }else{
                setHashMap.getStatementMap().put(inputlist[1], new Block(com));
            }
        } else {
            System.out.println("Invalid statement name");
        }
    }public static void ifChecking(String com) {
        String[] inputlist = com.split(" ");
        if (inputlist.length != 5) {
            System.out.println("Invalid command:" + com);
        } else if (!ErrorChecking.NameChecking(inputlist[1])) {
            System.out.println("Invalid statement name:" + inputlist[1]);
        } else if (!ErrorChecking.NameChecking(inputlist[3])) {
            System.out.println("Invalid statement name:" + inputlist[3]);
        } else if (!ErrorChecking.NameChecking(inputlist[4])) {
            System.out.println("Invalid statement name:" + inputlist[4]);
        } else if (!(Checking.isBoolean(inputlist[2]) || ErrorChecking.NameChecking(inputlist[2]))) {
            System.out.println("Invalid expression reference:" + inputlist[2]);
        } else if (setHashMap.getStatementMap().containsKey(inputlist[1])){
            System.out.println("This statement name has already been stored:"+inputlist[1]);
        }
        else {
            setHashMap.getStatementMap().put(inputlist[1], new IfElse(com));
        }
    }public static void whileChecking(String com) {
        String[] inputlist = com.split(" ");
        if (inputlist.length != 4) {
            System.out.println("Invalid command:" + com);
        } else if (!ErrorChecking.NameChecking(inputlist[1])) {
            System.out.println("Invalid statement name:" + inputlist[1]);
        } else if (!ErrorChecking.NameChecking(inputlist[3])) {
            System.out.println("Invalid statement name:" + inputlist[3]);
        } else if (!(Checking.isBoolean(inputlist[2]) || ErrorChecking.NameChecking(inputlist[2]))) {
            System.out.println("Invalid expression reference:" + inputlist[2]);
        } else if (setHashMap.getStatementMap().containsKey(inputlist[1])){
            System.out.println("This statement name has already been stored:"+inputlist[1]);
        }
        else {
            setHashMap.getStatementMap().put(inputlist[1], new While(com));
        }
    }public static void programChecking(String com) {
        String[] inputlist = com.split(" ");
        if (inputlist.length != 3) {
            System.out.println("Invalid command:" + com);
        } else if (!ErrorChecking.NameChecking(inputlist[2])) {
            System.out.println(com+"\nInvalid statement name:" + inputlist[2]);
        } else if (setHashMap.getProgramMap().containsKey(inputlist[1])){
            System.out.println(com+"\nThis program name has already been stored:"+inputlist[1]);
        }
        else {
            setHashMap.getProgramMap().put(inputlist[1], new Program(com));
        }
    }
    public static void executeChecking(String com){
        String[] inputlist = com.split(" ");
        if (inputlist.length!=2){
            System.out.println("Invalid command:"+com);
        }else{
            try{
                ((Program) setHashMap.getProgramMap().get(inputlist[1])).execute();
            }
            catch(NullPointerException e){
                System.out.println("The program name hasn't defined.");
            }
        }
    }public static void listChecking(String com) {
        String[] inputlist = com.split(" ");
        if (inputlist.length != 2) {
            System.out.println("Invalid command:" + com);
        } else {
            try {
                ((Program) setHashMap.getProgramMap().get(inputlist[1])).printList();
            } catch (NullPointerException e) {
                System.out.println("The program name hasn't defined.");
            }
        }
    }public static void storeChecking(String com) {
        String[] inputlist = com.split(" ");
        if (inputlist.length != 3) {
            System.out.println("Invalid command:" + com);
        } else {
            try {
                ((Program) setHashMap.getProgramMap().get(inputlist[1])).store(inputlist[2]);
            } catch (NullPointerException e) {
                System.out.println("The program name hasn't defined.");
            }
        }
    }public static void loadChecking(String com) {
        String[] inputlist = com.split(" ");
        if (inputlist.length != 3) {
            System.out.println("Invalid command:" + com);
        } else {
            LoadProgram a = new LoadProgram(com);
            a.Load();
        }
    }public static void quitChecking(String com) {
        String[] inputlist = com.split(" ");
        if (inputlist.length != 1) {
            System.out.println("Invalid command:" + com);
        } else {
            System.exit(0);
        }
    }public static void togglebreakpointChecking(String com) {
        String[] inputlist = com.split(" ");
        if (inputlist.length != 3) {
            System.out.println("Invalid command:" + com);
        } else {
            try {
                ((Program) setHashMap.getProgramMap().get(inputlist[1])).setbreakpoint(inputlist[2]);
            } catch (NullPointerException e) {
                System.out.println("The program name hasn't defined.");
            }
        }
    }public static void debugChecking(String com) {
        String[] inputlist = com.split(" ");
        if (inputlist.length != 2) {
            System.out.println("Invalid command:" + com);
        } else {
            try {
                ((Program) setHashMap.getProgramMap().get(inputlist[1])).debug();
            } catch (NullPointerException e) {
                System.out.println("The program name hasn't defined.");
            }
        }
    }public static void instrumentChecking(String com) {
        String[] inputlist = com.split(" ");
        if (inputlist.length != 5) {
            System.out.println("Invalid command:" + com);
        } else {
            try {
                ((Program) setHashMap.getProgramMap().get(inputlist[1])).addinstrument(inputlist[2], inputlist[3], inputlist[4]);
            } catch (NullPointerException e) {
                System.out.println("The program name hasn't defined.");
            }
        }
    }
}
