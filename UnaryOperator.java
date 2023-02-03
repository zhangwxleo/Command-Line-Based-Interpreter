package hk.edu.polyu.comp.comp2021.simple.model;


public enum UnaryOperator {
    PLUS("#"), MINUS("~"),NOT("!");
    private final String symbol;

    UnaryOperator(String symbol){
        this.symbol=symbol;
    }

    public int calculateInt(Operation op) {
        int result = 0;
        switch (this) {
            case PLUS -> {
                result = op.getint_value();
                result = Checking.resultChecking(result);
            }
            case MINUS -> {
                result = -op.getint_value();
                result = Checking.resultChecking(result);
            }
        }
        return result;
    }
    public boolean calculateBool(Operation op) {
        boolean result = true;
        return switch (this) {
            case NOT -> !op.getbool_value();
            default -> result;
        };
    }

    public String getSymbol(){
        return this.symbol;
    }

    public String toString(){
        return getSymbol();
    }

    public static UnaryOperator fromString(String symbol){
        for(UnaryOperator operator: UnaryOperator.values()){
            if(operator.getSymbol().equals(symbol)){
                return operator;
            }
        }
        return null;
    }
}
