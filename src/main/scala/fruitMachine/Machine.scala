package fruitMachine

case class Machine(spinner: SlotSpinner, priceToPlay: Int, jackpot: Int) {

  val run: (Outcome, String) = spinner.spin

  def display: String = s"${run._2}: ${run._1}"

  def play(player: Player): Player = {
    if (player.money > priceToPlay) {
      val outcome: Int = winnings(run._1)

      if (outcome > 0)  {
        val newCredit = outcome + player.money
        Player(newCredit)
      } else {
        Player(player.money - priceToPlay)
      }
    } else player
  }

  def winnings(outcome: Outcome): Int =
    outcome match {
      case AllEqual => jackpot
      case Lose => 0
    }

}
