package HelperClasses;

public class StringInsertX {
    public static String stringInserter(String word){
        String newWord = "";

        //Adding x if the same letter is twice
        for(int i = 0; i<word.length() - 1; i ++ ){
            if(word.charAt(i) == word.charAt(i+1)){
                newWord += word.charAt(i) + "x";
            } else {
                newWord += word.charAt(i) + "";
            }
        }
        //Adding last letter of the word
        newWord += word.charAt(word.length() - 1);

        return newWord;
    }

    //Adding or removing 'x' if the word is even or uneven
    public static String stringAddXAtEnd(String word){
        if(word.length() % 2 == 1 && !word.endsWith("x")){
            word += "x";
        } else if (word.length() % 2 == 1 && word.endsWith("x")){
            word = word.substring(0, word.length() - 1);
        }
        return word;
    }
}
