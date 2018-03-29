import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExistingUser{
    private int currentValue;
    private String coinName;
    Coin coin = new Coin();
    Portfolio portfolio;
    {   try {
            portfolio = new Portfolio();
        } catch (FileNotFoundException e) {
        System.out.println("File not found");
            e.printStackTrace();
        }
    }

    public void setCurrentValue()
    {
        currentValue=coin.setValueCoin();
    }
    public void NewCoin()
    {
        coinName=coin.setNameCoin();
    }

    public void removeCoin(File fileName) throws FileNotFoundException {
        for (String s : portfolio.Account ) {
            int i=0;

            Scanner lineReader = new Scanner(fileName);
            Scanner wordReader = null;
            String currentLine;
            String word;
            while (lineReader.hasNextLine()) {       //Checken op EOF.
                currentLine = lineReader.nextLine(); //Lezen van de volgende lijn in de textfile.
                wordReader = new Scanner(currentLine);
                while(wordReader.hasNext()) {
                    word = wordReader.next();
                    i = i+1;
                    if (i==3) {
                        Portfolio.Account.remove(word);
                        System.out.println("Dit is woord 3: "+word);
                        System.out.println("Dit is accounts: "+Portfolio.Account);
                    }
                    if (i==4) {
                        Portfolio.Account.remove(word);
                        System.out.println("Dit is woord 4: "+word);
                        System.out.println("Dit is accounts: "+Portfolio.Account);
                    }
                    if (i==5){
                        Portfolio.Account.remove(word);
                        System.out.println("Dit is woord 5: "+word);
                        System.out.println("Dit is accounts: "+Portfolio.Account);
                    }

                }
                i = 0;
            }
            lineReader.close();
            wordReader.close();
        }
        }

    }

