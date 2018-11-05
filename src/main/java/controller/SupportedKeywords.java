package controller;

import java.util.ArrayList;


public class SupportedKeywords {

    private String[] supportedLanguages = {".java"};

    private String[] java = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "System", "out", "print()", "println()",
            "new", "null", "package", "private", "protected", "public", "interface",
            "long", "native", "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while", "String"};

    
    public String[] getSupportedLanguages() {
        return supportedLanguages;
    }

    private String[] brackets = { "{", "(" };
    private String[] bCompletions = { "}", ")" };
    public String[] getJavaKeywords() {
        return java;
    }

    public ArrayList<String> getbracketCompletions() {
        ArrayList<String> al = new ArrayList<>();
        for(String completion : bCompletions) {
            al.add(completion);
        }
        return al;
    }
    public ArrayList<String> getbrackets() {
        ArrayList<String> al = new ArrayList<>();
        for(String completion : brackets) {
            al.add(completion);
        }
        return al;
    }
    public ArrayList<String> setKeywords(String[] arr) {
        ArrayList<String> al = new ArrayList<>();
        for(String words : arr) {
            al.add(words);
        }
        return al;
    }

}
