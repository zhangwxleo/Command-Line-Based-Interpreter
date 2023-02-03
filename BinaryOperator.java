package hk.edu.polyu.comp.comp2021.simple.model;


public enum BinaryOperator {
    ADD("+"), SUB("-"), MUL("*"), DIV("/"),
    GREATER(">"),GREATER_OR_EQUAL(">="),LESS("<"),LESS_OR_EQUAL("<="),
    EQUAL("=="),NOT_EQUAL("!="),REMAINDER("%"),

    AND ("&&"), OR("||");
    public static final int INTLOW = -99999;
    public static final int INTHIGH = 99999;
    private final String symbol;

    BinaryOperator(String symbol){
        this.symbol=symbol;
    }


    //int to int

    public int calculate(Operation left, Operation right){
        int result = 0;
        switch (this){
            case ADD:
                result = left.getint_value() + right.getint_value();
                result = Checking.resultChecking(result);
                break;
            case SUB:
                result = left.getint_value() - right.getint_value();
                result = Checking.resultChecking(result);
                break;
            case MUL:
                result = left.getint_value() * right.getint_value();
                result = Checking.resultChecking(result);
                break;
            case DIV:
                if (right.getint_value() != 0) {
                    result = left.getint_value() / right.getint_value();
                    result = Checking.resultChecking(result);
                }else {
                    System.out.println("Invalid equation: divided by 0."+left.getint_value()+" "+this.getSymbol()+" "+right.getint_value());
                    System.exit(0);
                }
                break;
            case REMAINDER:
                if (right.getint_value() != 0) {
                    result = left.getint_value() % right.getint_value();
                    result = Checking.resultChecking(result);
                }else {
                    System.out.println("Invalid equation: divided by 0."+left.getint_value()+" "+this.getSymbol()+" "+right.getint_value());
                    System.exit(0);
                }
                break;

        }

        return result;
    }

    //boolean to boolean
    public boolean bool_check(Operation left, Operation right){

        return switch (this) {
            case AND -> left.getbool_value() && right.getbool_value();
            case OR -> left.getbool_value() || right.getbool_value();
            case EQUAL -> left.getbool_value() == right.getbool_value();
            case NOT_EQUAL -> left.getbool_value() != right.getbool_value();
            default -> true;
        };
    }

    // int to boolean
    public boolean bool_calculate(Operation left, Operation right){

        return switch (this) {
            case GREATER -> left.getint_value() > right.getint_value();
            case GREATER_OR_EQUAL -> left.getint_value() >= right.getint_value();
            case LESS -> left.getint_value() < right.getint_value();
            case LESS_OR_EQUAL -> left.getint_value() <= right.getint_value();
            case EQUAL -> left.getint_value() == right.getint_value();
            case NOT_EQUAL -> left.getint_value() != right.getint_value();
            default -> true;
        };
    }

    public String getSymbol(){
        return this.symbol;
    }


    public static BinaryOperator fromString(String symbol){
        for(BinaryOperator operator: BinaryOperator.values()){
            if(operator.getSymbol().equals(symbol)){
                return operator;
            }
        }
        return null;
    }
}

