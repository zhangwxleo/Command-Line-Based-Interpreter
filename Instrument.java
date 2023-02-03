package hk.edu.polyu.comp.comp2021.simple.model;

import java.util.ArrayList;

public class Instrument {
    private static ArrayList<String> instrumentStat = new ArrayList<>(); // which statement to be instrumented
    private static ArrayList<String> instrumentVal = new ArrayList<>();  // instrument which value
    private static ArrayList<String> instrumentPos = new ArrayList<>(); // before or after
    Instrument(){

    }
    public void setInstrument(String stat, String pos, String val){

        //input all instrument, allow multiple statements for one
        instrumentStat.add(stat);
        instrumentVal.add(val);
        instrumentPos.add(pos);
    }
    public void checkBefore(String program_name){
        if (setHashMap.getStatementMap().containsKey(program_name)) { // if statement exists
            for (int i = 0; i < this.instrumentPos.size(); i++) {
                if (program_name.equals(instrumentStat.get(i))) // if statement is intrumented
                    if (instrumentPos.get(i).equals("before")) {
                        Operation exp = Checking.getvalue(instrumentVal.get(i));
                        if (exp.gettype()==Typ.INT) {

                            System.out.println("{"+exp.getint_value()+"}");
                        }else  {
                            System.out.println("{"+exp.getbool_value()+"}");
                        }
                    }
            }
        }
    }
    public void checkAfter(String program_name){
        if (setHashMap.getStatementMap().containsKey(program_name)) {
            for (int i = 0; i < this.instrumentPos.size(); i++) {
                if (program_name.equals(instrumentStat.get(i)))
                    if (instrumentPos.get(i).equals("after")) {
                        Operation exp = Checking.getvalue(instrumentVal.get(i));
                        if (exp.gettype()==Typ.INT) {
                            System.out.println("{"+exp.getint_value()+"}");
                        }else  {
                            System.out.println("{"+exp.getbool_value()+"}");
                        }
                    }
            }
        }
    }
}

