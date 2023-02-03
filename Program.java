package hk.edu.polyu.comp.comp2021.simple.model;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 */
public class Program  {
//    public String label;

    private String program_name;
    private ArrayList<String> list = new ArrayList<>();
    private String address;
    private static HashSet<String> breakpoints = new HashSet<>();
//    public static HashSet<String> beforeinstruments = new HashSet<>();
//    public static HashSet<String> afterinstruments = new HashSet<>();
    private String program;
    private String inputString;
    private static Instrument instrument = new Instrument();


    public Program(String input_){
//        label = this.getinput()[1];
        this.program_name = input_.split(" ")[2];
        this.program = input_.split(" ")[1];
        this.inputString = input_;
    }
    public void addinstrument(String lab, String pos, String expName){


        if (!(pos.equals("after")||pos.equals("before"))){
            System.out.println("invalid position: "+pos);
        }else{
            this.instrument.setInstrument(lab,pos,expName);
        }
    }

    public void setbreakpoint(String s){

        if (breakpoints.contains(s)){
            breakpoints.remove(s);
        }
        else breakpoints.add(s);


    }


    public void debug(){
        setHashMap.getVariableMap().clear();
        this.instrument.checkBefore(program_name);
        Checking.debugStatement(program_name,breakpoints,program,instrument);
        this.instrument.checkAfter(program_name);
    }

    public void execute(){
        setHashMap.getVariableMap().clear();
        this.instrument.checkBefore(program_name);
        Checking.executeStatement(program_name, instrument);
        this.instrument.checkAfter(program_name);

    }

    public void printList() {
        Checking.listStatement(this.list,this.program_name);
        list.add(this.inputString);
        for (String s : list) {
            System.out.println(s);
        }

    }
    public void store(String path) {
        this.list.clear();
        Checking.listStatement(this.list,this.program_name);
        list.add(this.inputString);

        BufferedWriter writer = null;
        File file = new File(path);
        // create a new file if the file doesn't exist
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // write the data into the file
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false), StandardCharsets.UTF_8));
            for(int i=0;i<list.size();i++) {
                writer.write(list.get(i));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}