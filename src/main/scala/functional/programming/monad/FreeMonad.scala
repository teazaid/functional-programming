package functional.programming.monad

import functional.programming.functor.FreeFunctor

trait FreeMonad[M[_]] extends FreeFunctor[M] {
  def unit[A](value: A): M[A]

  def flatMap[A, B](monad: M[A])(function: A => M[B]): M[B]
}
