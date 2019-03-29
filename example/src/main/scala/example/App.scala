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
        case Nil => 0
        case h::tail => size(n+1, tail)
      }
    size(0,l)
  }

  def sizeNative(l: List[Int]):Int = l.length
  
  def sizeF(l: List[Int]): Int = ???
  
  def reverse(l: List[Int]): List[Int] = ???
  
  def reverseR(l: List[Int]): List[Int] = ???
  
  def reverseTR(l: List[Int]): List[Int] = ???
  
  def reverseF(l: List[Int]): List[Int] = ???
  
}
