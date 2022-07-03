package tests.console.week01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
//Updated ReverseWordTest
public class ReverseWordsTest {

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("========================================================");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t \t  R  E  V  E  R  S  E    F  I  L  E    T  E  S  T");
        System.out.println(" \t \t      T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("========================================================");
        System.out.println();
        System.out.println();
    }

    public static void read(String inputLocation, List<String> list) throws FileNotFoundException{
        //TODO: READ IN DATA FROM INPUT FILE LOCATION

        File file = new File (inputLocation); // assigning a new file object
        Scanner input = new Scanner (file); // assigning a new scanner object

        //TODO: REVERSE LINES
        //TODO: REVERSE WORDS

        while (input.hasNext()){
            String wordsandlines = input.nextLine();
            System.out.println(wordsandlines);


            String[]  words = wordsandlines.split(" ");

            if(words.length > 0){
                List<String> newWords = new ArrayList<>();

                for(int i = words.length - 1; i >= 0; i-- ){

                    newWords.add(words[i]);
                }

                System.out.println(newWords);
            }

        }
        input.close();
    }


    public static void write(String outputLocation, List<String> list) throws FileNotFoundException{
        //TODO : WRITE TO OUTPUT FILE LOCATION
        PrintStream output      = new PrintStream(outputLocation); // new output object

        for(String sting:list){
            System.out.println(sting);
            output.println(sting);
        }
        //outputting the file location

        output.close();
    }


    public static void main(String[] args) throws FileNotFoundException{
        String inputLocation    = "." + File.separator + "data" + File.separator + "words.txt";
        String outputLocation   = "." + File.separator + "results" + File.separator + "reverse_words.txt";


        //TODO: update program to use an Array List

        List <String> list = new ArrayList<>(); // making the program use an array list


        // TODO: process items in file

        read(inputLocation, list); // calling the function read
        write(outputLocation, list); //  calling the function write
    }
}
