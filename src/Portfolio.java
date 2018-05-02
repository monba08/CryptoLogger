import java.io.*;
import java.util.ArrayList;

//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

public class Portfolio {
    public static ArrayList<String> UserInfoList = new ArrayList<>();

    public Portfolio() throws FileNotFoundException {

    }
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
        String surename = UserInfoList.get(1);
        String fullname= name+" "+surename;
        System.out.println("De volledige naam van de persoon is: "+fullname);
        //UserInfoList.clear();
        return fullname;
    }

//    public void printArrayList(){
//        for(String str: UserInfoList){
//            return str;
//        }
//    }

    public void plotGraph(){
        // Elke keer als er een nieuwe daily value is, de oude waarde wegschrijven naar de volgende lijnen.
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
            /*UserInfoList.add(parts2[0]);
            UserInfoList.add(parts2[1]);
            UserInfoList.add(parts2[2]);
            UserInfoList.add(parts2[3]);
            UserInfoList.add(parts2[4]);
            UserInfoList.add(parts2[5]);
            UserInfoList.add(parts2[6]);
            UserInfoList.add(parts2[7]);*/
        }



        System.out.println("Dit is accounts tot: " + UserInfoList);
        //fileIn3.close();


        /*Scanner lineReader = new Scanner(fileName);
        Scanner wordReader = null;
        String currentLine;
        String word;
        UserInfoList.clear();
        while (lineReader.hasNextLine()) {       //Checken op EOF.
            currentLine = lineReader.nextLine(); //Lezen van de volgende lijn in de textfile.
            wordReader = new Scanner(currentLine);
            while (wordReader.hasNext()) {
                word = wordReader.next();
                i = i + 1;
                if (i == 1) {
                    UserInfoList.add(word);
                    System.out.println("Voornaam van de persoonbruh: " + word);
                    //System.out.println("Dit is accounts: " + UserInfoList);

                }
                if (i == 2) {
                    UserInfoList.add(word);
                    System.out.println("Achternaam van de persoon: " + word);
                    //System.out.println("Dit is accounts: " + UserInfoList);
                }
                if (i == 3) {
                    UserInfoList.add(word);
                    System.out.println("Dit is woord 3: " + word);
                    //System.out.println("Dit is accounts: " + UserInfoList);
                }
                if (i == 4) {
                    UserInfoList.add(word);
                    System.out.println("Dit is woord 4: " + word);
                    //System.out.println("Dit is accounts: " + UserInfoList);
                }
                if (i == 5) {
                    UserInfoList.add(word);
                    System.out.println("Dit is woord 5: " + word);
                    System.out.println("Dit is accounts tot index 5: " + UserInfoList);
                }
                if (i == 6) {
                    UserInfoList.add(word);
                }
                if (i == 7) {
                    UserInfoList.add(word);
                }
                if (i == 8) {
                    UserInfoList.add(word);
                    System.out.println("Dit is accounts tot index 8: " + UserInfoList);
                }


            }
            i = 0;

        }
        lineReader.close();
        wordReader.close();*/


    }

    public void getWeekValues(){
    //date();
       // https://stackoverflow.com/questions/8714779/is-there-a-shortcut-for-inserting-date-time-in-intellij-idea?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
    }
}
