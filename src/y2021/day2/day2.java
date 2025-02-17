package y2021.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class day2 {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.lines(Path.of("src/y2021/day2/inputDay2")).toList();

        int up = input.stream().filter(s -> s.charAt(0) == 'u').mapToInt(s-> Integer.parseInt(s.substring(3))).sum();
        int down = input.stream().filter(s -> s.charAt(0) == 'd').mapToInt(s-> Integer.parseInt(s.substring(5))).sum();
        int forward = input.stream().filter(s -> s.charAt(0) == 'f').mapToInt(s-> Integer.parseInt(s.substring(8))).sum();

        int depth = down - up;
        int position = depth * forward;

        System.out.println("Rätt svar :" + position);


    }
}
