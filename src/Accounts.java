import java.lang.*;
import java.util.Scanner;


public class Accounts {

    private String coinType;
    private String nameUser;
    private int valueCoin;
    private int quantityCoin;
    private int date;


    public void createNewAccount(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = reader.next();
        System.out.println("Enter a password for your account: ");
        String password = reader.next();
        System.out.println("Which crypto-coin would you like to add? ");
        String coin = reader.next();
        System.out.println("Type in the current value of this coin: ");
        int value = reader.nextInt();
        nameUser = name;
        coinType=coin;
        valueCoin=value;
        reader.close();
    }

    public void logIn(String Name){

    }

    public void checkUser()
    {

    }
}
