package Main;

import HelperClasses.StringInsertX;
import Logic.Decoder;
import Logic.Encoder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String word;
        String doContinue;
        char[][] key = {
                {'a', 'b', 'c', 'd', 'e'},
                {'f', 'g', 'h', 'i', 'j'},
                {'k', 'l', 'm', 'n', 'o'},
                {'p', 'q', 'r', 's', 't'},
                {'u', 'v', 'w', 'y', 'z'},
                {'x', ' '}};

        //Making objects of the encoder and decoder and providing the key for the encoding
        Encoder enc = new Encoder(key);
        Decoder dec = new Decoder(key);
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.print("String to encode: ");
            try {
                word = input.nextLine();
                if (word.matches(".*[^a-zA-Z\\s].*")) {
                    throw new Exception("Please do not provide any special characters or numbers");
                }
                if (word.isEmpty()) {
                    throw new Exception("Please provide any content");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }


            //setting the word to lower case
            word = word.toLowerCase();

            //Inserting 'x' in places where there are 2 of the same letter next to each other
            word = StringInsertX.stringInserter(word);
            //Adding an 'x' at the end if the word is uneven
            word = StringInsertX.stringAddXAtEnd(word);

            //Encoding
            word = enc.encode(word);
            System.out.println(word);

            //Inserting or removing 'x' at the end if the word is uneven or even
            word = StringInsertX.stringAddXAtEnd(word);

            //Decoding
            word = dec.decode(word);
            System.out.println(word);

            System.out.print("If you want to continue press 'y': ");
            doContinue = input.nextLine();
            if(!doContinue.equalsIgnoreCase("y")) { break; }

        }
    }

}