
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

        nameCoin = coin; //Waarschijnlijk overbodig

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
    public void setCurrentValueCoin(String coin,int newCoinValue) throws IOException {
        Portfolio portfolio = Portfolio.getPortfolioInstance();
        String userName= portfolio.UserInfoList.get(0);
        int index = 0;
        int grootteArrayList = portfolio.UserInfoList.size();
        for (int j = 2; j < grootteArrayList; j += 3) {
            if (portfolio.UserInfoList.get(j).contains(coin)) {
                index = j;
            }
            else
            {
                System.out.println("Coin doesn't exist.");
            }
        }
        String oldValue=portfolio.UserInfoList.get(index+1);
        portfolio.UserInfoList.set(index+1,Integer.toString(newCoinValue));
        System.out.println("Dit is value " +newCoinValue);

        System.out.println("Aangepaste versie ArrayList: " + portfolio.UserInfoList);
        //Read old value of the coin and store it in an arraylist
        /*BufferedReader fileIn3= new BufferedReader(new FileReader(userName+".txt"));
        fileIn3.readLine(); //Skip first line*/
         //Get next line

        /*
        Scanner scanFile = new Scanner(new File(userName+".txt"));
        String line2= "";
        boolean lastEmptyLine=false;
        while(scanFile.hasNextLine() && !lastEmptyLine)
        {
            line2= scanFile.nextLine();
            if(!line2.isEmpty())
            {
                coinValueList.add(scanFile.next());
                if(scanFile.hasNextInt())
                {
                    coinValueList.add(Integer.toString(scanFile.nextInt()));
                }
            }
            else {
                lastEmptyLine = true;
            }


        }
        scanFile.close();*/
        createSecondArraylist(userName);



       /*
        boolean coinOnLine=false;
        while(!coinOnLine) {
            line2=fileIn3.readLine();
            if (line2.contains(coin)) {
                String parts2[]=line2.split(" ");
                for (int i = 0; i < parts2.length; i++) {
                    if (parts2.length >= 2) {
                        coinValueList.add(parts2[i]);
                    }
                }
                coinOnLine=true;
            } else {
                coinOnLine=false;
            }
        }
*/
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

        /*for(int i=0;i<coinValueList.size();i++)
        {
            if(coinValueList.get(i)=="EndOfLine")
            {
                output.newLine();
            }
            output.write(coinValueList.get(i));
            output.write(" ");


        }*/

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
            System.out.println("Dit is de waarde van i ervoor:" +i);
            i++;
            System.out.println("Dit is de waarde van i er na:" +i);

        }
            /*for(String s: coinValueList)
            {
                if(s.contains(coin))
                {
                    onThisLine=true;
                    output.write(s+" ");

                }
                else if(!s.contains(coin) && !s.contains("EndOfLine"))
                    output.write(s+" ");
                if(s.contains("EndOfLine") && onThisLine)
                {
                    if(i==last)
                    {
                        //output.write(s);
                        output.write(Integer.toString(newCoinValue)+" EndOfLine");
                        onThisLine=false;
                    }
                    else
                    {
                        output.write(s+"\n");
                    }

                }
                else if(s.contains("EndOfLine"))
                {
                    if(i==last)
                    {
                        //s.replace("EndOfLine","");
                        output.write(s);
                    }
                    else
                    {
                        //s.replace("EndOfLine","");
                        output.write(s+"\n");
                    }

                }

                System.out.println("Dit is de waarde van i ervoor:" +i);
            i++;
                System.out.println("Dit is de waarde van i er na:" +i);

            }*/

            /*output.write(" \n");
            output.write(coin);
            output.write(" ");
            output.write(oldValue);*/
            output.close();
            writer.close();
            output2.close();
            writer2.close();





    }
}


