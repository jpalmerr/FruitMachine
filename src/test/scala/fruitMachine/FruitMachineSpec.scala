package fruitMachine

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class FruitMachineSpec extends AnyWordSpec with Matchers {

  val fruitMachine = FruitMachine(Black, White, Green, Yellow)

  "Display" should {
    "return a list of colors" in {
      fruitMachine.display should be(List(Black, White, Green, Yellow))
    }
  }

}
