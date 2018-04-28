import java.io.*;
import java.util.Scanner;

public class ExistingUser {
    private int currentValue;
    private String coinName;
    private int valueCoin;
    private int quantityCoin;
    Portfolio portfolio;

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
        /*for(int i=0;i<portfolio.Account.size();i++)
        {

        }*/
        portfolio.Account.add(naamCoin);
        portfolio.Account.add(Integer.toString(value));
        portfolio.Account.add(Integer.toString(quantity));

        /*File fout = new File("Accounts.txt");
        FileOutputStream fos = new FileOutputStream(fout,true); //Append parameter, zodat oude data niet verdwijnt. Boolean argument
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));*/
        String currentUser = portfolio.Account.get(0);
        FileWriter writer = new FileWriter(currentUser + ".txt");
        BufferedWriter output = new BufferedWriter(writer);
        FileWriter writer2 = new FileWriter("User.txt");
        BufferedWriter output2 = new BufferedWriter(writer2);
        System.out.println("Size = " + portfolio.Account.size());
        for (String str : portfolio.Account) {
            output.write(str);
            output.write(" ");
            output2.write(str);
            output2.write(" ");
            /*if (j == 8) {
                output.newLine();
            }*/
        }
        output.close();
        writer.close();
        output2.close();
        writer2.close();
        /*Accounts acc=new Accounts();
        acc.updateDatabase("Mouhcine");*/
    }

    public void removeCoin() throws IOException {
        //for (String s : portfolio.Account) {
        int i = 0;
        String currentUser = Portfolio.Account.get(0);
        Scanner lineReader = new Scanner(currentUser + ".txt");
        Scanner wordReader = null;
        String currentLine;
        String word;
        System.out.println("Which coin would you like to remove?");
        Scanner reader = new Scanner(System.in);
        String coinRemover = reader.nextLine();
        int grootte=Portfolio.Account.size();
        System.out.println("Dit is de grootte: "+grootte);

        int teVerwijderen = 0;
        int grootteArrayList = portfolio.Account.size();
        for (int j = 2; j < grootteArrayList; j += 3) {
            if (portfolio.Account.get(j).contains(coinRemover)) {
                teVerwijderen = j;
            }
        }
        System.out.println("Verwijder is op "+teVerwijderen);
        for (int t = teVerwijderen+2; t >= teVerwijderen; t--) {
                    portfolio.Account.remove(t);
        }




        /*while (lineReader.hasNextLine()) {       //Checken op EOF.
            currentLine = lineReader.nextLine(); //Lezen van de volgende lijn in de textfile.
            wordReader = new Scanner(currentLine);
            while (wordReader.hasNext()) {*/
                //word = wordReader.next();
                //i = i + 1;
                /*int teVerwijderen = 0;
                int grootteArrayList = portfolio.Account.size();
                for (int j = 2; j < grootteArrayList; j += 3) {
                    if (portfolio.Account.get(j).contains(coinRemover)) {
                        teVerwijderen = j;
                    }
                }
                System.out.println("Verwijder is op "+teVerwijderen);*/
                //hier na verwijderen.
                /*for (int t = teVerwijderen; t < teVerwijderen; t++)
                    portfolio.Account.remove(t);*/
                /*
                if (portfolio.Account.get(2).contains(coinRemover)) {
                   // if (i == 3) {
                        String woord3=portfolio.Account.get(2);
                    portfolio.Account.remove(woord3);

                   // }
                   // if (i == 4) {
                        String woord4=portfolio.Account.get(3);
                    portfolio.Account.remove(woord4);

                   // }
                    //if (i == 5) {
                        String woord5=portfolio.Account.get(4);
                    portfolio.Account.remove(woord5);


                   // }
                } else if (portfolio.Account.get(5).contains(coinRemover)) {
                   // if (i == 6) {
                    String woord6=portfolio.Account.get(5);
                    portfolio.Account.remove(woord6);


                   // }
                  //  if (i == 7) {
                    String woord7=portfolio.Account.get(6);
                    portfolio.Account.remove(woord7);


                    //}
                    //if (i == 8) {
                    /*String woord8=portfolio.Account.get(7);
                    portfolio.Account.remove(woord8);

                // }
            }*/



                //i = 0;

            int size = portfolio.Account.size();
        System.out.println("Grootte arraylist is: " + size);

        //System.out.println("Dit is woord 5: " + word);
        System.out.println("Dit is accounts: " + Portfolio.Account);
        System.out.println("Dit is accountskleineP: " + portfolio.Account);
            //lineReader.close();
            //wordReader.close();
            //Pas dit aan m.b.v ListIterator
            FileWriter writer = new FileWriter(currentUser + ".txt");
            FileWriter writer2 = new FileWriter("User.txt");
            Writer output = new BufferedWriter(writer);
            Writer output2 = new BufferedWriter(writer2);
            //int size = portfolio.Account.size();
            for (int j = 0; j < size; j++) {
                output.write(portfolio.Account.get(j).toString());
                output.write(" ");
                output2.write(portfolio.Account.get(j).toString());
                output2.write(" ");
            }
            output.close();
            output2.close();


        }
    }




