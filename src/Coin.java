
import java.io.*;
import java.util.ArrayList;

public class Coin {
    public String nameCoin;
    public int valueCoin;
    public int quantityCoin;
    public ArrayList<String> coinValueList = new ArrayList<>();

    private static Coin coinInstance = null;
    public static Coin getCoinInstance() {
        if(coinInstance == null)
            coinInstance=new Coin(0,0,"");
        return coinInstance;
    }

    private Coin(int valueC, int quantityC, String nameC) { //Private constructor
        this.valueCoin = valueC;
        this.quantityCoin = quantityC;
        this.nameCoin = nameC;
    }

    public void setNameCoin(String coin) {

        nameCoin = coin;

    }

    public void setValueCoin(int value) {

        valueCoin = value;

    }

    public void setQuantityCoin(int quantity) {

        quantityCoin = quantity;
    }

    public void createSecondArraylist(String filename) throws IOException {

        coinValueList.clear();
        BufferedReader fileIn4= new BufferedReader(new FileReader(filename+".txt"));
        fileIn4.readLine(); //Skip first line
        String line2=fileIn4.readLine(); //Get next line

        while(line2 !=null) {
            String parts2[]=line2.split(" ");
            for (int i = 0; i < parts2.length; i++) {
                coinValueList.add(parts2[i]);
            }
            line2=fileIn4.readLine();

        }
        fileIn4.close();
        for (String c : coinValueList)
        {
            System.out.println("Coinlist: "+c);
        }
    }
    public int setCurrentValueCoin(String coin,int newCoinValue) throws IOException {
        Portfolio portfolio = Portfolio.getPortfolioInstance();
        String userName= portfolio.UserInfoList.get(0);
        int index = 0;
        int grootteArrayList = portfolio.UserInfoList.size();
        int exists=0;
        boolean coinExists=false;
        for (int j = 2; j < grootteArrayList; j += 3) {
            if (portfolio.UserInfoList.get(j).contains(coin)) {
                index = j;
                coinExists=true;
                exists=1;
            }
            else
            {
                System.out.println("Coin doesn't exist.");
            }
        }
        if(coinExists)
        {
        String oldValue=portfolio.UserInfoList.get(index+1);
        portfolio.UserInfoList.set(index+1,Integer.toString(newCoinValue));
        System.out.println("Dit is value " +newCoinValue);

        System.out.println("Aangepaste versie ArrayList: " + portfolio.UserInfoList);

        createSecondArraylist(userName);

        for (String c : coinValueList)
        {
            System.out.println("Coinlist: "+c);
        }

        FileWriter writer = new FileWriter(userName+".txt");
        FileWriter writer2=new FileWriter("User.txt");
        BufferedWriter output = new BufferedWriter(writer);
        BufferedWriter output2 = new BufferedWriter(writer2);

        System.out.println("Size = " + portfolio.UserInfoList.size());
        for (String str : portfolio.UserInfoList) {

                output.write(str);
                output.write(" ");
                output2.write(str);
                output2.write(" ");

            }
            output.write(" \n");

        int last= coinValueList.size()+1;//coinValueList.get(Integer.toString(coinValueList.size()-1));
        System.out.println("Last number: "+last);
        boolean onThisLine=false;
        int i=0;
        for(String s: coinValueList)
        {
            if(s.contains(coin))
            {
                onThisLine=true;
                output.write(s);
                output.write(" ");

            }
            else if(!s.contains("EndOfLine")) { //Zolang je niet aan het einde van de lijn zit, write word to file.
                output.write(s);
                output.write(" ");
            }

            if(s.contains("EndOfLine") && onThisLine) //Als je nog steeds op dezelfde lijn zit en je zit aan het einde van de lijn.
            {
                output.write(Integer.toString(newCoinValue)+" EndOfLine");
                output.write("\n");
                onThisLine=false;
            }
            else if(s.contains("EndOfLine")) {
                if( i==last)
                {
                    s.replace("EndOfLine","");
                    output.write(s);
                }
                else
                {
                    s.replace("EndOfLine","");
                    output.write(s);
                    output.write("\n");
                }
                //onThisLine=false;
            }
            //System.out.println("Dit is de waarde van i ervoor:" +i);
            i++;
            //System.out.println("Dit is de waarde van i er na:" +i);

        }
            output.close();
            writer.close();
            output2.close();
            writer2.close();
        }
       return exists;
    }
}


