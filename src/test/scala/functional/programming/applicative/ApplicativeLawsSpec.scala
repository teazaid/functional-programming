package functional.programming.applicative

import org.scalatest.FlatSpec

class ApplicativeLawsSpec extends FlatSpec {
  private val optionApplicative = new Applicative[Option] {
    override def ap[A, B](f: Option[(A) => B])(fa: Option[A]): Option[B] = {
      for {
        fUnwrapped <- f
        faUnwrapped <- fa
      } yield fUnwrapped(faUnwrapped)
    }

    override def pure[A](a: A): Option[A] = Some(a)
  }

  private val a = Option(1)
  private val unitInt = optionApplicative.pure(identity[Int](_))

  private def f(a: Int): Int = a + 1

  //apply(unit(id), v) == v
  "Applicative unit of the identity function" should "be is an identity for apply" in {
    assert(optionApplicative.ap[Int, Int](unitInt)(a) == a)
  }

  //apply(unit(f), unit(x)) == unit(f(x))
  "Applicative" should "unit is a homomorphism from A to F[A] with regard to function application" in {
    val x = 1
    val pureF = optionApplicative.pure(f(_))
    val pureX = optionApplicative.pure(x)

    assert(optionApplicative.ap[Int, Int](pureF)(pureX) == optionApplicative.pure(f(x)))
  }

  "Applicative" should "interchange law" in {
    //apply(u, unit(y)) == apply(unit(_(y)), u)
    val x = 1
    val pureF = optionApplicative.pure(f(_))
    val pureX = optionApplicative.pure(x)
    val newX = optionApplicative.pure((func: Int => Int) => func(x))

    assert(optionApplicative.ap[Int, Int](pureF)(pureX) ==
      optionApplicative.ap(newX)(pureF)
    )
  }
  //apply(u, apply(v, w)) == apply(apply(apply(unit(f => g => f compose g), u), v), w)
}
