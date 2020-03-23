package fruitMachine

import scala.util.Random
import cats.data.NonEmptyList
import cats.implicits._

case class SlotSpinner(s1: Int = Random.nextInt(Color.maxId),
                       s2: Int = Random.nextInt(Color.maxId),
                       s3: Int = Random.nextInt(Color.maxId),
                       s4: Int = Random.nextInt(Color.maxId),
                      ) {

  def spin: (Outcome, String) = {
    val display = s"${s1.toString}, ${s2.toString}, ${s3.toString}, ${s4.toString}"
    (results(NonEmptyList(s1, List(s2, s3, s4))), display)
  }

  private def results(slots: NonEmptyList[Int]): Outcome = {
    if (slots.distinct.length == 1) AllEqual
    else if (slots.distinct.length == slots.length) Unique
    else Lose
  }
}
