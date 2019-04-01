package example

import java.lang.IllegalStateException

object App {
  def main(args: Array[String]): Unit ={
    println("here is start")
    println("P01: last element: " + last(List(1, 1, 2, 3, 5, 8)))
    println("P02: before last element: " + beforeLast(List(1, 1, 2, 3, 5, 8)))
    println("P03: k-th element: " + kEl(2, List(1, 1, 2, 3, 5, 8)))
  }
  //Find the last element of a list.
  def last[A](l: List[A]): A = l match {
    case h :: Nil => h
    case h :: tail => last(tail)
    case _ => throw new NoSuchElementException
  }
  //Find the last but one element of a list.
  def beforeLast[A](l: List[A]): A = l match {
    case h :: t :: Nil => h
    case h :: tail => beforeLast(tail)
    case _ => throw new NoSuchElementException
  }

  //Find the Kth element of a list.
  def kEl(n: Int, ls: List[Int]): Int = (n, ls) match {
    case (0, h::tail) => h
    case(k, h::tail) => kEl(k-1,tail)
    case(_, Nil) => throw new NoSuchElementException
  }

  //P04 (*) Find the number of elements of a list.
  def sizeR(l: List[Int]):Int = l match {
    case (Nil) => 0
    case (h::tail) =>1 + sizeR(tail)
  }

  def sizeTR(l: List[Int]):Int = {
    def size(n:Int, l: List[Int]):Int = l match {
        case Nil => n
        case h::tail => size(n+1, tail)
      }
    size(0,l)
  }

  def sizeNative(l: List[Int]):Int = l.length
  
  def sizeF(l: List[Int]): Int = l.foldLeft(0){ (c,_) => c+1 }
  
  def reverse(l: List[Int]): List[Int] = l.reverse
  
  def reverseR(l: List[Int]): List[Int] = l match {
    case Nil => Nil
    case (h :: tail) => reverseR(tail) ::: List(h)
 }
  
  def reverseTR(l: List[Int]): List[Int] = {
    def reverse(result: List[Int], list: List[Int]): List[Int] = list match {
      case Nil => result
      case (h :: tail) => reverse(h :: result, tail)
    }
    reverse(Nil, l)
  }
  
  def reverseF(l: List[Int]): List[Int] = l.foldLeft(List[Int]())((h,c)=> c :: h)

  def isPalindromN(l: List[Int]): Boolean = l.reverse == l

  def flatten(l: List[Any]): List[Any] = l flatMap {
    case ls: List[_] => flatten(ls)
    case a => List(a)
  }

  def compress[A](l: List[A]):List[A] = l match {
    case Nil => Nil
    case h :: tail => h :: compress(tail.dropWhile(_ == h))
  }

  def compressTR[A](l: List[A]):List[A] = {
    def compress[A](result: List[A], ls: List[A]):List[A] = ls match {
      case Nil => result.reverse
      case h :: tail => compress(h::result, tail.dropWhile(_ == h))
    }
    compress(List[A](), l)
  }

  def compressF[A](ls: List[A]):List[A] = ls.foldRight(List[A]()) { (h, r) =>
      if (r.isEmpty || r.head != h) h :: r
      else r
    }
  
  def pack[A](ls: List[A]):List[List[A]] = ???
  //Run-length encoding of a list.
  def encode[A](ls: List[A]):List[Any] = ???
  //Modified run-length encoding.
  def encodeModified[A](ls: List[A]): List[Any] = ???
  //Decode a run-length encoded list
  def decode[A](ls: List[Any]):List[A] = ???
  //Run-length encoding of a list. Direct solution
  def encodeDirect[A](ls: List[A]):List[Any] = ???
	//Duplicate the elements of a list
  def duplicate[A](ls: List[A]): List[A] = ???
  //Duplicate the elements of a list N times
  def duplicateN[A](n: Int, ls: List[A]): List[A] = ???
  //Drop N-th elements of a list
  def drop[A](n: Int, ls: List[A]): List[A] = ???
  //Slit list into two parts
  def split[A](n: Int, ls: List[A]): (List[A], List[A]) = ???
  //Extract slice from a list
  def slice[A](n: Int, k: Int, ls: List[A]): List[A] = ???
  //Rotate list N places to left
  def rotate[A](n: Int, ls: List[A]): List[A] = ???
  // Remove the Kth element from a list.
  def removeAt[A](n: Int, ls: List[A]): (List[A], A) = ???
  // Insert an element at a given position into a list.
  def insertAt[A](el: A, n: Int, ls: List[A]): List[A] = ???
  //Create a list containing all integers within a given range.
  def range(a: Int, b: Int): List[Int] = ???
  // Extract a given number of randomly selected elements from a list.
  def randomSelect[A](n: Int, ls: List[A]): List[A] = ???
  //Lotto: Draw N different random numbers from the set 1..M.
  def lotto(n: Int, m: Int): List[Int] = ???
  //Generate the combinations of K distinct objects chosen from the N elements of a list.
  def combinations[A](n: Int, ls: List[A]): List[List[A]] = ???
  //Group the elements of a set into disjoint subsets.
  def group3[A](ls: List[A]):List[List[List[A]]] = ???
  // Sorting a list of lists according to length of sublists.
  def lsort[A](ls: List[List[A]]): List[List[A]] = ???


  //Arithmetic part
  //Determine whether a given integer number is prime.
  def isPrime(n: Int): Boolean = ???
  def isPrimeZip(n: Int): Boolean = ???
  //Determine the greatest commin divisor of two integer numbers
  def gcd(n: Int, m: Int): Int = ???
  //Determine whether two positive integer numbers are coprime.
  def coprime(n: Int, m: Int): Int = ???
  //Determine the prime factors of a given positive integer.
  def primeFactors(n: Int): List[Int] = ???
  def primeFactorsMultiple(n: Int): List[List[Int]] = ???
  def primeFactorsMap(n: Int): Map[Int, Int] = ???
  //A list of prime numbers.
  def listPrimesInRange(n: Int, m: Int): List[Int] = ???
  //Huffman code
  def huffman(ls: List[(String, Int)]) : List[(String, Int)] = ???
}
