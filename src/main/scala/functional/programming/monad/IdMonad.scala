package functional.programming.monad

case class IdMonad[T](value: T) {
  def unit(value: T): IdMonad[T] = IdMonadOps.unit(value)

  def flatMap[B](function: T => IdMonad[B]): IdMonad[B] = IdMonadOps.flatMap(this)(function)

  def map[B](function: T => B): IdMonad[B] = IdMonadOps.map(this)(function)
}

object IdMonadOps extends FreeMonad[IdMonad] {
  override def unit[A](value: A) = IdMonad(value)

  override def flatMap[A, B](monad: IdMonad[A])(function: A => IdMonad[B]) = function(monad.value)

  override def map[A, B](functor: IdMonad[A])(f: (A) => B) = unit(f(functor.value))
}