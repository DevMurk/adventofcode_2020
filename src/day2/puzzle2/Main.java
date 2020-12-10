package day2.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            // File reader
            File input = new File("src/input/day_2.txt");
            Scanner reader = new Scanner(input);

            int allowed = 0;

            // Loop over all the lines
            while (reader.hasNextLine()) {

                // Read the line and split it into 3 parts
                String line = reader.nextLine();
                String[] parts = line.split(" ");

                // Extract the variables
                int pos1 = Integer.parseInt(parts[0].split("-")[0]);
                int pos2 = Integer.parseInt(parts[0].split("-")[1]);
                char character = parts[1].charAt(0);
                char[] password_array = ("*" + parts[2]).toCharArray();

                // Check password and update counter if valid password
                if ((password_array[pos1] == character && password_array[pos2] != character) || password_array[pos1] != character && password_array[pos2] == character) allowed++;

            }

            // Print result
            System.out.printf("Amount of passwords that are valid: %s", allowed);

        } catch (FileNotFoundException ignored) {

        }

    }

}
