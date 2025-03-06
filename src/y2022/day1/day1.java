package y2022.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class day1 {
    public static void main(String[] args) {
        List<List<Integer>> allElves = new ArrayList<>();
        List<Integer> elf = new ArrayList<>();

        try {

            File file = new File("src/inputs/2022inputday1");


            BufferedReader reader = new BufferedReader(new FileReader(file));




            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (!line.isEmpty()) {
                    elf.add(Integer.parseInt(line));
                } else {
                    if (!elf.isEmpty()) {
                        allElves.add(new ArrayList<>(elf));
                        elf.clear();
                    }
                }
            }

            if (!elf.isEmpty()) {
                allElves.add(new ArrayList<>(elf));
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
        int sum = 0;
        int max = 0;
        for (int i = 0 ; i < allElves.size() ; i++) {
            for(int j = 0 ; j < allElves.get(i).size() ; j++) {
                sum = sum + allElves.get(i).get(j);
            }
            if (sum > max) {
                max = sum;
            }
            sum = 0;
        }
        System.out.println(max);

        List<Integer> list = new ArrayList<>(allElves.stream().map(l -> l.stream().mapToInt(Integer::intValue).sum())
                .toList());

        list.sort(Comparator.reverseOrder());
        System.out.println(list.getLast() +  list.get(list.size()-2)+ list.get(list.size()-3));






    }
}
