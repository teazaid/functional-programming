package functional.programming.monoid

import org.scalatest.FlatSpec

class SumSupportGenericSpec extends FlatSpec {
  import GenericItemInstances._

  "SumSupportGeneric" should "calculate sum for different items" in {
    val sumSupportGeneric = new SumSupportGeneric {}

    assert(sumSupportGeneric.sum(List(1, 2, 3, 4), intItem) == 10)

    assert(sumSupportGeneric.sum(List("a", "b", "c"), stringItem) == "abc")
  }

  "sumSupportGenericImproved" should "calculate sum for different items" in {
    val sumSupportGenericImproved = new SumSupportGenericImproved {}

    assert(sumSupportGenericImproved.sum(List(1, 2, 3, 4)) == 10)

    assert(sumSupportGenericImproved.sum(List("a", "b", "c")) == "abc")
  }
}
