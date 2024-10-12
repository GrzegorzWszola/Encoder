package HelperClasses;

import java.util.ArrayList;

public class IndexOfAChar {
    public static ArrayList<int[]> IndexCheck(ArrayList<int[]> index, String input, char[][]key){
        for (int i = 0; i < input.length(); i += 2) {

            //Checking for index of a char in key
            //Checking index of a first number
            for (int j = 0; j < key.length; j++) {
                for (int k = 0; k < key[j].length; k++) {
                    if (key[j][k] == input.charAt(i)) {
                        index.add(new int[]{j, k});
                    }
                }
            }

            //Checking index of a second number
            for (int j = 0; j < key.length; j++) {
                for (int k = 0; k < key[j].length; k++) {
                    if (key[j][k] == input.charAt(i + 1)) {
                        index.add(new int[]{j, k});
                    }
                }
            }
        }

        return index;
    }
}
