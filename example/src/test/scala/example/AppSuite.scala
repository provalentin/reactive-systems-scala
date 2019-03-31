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

  //Find the number of elements of a list
  test("P04: Find the number elements of a list: Recursive Method"){
    assert(sizeR(List(1, 1, 2, 3, 5, 8)) == 6)
  }
  //Find the number of elements of a list
  test("P04: Find the number elements of a list: Tail Recursive Method"){
    assert(sizeTR(List(1, 1, 2, 3, 5, 8)) == 6)
  }
   
  test("P04: Find the number elements of a list: Functional Style"){
    assert(sizeF(List(1, 1, 2, 3, 5, 8)) == 6)
  }

  test("P05: Reverse list: Native"){
    assert(reverse(List(1, 1, 2, 3, 5, 8))==List(8, 5, 3, 2, 1, 1))
  }

  test("P05: Reverse list: Recursive"){
    assert(reverseR(List(1, 1, 2, 3, 5, 8))==List(8, 5, 3, 2, 1, 1)) 
  }
  
  test("P05: Reverse list: TailRec"){
    assert(reverseTR(List(1, 1, 2, 3, 5, 8))==List(8, 5, 3, 2, 1, 1)) 
  } 
   
  test("P05: Reverse list: Functional"){
    assert(reverseF(List(1, 1, 2, 3, 5, 8))==List(8, 5, 3, 2, 1, 1))
  }

  test("P06: isPalindrom"){
    assert(isPalindromN(List(1, 2, 3, 2, 1))==true)
  }

  test("P07: flatten list structure"){
    assert(flatten(List(List(1, 1), 2, List(3, List(5, 8))))==List(1, 1, 2, 3, 5, 8))
  }

  test("P08: Eliminate consecutive duplicates of list elements: Recursive"){
    assert(compress(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))==List('a', 'b', 'c', 'a', 'd', 'e'))
  }

  test("P08: Eliminate consecutive duplicates of list elements: TailRec"){
    assert(compressTR(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))==List('a', 'b', 'c', 'a', 'd', 'e'))
  }

  test("P08: Eliminate consecutive duplicates of list elements: Functional "){
    assert(compressF(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))==List('a', 'b', 'c', 'a', 'd', 'e'))
  }
}
