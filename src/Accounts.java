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
    public void createNewAccount(String registNaam,String registPass,String coinNaam, int valueC, int quantityCoin) throws IOException {
        String name = registNaam;
        String pass =registPass;

        Coin coin = new Coin(valueCoin, quantityCoin, coinType);

        coin.setNameCoin(coinNaam);

        valueCoin = valueC;


        coin.setQuantityCoin(quantityCoin);

        String userFile = name + ".txt";
        File fout = new File(userFile);
        FileOutputStream fos = new FileOutputStream(fout, true); //Append parameter, zodat oude data niet verdwijnt. Boolean argument
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        bw.write(name);
        bw.write(" ");
        bw.write(pass);
        bw.write(" ");
        bw.write(coinNaam);
        bw.write(" ");
        bw.write(Integer.toString(valueC));
        bw.write(" ");
        bw.write(Integer.toString(quantityCoin));

        //Hiermee zullen de daily values van een coin worden weggeschreven.
        bw.write(coinNaam);
        bw.write(" ");
        bw.write(Integer.toString(valueC));
        bw.close();
        fos.close();
    }



    public boolean logIn(String gebruiker, String wachtwoord) throws IOException {
        boolean login = false;
        String userFile1 = gebruiker + ".txt";

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


            for (String st : loginArray) {
                System.out.println("LoginArray: " + st);
            }

            ListIterator<String> gegevens = loginArray.listIterator();
            String current2;
            String currentUser=loginArray.get(0);
            System.out.println("Currentuser:"+currentUser);
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
            return true;
        }
     else
        {
            //scan2.nextLine();
            System.out.print("User doesn't exist");
            return false;
        }

    }
    public String checkUser()
    {
        System.out.println("Dit is de user: "+userN);
        return userN;
    }
}
