package y2024.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class day2 {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.lines(Path.of("src/y2024/day2/inputday2")).toList();

        int safe = 0;


        for (int i = 0; i < input.size(); i++) {
            int safeSteps = 0;
            String line = input.get(i);
            String[] array = (line.split(" "));

            for (int j = 0; j < array.length - 1; j++) {
                if (Integer.parseInt(array[j]) > Integer.parseInt(array[j+1]) && Integer.parseInt(array[j]) - Integer.parseInt(array[j+1]) <= 3) {
                    safeSteps++;
                }
            }
            if (safeSteps == array.length -1) {
                safe++;
            }
        }


        for (int i = 0; i < input.size(); i++) {
            int safeSteps = 0;
            String line = input.get(i);
            String[] array = (line.split(" "));

            for (int j = 0; j < array.length - 1; j++) {
                if (Integer.parseInt(array[j]) < Integer.parseInt(array[j+1]) && Integer.parseInt(array[j+1]) - Integer.parseInt(array[j]) <= 3){
                    safeSteps++;
                }
            }
            if (safeSteps == array.length -1){
                safe++;
            }
        }

        System.out.println("Svar: " + safe);


    }
}
