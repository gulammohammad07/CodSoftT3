package atm_interface;

public class bankAcc {
private double balance ;

public bankAcc(double initialBal) {
    this.balance=initialBal;
}
public  double getBalance(){
    return  balance;
}

public void deposit(double amt){
    if (amt > 0){
        balance += amt;
    }else {
        System.out.println("Invalid deposit amount");
    }
}

public boolean withdraw(double amt){
    if (amt > 0 && amt <= balance){
        balance -= amt;
        return  true;
    } else if (amt > balance) {
        System.out.println("Insufficient balance. Available bal: $"+getBalance());
        return false;
    }else {
        System.out.println("invalid amount");
        return false;
    }
}


}
