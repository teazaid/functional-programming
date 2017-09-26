package functional.programming.monad

import org.scalatest.FlatSpec

class IdMonadTest extends FlatSpec {
  "IdMonad" should "work in for-comprihension" in {
    val result = for {
      idOne <- IdMonad("one")
      idTwo <- IdMonad("two")
    } yield idOne + idTwo

    assert(result.value == "onetwo")
  }

  "IdMonad" should "work in map" in {
    assert(IdMonad("hello").map(id => s"$id worlds") == IdMonad("hello worlds"))
  }

  "IdMonad" should "work in flatMap" in {
    assert(IdMonad("hello").map(id => IdMonad(s"$id worlds1")) == IdMonad("hello worlds1"))
  }
}
