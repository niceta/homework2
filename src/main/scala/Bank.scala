abstract class BankProduct {
  protected  val accountName:    String
  protected  var accountBalance: Double = 0

  def put(v: Double): Unit   = accountBalance += v
  def get(v: Double): Double = {
    val temp = accountBalance min v
    accountBalance -= temp
    temp
  }

  def balance: Double = accountBalance
  def name:    String = accountName

  override def toString: String = accountName +
    ". Balance: " + balance.toString
}

case class Debit(accountName: String)
  extends BankProduct

case class CreditCard(accountName: String)
  extends BankProduct

case class DebitCard(accountName: String)
  extends BankProduct

object App {
  def main(args: Array[String]): Unit = {
    val debit = Debit("Debit")
    val creditCard = CreditCard("CreditCard")
    val debitCard = DebitCard("DebitCard")

    debit.put(37.5)
    debitCard.put(21)
    creditCard.put(32.88)

    val getDebit = debit.get(37.5)
    println(getDebit)

    val products = List(debit, creditCard, debitCard)
    val sumBalance = products.map(_.balance).sum
    products.foreach(println)
    println(sumBalance)
  }
}