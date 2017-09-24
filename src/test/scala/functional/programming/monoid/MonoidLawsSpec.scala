package functional.programming.monoid

import org.scalatest.FlatSpec

class MonoidLawsSpec extends FlatSpec {
  val intMonoid = new Monoid[Int] {
    override def empty = 0

    override def combine(a: Int, b: Int): Int = a + b
  }

  private val a = 1
  private val b = 2
  private val c = 3

  "Monoid.combine" should "be associative" in {
    assert(
      intMonoid.combine(intMonoid.combine(a, b), c) == intMonoid.combine(a, intMonoid.combine(b, c))
    )
  }

  "Monoid left identity" should "not affect the value" in {
    assert(intMonoid.combine(intMonoid.empty, a) == a)
  }

  "Monoid right identity" should "not affect the value" in {
    assert(intMonoid.combine(a, intMonoid.empty) == a)
  }
}
