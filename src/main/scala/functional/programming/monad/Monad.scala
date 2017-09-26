package functional.programming.monad

trait Monad[A] {
  def unit(value: A): Monad[A]
  def flatMap[B](function: A => Monad[B]): Monad[B]
}
