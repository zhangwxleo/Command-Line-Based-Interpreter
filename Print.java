package hk.edu.polyu.comp.comp2021.simple.model;


import java.util.ArrayList;
import java.util.HashSet;

public class Print extends Operation {
    //    private String label;
    private Operation exp;
    private String expName;
    private String label;
    public Print(String input_){
        super(input_);
        label = getinput()[1];
        expName = getinput()[2];
    }

    private String getexpName(){
        return this.expName;
    }
    public void setexp(Operation exp) {
        this.exp = exp;
    }

    public void execute(Instrument instrument){
        setexp(Checking.getvalue(this.getexpName()));
        if (this.exp.gettype()==Typ.INT) {

            System.out.println("["+this.exp.getint_value()+"]");
        }else {
            System.out.println("["+this.exp.getbool_value()+"]");
        }

    }
    public void debug(HashSet<String> set, String program,Instrument instrument){
        execute(instrument);
    }
    @Override
    public void printlist(ArrayList<String> list) {
        Checking.listExpression(list, this.expName);

        if (!list.contains(this.getInputString())) {
//        	System.out.println(this.getInputString());
            list.add(this.getInputString());
        }
    }

}


