sealed trait Color

case object Black extends Color
case object White extends Color
case object Green extends Color
case object Yellow extends Color

case class FruitMachine(slot1: Color, slot2: Color, slot3: Color, slot4: Color) {

  def display: List[Color] = List(slot1, slot2, slot3, slot4)

}

FruitMachine(Black, White, Green, Yellow).display