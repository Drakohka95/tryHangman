object hangmanDo extends App {
  // val ch = scala.io.StdIn.readChar()

  val mistakesCount = 5
  val surprise = word.giveMe
  val table: String = surprise.map(_ => '*')

  def rechange(word: String, myChar: Char):String = {
    val iter = surprise.indexOf(myChar)
    val (first, second) = word.splitAt(iter)
    first + myChar ++ second.tail
  }

  def doGame(miss: Int = 0, table: String):String = {
    if (miss == mistakesCount) {
      println("You lost!")
      table
    }
    else if (!table.contains('*')) {
      println("You win!")
      table
    }
    else {
      val ch = scala.io.StdIn.readChar()
      if (surprise.contains(ch)) {
        println("Hit!")
        val newtable = rechange(table,ch)
        println(s"Word: $newtable")
        doGame (miss, newtable)
      }
      else {
        println(s"Mistake! ${miss+1} out of $mistakesCount")
        println(s"Word: $table")
        doGame (miss+1, table)
      }
    }
  }

  doGame(0, table)
}
