package day1.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            File input = new File("src/input/day_1.txt");
            Scanner reader = new Scanner(input);

            ArrayList<Integer> integers = new ArrayList<>();
            while (reader.hasNextInt()) {
                integers.add(reader.nextInt());
            }

            boolean answered = false;
            for (int entry : integers) {
                int needed = 2020 - entry;
                for (int entry2 : integers) {
                    if (integers.contains(needed - entry2)) {
                        System.out.printf("1st Entry: %s, 2nd Entry: %s, 3rd Entry: %s, Answer: %s", entry, entry2, needed - entry2, entry * entry2 * (needed - entry2));
                        answered = true;
                        break;
                    }
                }
                if (answered) break;
            }

            reader.close();

        } catch (FileNotFoundException e) {

        }

    }

}
