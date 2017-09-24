package functional.programming.functor

case class Thing[A](value: A) extends Functor[A] {
  override def map[B](f: A => B) = Thing(f(value))
}
