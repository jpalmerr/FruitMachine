package fruitMachine

object FruitMachineApp extends App {

  val machine = Machine(SlotSpinner(), 1000)

  println(s"The jackpot today is ${machine.jackpot}")
  println(machine.play)

  val riggedMachine = Machine(SlotSpinner(2, 2, 2, 2), 1000)
  println(s"You're going to win this time...")
  println(riggedMachine.play)
}
