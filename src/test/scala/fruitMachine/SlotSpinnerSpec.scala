package fruitMachine

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class SlotSpinnerSpec extends AnyWordSpec with Matchers {
  val unique: SlotSpinner = SlotSpinner(1, 2, 3, 4)
  val winnerSpinner: SlotSpinner = SlotSpinner(2, 2, 2, 2)

  "Spin" should {
    "return correct outcome" in {
      unique.spin should be((Unique, "1, 2, 3, 4"))
      winnerSpinner.spin should be((AllEqual, "2, 2, 2, 2"))
    }
  }
}
