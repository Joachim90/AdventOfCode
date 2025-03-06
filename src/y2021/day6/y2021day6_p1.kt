import java.nio.file.Files
import java.nio.file.Path

fun main(){

    val line = Files.readString(Path.of("src/inputs/y2021day6"))
    val fishes = ArrayList<Byte>()
    line.split(",").forEach{fishes.add(it.toByte())}



    val days = 80
    for (i in 1..days) {
        for (i in fishes.indices) {
            fishes[i]--
            if (fishes[i] == (-1).toByte()) {
                fishes[i] = 6
                fishes.add(8)
            }
        }
    }
    println(fishes.size)



}