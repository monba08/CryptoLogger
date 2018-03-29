import java.io.*;
import java.lang.*;
import java.util.Scanner;


public class Accounts {

    private String coinType;
    private String nameUser;
    private int valueCoin;
    private int quantityCoin;
    private int date;


    //Dit zal later geïmplementeerd worden in een GUI.
    public void createNewAccount() throws IOException {
        Coin coin = new Coin();
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = reader.next();
        System.out.println("Enter your surname: ");
        String surname = reader.next();
        /*System.out.println("Enter a password for your account: ");
        String password = reader.next();*/

        //Parameters die we zullen doorgeven.
        nameUser = name;
        coinType=coin.setNameCoin();
        valueCoin=coin.setValueCoin();
        quantityCoin=coin.setQuantityCoin();
        reader.close();

        File fout = new File("Accounts.txt");
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        bw.write(name);
        bw.write(" ");
        bw.write(surname);
        bw.write(" ");
        bw.write(coinType);
        bw.write(" ");
        bw.write(Integer.toString(valueCoin));
        bw.write(" ");
        bw.write(Integer.toString(quantityCoin));
        //bw.newLine();
        bw.close();

    }

    public void logIn(String Name){

    }

    public void checkUser(String naam)
    {
        this.nameUser=naam;



    }
}
