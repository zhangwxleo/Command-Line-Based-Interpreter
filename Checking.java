package hk.edu.polyu.comp.comp2021.simple.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Checking {

    public static final int INTHIGH = 99999;
    public static final int INTLOW = -99999;

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
            if (d< INTLOW||d> INTHIGH){
                return false;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static boolean isBoolean(String strbool) {
        if (strbool.equals("true")||strbool.equals("false")) {
            return true;
        }return false;
    }
    public static int resultChecking(int result){
        if (result < INTLOW) result = INTLOW;
        if (result > INTHIGH) result = INTHIGH;
        return result;
    }
    public static Operation getvalue(String expName) {
        Operation exp = null;
        if (setHashMap.getExpressionMap().containsKey(expName)) {
            if (((Operation) setHashMap.getExpressionMap().get(expName)).getLabel().equals("binexpr")) {
                ((binaryExp) setHashMap.getExpressionMap().get(expName)).execute();
                exp = (Operation) setHashMap.getExpressionMap().get(expName);
            }
            else {
                ((unaryExp) setHashMap.getExpressionMap().get(expName)).execute();
                exp = (Operation) setHashMap.getExpressionMap().get(expName);
            }
        }else if (setHashMap.getVariableMap().containsKey(expName)) {
            if (((Variable) setHashMap.getVariableMap().get(expName)).getvalue() instanceof Integer) {
                exp = new Operation(((Variable<Integer>) setHashMap.getVariableMap().get(expName)).getvalue());
                exp.set_type(Typ.INT);
            }else  {
                exp = new Operation(((Variable<Boolean>) setHashMap.getVariableMap().get(expName)).getvalue());
                exp.set_type(Typ.BOOL);
            }
        }else if (Checking.isNumeric(expName)) {
            exp = new Operation(Integer.parseInt(expName));
        }else if (Checking.isBoolean(expName)) {
            exp = new Operation(Boolean.parseBoolean(expName));
        }else {
            System.out.println("This expression is not defined:"+expName);
            System.exit(0);
        }
        return exp;
    }
    public static void executeStatement(String name,Instrument instrument) {
        try{
            setHashMap.getStatementMap().get(name);
        }catch (NullPointerException e){
            System.out.println("This statement is not defined:"+name);
            System.exit(0);
        }
        switch (((Operation) setHashMap.getStatementMap().get(name)).getLabel()) {
            case "vardef":
                ((varDef) setHashMap.getStatementMap().get(name)).execute(instrument);
                break;
            case "assign":
                ((Assign) setHashMap.getStatementMap().get(name)).execute(instrument);
                break;
            case "print":
                ((Print) setHashMap.getStatementMap().get(name)).execute(instrument);
                break;
            case "skip":
                ((Skip) setHashMap.getStatementMap().get(name)).execute(instrument);
                break;
            case "block":
                ((Block) setHashMap.getStatementMap().get(name)).execute(instrument);
                break;
            case "if":
                ((IfElse) setHashMap.getStatementMap().get(name)).execute(instrument);
                break;
            case "while":
                ((While) setHashMap.getStatementMap().get(name)).execute(instrument);
        }
    }
    public static void debugStatement(String name, HashSet<String> set,String program,Instrument instrument) {
//		System.out.println(((Operation) setHashMap.getStatementMap().get(name)).getLabel());
        if (set.contains(name)){

//            while(!inputlist[0].equals("debug")){
            boolean repeat = true;
            while(repeat){
                System.out.print('>');
                Scanner scanner = new Scanner(System.in);
                String com= scanner.nextLine();
                String[] inputlist = com.split(" ");
                switch (inputlist[0]){
                    case "togglebreakpoint" -> {
                        InputProcessing.togglebreakpointChecking(com);
                    }
                    case "inspect" -> {
                        if (inputlist.length != 3) {
                            System.out.println("Invalid command:" + com);
                        } else if (!inputlist[1].equals(program)){
                            System.out.println("Error: "+com);
                            System.out.println("Not current debugging program: "+inputlist[1]);
                        } else if (setHashMap.getVariableMap().containsKey(inputlist[2])) {
                            if (((Variable) setHashMap.getVariableMap().get(inputlist[2])).getvalue() instanceof Integer) {
                                System.out.println("<"+((Variable<Integer>) setHashMap.getVariableMap().get(inputlist[2])).getvalue()+">");
                            }else{
                                System.out.println("<"+((Variable<Boolean>) setHashMap.getVariableMap().get(inputlist[2])).getvalue()+">");
                            }
                        }else {
                            System.out.println("Error: "+com);
                            System.out.println("Variable hasn't defined:"+inputlist[2]);
                        }
                    }case "debug" ->{
                        if (inputlist.length != 2) {
                            System.out.println("Invalid command:" + com);
                        } else if (!inputlist[1].equals(program)){
                            System.out.println("Error: "+com);
                            System.out.println("Not current debugging program: "+inputlist[1]);
                        } else {
                            repeat = false;
                        }
                    }
                }
            }
        }
        try{
            setHashMap.getStatementMap().get(name);
        }catch (NullPointerException e){
            System.out.println("This statement is not defined:"+name);
            System.exit(0);
        }
        switch (((Operation) setHashMap.getStatementMap().get(name)).getLabel()) {
            case "vardef":
                ((varDef) setHashMap.getStatementMap().get(name)).debug(set,program,instrument);
                break;
            case "assign":
                ((Assign) setHashMap.getStatementMap().get(name)).debug(set,program,instrument);
                break;
            case "print":
                ((Print) setHashMap.getStatementMap().get(name)).debug(set,program,instrument);
                break;
            case "skip":
                ((Skip) setHashMap.getStatementMap().get(name)).debug(set,program,instrument);
                break;
            case "block":
                ((Block) setHashMap.getStatementMap().get(name)).debug(set,program,instrument);
                break;
            case "if":
                ((IfElse) setHashMap.getStatementMap().get(name)).debug(set,program,instrument);
                break;
            case "while":
                ((While) setHashMap.getStatementMap().get(name)).debug(set,program,instrument);
        }
    }
    public static void listExpression(ArrayList<String> list,String expName) {
        if (setHashMap.getExpressionMap().containsKey(expName)) {
            if (((Operation) setHashMap.getExpressionMap().get(expName)).getLabel().equals("binexpr")) {
                ((binaryExp) setHashMap.getExpressionMap().get(expName)).printlist(list);
            }
            else ((unaryExp) setHashMap.getExpressionMap().get(expName)).printlist(list);
        }
        //don't need don't print

    }
    public static void listStatement(ArrayList<String> list,String sName) {
        if (setHashMap.getStatementMap().containsKey(sName)){
            switch (((Operation) setHashMap.getStatementMap().get(sName)).getLabel()) {
                case "vardef":
                    ((varDef) setHashMap.getStatementMap().get(sName)).printlist(list);
                    break;
                case "assign":
                    ((Assign) setHashMap.getStatementMap().get(sName)).printlist(list);
                    break;
                case "print":
                    ((Print) setHashMap.getStatementMap().get(sName)).printlist(list);
                    break;
                case "skip":
                    ((Skip) setHashMap.getStatementMap().get(sName)).printlist(list);
                    break;
                case "block":
                    ((Block) setHashMap.getStatementMap().get(sName)).printlist(list);
                    break;
                case "if":
                    ((IfElse) setHashMap.getStatementMap().get(sName)).printlist(list);
                    break;
                case "while":
                    ((While) setHashMap.getStatementMap().get(sName)).printlist(list);
            }
        }//don't need don't print
    }
}

