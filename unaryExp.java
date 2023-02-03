package hk.edu.polyu.comp.comp2021.simple.model;

import java.util.ArrayList;

public class unaryExp extends Operation{
    private UnaryOperator unaryOperator;
    private Operation exp;
    private Typ type;
    private String expName;
    public unaryExp(String input_) {
        super(input_);
        this.unaryOperator = UnaryOperator.fromString(this.getinput()[2]);
        this.expName = this.getinput()[3];
    }


    @Override
    public void execute() {
        this.exp = Checking.getvalue(this.getinput()[3]);
        this.type =  this.exp.gettype();
        super.set_type(type);

        if (this.type == Typ.INT) {
            if (getinput()[2].equals("#")||getinput()[2].equals("~")){
                super.set_intValue(unaryOperator.calculateInt(exp));
                this.set_type(Typ.INT);
                super.set_type(Typ.INT);
            }else {
                System.out.println("Invalid operator for int type:"+this.getInputString());
                System.exit(0);
            }

//			this.set_intValue(unaryOperator.calculateInt(exp));
        }else {
            if (getinput()[2].equals("!")){
                super.set_boolValue(unaryOperator.calculateBool(exp));
                this.set_type(Typ.BOOL);
                super.set_type(Typ.BOOL);
            }else {
                System.out.println("Invalid operator for bool type:"+this.getInputString());
                System.exit(0);
            }

        }
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

//variable map


