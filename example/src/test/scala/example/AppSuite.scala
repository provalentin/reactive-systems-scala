package example

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

 @RunWith(classOf[JUnitRunner])
  class AppSuite extends FunSuite {

  import App._

  test("P01: Find the last element of a list"){
    assert(last(List(1, 1, 2, 3, 5, 8))==8)
  }

  //Find the last but one element of a list.
  test("P02: Find the last but one element of a list"){
    assert(beforeLast(List(1, 1, 2, 3, 5, 8))==5)
  }

  //Find the Kth element of a list.
  test("P03: Find the Kth element of a list"){
    assert(kEl(2, List(1, 1, 2, 3, 5, 8))==2)
  }
  
  //Find the number of elements of a list
  test("P04: Find the number elements of a list: Native Method"){
    assert(sizeNative(List(1, 1, 2, 3, 5, 8)) == 6)
  }


}
