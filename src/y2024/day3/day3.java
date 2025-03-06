package y2024.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day3 {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.lines(Path.of("src/inputs/2024inputday3")).toList();
        String line = input.getFirst();


        List<String> array = new ArrayList<>();

        Pattern pattern = Pattern.compile("mul\\((\\d+,\\d+)\\)");
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            array.add(matcher.group(1));
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            String s = array.get(i);
            String first = s.substring(0, s.indexOf(","));
            String second = s.substring(s.indexOf(",") + 1);
            numbers.add(Integer.parseInt(first) * Integer.parseInt(second));
        }


        System.out.println(array);
        System.out.println(numbers);
        long total = 0;
        for (Integer i : numbers) {
            total = total + i;
        }
        System.out.println(total);





    }
}
