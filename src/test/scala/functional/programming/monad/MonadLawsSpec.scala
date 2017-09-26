package functional.programming.monad

import org.scalatest.FlatSpec

import scala.util.{Success, Try}

class MonadLawsSpec extends FlatSpec {
  val optionFreeMonad = new FreeMonad[Option] {
    override def unit[A](value: A): Option[A] = Some(value)

    override def flatMap[A, B](monad: Option[A])(function: (A) => Option[B]) = monad.flatMap(function)

    //    override def map[A, B](functor: Option[A])(f: A => B) = functor.flatMap(x => unit(f(x)))
    override def map[A, B](functor: Option[A])(f: A => B) = functor.map(f)
  }

  def fT(x: String): Try[Int] = Try(x.toInt)

  def gT(x: Int): Try[Int] = Try(x)

  def f(x: Int): Option[Int] = Option(x)
  def o(x: String): Option[String] = Option(x)

  def g(x: Int): Option[String] = Option(x.toString)

  "Monad unit left law" should "" in {
    val x = 1
    val d: String = null
    val unit = optionFreeMonad.unit(x)
    assert(optionFreeMonad.flatMap(unit)(f) == f(x))

    assert(Some(d).flatMap(o) == o(d))
    assert(Some(x).flatMap(f) == f(x))
    assert(Success("").flatMap(fT) == fT(""))
  }

  "Monad unit right law" should "" in {
    val x = 1
    val unit = optionFreeMonad.unit(x)
    assert(optionFreeMonad.flatMap(unit)(optionFreeMonad.unit) == unit)
    assert(Some(x).flatMap(Some(_)) == Some(x))
  }

  "Monad associativity" should "" in {
    val x = 1
    val unit = optionFreeMonad.unit(x)
    val r1 = optionFreeMonad.flatMap(unit)(f)
    assert(optionFreeMonad.flatMap(r1)(g) == optionFreeMonad.flatMap(unit)(x => optionFreeMonad.flatMap(f(x))(g)))
    assert(Some(x).flatMap(f).flatMap(g) == Some(x).flatMap(i => f(i).flatMap(g)))
    assert(Success("").flatMap(fT).flatMap(gT) == Success("").flatMap(i => fT(i).flatMap(gT)))
  }
}
