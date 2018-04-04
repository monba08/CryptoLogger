import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;


public class Accounts {

    private String coinType;
    private String nameUser;
    private int valueCoin;
    private int quantityCoin;
    private int date;
    Portfolio portfolio;
    private static ArrayList<InformationUser> info = new ArrayList<>();


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

    public void logIn() throws IOException {
        Scanner scan = new Scanner (new File("Accounts.txt"));
        Scanner keyboard = new Scanner (System.in);
        String user = scan.next();
        String pass = scan.next(); // looks at selected file in scan

        System.out.println("Type in your username and password please:");
        String inpUser = keyboard.nextLine();
        String inpPass = keyboard.nextLine(); // gets input from user

        if (inpUser.equals(user) && inpPass.equals(pass)) {
            System.out.print("Wilkommen");
            InformationUser current;
            String currentLine;
            String name;
            String surname;
            String coin;
            int coinValue;
            int quantity;
            Scanner lineReader=null;
            Scanner wordReader=null;
            File inputFile=new File("Accounts.txt");
            try {
                lineReader = new Scanner(inputFile);	//Proberen of lijn gelezen kan worden.
            }
            catch(FileNotFoundException e) {
                System.out.println("File not found!");
            }
            while (lineReader.hasNextLine()) {       //Checken op EOF.
                currentLine = lineReader.nextLine(); //Lezen van de volgende lijn in de textfile.
                wordReader = new Scanner(currentLine);
                name = wordReader.next();
                surname = wordReader.next();
                coin = wordReader.next();
                coinValue= Integer.parseInt(wordReader.next());
                quantity = Integer.parseInt(wordReader.next());
                info.add(new InformationUser(name,surname,coin,coinValue,quantity));
                for(InformationUser str: info)
                {
                    System.out.println("Info: "+str);
                }
            }
            lineReader.close();
            wordReader.close();

            ListIterator<InformationUser> gegevens = info.listIterator();
            //ArrayList<String> gegevens=new ArrayList<>();
            //Scanner scan2 = new Scanner (new File("Accounts.txt"));
            while(gegevens.hasNext()){
                    current=gegevens.next();
                    if(inpUser.equals(current.getVoornaam()))
                    {
                        //current=gegevens.previous();
                        System.out.println("\nCurrent: "+current);
                        FileWriter writer = new FileWriter("User.txt");
                        Writer output=new BufferedWriter(writer);
                        output.write(String.valueOf(current));
                        output.close();
                    }
                    //System.out.println("Ik weet ni man: " +scan.next());
                    //System.out.println("Dit is gegevens: "+gegevens);
                    //i++;
             }

            //System.out.println("Gegevens: "+gegevens.toString());
                /*while(scan.hasNext()){
                    current = scan.next();
                    System.out.println("Curent line"+current);
                    if(inpUser.equals(current)){
                        System.out.println(current);
                        FileWriter writer = new FileWriter("User.txt");
                        Writer output=new BufferedWriter(writer);
                        output.write(String.valueOf(current));
                        output.close();

                    }
                }*/
            } else {
            System.out.print("your error message");
        }
    }

    public void checkUser(String naam)
    {
        this.nameUser=naam;



    }
}
