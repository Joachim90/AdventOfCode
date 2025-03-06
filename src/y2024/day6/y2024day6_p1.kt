import java.nio.file.Files
import java.nio.file.Path

fun main(){
    val input = Files.lines(Path.of("src/inputs/y2024day6")).toList().toMutableList()

    var posX = 0
    var posY = 0
    for (y in input.indices){
        for (x in input[y].indices){
            if (input[y][x] == '^'){
                posX = x
                posY = y
                break
            }
        }
    }

    println("Startposition:  x: $posX, y: $posY")


    //              X   Y
    val right = Pair(1, 0)
    val left  = Pair(-1, 0)
    val up    = Pair(0, -1)
    val down  = Pair(0, 1)

    var sum = 0
    var currentDirection = up


    while (true){
        var newY = posY + currentDirection.second  //Y 49 + -1 = 48
        var newX = posX + currentDirection.first   //X 39 + 0  = 39

        try{
            if (input[posY][posX] != 'X'){
                input[posY] = input[posY].toCharArray().also { it[posX] = 'X' }.concatToString() //Märk current position med X
                sum +=1
            }
            if (input[newY][newX] == '#'){

                when(currentDirection){
                    right-> currentDirection = down
                    down -> currentDirection = left
                    left -> currentDirection = up
                    up   -> currentDirection = right
                }
                continue
            }else{
                posY = newY
                posX = newX
            }
        }catch (e: IndexOutOfBoundsException){
            println("Klart, $sum unika rutor besöktes")
            break
        }
    }
}