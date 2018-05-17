import javax.sound.sampled.Port;
import java.io.*;
import java.util.ArrayList;

//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

public class Portfolio {
    public  ArrayList<String> UserInfoList =new ArrayList<>();
    private static Portfolio portfolioInstance = null;

    public static Portfolio getPortfolioInstance(){
        if(portfolioInstance == null)
            portfolioInstance=new Portfolio();
        return portfolioInstance;
    }

    private Portfolio(){}

    public String getQuantityCoin(){

        return UserInfoList.get(4);
    }
    public String getCoinName()
    {
        String coinName= UserInfoList.get(2);
        return coinName;
    }

    public String getCoinValue()
    {
        String coinValue = UserInfoList.get(3);
        return coinValue;
    }

    public String getName()
    {
        String name = UserInfoList.get(0);
        System.out.println("De  naam van de persoon is: "+name);
        return name;
    }

    public void readFromFile() throws IOException {
        //File inputFile = new File("Accounts.txt");
        UserInfoList.clear();
        BufferedReader fileIn2 = new BufferedReader(new FileReader("User.txt"));
        String line=fileIn2.readLine();
        String parts[]=line.split(" ");
        String fileName = parts[0]+".txt";
        fileIn2.close();

        System.out.println("Dit is de naam: "+fileName);
        BufferedReader fileIn3= new BufferedReader(new FileReader(fileName));
        String line2=fileIn3.readLine();
        String parts2[]=line2.split(" ");
        fileIn3.close();

        int lengte=parts.length;
        System.out.println("Dit is de lengte: "+lengte);
        if(parts2.length==2 && !(parts.length>=5))
        {
            UserInfoList.add(parts2[0]);
            UserInfoList.add(parts2[1]);
        }
        else if(parts2.length == 5)
        {
            UserInfoList.add(parts2[0]);
            UserInfoList.add(parts2[1]);
            UserInfoList.add(parts2[2]);
            UserInfoList.add(parts2[3]);
            UserInfoList.add(parts2[4]);
        }
        else if(parts2.length>=8) //Hier misschien nog zien of we meer dan twee coins zullen toevoegen
        {
            System.out.println("We zitten hier");
            for (int j=0;j<lengte;j++)
            {
                UserInfoList.add(parts2[j]);
            }
        }

        System.out.println("Dit is accounts tot: " + UserInfoList);



    }
    public int calculateTotalValue()
    {
        int totalValue=0;
        for(int i=3;i<UserInfoList.size();i+=3)
        {
            totalValue=totalValue + (Integer.parseInt(UserInfoList.get(i))*Integer.parseInt(UserInfoList.get(i+1)));
        }
        System.out.println("De totale waarde van de portfolio is: "+totalValue);
        return totalValue;
    }

    public void getWeekValues(){
    //date();
       // https://stackoverflow.com/questions/8714779/is-there-a-shortcut-for-inserting-date-time-in-intellij-idea?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
    }
}
