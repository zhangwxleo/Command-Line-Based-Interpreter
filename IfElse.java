package hk.edu.polyu.comp.comp2021.simple.model;


import java.util.ArrayList;
import java.util.HashSet;

public class IfElse extends Operation {
    private String label;
    private String condition;
    private String trueStatement;
    private String falseStatement;
    private Operation conditionO;
    private Operation trueStatementO;
    private Operation falseStatementO;
    public IfElse(String input_){
        super(input_);
        this.condition = this.getinput()[2];
        this.trueStatement = this.getinput()[3];
        this.falseStatement = this.getinput()[4];
        label = this.getinput()[1];
    }
    public void setCondition(Operation o){
        this.conditionO = o;
    }
    public void settrue(Operation o){
        this.trueStatementO = o;
    }
    public void setfalse(Operation o) {
        this.falseStatementO = o;
    }
    public Operation getCondition() {
        return this.conditionO;
    }
    public Operation gettrue() {
        return this.trueStatementO;
    }
    public Operation getfalse() {
        return this.falseStatementO;
    }


    public void execute(Instrument instrument){
        if (Checking.getvalue(condition).gettype()==Typ.BOOL){
            if (Checking.getvalue(condition).getbool_value()) {
                instrument.checkBefore(trueStatement);
                Checking.executeStatement(trueStatement,instrument);
                instrument.checkAfter(trueStatement);
            }else  {
                instrument.checkBefore(falseStatement);
                Checking.executeStatement(falseStatement,instrument);
                instrument.checkAfter(falseStatement);
            }
        }else {
            System.out.println("Error: "+this.getInputString());
            System.out.println("condition is not bool value");
            System.exit(0);
        }

    }
    public void debug(HashSet<String> set, String program,Instrument instrument){
        if (Checking.getvalue(condition).gettype()==Typ.BOOL){
            if (Checking.getvalue(condition).getbool_value()) {
                instrument.checkBefore(trueStatement);
                Checking.debugStatement(trueStatement,set,program,instrument);
                instrument.checkAfter(trueStatement);
            }else if (!Checking.getvalue(condition).getbool_value()) {
                instrument.checkBefore(falseStatement);
                Checking.debugStatement(falseStatement,set,program,instrument);
                instrument.checkAfter(falseStatement);
            }
        }else {
            System.out.println("Error: "+this.getInputString());
            System.out.println("condition is not bool value");
            System.exit(0);
        }

    }
    @Override
    public void printlist(ArrayList<String> list) {
        Checking.listExpression(list, this.condition);
        Checking.listStatement(list, this.trueStatement);
        Checking.listStatement(list, this.falseStatement);

        if (!list.contains(this.getInputString())) {
//        	System.out.println(this.getInputString());
            list.add(this.getInputString());
        }
    }

}