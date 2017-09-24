package functional.programming.monoid

object GenericItemInstances {
  implicit val stringItem = new GenericItem[String] {
    override def empty = ""

    override def combine(a: String, b: String) = a + b
  }

  implicit val intItem = new GenericItem[Int] {
    override def empty = 0

    override def combine(a: Int, b: Int) = a + b
  }
}
