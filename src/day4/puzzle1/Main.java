package day4.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            // File reader
            File input = new File("src/input/day_4.txt");
            Scanner reader = new Scanner(input);


            // Loop over all the lines
            int total = 0;
            int valid = 0;
            Passport passport = new Passport();
            while (reader.hasNextLine()) {

                // Read the line
                String line = reader.nextLine();
                if (line.isBlank()) {
                    total++;
                    System.out.println(passport);
                    if (passport.isValid()) valid++;
                    passport = new Passport();
                    continue;
                }

                String[] items = line.split(" ");
                for (String item : items) {
                    String[] content = item.split(":");
                    passport.set(content[0], content[1]);
                }

            }

            // Print last passport
            total++;
            System.out.println(passport);
            if (passport.isValid()) valid++;
            System.out.printf("Total amount of valid passports: %s / %s", valid, total);

        } catch (FileNotFoundException ignored) {

        }

    }

    public static class Passport {

        private final HashMap<String, String> data = new HashMap<>();

        public Passport() {

        }

        public boolean isValid() {

            if (data.size() < 7) return false;

            if (data.size() == 7 && data.containsKey("cid")) return false;

            return true;

        }

        public void set(String key, String value) {
            data.put(key, value);
        }

        @Override
        public String toString() {
            return "Passport{" +
                    "data=" + data +
                    "valid=" + isValid() +
                    '}';
        }
    }

}
