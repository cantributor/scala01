package lectures.week2oop

abstract class Account1

case class PersonalAccount() extends Account1

case class BusinessAccount() extends Account1

// здесь пропущен код --------------------------------------------------------------------------------------------------
object Account1 {
  def apply(accountType: String): Account1 =
    if ("business" == accountType) BusinessAccount()
    else if ("personal" == accountType) PersonalAccount()
    else throw new RuntimeException()
}
//----------------------------------------------------------------------------------------------------------------------

abstract class Bank {
  def openAccount(accountType: String): Account1 = {
    Account1(accountType)
  }
}

case class HeadOffice() extends Bank

case class Branch() extends Bank

