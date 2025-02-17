package y2024.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class day1part2 {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.lines(Path.of("src/y2024/day1/inputday1")).toList();

        List<String> first = input.stream().map(s -> s.substring(0,5)).toList();
        List<String> second = input.stream().map(s -> s.substring(5).trim()).toList();

        long similarity = 0;

        for (int i = 0; i < first.size(); i++) {
            for (int j = 0; j < second.size(); j++) {
                if (first.get(i).equals(second.get(j))) {
                    similarity += Long.parseLong(first.get(i));
                    System.out.println(i + ": "+ first.get(i) + "      "+j+ ": " + second.get(j));
                }
            }

        }

        System.out.println("Svar: " + similarity);
    }
}
