package Logic;

import HelperClasses.IndexOfAChar;

import java.util.ArrayList;

public class Encoder {
    private char[][] key;

    //Constructor
    public Encoder(char[][] key){
        this.key = key;
    }

    public String encode(String word){
        ArrayList<int[]> indexOfNewKey = new ArrayList<>();
        StringBuilder encryptedWord = new StringBuilder();
        encryptedWord.setLength(0);

        //Creating array of key indexes for the string
        IndexOfAChar.IndexCheck(indexOfNewKey, word, key);

        for (int i = 0; i < word.length(); i += 2) {
            //Adding variables for readability
            int column1 = indexOfNewKey.get(i)[1];
            int column2 = indexOfNewKey.get(i + 1)[1];

            int row1 = indexOfNewKey.get(i)[0];
            int row2 = indexOfNewKey.get(i + 1)[0];

            //Checking if the string has an x at the end and skipping this iteration
            if (word.charAt(i + 1) == 'x') {
                encryptedWord.append(key[row1][column1]).append("x");

            } else if (word.charAt(i) == 'x') {
                encryptedWord.append("x").append(key[row2][column2]);

            //Checking if there is an ' ' in the pair
            } else if(word.charAt(i + 1) == ' ') {
                encryptedWord.append(key[row1][column1]).append(" ");

            } else if (word.charAt(i) == ' ')  {
                encryptedWord.append(" ").append(key[row2][column2]);

            //Checking if the pair is in the same row
            }else if (row1 == row2) {
                //checking if the index is out of bounds
                if(column1 + 1 >= key[row1].length){ column1 = 0; } else { column1 += 1; }
                if(column2 + 1 >= key[row2].length){ column2 = 0; } else { column2 += 1; }

                encryptedWord.append(key[row1][column1]).append(key[row2][column2]);

              //Checking if the letters are in the same column
            } else if(column1 == column2){
                if(row1 + 1 >= key[column1].length){ row1 = 0; } else { row1 += 1; }
                if(row2 + 1 >= key[column2].length){ row2 = 0; } else { row2 += 1; }

                encryptedWord.append(key[row1][column1]).append(key[row2][column2]);

              //Assigning the letters if everything is okay
            } else {
                encryptedWord.append(key[row2][column1]).append(key[row1][column2]);
            }
        }
        return encryptedWord.toString();
    }
}
