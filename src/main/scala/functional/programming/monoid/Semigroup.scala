package functional.programming.monoid

trait Semigroup[T] {
  def combine(a: T, b: T): T
}
