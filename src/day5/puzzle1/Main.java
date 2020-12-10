package day5.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            // File reader
            File input = new File("src/input/day_5.txt");
            Scanner reader = new Scanner(input);


            // Loop over all the lines
            int highest_seat = 0;
            while (reader.hasNextLine()) {

                // Read the line
                String line = reader.nextLine();
                int row = decodeRow(line.substring(0, 7)), col = decodeCol(line.substring(7, 10));
                if (row * 8 + col > highest_seat) highest_seat = row * 8 + col;
                System.out.printf("- %s: row %s, col %s, seat ID %s.\n", line, row, col, row * 8 + col);

            }

            System.out.println(highest_seat);

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
