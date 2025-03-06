import java.nio.file.Files
import java.nio.file.Path


fun main(){

    val line = Files.readString(Path.of("src/inputs/y2021day6"))
    val fishes = ArrayList<Byte>()
    line.split(",").forEach{fishes.add(it.toByte())}

    val fishMap = HashMap<Int, Long>()
    fishMap[0] = line.count{it == '0'}.toLong()
    fishMap[1] = line.count{it == '1'}.toLong()
    fishMap[2] = line.count{it == '2'}.toLong()
    fishMap[3] = line.count{it == '3'}.toLong()
    fishMap[4] = line.count{it == '4'}.toLong()
    fishMap[5] = line.count{it == '5'}.toLong()
    fishMap[6] = line.count{it == '6'}.toLong()
    fishMap[7] = line.count{it == '7'}.toLong()
    fishMap[8] = line.count{it == '8'}.toLong()

    val days = 256
    var newFish : Long = 0

    for (i in 1..days){
        newFish = (fishMap[0] ?: 0)
        for (j in 0 until 8) {
            fishMap[j] = fishMap[j + 1] ?: 0
        }
        fishMap[6] = (fishMap[6] ?: 0) + newFish
        fishMap[8] = newFish
    }

    val sum = fishMap.values.sum()
    println(sum)
    println(fishMap)
}