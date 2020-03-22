package fruitMachine

case class FruitMachine(spinner: SlotSpinner, jackpot: Int) {

  def play: String = {
    if (winnings > 0) s"Congratulations, you won £$winnings"
    else "Commiserations"
  }

  def winnings: Int = {
    spinner.spin match {
      case AllEqual => jackpot
      case Lose => 0
    }
  }
}
