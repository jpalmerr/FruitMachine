package fruitMachine

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class SlotSpinnerSpec extends AnyWordSpec with Matchers {
  val spinner = SlotSpinner(1, 2, 3, 4)
  val winnerSpinner = SlotSpinner(2, 2, 2, 2)

  "Spin" should {
    "return correct outcome" in {
      spinner.spin should be(Lose)
      winnerSpinner.spin should be(AllEqual)
    }
  }
}
