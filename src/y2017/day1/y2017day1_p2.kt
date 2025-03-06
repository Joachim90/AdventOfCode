import java.nio.file.Files
import java.nio.file.Path


fun main(){

    val line = Files.readString(Path.of("src/inputs/y2017day1"))
    var sum = 0;
    val halfLine = line.length / 2


    for (i in 0 until halfLine){
        if (line[i] == line[halfLine + i]){
            sum += Integer.parseInt(line[i].toString()) * 2
        }
    }

    println(sum)
}