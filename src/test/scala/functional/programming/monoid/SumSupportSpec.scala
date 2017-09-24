package functional.programming.monoid

import org.scalatest.FlatSpec

class SumSupportSpec extends FlatSpec {
  "SumSupportInt" should "calculate sum of ints" in {
    val intSum = new SumSupportInt()
    assert(intSum.sum(List(1, 2, 3, 4)) == 10)
  }

  "SumSupportString" should "calculate sum of strings" in {
    val stringSum = new SumSupportString()
    assert(stringSum.sum(List("1", "2", "3", "4")) == "1234")
  }

  "SumSupportListInt" should "calculate sum of list of ints" in {
    val listSumInt = new SumSupportListInt()
    assert(listSumInt.sum(List(
      List(1, 2, 3, 4),
      List(5, 6, 7, 9)
    )) == List(1, 2, 3, 4, 5, 6, 7, 9))
  }

  "SumSupportSetInt" should "calculate sum of sets of ints" in {
    val setSumInt = new SumSupportSetInt()
    assert(setSumInt.sum(List(
      Set(1, 2, 3, 4),
      Set(5, 6, 7, 9)
    )) == Set(1, 2, 3, 4, 5, 6, 7, 9))
  }
}
