import java.nio.file.Files
import java.nio.file.Path

fun main(){
    val input = Files.lines(Path.of("src/inputs/y2024day4")).toList()

    var totalXMAS = 0;

    for (row in input.indices){
        for (column in input[row].indices){
            if (input[row][column] == 'X'){
                when {
                    //Om X hittas i den mittre delen av texten (4 steg in från alla håll)
                    row in 3..(input.size -4) && column in 3..(input[row].length - 4)-> {
                        totalXMAS += xmasRight(input,column,row)
                        totalXMAS += xmasLeft(input,column,row)
                        totalXMAS += xmasUp(input,column,row)
                        totalXMAS += xmasDown(input,column,row)
                        totalXMAS += xmasUpLeft(input,column,row)
                        totalXMAS += xmasUpRight(input,column,row)
                        totalXMAS += xmasDownLeft(input,column,row)
                        totalXMAS += xmasDownRight(input,column,row)

                    }

                    //Om X hittas i den övre mittre delen av texten
                    row < input.size - 4 && column in 3..(input[row].length - 4)->{

                        totalXMAS += xmasRight(input,column,row)
                        totalXMAS += xmasLeft(input,column,row)
                        totalXMAS += xmasDown(input,column,row)
                        totalXMAS += xmasDownRight(input,column,row)
                        totalXMAS += xmasDownLeft(input,column,row)
                    }


                    //Om X hittas i den undre mittre delen av texten
                    row > input.size - 4 && column in 3..(input[row].length - 4)->{
                        totalXMAS += xmasRight(input,column,row)
                        totalXMAS += xmasLeft(input,column,row)
                        totalXMAS += xmasUp(input,column,row)
                        totalXMAS += xmasUpRight(input,column,row)
                        totalXMAS += xmasUpLeft(input,column,row)
                    }


                    //Om X hittas i den vänstra mittre delen av texten
                    column < 3 && row in 3..(input.size - 4)->{
                        totalXMAS += xmasUp(input,column,row)
                        totalXMAS += xmasDown(input,column,row)
                        totalXMAS += xmasRight(input,column,row)
                        totalXMAS += xmasUpRight(input,column,row)
                        totalXMAS += xmasDownRight(input,column,row)
                    }

                    // kolumnen är större än
                    //Om X hittas i den högra mittre delen av texten
                    column > input[row].length - 4 && row in 3..(input.size - 4)->{
                        totalXMAS += xmasLeft(input,column,row)
                        totalXMAS += xmasUp(input,column,row)
                        totalXMAS += xmasDown(input,column,row)
                        totalXMAS += xmasUpLeft(input,column,row)
                        totalXMAS += xmasDownLeft(input,column,row)
                    }


                    //Om X hittas i det övre vänstra hörnet
                    column < 3 && row < 3 -> {
                        totalXMAS += xmasRight(input,column,row)
                        totalXMAS += xmasDown(input,column,row)
                        totalXMAS += xmasDownRight(input,column,row)
                    }


                    //Om X hittas i övre högra hörnet
                    column > 3 && row < 3 -> {
                        totalXMAS += xmasLeft(input,column,row)
                        totalXMAS += xmasDown(input,column,row)
                        totalXMAS += xmasDownLeft(input,column,row)
                    }


                    //Om X hittas i nedre vänstra hörnet
                    column < 3 && row > 3 -> {
                        totalXMAS += xmasRight(input,column,row)
                        totalXMAS += xmasUp(input,column,row)
                        totalXMAS += xmasUpRight(input,column,row)
                    }


                    //Om X hittas i nedre högra hörnet
                    column > 3 && row > 3 -> {
                        totalXMAS += xmasLeft(input,column,row)
                        totalXMAS += xmasUp(input,column,row)
                        totalXMAS += xmasUpLeft(input,column,row)
                    }
                }
            }
        }
    }

    println(totalXMAS)

}

fun xmasDown(list : List<String> , x : Int , y : Int) : Int{
    if (list[y+1][x] == 'M' && list[y+2][x] == 'A' && list[y+3][x] == 'S' ){
        println("Down        - x:$x   y:$y")
        return 1;
    }
    return 0;
}

fun xmasUp(list : List<String> , x : Int , y : Int) : Int{
    if (list[y-1][x] == 'M' && list[y-2][x] == 'A' && list[y-3][x] == 'S' ){
        println("Up          - x:$x   y:$y")
        return 1;
    }
    return 0
}

fun xmasRight(list : List<String> , x : Int , y : Int) : Int{
    if (list[y][x+1] == 'M' && list[y][x+2] == 'A' && list[y][x+3] == 'S' ){
        println("Right       - x:$x   y:$y")
        return 1;
    }
    return 0
}

fun xmasLeft(list : List<String> , x : Int , y : Int) : Int{
    if (list[y][x-1] == 'M' && list[y][x-2] == 'A' && list[y][x-3] == 'S' ){
        println("Left        - x:$x   y:$y")
        return 1;
    }
    return 0
}

fun xmasDownLeft(list : List<String> , x : Int , y : Int) : Int{
    if (list[y+1][x-1] == 'M' && list[y+2][x-2] == 'A' && list[y+3][x-3] == 'S' ){
        println("Down Left   - x:$x   y:$y")
        return 1;
    }
    return 0
}

fun xmasDownRight(list : List<String> , x : Int , y : Int) : Int{
    if (list[y+1][x+1] == 'M' && list[y+2][x+2] == 'A' && list[y+3][x+3] == 'S' ){
        println("Down Right  - x:$x   y:$y")
        return 1;
    }

    return 0
}

fun xmasUpLeft(list : List<String> , x : Int , y : Int) : Int{
    if (list[y-1][x-1] == 'M' && list[y-2][x-2] == 'A' && list[y-3][x-3] == 'S' ){
        println("Up Left     - x:$x   y:$y")
        return 1;
    }
    return 0
}

fun xmasUpRight(list : List<String> , x : Int , y : Int) : Int{
    if (list[y-1][x+1] == 'M' && list[y-2][x+2] == 'A' && list[y-3][x+3] == 'S' ){
        println("Up right    - x:$x   y:$y")
        return 1;
    }
    return 0
}

