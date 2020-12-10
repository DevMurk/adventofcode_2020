package day6.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            // File reader
            File input = new File("src/input/day_6.txt");
            Scanner reader = new Scanner(input);


            // Loop over all the lines
            ArrayList<Group> groups = new ArrayList<>();
            Group current = new Group();
            while (reader.hasNextLine()) {

                // Read the line
                String line = reader.nextLine();

                if (line.isBlank()) {
                    groups.add(current);
                    current = new Group();
                    continue;
                }

                current.addAnswerLine(line);

                if (!reader.hasNextLine()) {
                    groups.add(current);
                    break;
                }

            }

            int total = 0;
            for (Group group : groups) {
                total += group.getAllSameAnsweredQuestionsAmount();
            }
            System.out.println(total);

        } catch (FileNotFoundException ignored) {

        }

    }

    public static class Group {

        private final ArrayList<String> answer_lines = new ArrayList<>();

        public Group() {

        }

        public void addAnswerLine(String line) {
            answer_lines.add(line);
        }

        public int getAllSameAnsweredQuestionsAmount() {
            ArrayList<Character> questions = new ArrayList<>();

            for (char answer : answer_lines.get(0).toCharArray())
                questions.add(answer);

            ArrayList<Character> yes = new ArrayList<>();
            for (int i = 1; i < answer_lines.size(); i++) {
                yes.clear();

                for (char answer : answer_lines.get(i).toCharArray())
                    if (questions.contains(answer))
                        yes.add(answer);

                questions = new ArrayList<>(yes);
            }

            System.out.println(questions);
            return questions.size();
        }

    }

}