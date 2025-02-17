package y2021.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class day2part2 {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.lines(Path.of("src/y2021/day2/inputDay2")).toList();

        int aim = 0;
        int hp = 0;
        int depth = 0;
        int forward = 0;

        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);
            switch (line.charAt(0)) {
                case 'd':
                    aim = aim + Integer.parseInt(line.substring(5));
                    break;
                case 'u':
                    aim = aim - Integer.parseInt(line.substring(3));
                    break;
                case 'f':
                    forward = Integer.parseInt(line.substring(8));
                    hp = hp + forward;
                    depth += aim * forward;
                    break;
                default:
                    System.out.println("error");
            }



        }
        System.out.println(hp*depth);

    }
}
