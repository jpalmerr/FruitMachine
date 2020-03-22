import scala.util.Random

sealed trait Outcome
case object AllEqual extends Outcome
case object Lose extends Outcome

object Color extends Enumeration {
  val Black, White, Green, Yellow = Value
}

class SlotSpinner {
  def spin: Outcome = {
    val slots = (Random.nextInt(Color.maxId),
                 Random.nextInt(Color.maxId),
                 Random.nextInt(Color.maxId),
                 Random.nextInt(Color.maxId)
                )

    slots match {
      case (s1, s2, s3, s4)  => results(s1, s2, s3, s4)
    }
  }

  private def results(slot1: Int, slot2: Int, slot3: Int, slot4: Int): Outcome = {
    if (slot1 == slot2 && slot2 == slot3 && slot3 == slot4) AllEqual
    else Lose
  }
}

val spinner: SlotSpinner = new SlotSpinner
spinner.spin

case class FruitMachine(spinner: SlotSpinner, jackpot: Int) {

  def play: String = {
    if (winnings > 0) s"Congratulations, you won $winnings"
    else "Commiserations"
  }

  def winnings: Int = {
    spinner.spin match {
      case AllEqual => jackpot
      case Lose => 0
    }
  }
}
