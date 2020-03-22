package fruitMachine

import scala.util.Random

case class SlotSpinner(s1: Int = Random.nextInt(Color.maxId),
                       s2: Int = Random.nextInt(Color.maxId),
                       s3: Int = Random.nextInt(Color.maxId),
                       s4: Int = Random.nextInt(Color.maxId),
                      ) {

  def spin: (Outcome, String) = {
    val display = s"${s1.toString}, ${s2.toString}, ${s3.toString}, ${s4.toString}"
    (results(s1, s2, s3, s4), display)
  }

  private def results(slot1: Int, slot2: Int, slot3: Int, slot4: Int): Outcome = {
    if (slot1 == slot2 && slot2 == slot3 && slot3 == slot4) AllEqual
    else Lose
  }
}
