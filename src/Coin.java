
import java.io.*;

public class Coin {
    private String nameCoin;
    Portfolio portfolio;
    private int valueCoin;   //Waarschijnlijk overbodig
    private int quantityCoin;//Waarschijnlijk overbodig
   // private int currentValue;//Waarschijnlijk overbodig
    private int newValueCoin;//Waarschijnlijk overbodig

    public Coin(int valueC, int quantityC, String nameC) {
        valueCoin = valueC;
        quantityCoin = quantityC;
        nameCoin = nameC;
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

    public void setCurrentValueCoin(String name,int newCoinValue) throws IOException {
        String userName=portfolio.UserInfoList.get(0);
        int index = 0;
        int grootteArrayList = portfolio.UserInfoList.size();
        for (int j = 2; j < grootteArrayList; j += 3) {
            if (portfolio.UserInfoList.get(j).contains(name)) {
                index = j;
            }
        }
        portfolio.UserInfoList.set(index+1,Integer.toString(newCoinValue));
        System.out.println("Dit is value " +newCoinValue);

        System.out.println("Aangepaste versie ArrayList: " + portfolio.UserInfoList);

        FileWriter writer = new FileWriter(userName+".txt");
        FileWriter writer2=new FileWriter("User.txt");
        BufferedWriter output = new BufferedWriter(writer);
        BufferedWriter output2 = new BufferedWriter(writer2);
        int j = 0;
        System.out.println("Size = " + portfolio.UserInfoList.size());
        for (String str : portfolio.UserInfoList) {
                //out.println(str);
                output.write(str);
                output.write(" ");
                output2.write(str);
                output2.write(" ");
                j++;
            }
        output.close();
        writer.close();
        output2.close();
        writer2.close();

    }
}


