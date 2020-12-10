package day4.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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

            try {

                // Original Rules (Country Id)
                if (data.size() < 7) return false;
                if (data.size() == 7 && data.containsKey("cid")) return false;

                // Birth Year
                int byr = Integer.parseInt(data.get("byr"));
                if (byr < 1920 || byr > 2002) return false;

                // Issue Year
                int iyr = Integer.parseInt(data.get("iyr"));
                if (iyr < 2010 || iyr > 2020) return false;

                // Expiration Year
                int eyr = Integer.parseInt(data.get("eyr"));
                if (eyr < 2020 || eyr > 2030) return false;

                // Height
                String hgt = data.get("hgt");
                if (hgt.endsWith("cm")) {
                    int cm = Integer.parseInt(hgt.substring(0, 3));
                    if (cm < 150 || cm > 193) return false;
                } else if (hgt.endsWith("in")) {
                    int in = Integer.parseInt(hgt.substring(0, 2));
                    if (in < 59 || in > 76) return false;
                } else return false;

                // Hair Color
                String hcl = data.get("hcl");
                if (!hcl.matches("^#([0-9]|[a-f]){6}")) return false;

                // Eye Color
                String ecl = data.get("ecl");
                String[] ecls = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
                if (Arrays.stream(ecls).noneMatch(e -> e.equalsIgnoreCase(ecl))) return false;

                // Passport Id
                String pid = data.get("pid");
                if (!pid.matches("[0-9]{9}")) return false;

            } catch (NumberFormatException e) {

                return false;

            }

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
