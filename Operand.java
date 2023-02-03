package hk.edu.polyu.comp.comp2021.simple.model;


public class Operand {
    private int value;                                                            // define value
    private boolean bool_value;                                                   //define boolean

    public Operand(int value) {                                                   // Value Type: int Operand
        this.value = value;
    }

    public Operand(boolean bool_value){                                          //return Type: boolean Operand
        this.bool_value = bool_value;
    }


    public int evaluate() {                                                      // return the int value of each operand
        return value;
    }

    public boolean bool_evaluate(){                                             //return boolean value of each Operand
        return bool_value;
    }

    public boolean bo_evaluate(){                                              //For Boolean check: return boolean value
        return bool_value;
    }


    public String toString(){                                                  // change the integer value into string
        return String.valueOf(this.value);
    }

    public static Operand fromString(String s){                                //change a int string into operand
        return new Operand(Integer.parseInt(s));
    }

    public static Operand fromStringToBoolean(String s){                       //change a boolean string into operand
        boolean return_O = true;
        if (s.equals("true")){
            return_O = true;
        }
        else if (s.equals("false")){
            return_O = false;
        }
        return new Operand(return_O);
    }

}

