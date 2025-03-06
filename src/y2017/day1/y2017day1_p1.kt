import java.nio.file.Files
import java.nio.file.Path
import kotlin.streams.toList

fun main(){
    val line = Files.readString(Path.of("src/inputs/y2017day1"))

    // Lösning med vanlig loop (min lösning)
    var sum = 0;

    for (i in 0 until line.length - 1){
        if (line[i] == line[i + 1]){
            sum += Integer.parseInt(line[i].toString())
        }
    }
    //Jämför om första och sista är samma
    if (line[0] == line[line.length - 1]){
        sum += Integer.parseInt(line[0].toString())
    }
    println("Lösning med vanlig loop: $sum")



    //Lösning med zipWithNext (inte min lösning)

    val sum1 = (line + line.first())    //line + line.first() för att addera char på line[0] till slutet av line. För att kunna jämföra sista siffran i line med första.
        .zipWithNext()                  //Skapar par av varje element och nästakommande element i strängen.
        .sumOf { (a, b) -> a.digitToInt().takeIf { a == b } ?: 0 }  // Om paret är samma siffra, så adderas siffran till sum1, annars adderas 0.

    println("Lösning med zipWithNext: $sum1")

}