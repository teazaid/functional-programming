package functional.programming.functor

trait FreeFunctor[F[_]] {
  def map[A, B](functor: F[A])(f: A => B): F[B]
}
