package hk.edu.polyu.comp.comp2021.simple.model;


import java.util.ArrayList;
import java.util.HashSet;

public class Assign extends Operation {
    private String label;
    private String varName;
    private String expName;
    private Operation exp;
//    private Variable v;

    public Assign(String input_){
        super(input_);
        label = getinput()[1];
        this.varName = this.getinput()[2];
        this.expName = this.getinput()[3];
    }
    public String getexpName() {
        return this.expName;
    }
    public void setexp(Operation exp) {
        this.exp = exp;
    }

    public void execute(Instrument instrument) {
//        this.v = this.findToBeassigned();

        setexp(Checking.getvalue(this.getexpName()));
        try{
            setHashMap.getVariableMap().get(varName);
        }catch (NullPointerException e){
            System.out.println("Error"+this.getInputString());
            System.out.println(varName +"hasn't been defined. "+this.getInputString());
            System.exit(0);
        }
        if (this.exp.gettype()==Typ.INT) {
            if (((Variable) setHashMap.getVariableMap().get(varName)).getvalue() instanceof Integer){
                setHashMap.getVariableMap().put(varName, new Variable<Integer>(this.exp.getint_value()));
            }else {
                System.out.println("Error: "+this.getInputString());
                System.out.println("Data type conflict.");
                System.exit(0);
            }
        }else if (this.exp.gettype()==Typ.BOOL) {
            if (((Variable) setHashMap.getVariableMap().get(varName)).getvalue() instanceof Boolean){
                setHashMap.getVariableMap().put(varName, new Variable<Boolean>(this.exp.getbool_value()));
            }else {
                System.out.println("Error: "+this.getInputString());
                System.out.println("Data type conflict.");
                System.exit(0);
            }
        }


    }
    public void debug(HashSet<String> set, String program,Instrument instrument){
        execute(instrument);
    }


    private Variable findToBeassigned() {
        return (Variable) setHashMap.getVariableMap().get(this.varName);
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



