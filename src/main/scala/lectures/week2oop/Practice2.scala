package lectures.week2oop

// account type
sealed abstract class AccountType

case object FreeAccount extends AccountType

case object PaidAccount extends AccountType

// subscription status
sealed abstract class SubscriptionStatus

case object Subscribed extends SubscriptionStatus

case object Unsubscribed extends SubscriptionStatus

case object SubscriptionMissingData extends SubscriptionStatus

// settings
object Settings {
  case class AccountSettings(
                              email: String,
                              password: String,
                              picture: String)

  case class SubscriptionSettings(
                                   paymentMethod: String,
                                   notifications: String,
                                   expiration: String)
}

trait Unsubscriber {
  def unsubscribe(accountId: Int): Unit = println(s"$accountId unsubscribed")
}

abstract class Account(
                        accountId: Int,
                        accountType: AccountType,
                        settings: Settings.AccountSettings) {

  def info(): Unit = println(s"Account Type: $accountType")

  def subscribe(accountId: Int): Unit = println(s"$accountId ${settings.email} subscribed")

  def performAction(): Unit
}

case class BaseAccount(accountId: Int,
                       accountType: AccountType,
                       settings: Settings.AccountSettings) extends Account(accountId, accountType, settings) {
  def performAction(): Unit = {
    subscribe(this.accountId)
  }
}

object BaseAccount {
  def apply(accountId: Int,
            accountType: AccountType,
            settings: Settings.AccountSettings): BaseAccount = new BaseAccount(accountId, FreeAccount, settings)
}

case class PrivilegedAccount(accountId: Int,
                             accountType: AccountType,
                             settings: Settings.AccountSettings,
                             subscriptionStatus: SubscriptionStatus)
  extends Account(accountId, accountType, settings) with Unsubscriber {

  override def info(): Unit = {
    super.info()
    println(s"Subscription Status: $subscriptionStatus")
  }

  override def performAction(): Unit = {
    unsubscribe(this.accountId)
  }
}