package fruitMachine

object FruitMachineApp extends App {

  val initialJackpot: Int = 1000
  val machine: Option[Machine] = Some(Machine(SlotSpinner(), 5, initialJackpot))
  val player: Option[Player] = Some(Player(15))

  (1 to 10).foldLeft((player, machine)){
      case ((Some(p), Some(m)), _) =>
        println(s"Your credit: ${p.money}, jackpot: ${m.jackpot}")
        println("Spinning...")
        println(m.display)
        m.play(p)

      case ((None, Some(m)), _) =>
        println(s"Sorry, you need £${m.priceToPlay} to play.")
        (None, None)

      case ((Some(p), None), _) =>
        println(s"You hit the jackpot, collect your winnings: ${p.money}")
        (None, None)
      case ((None, None), _) =>
        println("Goodbye")
        System.exit(200)
        (None, None)
  }

}
