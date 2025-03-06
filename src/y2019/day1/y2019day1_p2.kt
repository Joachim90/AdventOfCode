import java.nio.file.Files
import java.nio.file.Path


fun main(){
    val input = Files.lines(Path.of("src/inputs/y2019day1")).toList()
    var sum = 0

    for (line in input){
        val line = Integer.parseInt(line)
        sum += fuelCalculator(line)
    }
    println(sum)
}

fun fuelCalculator(mass : Int) : Int {
    val fuel : Int
    if (mass > 8) {
        fuel = (mass / 3) - 2
        return fuelCalculator(fuel) + fuel
    }

    return 0;
}