package functional.programming.monoid

trait GenericItem[T] {
  def empty: T

  def combine(a: T, b: T): T
}
