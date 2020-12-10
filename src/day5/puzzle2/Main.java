package day5.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            // File reader
            File input = new File("src/input/day_5.txt");
            Scanner reader = new Scanner(input);


            // Loop over all the lines
            ArrayList<Integer> ids = new ArrayList<>();
            while (reader.hasNextLine()) {

                // Read the line
                String line = reader.nextLine();

                // Calculate all ids from the boarding passes
                int row = decodeRow(line.substring(0, 7)), col = decodeCol(line.substring(7, 10));
                ids.add(row * 8 + col);

            }

            // Calculate all ids
            ArrayList<Integer> all = new ArrayList<>();
            for (int r = 0; r < 128; r++)
                for (int c = 0; c < 8; c++)
                    all.add(r * 8 + c);

            // Filter out all the -1 and +1 ids
            for (int id : all)
                if (!all.contains(id - 1) && !all.contains(id + 1))
                    System.out.println(id);

        } catch (FileNotFoundException ignored) {

        }

    }

    public static int decodeRow(String sequence) {
        double row_low = 0, row_high = 127;
        for (char a : sequence.toCharArray()) {
            if (a == 'F')
                row_high -= Math.ceil((row_high - row_low) / 2);
            else
                row_low += Math.ceil((row_high - row_low) / 2);

            if (row_high == row_low)
                return (int) row_high;
        }
        return -1;
    }

    public static int decodeCol(String sequence) {
        double row_low = 0, row_high = 7;
        for (char a : sequence.toCharArray()) {
            if (a == 'L')
                row_high -= Math.ceil((row_high - row_low) / 2);
            else
                row_low += Math.ceil((row_high - row_low) / 2);

            if (row_high == row_low)
                return (int) row_high;
        }
        return -1;
    }
}
