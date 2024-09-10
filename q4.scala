 object BankSystem extends App {
    class Account (var balance : Double) {
        override def toString: String = s"Balance: $$${balance}"
    }

    class Bank(val accounts: List[Account]) {
        def accountsWithNegativeBalance : List [Account] = {
            accounts.filter(account => account.balance < 0)
        }

        def totalBalance : Double = {
            accounts.map(_.balance).sum
        }

        def applyInterest(): Unit = {
            accounts.foreach {account => 
                if (account.balance > 0){
                  account.balance += account.balance * 0.05
                } else {
                    account.balance += account.balance * 0.10
                }
            }
        }
        def displayAccounts(): Unit = {
            accounts.foreach(println)
        }
    }
        val account1 = new Account(1000)
        val account2 = new Account(-500)
        val account3 = new Account(200)
        val account4 = new Account(-100)
        val account5 = new Account(500)
        val bank = new Bank(List(account1, account2, account3 , account4, account5))
    
        println("Accounts with negative balances: ")
        bank.accountsWithNegativeBalance.foreach(println)

        val total = bank.totalBalance
        println(s"Total balance of all accounts: $$${total}")

        bank.applyInterest()
        println("Balances after applying interest: ")
        bank.displayAccounts()  
 }