import java.io.*;
import java.util.ArrayList;

public class ExistingUser {
    public static ArrayList<String> newCoinList = new ArrayList<>();

    private static ExistingUser existingUserInstance = null;
    public static ExistingUser getUserInstance() {
        if(existingUserInstance == null)
            existingUserInstance=new ExistingUser();
        return existingUserInstance;
    }

    private ExistingUser() {
        /*try {
            portfolio = new Portfolio();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }*/
    }


    public void newCoin(String nameCoin, int value, int quantity) throws IOException {

        //Coin coin = new Coin(value,quantity,naamCoin);
        Coin coin = Coin.getCoinInstance();
        coin.setNameCoin(nameCoin);
        coin.setValueCoin(value);
        coin.setQuantityCoin(quantity);

        Portfolio port = Portfolio.getPortfolioInstance();
        port.UserInfoList.add(nameCoin);
        port.UserInfoList.add(Integer.toString(value));
        port.UserInfoList.add(Integer.toString(quantity));
        String currentUser = port.UserInfoList.get(0);
        newCoinList.clear();

        BufferedReader fileIn3= new BufferedReader(new FileReader(currentUser+".txt"));
        fileIn3.readLine(); //Skip first line
        String line2=fileIn3.readLine(); //Get next line

        while(line2 !=null) {
            String parts2[]=line2.split(" ");
            for (int i = 0; i < parts2.length; i++) {
                        newCoinList.add(parts2[i]);
                                    }
            line2=fileIn3.readLine();

        }
        fileIn3.close();

        System.out.println("newCoinList: "+newCoinList);


        FileWriter writer = new FileWriter(currentUser + ".txt");
        BufferedWriter output = new BufferedWriter(writer);
        FileWriter writer2 = new FileWriter("User.txt");
        BufferedWriter output2 = new BufferedWriter(writer2);
        System.out.println("Size = " + port.UserInfoList.size());
        for (String str : port.UserInfoList) {
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
        output.write(nameCoin);
        output.write(" ");
        output.write(Integer.toString(value));
        output.write(" "+"EndOfLine");

        output.close();
        writer.close();
        output2.close();
        writer2.close();
    }

    public void removeCoin(String coinRemove) throws IOException {

        Portfolio port = Portfolio.getPortfolioInstance();
        String currentUser = port.UserInfoList.get(0);

        int grootte=port.UserInfoList.size();
        System.out.println("Dit is de grootte: "+grootte);

        int teVerwijderen = 0;
        int grootteArrayList = port.UserInfoList.size();
        for (int j = 2; j < grootteArrayList; j += 3) {
            if (port.UserInfoList.get(j).contains(coinRemove)) {
                teVerwijderen = j;
            }
        }
        System.out.println("Verwijder is op "+teVerwijderen);
        for (int t = teVerwijderen+2; t >= teVerwijderen; t--) {
            port.UserInfoList.remove(t);
        }
        //coinLijst = new Coin(0,0,"");
        Coin coin = Coin.getCoinInstance();
        coin.createSecondArraylist(currentUser);
        int index = coin.coinValueList.indexOf(coinRemove)-1;

        /*for(int i=index;i<=index+7;i++)
        {
            //coinLijst.coinValueList.remove(i);
            if(coin.coinValueList.get(index)=="EndOfLine" && i<=index+7)
            {
                coin.coinValueList.remove(i);
                i=index+8; //Om uit de for-loop te gaan
            }
            else
                coin.coinValueList.remove(i);

        }*/

        int size = port.UserInfoList.size();
        System.out.println("Grootte arraylist is: " + size);

        System.out.println("Dit is accounts: " + port.UserInfoList);
        System.out.println("Dit is accountskleineP: " + port.UserInfoList);

            FileWriter writer = new FileWriter(currentUser + ".txt");
            FileWriter writer2 = new FileWriter("User.txt");
            Writer output = new BufferedWriter(writer);
            Writer output2 = new BufferedWriter(writer2);
            //int size = portfolio.UserInfoList.size();
            for (int j = 0; j < size; j++) {
                output.write(port.UserInfoList.get(j));
                output.write(" ");
                output2.write(port.UserInfoList.get(j));
                output2.write(" ");
            }
        int i =0;
        output.write("\n");
        int lastObject = coin.coinValueList.size()-1;
        for (String st : coin.coinValueList)
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
            output.close();
            output2.close();


        }
    }




