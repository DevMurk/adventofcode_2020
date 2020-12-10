package day3.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

            int[][] slopes = {
                    {1, 1},
                    {3, 1},
                    {5, 1},
                    {7, 1},
                    {1, 2},
            };

            int sum = 1;
            for (int[] slope : slopes)
                sum *= getTreeAmount(rows, slope[0], slope[1]);

            // Print result
            System.out.printf("Multiplication of trees: %s", sum);

        } catch (FileNotFoundException ignored) {

        }

    }

    public static int getTreeAmount(ArrayList<String> rows, int right, int down) {
        int x = 0, trees = 0;

        for (int y = 0; y < rows.size(); y += down) {
            if (rows.get(y).charAt(x) == '#') trees++;
            x = x + right >= rows.get(y).length() ? x + right - rows.get(y).length() : x + right;
        }

        return trees;
    }

}