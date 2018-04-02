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
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = reader.next();
        System.out.println("Enter your surname: ");
        String surname = reader.next();

        Coin coin = new Coin(valueCoin, quantityCoin,coinType);
        System.out.println("Which crypto-coin would you like to add? ");
        if(reader.hasNext())
            coinType=reader.next();
        //coinType=reader.next();
        coin.setNameCoin(coinType);

        System.out.println("Type in the current value of this coin: ");
        String valueString =reader.next();
        /*if(reader.hasNext())
            valueString=reader.next();*/
        valueCoin=Integer.parseInt(valueString);
        coin.setValueCoin(valueCoin);

        System.out.println("How much do you want to own from "+coinType+"?");
        String quantityString = reader.next();
        /*if(reader.hasNext())
            quantityString=reader.next();*/
        quantityCoin = Integer.parseInt(quantityString);
        coin.setQuantityCoin(quantityCoin);


        //Parameters die we zullen doorgeven.
        nameUser = name;
        /*coinType=coin.setNameCoin();
        valueCoin=coin.setValueCoin();
        quantityCoin=coin.setQuantityCoin();*/
        reader.nextLine();
        reader.close();

        File fout = new File("Accounts.txt");
        FileOutputStream fos = new FileOutputStream(fout,true); //Append parameter, zodat oude data niet verdwijnt. Boolean argument
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            bw.write(name);
            bw.write(" ");
            bw.write(surname);
            bw.write(" ");
            bw.write(coinType);
            bw.write(" ");
            bw.write(valueString);
            bw.write(" ");
            bw.write(quantityString);
            bw.newLine();
            bw.close();
    }

    public void logIn(String Name){

    }

    public void checkUser(String naam)
    {
        this.nameUser=naam;



    }
}
