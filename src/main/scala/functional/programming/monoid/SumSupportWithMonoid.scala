package functional.programming.monoid

trait SumSupportWithMonoid {
  def sum[T](elements: List[T])(implicit monoid: Monoid[T]) = {
    elements.foldLeft(monoid.empty)((a, b) => monoid.combine(a, b))
  }
}
