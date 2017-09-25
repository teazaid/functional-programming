package functional.programming.applicative

import functional.programming.functor.FreeFunctor

trait Applicative[F[_]] extends FreeFunctor[F] {
  //  def ap[A, B](f: F[A => B]): F[A] => F[B]

  def ap[A, B](f: F[A => B])(fa: F[A]): F[B]

  def pure[A](a: A): F[A]

  override def map[A, B](functor: F[A])(f: A => B): F[B] = ap(pure(f))(functor)
}
