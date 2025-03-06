package y2021.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.IntStream;



public class day1 {
    public static void main(String[] args) throws IOException {
        List<Integer> input = Files.lines(Path.of("src/inputs/2021inputday1")).map(Integer::parseInt).toList();


        long increasesDayOne = IntStream.range(0, input.size() - 1).filter(i -> input.get(i) < input.get(i+1)).count();
        System.out.println("Day one: " + increasesDayOne);


    }
}
