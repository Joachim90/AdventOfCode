package y2024.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class day2part2 {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.lines(Path.of("src/y2024/day2/inputday2")).toList();
        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            String[] array = input.get(i).split(" ");
            List<String> list = new java.util.ArrayList<>(Arrays.stream(array).toList());
            if (isSafe(list)) {
                count++;
            }else {
                // Removing one element at the time and testing if list "is safe" then
                for (int j = list.size() -1; j >= 0; j--) {
                    String removed = list.get(j);
                    list.remove(j);
                    if (isSafe(list)) {
                        count++;
                        break;
                    }else{
                        list.add(j, removed);
                    }
                }
            }
        }

        System.out.println(count);


    }
    public static boolean isSafe (List<String> list){
        int safeSteps = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (Integer.parseInt(list.get(i)) > Integer.parseInt(list.get(i + 1)) && Integer.parseInt(list.get(i)) - Integer.parseInt(list.get(i + 1)) <= 3) {
                safeSteps++;
            }
        }
        if (safeSteps == list.size() -1) {
            return true;
        }

        safeSteps = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (Integer.parseInt(list.get(i)) < Integer.parseInt(list.get(i + 1)) && Integer.parseInt(list.get(i + 1)) - Integer.parseInt(list.get(i)) <= 3){
                safeSteps++;
            }
        }
        if (safeSteps == list.size() -1){
            return true;
        }

        return false;
    }
}
