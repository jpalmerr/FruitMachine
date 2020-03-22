package fruitMachine

object FruitMachineApp extends App {

  // TODO: Logic for updating player and machine

  val player = Player(20)
  val machine = Machine(SlotSpinner(), 5, 1000)

  println(s"The jackpot today is ${machine.jackpot}")
  println(s"Spinning...")
  println(machine.display)
  val updatedPlayer = machine.play(player)
  println(s"You have ${updatedPlayer.money}")

//  val riggedMachine = Machine(SlotSpinner(2, 2, 2, 2), 5, 1000)
//  println(s"You're going to win this time...")
//  println(s"Spinning...")
//  println(riggedMachine.display)
//  val updatedRiggedPlayer = riggedMachine.play(player)
//  println(s"You have ${updatedRiggedPlayer.money}")
//  println(s"You're going to win this time...")


}
