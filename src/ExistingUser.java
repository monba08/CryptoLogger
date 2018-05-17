import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ExistingUser {
    private int currentValue;
    private String coinName;
    private int valueCoin;
    private int quantityCoin;
    Portfolio portfolio;
    public static ArrayList<String> newCoinList = new ArrayList<>();

    public ExistingUser() {
        try {
            portfolio = new Portfolio();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    public void setCurrentValue() throws IOException {
        //currentValue = coin.setValueCoin();
        //Scanner sc = new Scanner(new File("Accounts.txt"));


        FileWriter writer = new FileWriter("Accounts.txt");
        int i = 0;
        Scanner lineReader = new Scanner("Accounts.txt");
        Scanner wordReader = null;
        String currentLine;
        String word;
        while (lineReader.hasNextLine()) {       //Checken op EOF.
            currentLine = lineReader.nextLine(); //Lezen van de volgende lijn in de textfile.
            wordReader = new Scanner(currentLine);
            while (wordReader.hasNext()) {
                word = wordReader.next();
                i = i + 1;
                if (i == 3) {
                    word = Integer.toString(currentValue);
                    writer.write(word);
                }
            }

        }
        lineReader.close();
        wordReader.close();
        //sc.close();
        writer.close();

    }

    public void newCoin(String naamCoin, int value, int quantity) throws IOException {
        //Scanner reader = new Scanner(System.in);
        Coin coin = new Coin(value,quantity,naamCoin);
        //System.out.println("Which crypto-coin would you like to add? ");
        //if (reader.hasNext())
          //  coinName = reader.next();
        coin.setNameCoin(naamCoin);

        //System.out.println("Type in the current value of this coin: ");
        //String valueString = reader.next();
        coin.setValueCoin(value);

        //System.out.println("How much do you want to own from " + coinName + "?");
        //String quantityString = reader.next();

        //quantityCoin = Integer.parseInt(quantityString);
        coin.setQuantityCoin(quantity);
        /*for(int i=0;i<portfolio.UserInfoList.size();i++)
        {

        }*/
        portfolio.UserInfoList.add(naamCoin);
        portfolio.UserInfoList.add(Integer.toString(value));
        portfolio.UserInfoList.add(Integer.toString(quantity));
        String currentUser = portfolio.UserInfoList.get(0);
        newCoinList.clear();
        Scanner scanFile = new Scanner(new File(currentUser+".txt"));
        scanFile.nextLine();

        /*while(scanFile.hasNextLine())
        {
            //String line3=scanFile.nextLine();
            //String parts3[]=line3.split(" ");
            newCoinList.add(scanFile.next());
            if(scanFile.hasNextInt())
            {
                newCoinList.add(Integer.toString(scanFile.nextInt()));
            }
            //newCoinList.add(" ");
        }
        scanFile.close();
        */


        BufferedReader fileIn3= new BufferedReader(new FileReader(currentUser+".txt"));
        fileIn3.readLine(); //Skip first line
        String line2=fileIn3.readLine(); //Get next line

        //newCoinList.clear();
        while(line2 !=null) {
            String parts2[]=line2.split(" ");
            for (int i = 0; i < parts2.length; i++) {
                        newCoinList.add(parts2[i]);
                                    }
            line2=fileIn3.readLine();

        }

        fileIn3.close();
/*
        for (int i = 0; i < newCoinList.size(); i++) {

            if (newCoinList.get(i) == portfolio.UserInfoList.get(i += 2) || newCoinList.get(i) == portfolio.UserInfoList.get(i += 3)) {
                newCoinList.set(i += 8, portfolio.UserInfoList.get(5));
            }
        }*/

        System.out.println("newCoinList: "+newCoinList);


        FileWriter writer = new FileWriter(currentUser + ".txt");
        BufferedWriter output = new BufferedWriter(writer);
        FileWriter writer2 = new FileWriter("User.txt");
        BufferedWriter output2 = new BufferedWriter(writer2);
        System.out.println("Size = " + portfolio.UserInfoList.size());
        for (String str : portfolio.UserInfoList) {
            output.write(str);
            output.write(" ");
            output2.write(str);
            output2.write(" ");

        }
        int i =0;
        output.write("\n");
        int lastObject = newCoinList.size()-1;
        for (String st : newCoinList)
        {
            if (st.contains("EndOfLine"))
            {
                if(i==lastObject)
                {
                    output.write(st);
                }
                else
                {
                    output.write(st);
                    output.write("\n");
                }
            }
            else
            {
                output.write(st);
                output.write(" ");
            }

            i++;


        }
        output.write("\n");
        output.write(naamCoin);
        output.write(" ");
        output.write(Integer.toString(value));
        output.write(" "+"EndOfLine");

        output.close();
        writer.close();
        output2.close();
        writer2.close();
        /*Accounts acc=new Accounts();
        acc.updateDatabase("Mouhcine");*/
    }

    public void removeCoin(String coin) throws IOException {
        //for (String s : portfolio.UserInfoList) {
        int i = 0;
        String currentUser = Portfolio.UserInfoList.get(0);
        Scanner lineReader = new Scanner(currentUser + ".txt");
        Scanner wordReader = null;
        String currentLine;
        String word;
        System.out.println("Which coin would you like to remove?");
        Scanner reader = new Scanner(System.in);
        String coinRemover = reader.nextLine();
        int grootte=Portfolio.UserInfoList.size();
        System.out.println("Dit is de grootte: "+grootte);

        int teVerwijderen = 0;
        int grootteArrayList = portfolio.UserInfoList.size();
        for (int j = 2; j < grootteArrayList; j += 3) {
            if (portfolio.UserInfoList.get(j).contains(coinRemover)) {
                teVerwijderen = j;
            }
        }
        System.out.println("Verwijder is op "+teVerwijderen);
        for (int t = teVerwijderen+2; t >= teVerwijderen; t--) {
                    portfolio.UserInfoList.remove(t);
        }




        /*while (lineReader.hasNextLine()) {       //Checken op EOF.
            currentLine = lineReader.nextLine(); //Lezen van de volgende lijn in de textfile.
            wordReader = new Scanner(currentLine);
            while (wordReader.hasNext()) {*/
                //word = wordReader.next();
                //i = i + 1;
                /*int teVerwijderen = 0;
                int grootteArrayList = portfolio.UserInfoList.size();
                for (int j = 2; j < grootteArrayList; j += 3) {
                    if (portfolio.UserInfoList.get(j).contains(coinRemover)) {
                        teVerwijderen = j;
                    }
                }
                System.out.println("Verwijder is op "+teVerwijderen);*/
                //hier na verwijderen.
                /*for (int t = teVerwijderen; t < teVerwijderen; t++)
                    portfolio.UserInfoList.remove(t);*/
                /*
                if (portfolio.UserInfoList.get(2).contains(coinRemover)) {
                   // if (i == 3) {
                        String woord3=portfolio.UserInfoList.get(2);
                    portfolio.UserInfoList.remove(woord3);

                   // }
                   // if (i == 4) {
                        String woord4=portfolio.UserInfoList.get(3);
                    portfolio.UserInfoList.remove(woord4);

                   // }
                    //if (i == 5) {
                        String woord5=portfolio.UserInfoList.get(4);
                    portfolio.UserInfoList.remove(woord5);


                   // }
                } else if (portfolio.UserInfoList.get(5).contains(coinRemover)) {
                   // if (i == 6) {
                    String woord6=portfolio.UserInfoList.get(5);
                    portfolio.UserInfoList.remove(woord6);


                   // }
                  //  if (i == 7) {
                    String woord7=portfolio.UserInfoList.get(6);
                    portfolio.UserInfoList.remove(woord7);


                    //}
                    //if (i == 8) {
                    /*String woord8=portfolio.UserInfoList.get(7);
                    portfolio.UserInfoList.remove(woord8);

                // }
            }*/



                //i = 0;

            int size = portfolio.UserInfoList.size();
        System.out.println("Grootte arraylist is: " + size);

        //System.out.println("Dit is woord 5: " + word);
        System.out.println("Dit is accounts: " + Portfolio.UserInfoList);
        System.out.println("Dit is accountskleineP: " + portfolio.UserInfoList);
            //lineReader.close();
            //wordReader.close();
            //Pas dit aan m.b.v ListIterator
            FileWriter writer = new FileWriter(currentUser + ".txt");
            FileWriter writer2 = new FileWriter("User.txt");
            Writer output = new BufferedWriter(writer);
            Writer output2 = new BufferedWriter(writer2);
            //int size = portfolio.UserInfoList.size();
            for (int j = 0; j < size; j++) {
                output.write(portfolio.UserInfoList.get(j).toString());
                output.write(" ");
                output2.write(portfolio.UserInfoList.get(j).toString());
                output2.write(" ");
            }
            output.close();
            output2.close();


        }
    }




