package hk.edu.polyu.comp.comp2021.simple.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Block extends Operation {
    private String label;
    private List<String> list = new ArrayList<>();

    public Block(String input_){
        super(input_);
        label = this.getinput()[1];
        for (int i = 2,j=0; i<this.getinput().length;i++,j++){
            list.add(getinput()[i]);
        }
    }
    //x=100 exp1 = 2000 exp2 = -2000 x = -2000 40000

    public void execute(Instrument instrument){
        for (int i = 0; i<list.size(); i++){
//        	System.out.println(list.get(i));
            if (setHashMap.getStatementMap().containsKey(list.get(i))){
                instrument.checkBefore(list.get(i));
                Checking.executeStatement(list.get(i),instrument);
                instrument.checkAfter(list.get(i));

            }
            else {
                System.out.println("Error: "+this.getInputString());
                System.out.println("The statement doesn't exist: "+list.get(i));
                System.exit(0);
            }
        }

    }
    public void debug(HashSet<String> set, String program,Instrument instrument){
        for (int i = 0; i<list.size(); i++){
//        	System.out.println(list.get(i));
            if (setHashMap.getStatementMap().containsKey(list.get(i))){
                instrument.checkBefore(list.get(i));
                Checking.debugStatement(list.get(i),set,program,instrument);
                instrument.checkAfter(list.get(i));
            }
            else {
                System.out.println("The statement doesn't exist.");
                throw new IllegalArgumentException();
            }
        }
    }
    @Override
    public void printlist(ArrayList<String> newlist) {
        for (int i = 0; i<this.list.size(); i++){
            Checking.listStatement(newlist, this.list.get(i));
        }
//    	System.out.println(!list.contains(this.getInputString()));
        if (!newlist.contains(this.getInputString())) {
//        	System.out.println(this.getInputString());
            newlist.add(this.getInputString());
        }
    }
}
