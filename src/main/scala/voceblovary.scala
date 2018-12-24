object word {
  private val voceblovary : List[String] = List (
    "easy",
    "house",
    "bird",
    "bone",
    "mother",
    "father",
    "famous",
    "garden",
    "child"
  )

  def giveMe:String = {
    val iter = (Math.random() * voceblovary.size).toInt
    voceblovary(iter)
  }

}
