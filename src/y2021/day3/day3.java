package y2021.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class day3 {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.lines(Path.of("src/y2021/day3/inputDay3")).toList();

        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();



        for (int i = 0; i < input.getFirst().length() ; i++) {
            int countOnes = 0;
            int countZeros = 0;

            for (int j = 0 ; j < input.size() ; j++) {
                if (input.get(j).charAt(i) == '1'){
                    countOnes++;
                }else if (input.get(j).charAt(i) == '0'){
                    countZeros++;
                }
            }
            if (countOnes > countZeros){
                gamma.append("1");
            }else{
                gamma.append("0");
            }
        }

        System.out.println("gamma: "+gamma.toString());

        for (int i = 0 ; i < gamma.length() ; i++) {
            if (gamma.charAt(i) == '1'){
                epsilon.append("0");
            }else{
                epsilon.append("1");
            }
        }
        System.out.println("hej");
        System.out.println("epsilon: " + epsilon);






        int dec = Integer.parseInt(gamma.toString(), 2);
        int dec2 = Integer.parseInt(epsilon.toString(), 2);

        System.out.println(dec * dec2);

    }

}
