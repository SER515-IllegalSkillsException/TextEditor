package controller;

import java.util.ArrayList;


public class SupportedKeywords {

    private String[] supportedLanguages = {".java",".cpp",".python"};

    private String[] java = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "System", "out", "print()", "println()",
            "new", "null", "package", "private", "protected", "public", "interface",
            "long", "native", "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while", "String"};
    private String[] cpp = { "auto", "const", "double", "float", "int", "short",
            "struct", "unsigned", "break", "continue", "else", "for", "long", "signed",
            "switch", "void", "case", "default", "enum", "goto", "register", "sizeof",
            "typedef", "volatile", "char", "do", "extern", "if", "return", "static",
            "union", "while", "asm", "dynamic_cast", "namespace", "reinterpret_cast", "try",
            "bool", "explicit", "new", "static_cast", "typeid", "catch", "false", "operator",
            "template", "typename", "class", "friend", "private", "this", "using", "const_cast",
            "inline", "public", "throw", "virtual", "delete", "mutable", "protected", "true", "wchar_t" };
    
    private String[] python = {"and","as","assert","break","class","continue","def","del","elif","else","except",
    		"False","finally","for","from","global","if","import","in","is","lambda","None",
    		"nonlocal","not","or","pass","raise","return","True","try","while","with","yield"};	

    
    public String[] getSupportedLanguages() {
        return supportedLanguages;
    }

    private String[] brackets = { "{", "(" };
    private String[] bCompletions = { "}", ")" };
    public String[] getJavaKeywords() {
        return java;
    }
    public String[] getCppKeywords() {
        return cpp;
    }
    public String[] getPythonKeywords() {
        return python;
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
