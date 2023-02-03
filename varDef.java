package hk.edu.polyu.comp.comp2021.simple.model;


import java.util.ArrayList;
import java.util.HashSet;

public class varDef extends Operation{
    //private T value;
    private int num;
    private Typ type;
    protected boolean judge;
    private String varName;
    private Operation expression;
    private final String expName;
    private final String labName;
    private String inputType;


    public varDef(String input_) {
        super(input_);
        this.labName = getinput()[1];
        this.expName = getinput()[4];
        this.inputType = getinput()[2];
        switch(this.getinput()[2]){
            case "int":
                this.varName = this.getinput()[3];
                type = Typ.INT;//means that the variable is the type of integer
                super.set_type(type);
                break;
            case "bool":
                this.varName = this.getinput()[3];
                type = Typ.BOOL;
                super.set_type(type);
                break;
        }
    }

    public int get_IntValue(){
        return num;
    }

    public boolean get_BoolValue(){
        return this.judge;
    }

    public String get_VarName() {
        return this.varName;
    }
    public void setExpression(Operation expression) {
        this.expression = expression;
    }

    public void execute(Instrument instrument) {

        setExpression(Checking.getvalue(expName));
        if (this.type==Typ.INT) {
            if (setHashMap.getVariableMap().containsKey(this.get_VarName())){
                System.out.println("Error: "+this.getInputString() );
                System.out.println("This variable has been defined:"+this.get_VarName());
                System.exit(0);
            }else if (this.expression.gettype()==Typ.BOOL){
                System.out.println("The expression should be int type: "+ this.getInputString());
                System.exit(0);
            }
            setHashMap.getVariableMap().put(this.get_VarName(),new Variable<Integer>(this.expression.getint_value()));
            this.set_intValue(this.get_IntValue());
        }else {
            if (setHashMap.getVariableMap().containsKey(this.get_VarName())){
                System.out.println("Error: "+this.getInputString() );
                System.out.println("This variable has been defined:"+this.get_VarName());
                System.exit(0);
            }else if (this.expression.gettype()==Typ.INT){
                System.out.println("The expression should be bool type: "+ this.getInputString());
                System.exit(0);
            }
            setHashMap.getVariableMap().put(this.get_VarName(), new Variable<Boolean>(this.expression.getbool_value()));
            this.set_boolValue(this.get_BoolValue());
        }
    }


    @Override
    public void printlist(ArrayList<String> list) {
        Checking.listExpression(list, this.expName);

        if (!list.contains(this.getInputString())) {
            list.add(this.getInputString());
        }
    }

    public void debug(HashSet<String> set, String program,Instrument instrument){
        execute(instrument);
    }

}


