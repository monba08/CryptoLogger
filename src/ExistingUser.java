import java.io.*;
import java.util.Scanner;

public class ExistingUser {
    private int currentValue;
    private String coinName;
    private int valueCoin;
    private int quantityCoin;
    Portfolio portfolio;

    public ExistingUser()
    {
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
                    word=Integer.toString(currentValue);
                    writer.write(word);
                }
            }

        }
        lineReader.close();
        wordReader.close();
        //sc.close();
        writer.close();

    }

    public void NewCoin() throws IOException {
        Scanner reader = new Scanner(System.in);
        Coin coin = new Coin(valueCoin, quantityCoin,coinName);
        System.out.println("Which crypto-coin would you like to add? ");
        if(reader.hasNext())
            coinName=reader.next();
        coin.setNameCoin(coinName);

        System.out.println("Type in the current value of this coin: ");
        String valueString =reader.next();
        /*if(reader.hasNext())
            valueString=reader.next();*/
        valueCoin=Integer.parseInt(valueString);
        coin.setValueCoin(valueCoin);

        System.out.println("How much do you want to own from "+coinName+"?");
        String quantityString = reader.next();
        /*if(reader.hasNext())
            quantityString=reader.next();*/
        quantityCoin = Integer.parseInt(quantityString);
        coin.setQuantityCoin(quantityCoin);
        portfolio.Account.add(2,coinName);
        portfolio.Account.add(3,valueString);
        portfolio.Account.add(4,quantityString);

        /*File fout = new File("Accounts.txt");
        FileOutputStream fos = new FileOutputStream(fout,true); //Append parameter, zodat oude data niet verdwijnt. Boolean argument
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));*/
        FileWriter writer = new FileWriter("User.txt");
        BufferedWriter output = new BufferedWriter(writer);
        int j = 0;
        System.out.println("Size = " + portfolio.Account.size());
        for (String str : portfolio.Account) {
            //out.println(str);
            output.write(str);
            output.write(" ");
            j++;
            if (j == 8) {
                output.newLine();
            }
        }
        output.close();
        writer.close();
        Accounts acc=new Accounts();
        //acc.updateDatabase("Mouhcine");
    }

    public void removeCoin(File fileName) throws IOException {
        //for (String s : portfolio.Account) {
            int i = 0;

            Scanner lineReader = new Scanner(fileName);
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
                        Portfolio.Account.remove(word);

                    }
                    if (i == 4) {
                        Portfolio.Account.remove(word);

                    }
                    if (i == 5) {
                        Portfolio.Account.remove(word);

                    }
                    int size=portfolio.Account.size();
                    System.out.println("Grootte arraylist is: "+size);


                    System.out.println("Dit is woord 5: " + word);
                    System.out.println("Dit is accounts: " + Portfolio.Account);

                }

                i = 0;

            }
            //Pas dit aan m.b.v ListIterator
        FileWriter writer = new FileWriter("Accounts.txt");
        FileWriter writer2 = new FileWriter("User.txt");
        Writer output=new BufferedWriter(writer);
        Writer output2=new BufferedWriter(writer2);
        int size=portfolio.Account.size();
        for (int j=0;j<size;j++)
        {
            output.write(portfolio.Account.get(j).toString());
            output.write(" ");
            output2.write(portfolio.Account.get(j).toString());
            output2.write(" ");
        }
        output.close();
        output2.close();
       /* for(String s: portfolio.Account)
        {
            s.split(" ");
            writer.write(s);
        }*/

            lineReader.close();
            wordReader.close();
        //}
    }
}



