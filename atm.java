package atm_interface;

import java.util.Scanner;

public class atm {
    private static bankAcc account;

    public atm(bankAcc account){
        this.account=account;
    }

    public  void displayMenu(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("\n ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    chechBal();
                    break;
                case 2:
                    System.out.println("Enter the deposit amount: ");
                    double depositAmt = sc.nextDouble();
                    deposit(depositAmt);
                    break;
                case 3:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawalAmt = sc.nextInt();
                    withdraw(withdrawalAmt);
                    break;
                case 4:
                    System.out.println("Thank you for using ATM. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try agian.");
            }
        }
    }

    public void chechBal(){
        System.out.println("Current Balance : $"+account.getBalance());
    }

    public void deposit(double amount){
        account.deposit(amount);
        System.out.println("Deposit successful. Current balance: $" +account.getBalance());
    }

    public void withdraw(double amount){
        boolean success = account.withdraw(amount);
        if (success){
            System.out.println("Withdrawal successful. Current balance: $"+account.getBalance());
        }
    }

    public static void main(String[] args) {
        bankAcc account= new bankAcc(5000); //initial bal
        atm ATM = new atm(account);
        ATM.displayMenu();
    }

}
