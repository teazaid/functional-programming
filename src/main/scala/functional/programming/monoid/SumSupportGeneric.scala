package functional.programming.monoid

trait SumSupportGeneric {
  def sum[T](elements: List[T], genericItem: GenericItem[T]) = {
    elements.foldLeft(genericItem.empty)((a, b) => genericItem.combine(a, b))
  }
}

trait SumSupportGenericImproved {
  def sum[T](elements: List[T])(implicit genericItem: GenericItem[T]) = {
    elements.foldLeft(genericItem.empty)((a, b) => genericItem.combine(a, b))
  }
}