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
                int row = decodeRow(line.substring(0, 7)), col = decodeCol(line.substring(7, 10));
                ids.add(row * 8 + col);

            }

            ArrayList<Integer> news = new ArrayList<>();
            for (int id : ids) {
                if (ids.contains(id + 1) && ids.contains(id - 1)) news.add(id);
            }

            System.out.println(ids.size());
            System.out.println(news.size());

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
