package functional.programming.functor

import org.scalatest.FlatSpec

class FunctorLaws extends FlatSpec {
//  The first functor law states that if we map the id function over a functor,
//  the functor that we get back should be the same as the original functor.

  private val a = 1

  "Functor.map over identity" should "return original functor" in {
    assert(Thing(a).map(identity) == Thing(a))
    assert(List(a).map(identity) == List(a))
  }

//  The second law says that composing two functions and then mapping the resulting function over a functor
//  should be the same as first mapping one function over the functor and then mapping the other one
  "Functor map over few functions" should "be same as Functor map over combined function" in {
    assert(Thing(a).map(f).map(g) == Thing(a).map(value => g(f(value))))
    assert(List(a).map(f).map(g) == List(a).map(value => g(f(value))))
  }

  private def f(x: Int): Int = x + 1
  private def g(x: Int): String = x.toString
}
