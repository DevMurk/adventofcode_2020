package day3.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            // File reader
            File input = new File("src/input/day_3.txt");
            Scanner reader = new Scanner(input);

            ArrayList<String> rows = new ArrayList<>();

            // Loop over all the lines
            while (reader.hasNextLine()) {

                // Read the line
                String line = reader.nextLine();
                rows.add(line);

            }

            // Loop over rows and find char
            int x = 0, trees = 0;
            for (String row : rows) {

                if (row.charAt(x) == '#') trees++;
                x = x + 3 >= rows.get(0).length() ? x + 3 - rows.get(0).length() : x + 3;


            }

            // Print result
            System.out.printf("Amount of trees: %s", trees);

        } catch (FileNotFoundException ignored) {

        }

    }

}
