import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        ATMop obj = new ATMop();
    }
}

class Data{
    float balance;
}

class ATMop{
    //    float balance;
    Scanner sc = new Scanner(System.in);
    HashMap<Integer,Data> map =new HashMap<>();
    ATMop(){
        System.out.println("********************************************************************");
        System.out.println("Welcome to Our ATM");
        op();
    }

    public  void op(){
        System.out.println("********************************************************************");
        System.out.println("Enter your pin code");
        int pincode = sc.nextInt();

        if(map.containsKey(pincode) == true){
            Data obj = map.get(pincode);
            menu(obj);
        }
        else {
            System.out.println("****************************************************************");
            System.out.println("Please create account first");
            System.out.println("set your pin code");
            int pin = sc.nextInt();
            Data obj = new Data();
            map.put(pin,obj);
            menu(obj);

        }
    }
    public  void menu(Data obj){
        System.out.println("********************************************************************");
        System.out.println("Please enter valid number");

        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check another Account");
        System.out.println("5. Exit");


        int x =sc.nextInt();

        if(x==1){
            check_balance(obj);
        } else if (x==2) {
            deposit(obj);
        } else if (x==3) {
            withdraw(obj);
        } else if (x==4) {
            op();
        } else if (x==5) {
            System.out.println("Thank you for using our ATM");
        } else {
            System.out.println("Please enter valid number");
            menu(obj);
        }
    }

    public  void check_balance(Data obj){
        System.out.println("********************************************************************");
        System.out.println("Your Balance is: "+obj.balance);
        System.out.println("********************************************************************");
        menu(obj);
    }

    public void deposit(Data obj){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to deposit");
        float x = sc.nextFloat();

        obj.balance = obj.balance + x;
        System.out.println("Your Amount deposited successfully");
        System.out.println("********************************************************************");
        menu(obj);
    }

    public void withdraw(Data obj){
        System.out.println("Enter your Amount");
        float a = sc.nextInt();
        if(obj.balance>=a){
            obj.balance = obj.balance - a;
            System.out.println("Your Balance is withdraw successfully");
        }
        else {
            System.out.println("Insufficent Balance");
        }
        System.out.println("********************************************************************");
        menu(obj);
    }
}