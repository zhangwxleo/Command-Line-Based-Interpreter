package hk.edu.polyu.comp.comp2021.simple.model;

import java.util.ArrayList;
import java.util.Arrays;

public class ErrorChecking {
    private static final ArrayList<String> name = new ArrayList<String>(
            Arrays.asList("int","bool","true","false","vardef","binexpr",
                    "unexpr","assign","print","skip","block","if","while","program","execute",
                    "list","store","load","quit","debug","togglebreakpoint","inspect","instrument"));

    public static boolean NameChecking(String s){
        if (s.length()>8) return false;
        if (!((s.charAt(0)>='a'&&s.charAt(0)<='z')||(s.charAt(0)>='A'&&s.charAt(0)<='Z'))) return false;
        for(int i=1;i<s.length();i++){
            if (!((s.charAt(0)>='a'&&s.charAt(0)<='z')||(s.charAt(0)>='A'&&s.charAt(0)<='Z')||(s.charAt(i)>='0'&&s.charAt(i)<='9'))) return false;
        }if (name.contains(s)) return false;
        return true;
    }

}
