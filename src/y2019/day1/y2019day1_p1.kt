import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Collectors

fun main() {
    val input = Files.lines(Path.of("src/inputs/y2019day1")).toList()

    var sum = 0;

    for (line in input) {
        val line = Integer.parseInt(line)
        sum += (line/3) -2
    }


    println(sum)
}