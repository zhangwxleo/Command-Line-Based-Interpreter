package hk.edu.polyu.comp.comp2021.simple.model;


import java.util.HashMap;

public class setHashMap {
    private static HashMap<String, Operation> statements = new HashMap<>();
    private static HashMap<String, Variable> variables = new HashMap<>();
    private static HashMap<String, Operation> expressions = new HashMap<>();
    private static HashMap<String, Program> programs = new HashMap<>();
//    public static HashMap<String,String> breakpoints = new HashMap<>();
//    public static HashMap getBreakPoints(){
//        return breakpoints;
//    }

    public static HashMap getStatementMap() {
        return statements;
    }
    public static HashMap getProgramMap() {
        return programs;
    }
    public static HashMap getExpressionMap() {
        return expressions;
    }
    //not used
    public static HashMap getVariableMap() {
        return variables;
    }



}
