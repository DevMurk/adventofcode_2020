package day2.puzzle1;

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
                int min = Integer.parseInt(parts[0].split("-")[0]);
                int max = Integer.parseInt(parts[0].split("-")[1]);
                String character = parts[1].substring(0, 1);
                String password = parts[2];

                // Check password and update counter if valid password
                int amount = password.length() - password.replaceAll(character, "").length();
                if (min <= amount && amount <= max) allowed++;

            }

            // Print result
            System.out.printf("Amount of passwords that are valid: %s", allowed);

        } catch (FileNotFoundException ignored) {

        }

    }

}
