package Logic;

import java.util.ArrayList;
import HelperClasses.IndexOfAChar;

public class Decoder {
    private char[][] key;

    //Constructor
    public Decoder(char[][] key){ this.key = key; }

    public String decode(String word){
        ArrayList<int[]> indexOfNewKey = new ArrayList<>();
        StringBuilder decryptedWord = new StringBuilder();
        decryptedWord.setLength(0);

        //Creating array of key indexes for the string
        IndexOfAChar.IndexCheck(indexOfNewKey, word, key);

        for (int i = 0; i < word.length(); i+=2){
            //Adding variables for readability
            int column1 = indexOfNewKey.get(i)[1];
            int column2 = indexOfNewKey.get(i + 1)[1];

            int row1 = indexOfNewKey.get(i)[0];
            int row2 = indexOfNewKey.get(i + 1)[0];

            //Checking if there is an 'x' in the pair and skipping iteration
            if (word.charAt(i + 1) == 'x') {
                decryptedWord.append(key[row1][column1]).append("x");

            } else if (word.charAt(i) == 'x') {
                decryptedWord.append("x").append(key[row2][column2]);

            //Checking if there is an ' ' in the pair
            } else if(word.charAt(i + 1) == ' ') {
                decryptedWord.append(key[row1][column1]).append(" ");

            } else if (word.charAt(i) == ' ')  {
                decryptedWord.append(" ").append(key[row2][column2]);

              //Checking if both letters are in the same row in key
            } else if (row1 == row2){
                //checking if the index is out of bounds
                if(column1 - 1 < 0){ column1 = key[row1].length - 1; } else { column1 -= 1; }
                if(column2 - 1 < 0){ column2 = key[row2].length - 1; } else { column2 -= 1; }

                //Assigning the new letters for the string
                decryptedWord.append(key[row1][column1]).append(key[row2][column2]);

              //Checking if both letters are in the same column in key
            } else if (column1 == column2) {
                if (row1 - 1 < 0) { row1 = key[column1].length - 1; } else { row1 -= 1; }
                if (row2 - 1 < 0) { row2 = key[column2].length - 1; } else { row2 -= 1; }

                decryptedWord.append(key[row1][column1]).append(key[row2][column2]);

            } else {
                decryptedWord.append(key[row2][column1]).append(key[row1][column2]);
            }
        }

        return decryptedWord.toString();
    }
}
