package fruitMachine

sealed trait Outcome
case object AllEqual extends Outcome
case object TwoAdjacent extends Outcome
case object Lose extends Outcome

