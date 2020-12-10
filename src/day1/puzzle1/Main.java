package day1.puzzle1;

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

            for (int entry : integers) {
                if (integers.contains(2020 - entry)) {
                    System.out.printf("1st Entry: %s, 2nd Entry: %s, Answer: %s", entry, 2020 - entry, entry * (2020 - entry));
                    break;
                }
            }

        } catch (FileNotFoundException e) {

        }

    }

}
