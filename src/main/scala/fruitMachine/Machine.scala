package fruitMachine

case class Machine(spinner: SlotSpinner, jackpot: Int) {

  def play: String = {
    val run: Int = winnings
    if (run > 0) s"Congratulations, you won £$run"
    else "Commiserations"
  }

  def winnings: Int =
    spinner.spin match {
      case AllEqual => jackpot
      case Lose => 0
    }

}
