package fruitMachine

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class FruitMachineSpec extends AnyWordSpec with Matchers {

  val fruitMachine = FruitMachine(Black, White, Green, Yellow)
  val winner = FruitMachine(Black, Black, Black, Black)

  "Display" should {
    "return a list of colors" in {
      fruitMachine.display should be(List(Black, White, Green, Yellow))
    }
  }

  "Result" should {
    "return whether all slots are the same" in {
      fruitMachine.result should be(false)
      winner.result       should be(true)
    }
  }

}
