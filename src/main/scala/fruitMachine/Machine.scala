package fruitMachine

case class Machine(spinner: SlotSpinner, priceToPlay: Int, jackpot: Int) {

  lazy val run: (Outcome, String) = spinner.spin

  def display: String = s"Spinning...${run._2}: ${run._1}"

  def play(player: Player): (Option[Player], Option[Machine]) = {
    if (player.money >= priceToPlay) {
      lazy val outcome: Int = winnings(run._1)

      if (outcome >= jackpot) {
        (Some(Player(player.money + jackpot)), None)
      }
      else if (outcome > 0 && outcome < jackpot)  {
        val newCredit = outcome + player.money - priceToPlay
        (Some(Player(newCredit)), Some(Machine(SlotSpinner(), priceToPlay, jackpot - outcome + priceToPlay)))
      } else {
        (Some(Player(player.money - priceToPlay)), Some(Machine(SlotSpinner(), priceToPlay, jackpot + priceToPlay)))
      }
    } else (None, Some(Machine(SlotSpinner(), priceToPlay, jackpot)))
  }

  def winnings(outcome: Outcome): Int =
    outcome match {
      case AllEqual => jackpot + priceToPlay
      case Unique => (jackpot + priceToPlay) / 2
      case TwoAdjacent => priceToPlay / 2
      case Lose => 0
    }

}
