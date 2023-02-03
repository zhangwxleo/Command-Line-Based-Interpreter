package hk.edu.polyu.comp.comp2021.simple.model;


import java.util.ArrayList;

//value
public class binaryExp extends Operation {

    private BinaryOperator binaryOperator;
    private Operation left;
    private Operation right;
    private Typ left_type;
    private Typ right_type;
    private Typ type;



    private String Leftname;
    private String Rightname;

    public binaryExp(String input_) {
        super(input_);
        this.binaryOperator = BinaryOperator.fromString(this.getinput()[3]);
        this.Leftname = this.getinput()[2];
        this.Rightname = this.getinput()[4];
    }


    @Override
    public void execute() {

        this.left = Checking.getvalue(Leftname);
        this.right = Checking.getvalue(Rightname);
        this.left_type = this.left.gettype();
        this.right_type = this.right.gettype();
        if (this.left_type == Typ.INT) {
            if (this.right_type == Typ.INT){
                if (getinput()[3].equals("+") || getinput()[3].equals("-") || getinput()[3].equals("*") || getinput()[3].equals("/") || getinput()[3].equals("%")) {
                    super.set_intValue(binaryOperator.calculate(left, right));
                    this.type = Typ.INT;
                    super.set_type(Typ.INT);
//              this.set_intValue(binaryOperator.calculate(left,right));
                } else if (getinput()[3].equals(">") || getinput()[3].equals("<") || getinput()[3].equals(">=") ||
                        getinput()[3].equals("<=") || getinput()[3].equals("==") || getinput()[3].equals("!=")) {
                    super.set_boolValue(binaryOperator.bool_calculate(left, right));
                    this.type = Typ.BOOL;
                    super.set_type(Typ.BOOL);
//              this.set_boolValue(binaryOperator.bool_calculate(left, right));
//              System.out.println(this.getbool_value()+"inside");
                }else {
                    System.out.println("Error"+this.getInputString());
                    System.out.println("Invalid operator:"+this.getInputString());
                    System.exit(0);
                }
            }else {
                System.out.println("Error"+this.getInputString());
                System.out.println("Not corresponding data type for 2 expressions: "+this.getInputString());
                System.exit(0);
            }

        } else if (this.left_type == Typ.BOOL) {
            if (this.right_type==Typ.BOOL){
                if (this.getinput()[3].equals("&&") || getinput()[3].equals("||") || getinput()[3].equals("==")|| getinput()[3].equals("!=") ){
                    super.set_boolValue(binaryOperator.bool_check(left, right));
                    this.type = Typ.BOOL;
                    super.set_type(Typ.BOOL);
                }else {

                    System.out.println("Invalid operator:"+this.getInputString());
                    System.exit(0);
                }

            }else {
                System.out.println("Not corresponding data type for 2 expressions: "+this.getInputString());
                System.exit(0);

            }

//          this.set_boolValue(binaryOperator.bool_check(left, right));
        }
//      System.out.println(this.getbool_value());

    }


    @Override
    public void printlist(ArrayList<String> list) {
        Checking.listExpression(list, this.Leftname);
        Checking.listExpression(list, this.Rightname);

        if (!list.contains(this.getInputString())) {
//    	System.out.println(this.getInputString());
            list.add(this.getInputString());
        }
    }


}