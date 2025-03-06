import java.nio.file.Files
import java.nio.file.Path

fun main(){

    //lösning 1 (min lösning)
    val input = Files.lines(Path.of("src/inputs/y2024day4")).toList()

    var totalXMAS = 0;

    var hits = 0;
    for (row in 1 until input.size -1){
        for (column in 1 until input[row].length -1){
            if (input[row][column] == 'A'){

                if (xmasRightDownM(input,column,row)) hits++

                if (xmasLeftDownM(input,column,row)) hits++

                if (xmasRightUpM(input,column,row)) hits++

                if (xmasLeftUpM(input,column,row)) hits++

                if (hits == 2) totalXMAS++

                hits = 0

            }
        }
    }

    println("(Lösning 1) total XMAS: $totalXMAS")



    //lösning2 (inte min lösning)

    var totalXMAS2 = 0

    // Lista med de fyra diagonala riktningarna
    val directions = listOf(
        Pair(1, 1),  // Höger-ner
        Pair(1, -1), // Höger-upp
        Pair(-1, 1), // Vänster-ner
        Pair(-1, -1) // Vänster-upp
    )


    for (y in 1 until input.size - 1) {
        for (x in 1 until input[y].length - 1) {
            if (input[y][x] == 'A') {
                val hits2 = directions.count { (dx, dy) -> hasXMASPattern(input, x, y, dx, dy) }
                if (hits2 == 2) totalXMAS2++

            }
        }
    }

    println("(Lösning 2) Total XMAS: $totalXMAS2")



    println("Listans storlek: ${input.size}  Hämta element på index 150: ${input.getOrNull(150)}")


}



//lösning 1 (min lösning)
fun xmasRightUpM(list : List<String> , x : Int , y : Int) : Boolean{
    return list[y-1][x+1] == 'M' && list[y+1][x-1] == 'S'
}

fun xmasRightDownM(list : List<String> , x : Int , y : Int) : Boolean{
    return list[y+1][x+1] == 'M' && list[y-1][x-1] == 'S'
}

fun xmasLeftUpM(list : List<String> , x : Int , y : Int) : Boolean{
    return list[y-1][x-1] == 'M' && list[y+1][x+1] == 'S'
}

fun xmasLeftDownM(list : List<String> , x : Int , y : Int) : Boolean{
    return list[y+1][x-1] == 'M' && list[y-1][x+1] == 'S'
}


//lösning 2 (inte min lösning)
fun hasXMASPattern(grid: List<String>, x: Int, y: Int, dx: Int, dy: Int): Boolean {
    val mX = x + dx
    val mY = y + dy
    val sX = x - dx
    val sY = y - dy

    return (grid.getOrNull(mY)?.getOrNull(mX) == 'M' && grid.getOrNull(sY)?.getOrNull(sX) == 'S')
}

