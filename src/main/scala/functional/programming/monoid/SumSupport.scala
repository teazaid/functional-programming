package functional.programming.monoid

trait SumSupport[T] {
  def sum(elements: List[T]): T
}

class SumSupportInt extends SumSupport[Int] {
  override def sum(elements: List[Int]) = elements.foldLeft(0)(_ + _)
}

class SumSupportString extends SumSupport[String] {
  override def sum(elements: List[String]) = elements.foldLeft("")(_ + _)
}

class SumSupportListInt extends SumSupport[List[Int]] {
  override def sum(elements: List[List[Int]]) = elements.foldLeft(List.empty[Int])(_ ::: _)
}

class SumSupportSetInt extends SumSupport[Set[Int]] {
  override def sum(elements: List[Set[Int]]) = elements.foldLeft(Set.empty[Int])(_ ++ _)
}


//
//trait SumSupportGeneric[T <: GenericItem[T]] extends SumSupport[T] {
//  override def sum(elements: List[T]) = {
//    val instance = classOf[T].getConstructor().newInstance()
//    elements.foldLeft(instance.empty)((a, b) => instance.combine(a, b))
//  }
//}



