package functional.programming.applicative

import org.scalatest.FlatSpec

class FunctorAgainstFunctionArity2Spec extends FlatSpec {
  def functionArity2(a: Int, b: Int): Int = a + b

  private val a = 2
  private val b = 3

  "Functor against function arity2" should "return function in a context" in {
    val partiallyAppliedFunction: Option[Int => Int] = Option(a).map(value =>
      functionArity2(value, _))
    //    partiallyAppliedFunction(b)
    assert(partiallyAppliedFunction.isInstanceOf[Option[Int => Int]])

    val optionApplicative = new Applicative[Option] {
      override def ap[A, B](f: Option[(A) => B])(fa: Option[A]): Option[B] = {
        for {
          fUnwrapped <- f
          faUnwrapped <- fa
        } yield fUnwrapped(faUnwrapped)
      }

      override def pure[A](a: A): Option[A] = Some(a)
    }

    assert(optionApplicative.ap(partiallyAppliedFunction)(optionApplicative.pure(b)) == Some(5))
  }
  /*
  * Every applicative is a functor and by the laws for Applicatives,
  * this property has to hold valid: fmap = apply ο pure. This law ensures that we can use applicative as a functor i.e on arity -1 function.

  Applicatives allows us to apply functions of arbitrary arity (>=1) to its arguments
  inside a computational context, and as functors provide for the exact functions of arity-1,
  Applicatives can be thought as generalized functors.
  * */
}
