import java.nio.file.Files
import java.nio.file.Path

fun main(){
    val line = Files.readString(Path.of("src/inputs/y2021day7"))
    val numbers = ArrayList<Int>()
    line.split(",").forEach{numbers.add(it.toInt())}

    val highest = numbers.max()
    val lowest = numbers.min()
    var sum = 0;

    var map = HashMap<Int, Long>()

    for ( i in lowest..highest){
        for ( j in numbers.indices){
            sum = sum + (Math.abs(i - numbers[j]))

        }
        map.put(i, sum.toLong())
        sum = 0
    }





// Hämta det lägsta värdet
    val minValue = map.minByOrNull { it.value }?.value

    if (minValue != null) {
        println("Lägsta värde: $minValue")
    } else {
        println("Map är tom")
    }
}