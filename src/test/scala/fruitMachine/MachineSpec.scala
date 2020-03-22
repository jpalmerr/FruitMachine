package fruitMachine

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

case class MachineSpec() extends AnyWordSpec with Matchers {

  val player: Player = Player(30)
  val spinner: SlotSpinner = SlotSpinner(1, 2, 3, 4)
  val winnerSpinner: SlotSpinner = SlotSpinner(2, 2, 2, 2)
  val machine: Machine = Machine(spinner, 10, 1000)
  val winner: Machine = Machine(winnerSpinner, 5, 1000)

  "Winnings" should {
    "calculate winnings owed" in {
      machine.winnings(AllEqual) should be(1000)
      machine.winnings(Lose) should be(0)
    }
  }

  "Play" should {
    "return a message with the correct winnings" in {
      winner.play(player) should be(Player(1030))
      machine.play(player) should be(Player(20))
    }
  }
}
