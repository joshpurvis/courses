package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (r <= 0 || c <= 0 || c >= r) 1
    else pascal(c-1,r-1)+pascal(c,r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
      def balanceHelper(chars: List[Char], count: Int): Int =
        if (chars.isEmpty || count < 0) count
        else {
          if (chars.head=='(') balanceHelper(chars.tail, count+1)
          else if (chars.head==')') balanceHelper(chars.tail, count-1)
          else balanceHelper(chars.tail, count)
        }
      balanceHelper(chars, 0) == 0
    }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0 || coins.isEmpty) 0
    else {
      val sortedCoins = coins.sorted
      countChange(money, sortedCoins.tail)+countChange(money-sortedCoins.head, coins)
    }
  }
}
