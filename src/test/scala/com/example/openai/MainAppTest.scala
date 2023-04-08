/**
  * tests for simple app
  */

package com.example.openai
import org.scalatest.flatspec.AnyFlatSpec

class FirstSpec extends AnyFlatSpec {
  "An empty set" should "have size 0" in {
    assert(Set.empty.size == 0)
  }

  it should "produce NoSuchElementException for head" in {
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  }
}
