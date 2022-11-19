
//Emon Sarker
//1931461642

import java.util.*;

class main{


    public static void main(String[] args){

        // Initialize Hashmaps
        HashMap<String, String> lexemeDictionary = new HashMap<String, String>();

        // Initialize Identifier
        lexemeDictionary.put("auto","KEYWORD");
        lexemeDictionary.put("break","KEYWORD");
        lexemeDictionary.put("case","KEYWORD");
        lexemeDictionary.put("char","KEYWORD");
        lexemeDictionary.put("const","KEYWORD");
        lexemeDictionary.put("continue","KEYWORD");
        lexemeDictionary.put("define","KEYWORD");
        lexemeDictionary.put("do","KEYWORD");
        lexemeDictionary.put("double","KEYWORD");
        lexemeDictionary.put("else","KEYWORD");
        lexemeDictionary.put("enum","KEYWORD");
        lexemeDictionary.put("extern","KEYWORD");
        lexemeDictionary.put("float","KEYWORD");
        lexemeDictionary.put("for","KEYWORD");
        lexemeDictionary.put("goto","KEYWORD");
        lexemeDictionary.put("if","KEYWORD");
        lexemeDictionary.put("int","KEYWORD");
        lexemeDictionary.put("long","KEYWORD");
        lexemeDictionary.put("register","KEYWORD");
        lexemeDictionary.put("return","KEYWORD");
        lexemeDictionary.put("short","KEYWORD");
        lexemeDictionary.put("signed","KEYWORD");
        lexemeDictionary.put("sizeof","KEYWORD");
        lexemeDictionary.put("static","KEYWORD");
        lexemeDictionary.put("struct","KEYWORD");
        lexemeDictionary.put("switch","KEYWORD");
        lexemeDictionary.put("typedef","KEYWORD");
        lexemeDictionary.put("union","KEYWORD");
        lexemeDictionary.put("unsigned","KEYWORD");
        lexemeDictionary.put("void","KEYWORD");
        lexemeDictionary.put("volatile","KEYWORD");
        lexemeDictionary.put("while","KEYWORD");

        // Initialize OPERATORs
        lexemeDictionary.put(".","DOT OPERATOR");
        lexemeDictionary.put(",","COMMA OPERATOR");
        lexemeDictionary.put(":","COLON OPERATOR");
        lexemeDictionary.put(";","SEMI-COLON OPERATOR");
        lexemeDictionary.put("'","CHAR OPERATOR");
        lexemeDictionary.put("\"","STRING OPERATOR");
        lexemeDictionary.put("!","NOT OPERATOR");
        lexemeDictionary.put("|","OR OPERATOR");
        lexemeDictionary.put("/","FORWARD SLASH OPERATOR");
        lexemeDictionary.put("\\","BACK SLASH OPERATOR");
        lexemeDictionary.put("~","EQUIVALENCY OPERATOR");
        lexemeDictionary.put("_","UNDERSCORE OPERATOR");
        lexemeDictionary.put("?","TERNARY OPERATOR");
        lexemeDictionary.put("$","MEMORY OPERATOR");
        lexemeDictionary.put("%","MODULO OPERATOR");
        lexemeDictionary.put("#","HASH OPERATOR");
        lexemeDictionary.put("&","AMPERSAND OPERATOR");
        lexemeDictionary.put("*","MULTIPLY OPERATOR");
        lexemeDictionary.put("-","SUBTRACT OPERATOR");
        lexemeDictionary.put("+","ADD OPERATOR");
        lexemeDictionary.put("<","LESS THAN OPERATOR");
        lexemeDictionary.put(">","GREATER THAN OPERATOR");
        lexemeDictionary.put("(","LEFT PARENTHESIS");
        lexemeDictionary.put(")","RIGHT PARENTHESIS");
        lexemeDictionary.put("{","LEFT BRACE");
        lexemeDictionary.put("}","RIGHT BRACE");
        lexemeDictionary.put("[","LEFT BRACKET");
        lexemeDictionary.put("]","RIGHT BRACKET");
        lexemeDictionary.put("\\n","NEXT LINE");
        lexemeDictionary.put("\\t","TAB SPACE");
        lexemeDictionary.put("\\a","OPERATOR");
        lexemeDictionary.put("\\f","OPERATOR");
        lexemeDictionary.put("\\v","OPERATOR");
        lexemeDictionary.put("\\0","EOF");
        lexemeDictionary.put("\\\\","OPERATOR");

        // create scanner object
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder("");

        // Program Variables
        String line = "";
        char[] ch;
        String lexeme = "";
        String token = "";

        // Program Loop
        while(true){
            line = input.nextLine(); // take input
            ch = line.toCharArray(); // String to Char Array

            // Iterate over String
            for(int i=0; i<ch.length;i++){

                // check if char is letter or number
                boolean charCheck = (ch[i] >= 65 && ch[i] <= 90) || (ch[i] >= 97 && ch[i] <= 122);
                boolean numCheck =  (ch[i] >= 48 && ch[i] <= 57) ;


                if(charCheck){
                    // letter based keywords or identifiers
                    while(charCheck){
                        sb.append(ch[i]);
                        i++;
                        charCheck = (ch[i] >= 65 && ch[i] <= 90) || (ch[i] >= 97 && ch[i] <= 122);
                    }
//                    System.out.print(lexeme);
                    lexeme = sb.toString();
                    sb = new StringBuilder("");
                    token = lexemeDictionary.get(lexeme);

                    if(token == null){
                        System.out.println("Next token is: IDENTIFIER Next lexeme is "+lexeme);
                    }
                    else{
                        System.out.println("Next token is: "+token+ " Next lexeme is "+lexeme);
                    }
                }
                else if(numCheck){
                    // number literals
                    while(numCheck){
                        sb.append(ch[i]);
                        i++;
                        numCheck =  (ch[i] >= 48 && ch[i] <= 57) ;
                    }
                    i--;
//                    System.out.print(lexeme);
                    lexeme = sb.toString();
                    sb = new StringBuilder("");
                    System.out.println("Next token is: INT_LITERAL Next lexeme is "+lexeme);
                }
                else if(!(ch[i]==' ')){
                    // Operators or Special Character
                    sb.append(ch[i]);
                    lexeme = sb.toString();
                    sb = new StringBuilder("");
                    token = lexemeDictionary.get(lexeme);
                    if(token == null){
                        System.out.println("Next token is: SPECIAL CHARACTER Next lexeme is "+lexeme);
                    }
                    else{
                        System.out.println("Next token is: "+token+ " Next lexeme is "+lexeme);
                    }
                }
            }

        }

    }
}