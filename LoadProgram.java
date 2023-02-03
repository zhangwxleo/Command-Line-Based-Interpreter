package hk.edu.polyu.comp.comp2021.simple.model;


import java.io.*;

import static hk.edu.polyu.comp.comp2021.simple.model.InputProcessing.*;

public class LoadProgram {
    private final String path;
    private final String programName;
    public LoadProgram(String input_){
        String[] input = input_.split(" ");
        path = input[1];
        programName = input[2];
    }

    public void Load(){
        String Path = this.path;
        BufferedReader reader = null;
        String data = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String com = null;
            while ((com = reader.readLine()) != null) {
                String[] inputlist = com.split(" ");
//            	System.out.println(com);
                switch (inputlist[0]) {
                    case "vardef" -> vardefChecking(com);
                    case "binexpr" -> binexprChecking(com);
                    case "unexpr" -> unexprChecking(com);
                    case "assign" -> assignChecking(com);
                    case "print" -> printChecking(com);
                    case "skip" -> skipChecking(com);
                    case "block" -> blockChecking(com);
                    case "if" -> ifChecking(com);
                    case "while" -> whileChecking(com);
                    case "program"-> {
                        com = inputlist[0] + " " + programName + " " + inputlist[2];
                        programChecking(com);
                    }

                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

