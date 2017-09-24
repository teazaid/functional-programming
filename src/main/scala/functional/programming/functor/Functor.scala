package functional.programming.functor

trait Functor[A] {
  def map[B](f: A => B): Functor[B]
}