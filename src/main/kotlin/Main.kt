import java.lang.NumberFormatException

class Pole(){
    val table = MutableList(3){MutableList(3){ ' ' } }
    var popa = 0
    var sampopa = true

    fun vivestiPole(table:MutableList<MutableList<Char>>) {
        println("---------")
        println("| ${table[0][0]} ${table[0][1]} ${table[0][2]} |")
        println("| ${table[1][0]} ${table[1][1]} ${table[1][2]} |")
        println("| ${table[2][0]} ${table[2][1]} ${table[2][2]} |")
        println("---------")
        if (table[0].all { it == table[0][0] } && table[0][0] != ' ') {
            println("${table[0][0]} wins")
            sampopa = false
        } else if (table[1].all { it == table[1][0] } && table[1][0] != ' ') {
            println("${table[1][0]} wins")
            sampopa = false
        } else if (table[2].all { it == table[2][0] } && table[2][0] != ' ') {
            println("${table[2][0]} wins")
            sampopa = false
        } else if (table.all { it[0] == table[0][0] } && table[0][0] != ' ') {
            println("${table[0][0]} wins")
            sampopa = false
        } else if (table.all { it[1] == table[0][1] } && table[0][1] != ' ') {
            println("${table[0][1]} wins")
            sampopa = false
        } else if (table.all { it[2] == table[0][2] } && table[0][2] != ' ') {
            println("${table[0][2]} wins")
            sampopa = false
        } else if (table[0][0] == table[1][1] && table[1][1] == table[2][2] && table[0][0] != ' ') {
            println("${table[0][0]} wins")
            sampopa = false
        } else if (table[0][2] == table[1][1] && table[1][1] == table[2][0] && table[0][2] != ' ') {
            println("${table[0][2]} wins")
            sampopa = false
        }
         else if (table.none{row -> ' ' in row}){
             println("Draw")
            sampopa = false
        }
    }
    fun dobavitiElement(a:Int,b:Int){
        popa += 1

          if (a > 3 || b > 3) {
              println("Coordinates should be from 1 to 3!")

          } else if (table[a - 1][b - 1] != ' ') {
              println("This cell is occupied! Choose another one!")
          }


       else if(popa%2 != 0) table[a-1][b-1] = 'X'
        else table[a-1][b-1] = 'O'



    }
}
fun main() {

    val pole = Pole()
    pole.vivestiPole(pole.table)
     do {
         try {
             val (a, b) = readln().split(" ")
             pole.dobavitiElement(a.toInt(), b.toInt())
             pole.vivestiPole(pole.table)
         } catch (e: NumberFormatException) {
             println("You should enter numbers!")
         }

     }
         while (pole.sampopa == true)

}