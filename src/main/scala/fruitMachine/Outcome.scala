package fruitMachine

sealed trait Outcome
case object AllEqual extends Outcome
case object Unique extends Outcome
case object OneShort extends Outcome
case object Lose extends Outcome

