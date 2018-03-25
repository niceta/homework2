import org.scalatest.FlatSpec

class PermutationsSpec extends FlatSpec {
  def myPermutation(l: List[Int]): List[List[Int]] = {
    def permutationList(l: List[Int]): List[List[Int]] = l match {
      case List() => List(List.empty[Int])
      case List(elem) => List(List(elem))
      case list =>
        for {
          i <- List.range(0, list.length)
          p <- permutationList(list.slice(0, i) ++ list.slice(i + 1, list.length))
        } yield list(i) :: p
    }
    permutationList(l).distinct
  }

  val testedFunc: List[Int] => List[List[Int]] = myPermutation


  def compare(actual: List[List[Int]], expected: List[Int]): Boolean = {
    actual.diff(expected.permutations.toList).isEmpty && expected.permutations.toList.diff(actual).isEmpty
  }

  "My permutation func" should "work right for empty list" in {
    val xs = List.empty[Int]
    assert(compare(testedFunc(xs), xs))
  }

  "My permutation func" should "work right for list with not repetitive elements" in {
    val xs = List(1, 2, 3)
    assert(compare(testedFunc(xs), xs))
  }

  "My permutation func" should "work right for list with repetitive element elements" in {
    val xs = List(1, 2, 2)
    assert(compare(testedFunc(xs), xs))
  }

  "My permutation func" should "work right for list with same elements" in {
    val xs = List(2, 2, 2)
    assert(compare(testedFunc(xs), xs))
  }
}
