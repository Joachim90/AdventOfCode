import java.nio.file.Files
import java.nio.file.Path

fun main(){

    val input = Files.lines(Path.of("src/inputs/y2017day2")).toList()
    var sum = 0;


    for (i in input){

        val numbers = i.split(" ").map{it.toInt()}

        for (j in numbers.indices){
            for (k in numbers.indices){
                if (j == k){
                    continue
                }
                if (numbers[j] % numbers[k] == 0 ){
                    sum += numbers[j]/numbers[k]
                    break
                }

            }
            println("j = $j")
            println(sum)
        }

    }

    println(sum)

}