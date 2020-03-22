package fruitMachine

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

case class FruitMachineSpec() extends AnyWordSpec with Matchers {

  val spinner: SlotSpinner = SlotSpinner(1, 2, 3, 4)
  val winnerSpinner: SlotSpinner = SlotSpinner(2, 2, 2, 2)
  val winner: FruitMachine = FruitMachine(winnerSpinner, 1000)
  val loser: FruitMachine = FruitMachine(spinner, 1000)

  "Winnings" should {
    "calculate winnings owed" in {
      winner.winnings should be(1000)
      loser.winnings should be(0)
    }
  }

  "Play" should {
    "return a message with the correct winnings" in {
      winner.play should be("Congratulations, you won £1000")
      loser.play should be("Commiserations")
    }
  }
}
