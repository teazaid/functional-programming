package functional.programming.monoid

trait Monoid[T] extends Semigroup[T] {
  def empty: T
}
