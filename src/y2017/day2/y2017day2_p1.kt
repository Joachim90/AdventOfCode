import java.nio.file.Files
import java.nio.file.Path

fun main(){
    val input = Files.lines(Path.of("src/inputs/y2017day2")).toList()
    var sum = 0;


    for (i in input){
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        i.split(" ").forEach {
            if (Integer.parseInt(it) > max){
                max = Integer.parseInt(it)
            }else if (Integer.parseInt(it) < min){
                min = Integer.parseInt(it)
            }
        }
        sum += max - min

    }
    println("Totala skillnaden mellan högsta och lägsta på alla rader blir: $sum")





}