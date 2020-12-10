package day7.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            // File reader
            File input = new File("src/input/day_7.txt");
            Scanner reader = new Scanner(input);


            // Loop over all the lines
            while (reader.hasNextLine()) {

                // Read the line
                String line = reader.nextLine();

            }

        } catch (FileNotFoundException ignored) {

        }

    }
    
}
