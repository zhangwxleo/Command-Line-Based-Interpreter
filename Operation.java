package hk.edu.polyu.comp.comp2021.simple.model;


import java.util.ArrayList;


//
public class Operation {

    private int int_value;
    private String label;
    private boolean bool_value;
    private String inputString;
    private Typ type;
    private String[] input;
    public Operation (String input_){
        this.inputString = input_;
        input = input_.split(" ");
        this.label = input[0];
    }
    public String getLabel() {
        return this.label;
    }
    public Operation (Typ type) {
        this.type = type;
    }
    public Operation (int a) {
        this.set_intValue(a);
        this.set_type(Typ.INT);
    }
    public Operation (boolean b) {
        this.set_boolValue(b);
        this.set_type(Typ.BOOL);
    }
    public String[] getinput() {
        return this.input;
    }
    public Typ gettype() {
        return this.type;
    }
    public void set_type(Typ type) {
        this.type = type;
    }
    public void execute() {}
    public int getint_value(){
        return int_value;
    }public boolean getbool_value() {
        return bool_value;
    }public void set_intValue(int a) {
        this.int_value = a;
    }public void set_boolValue(boolean b) {
        this.bool_value = b;
    }
    public String getInputString() {
        return this.inputString;
    }public void printlist(ArrayList<String> list) {

    }

}