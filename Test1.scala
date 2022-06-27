/*This is Scala code*/
import scala.io.StdIn.readInt
object Test1 extends App {
  println("Input the number")
  //Reading the number of combinations
  val line = readInt()
  //Creating a function
  def Generator(open: Int, close: Int,result: String,N: Int = line):Unit = {

          if (open<N) Generator(open+1,close,result+"(",N)    // Generation of open parentheses
          if(close < open) Generator(open,close+1,result+")",N)    // Generation of close parentheses
          else if(close==N) {

            val res: String = result   // When get the result of parentheses in given number
            println(res)    //Output the result

          }
    }
  Generator(0,0,"")
}