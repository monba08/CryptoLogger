import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;


public class Accounts {

    private String coinType;
    InformationUser nameUser;
    private int valueCoin;
    private int quantityCoin;
    private int date;
    Portfolio portfolio;
    private static ArrayList<InformationUser> info = new ArrayList<>();
    public String userN;
    public static ArrayList<String> loginArray = new ArrayList<>();


    //Dit zal later geïmplementeerd worden in een GUI.
    public void createNewAccount(/*String registNaam,String registPass,String coinNaam, int valueC, int quantityCoin*/) throws IOException {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your name: ");
        //String name = registNaam;
        String name = reader.next();
        System.out.println("Enter a password: ");
        //String pass =registPass;
        String pass = reader.next();

        Coin coin = new Coin(valueCoin, quantityCoin, coinType);
        System.out.println("Which crypto-coin would you like to add? ");
        /*if(reader.hasNext())
            coinType=reader.next();*/
        coinType = reader.next();
        coin.setNameCoin(coinType);
        //coin.setNameCoin(coinNaam);

        System.out.println("Type in the current value of this coin: ");
        String valueString = reader.next();
        ;
        /*if(reader.hasNext())
            valueString=reader.next();*/
        valueCoin = Integer.parseInt(valueString);
        coin.setValueCoin(valueCoin);

        System.out.println("How much do you want to own from " + coinType + "?");
        String quantityString = reader.next();
        /*if(reader.hasNext())
            quantityString=reader.next();*/
        quantityCoin = Integer.parseInt(quantityString);
        coin.setQuantityCoin(quantityCoin);


        //Parameters die we zullen doorgeven.
        //nameUser = name;
        /*coinType=coin.setNameCoin();
        valueCoin=coin.setValueCoin();
        quantityCoin=coin.setQuantityCoin();*/
        /*reader.nextLine();
        reader.close();*/
        String userFile = name + ".txt";
        File fout = new File(userFile);
        FileOutputStream fos = new FileOutputStream(fout, true); //Append parameter, zodat oude data niet verdwijnt. Boolean argument
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        bw.write(name);
        bw.write(" ");
        bw.write(pass);
        bw.write(" ");
        bw.write(coinType);
        bw.write(" ");
        bw.write(valueString);
        bw.write(" ");
        bw.write(quantityString);
        bw.newLine();
        bw.close();
        fos.close();
    }

    public void updateDatabase(String Username, String NewValue) throws IOException {
        String line;
        String userFile = Username + ".txt";
        BufferedReader file = new BufferedReader(new FileReader(userFile));//User.txt
        StringBuffer inputBuffer = new StringBuffer();

        while ((line = file.readLine()) != null) {
            inputBuffer.append(line);
            System.out.println("Dit is line: " + line);
            inputBuffer.append('\n');
        }
        String inputStr = inputBuffer.toString();
        System.out.println("Dit is INPUTSTR: " + inputStr);
        file.close();

        BufferedReader file2 = new BufferedReader(new FileReader("Accounts.txt"));
        StringBuffer inputBuffer2 = new StringBuffer();
        String line2;
        while ((line2 = file2.readLine()) != null) {
            inputBuffer2.append(line2);
            System.out.println("Dit is line: " + line2);
            inputBuffer2.append('\n');
        }
        String inputStr2 = inputBuffer2.toString();
        System.out.println("Dit is INPUTSTR2Man: " + inputStr2);
        file2.close();

        String currentLine2;
        Scanner wordReader = null;
        String word;
        Scanner lineReader = new Scanner("Accounts.txt");
        while (lineReader.hasNextLine()) {       //Checken op EOF.
            currentLine2 = lineReader.nextLine();
            wordReader = new Scanner(currentLine2);
            while (wordReader.hasNext()) {
                word = wordReader.next();
                if (word.contains(Username)) {
                    System.out.println("I'm here");
                    System.out.println("Dit is currentLine2: " + currentLine2);
                    inputStr2.replaceAll(currentLine2, inputStr);
                }
            }
        }
        lineReader.close();
        wordReader.close();
        System.out.println("InputSTR2MetReplacement: " + inputStr2);

        System.out.println("----------------------------------\n" + inputStr2);
        FileOutputStream fileOut = new FileOutputStream("Accounts.txt");
        fileOut.write(inputStr2.getBytes());
        fileOut.close();


    }

    public void logIn(String gebruiker, String wachtwoord) throws IOException {
        boolean login = false;

       /* Scanner keyboard = new Scanner(System.in);
        // looks at selected file in scan

        System.out.println("Type in your username:");
        inpUser = keyboard.nextLine();
        System.out.println("Type in your password:");
        String inpPass = keyboard.nextLine(); // gets input from user.*/

        String userFile1 = gebruiker + ".txt";
        //System.out.println(userFile1);

        BufferedReader fileIn = new BufferedReader(new FileReader(userFile1));
        String line = fileIn.readLine();
        String parts[] = line.split(" ");
        String user = parts[0];
        int gr = parts.length;
        System.out.println("Grootte is: " + gr);
        if (gebruiker.equals(user)) {
            String pass = parts[1];
            if (wachtwoord.equals(pass)) {
                login = true;
            }

        }
        //scan2.close();
        //keyboard.close();
        if (login) {
            System.out.print("Wilkommen\n");

            if (parts.length==2 && !(parts.length>=5))
            {
                loginArray.add(parts[0]);
                loginArray.add(parts[1]);
            }else if(parts.length==5){
                loginArray.add(parts[0]);
                loginArray.add(parts[1]);
                loginArray.add(parts[2]);
                loginArray.add(parts[3]);
                loginArray.add(parts[4]);
            }
            else if (parts.length >= 8) {
                for(int j=0;j<parts.length;j++) {
                    loginArray.add(parts[j]);
                    //loginArray.add(parts[j+1]);
                    //loginArray.add(parts[j+2]);
                }
            }

            /*
            InformationUser current;
            String currentLine;
            String name;
            String password;
            String coin;
            String coinValue;
            String quantity;
            String secondCoin;
            String secondCoinValue;
            String secondQuantity;
            Scanner lineReader=null;
            Scanner wordReader=null;
            File inputFile=new File(userFile1);
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
                    password = wordReader.next();
                    coin = wordReader.next();
                    coinValue= wordReader.next();
                    quantity = wordReader.next();
                    secondCoin=wordReader.next();
                    secondCoinValue= wordReader.next();
                    secondQuantity = wordReader.next();
                    //info.add(new InformationUser(name,password,coin,coinValue,quantity,secondCoin,secondCoinValue,secondQuantity));
                    loginArray.add(name);
                    loginArray.add(password);
                    loginArray.add(coin);
                    loginArray.add(coinValue);
                    loginArray.add(quantity);

                    if(!wordReader.next().isEmpty())
                    {
                        System.out.println("Het is niet leeg");
                        coin = wordReader.next();
                        secondCoinValue= wordReader.next();
                        secondQuantity = wordReader.next();
                        loginArray.add(coin);
                        loginArray.add(secondCoinValue);
                        loginArray.add(secondQuantity);
                    }

                //info.add(new InformationUser(user.getVoornaam(),user.getPassword(),user.getCoin(),user.getCoinValue(),user.getQuantityCoin()));
*/
            for (String st : loginArray) {
                System.out.println("LoginArray: " + st);
            }
                /*for(InformationUser str: info)
                {
                    System.out.println("\nInfo: "+str);
                }*/

            /*nameUser=info.get(0);
            userN=nameUser.getVoornaam();
            System.out.println("DIt is nameUser: "+userN);*/
            //lineReader.close();
            //wordReader.close();

            //ListIterator<InformationUser> gegevens = info.listIterator();
            ListIterator<String> gegevens = loginArray.listIterator();
            String current2;
            String currentUser=loginArray.get(0);
            System.out.println("Currentuser:"+currentUser);
            //String gegevensCurrent=gegevens.next();
            //System.out.println("gegevensCurrent: "+gegevensCurrent);
            //if (gebruiker.equals(currentUser))//gebruiker.equals(current2.getVoornaam())
            FileWriter writer = new FileWriter("User.txt");
            Writer output = new BufferedWriter(writer);
                //{
                    while (gegevens.hasNext()) {
                        current2 = gegevens.next();
                    System.out.println("\nCurrent: " + current2);
                    output.write(String.valueOf(current2));
                    output.write(" ");

              //  }
            }
            output.close();
        }
     else
        {
            //scan2.nextLine();
            System.out.print("User doesn't exist");
        }

    }
    public String checkUser()
    {
        System.out.println("Dit is de user: "+userN);
        return userN;
    }
}
