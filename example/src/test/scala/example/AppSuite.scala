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
  // Reverse a list.
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
  //Find out whether a list is a palindrome
  test("P06: isPalindrom"){
    assert(isPalindromN(List(1, 2, 3, 2, 1))==true)
  }
  //Flatten a nested list structure.
  test("P07: flatten list structure"){
    assert(flatten(List(List(1, 1), 2, List(3, List(5, 8))))==List(1, 1, 2, 3, 5, 8))
  }
  //Eliminate consecutive duplicates of list elements.
  test("P08: Eliminate consecutive duplicates of list elements: Recursive"){
    assert(compress(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))==List('a', 'b', 'c', 'a', 'd', 'e'))
  }

  test("P08: Eliminate consecutive duplicates of list elements: TailRec"){
    assert(compressTR(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))==List('a', 'b', 'c', 'a', 'd', 'e'))
  }

  test("P08: Eliminate consecutive duplicates of list elements: Functional "){
    assert(compressF(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))==List('a', 'b', 'c', 'a', 'd', 'e'))
  }
  //Pack consecutive duplicates of list elements into sublists.
  //If a list contains repeated elements they should be placed in separate sublists.
  test("P09: Pack consecutive duplicates of list elements into sublists."){
    assert(pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))==List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
  }
  //Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
  test("P10: Run-length encoding of a list."){
    assert(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))==List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  }
  //Modified run-length encoding.
  //Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
  test("P11: modified run-length encoding"){
    assert(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) == List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)))
  }
  //Decode a run-length encoded list.
  //Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
  test("P12: Decode a run-length encoded list. "){
    assert(decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) == List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  }
  //Run-length encoding of a list (direct solution).
  //Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've written (like P09's pack); do all the work directly.
  test("P13: Run-length encoding of a list. Direct solution "){
   assert(encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) == List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  }
  //Duplicate the elements of a list.
  test("P14: Duplicate the elements of a list."){
    assert(duplicate(List('a, 'b, 'c, 'c, 'd)) == List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd))
  }
  //Duplicate the elements of a list N times
  test("P14: Duplicate the elements of a list N times"){
   assert(duplicateN(3, List('a, 'b, 'c, 'c, 'd)) == List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
  }
  //Drop every Nth element from a list.
  test("P16: Drop every Nth element from a list."){
    assert(drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
  }
  //Split a list into two parts.
  test("P17: Split a list into two parts."){
    assert(split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
  //Extract a slice from a list.
  test("P18: Extract a slice from a list."){
    assert(slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('d, 'e, 'f, 'g))
  }
  //Rotate a list N places to the left.
  test("P19: Rotate a list N places to the left."){
    assert(rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c))
  }
  //Rotate a list N places to the left.
  test("P19: Rotate a list N places to the left again"){
   assert(rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i))
  }
  //Remove the Kth element from a list.
  test("P20: Remove the Kth element from a list."){
    assert(removeAt(1, List('a, 'b, 'c, 'd)) == (List('a, 'c, 'd),'b))
  }
  // Insert an element at a given position into a list.
  test("P21:  Insert an element at a given position into a list."){
    assert(insertAt('new, 1, List('a, 'b, 'c, 'd)) == List('a, 'new, 'b, 'c, 'd))
  }
  //Create a list containing all integers within a given range.
  test("P22: Create a list containing all integers within a given range."){
    assert(range(4, 9) == List(4, 5, 6, 7, 8, 9))
  }
  // Extract a given number of randomly selected elements from a list.
  test("P23:  Extract a given number of randomly selected elements from a list." ){
    assert(randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)) == List('e, 'd, 'a))
  }
  //Lotto: Draw N different random numbers from the set 1..M.
  test("P24: Lotto: Draw N different random numbers from the set 1..M."){
    assert(lotto(6, 49) == List(23, 1, 17, 33, 21, 37))
  }
  //Generate the combinations of K distinct objects chosen from the N elements of a list.
  test("P26: Generate the combinations of K distinct objects chosen from the N elements of a list."){
    assert(combinations(3, List('a, 'b, 'c, 'd, 'e, 'f)) == List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e)))
  }
  //Group the elements of a set into disjoint subsets.
  test("P27: Group the elements of a set into disjoint subsets."){
    assert(group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")) == List(List(List("Aldo", "Beat"), List("Carla", "David", "Evi"), List("Flip", "Gary", "Hugo", "Ida"))))
  }
  // Sorting a list of lists according to length of sublists.
  test("P28:  Sorting a list of lists according to length of sublists."){
    assert(
      lsort(
        List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
      ==
        List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l)))
  }

  //ARITHMETIC PART

  //Determine whether a given integer number is prime.
  test("P31: Determine whether a given integer number is prime."){
    //assert( 7.isPrime == true ) //should be this way
    assert( isPrime(7) === true )
  }
   test("P31: Zip method Determine whether a given integer number is prime."){
     //assert( 7.isPrime == true ) //should be this way
     assert( isPrimeZip(7) === true )
   }
   //Determine the greatest common divisor of two positive integer numbers.
  test("P32: Determine the greatest common divisor of two positive integer numbers."){
    assert( gcd(36, 63) == 9)
  }
   //Determine whether two positive integer numbers are coprime.
  test("P33: Determine whether two positive integer numbers are coprime."){
    assert(coprime(35, 64) === true)
  }
  //Determine the prime factors of a given positive integer.
  test("P35: Determine the prime factors of a given positive integer."){
    assert(primeFactors(315) == List(3, 3, 5, 7))
  }
  test("P35: Multi: Determine the prime factors of a given positive integer."){
   assert(primeFactorsMultiple(315) == List((3,2), (5,1), (7,1)))
  }
  test("P35: Map:  Determine the prime factors of a given positive integer."){
   assert(primeFactorsMap(315) == Map(3 -> 2, 5 -> 1, 7 -> 1))
  }
  //A list of prime numbers.
  test("P39: A list of prime numbers."){
    assert(listPrimesInRange(7, 31) == List(7, 11, 13, 17, 19, 23, 29, 31))
  }

   //CODES PART
   //Huffman code
  test("P50: Huffman code"){
    assert(huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))) == List(("a",0), ("b",101), ("c",100), ("d",111), ("e",1101), ("f",1100)))
  }
}
