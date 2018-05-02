import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InformationUser {
    public ArrayList<String> namen = new ArrayList<>();


    public InformationUser(){
        //this.namen = new ArrayList();

    }

    public void addPerson(String name){
        namen.add(name);
        try {
            FileWriter fw = new FileWriter("list.txt",true);
            Writer Output = new BufferedWriter(fw);
            Output.write(name);
            Output.write("\n");
            Output.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkName(String name){
        if (namen.contains(name)) {
            //List.txt moet gecheckt worden a hoofd.
            System.out.println("Array contains: "+name);
            return true;
        }
        else
            return false;
    }

    public void fillList(String fileName) throws IOException {
        //namen.clear();
        //File file = new File(fileName);
        BufferedReader fileIn = new BufferedReader(new FileReader(fileName));
        String line = fileIn.readLine();
        namen.add(line);
        //Scanner input = new Scanner(file);
        /*while(input.hasNextLine()){
            namen.add(input.nextLine());
        }
        input.close();*/
        for(String str: namen){
            System.out.println(str);
        }
    }
}

