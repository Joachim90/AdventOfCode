package y2024.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class day1 {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.lines(Path.of("src/y2024/day1/inputday1")).toList();
        System.out.println(input.get(4));

        List<String> first = input.stream().map(s -> s.substring(0,5)).toList();
        List<String> second = input.stream().map(s -> s.substring(5).trim()).toList();

        List<Integer> list1 = first.stream().map(Integer::parseInt).sorted().toList();
        List<Integer> list2 = second.stream().map(Integer::parseInt).sorted().toList();

        int distance = 0;

        for (int i = 0; i < list1.size(); i++) {
            distance = distance + Math.abs(list1.get(i) - list2.get(i));
        }

        System.out.println("The distance is " + distance);
    }
}
