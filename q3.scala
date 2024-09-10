object BankExample extends App {
    class Account(var balance : Double) {
        def deposit ( amount : Double ) : Unit = {
            if (amount > 0) {
                balance += amount
                println(s"Deposited $$${amount}. Current balance: $$${balance}")
            } else {
                println("Deposit amount must be positivel")
            }
        }
        def withdraw (amount: Double): Unit = {
            if (amount > 0 && amount <= balance) {
                balance -= amount 
                println(s"Withdraw $$${amount}. Current balance: $$${balance}")
            } else if (amount > balance) {
                println("Insufficient funds!")
            } else {
                println("Withdrawal amount must be positivel")
            }
        }
        def transfer(amount : Double, toAccount : Account): Unit = {
            if (amount > 0 && amount <= balance){
                this.withdraw(amount)
                toAccount.deposit(amount)
                println(s"Transferred $$${amount} to the recipient's account.")
            } else if  (amount > balance) {
                println ("Insufficeient funds for transfer!")
            } else {
                println("Transfer amount must be positive!")
            }
        }
        def checkBalance() : Unit = {
            println(s"Current balance: $$${balance}")
        }
    }
         val account1 = new Account(1000)
         val account2 = new Account(500)
         println("\n")
         account1.deposit(200)
         account1.withdraw(100)
         println("\n")
         account1.transfer(300, account2)
         println("\n")
         account1.checkBalance()
         account2.checkBalance()
         println("\n")
}