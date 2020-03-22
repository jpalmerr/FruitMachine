package fruitMachine

case class FruitMachine(slot1: Color, slot2: Color, slot3: Color, slot4: Color) {

  def display: List[Color] = List(slot1, slot2, slot3, slot4)

}

object FruitMachine extends App {

  val fruity1 = FruitMachine(Black, White, Yellow, Green)
  println(fruity1.display)

}