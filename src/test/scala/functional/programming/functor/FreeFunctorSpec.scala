package functional.programming.functor

import org.scalatest.FlatSpec

class FreeFunctorSpec extends FlatSpec {
  val functorList = new FreeFunctor[List] {
    override def map[A, B](functor: List[A])(f: (A) => B) = functor.map(f)
  }

  "FreeFunctor" should "interact with any Functor" in {
    assert(functorList.map[Int, Int](List(1, 2, 3))(_ + 1) == List(2, 3, 4))

    assert(functorList.map[String, Int](List("1", "2", "3"))(_.toInt) == List(1, 2, 3))
  }
}
