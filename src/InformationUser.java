import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InformationUser {
    public ArrayList<String> names;
    //Singleton
    public static InformationUser iUserInstance=null;

    public static InformationUser getiUserInstance() {
        if(iUserInstance == null)
            iUserInstance=new InformationUser();
        return iUserInstance;
    }


    private InformationUser(){
        this.names = new ArrayList();

    }

    public void writeToFile(String name){
        names.add(name);
        try {
            FileWriter fw = new FileWriter("list.txt",true);
            Writer Output = new BufferedWriter(fw);
            Output.write("\n"+name);
            //Output.write();
            Output.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkName(String name) throws FileNotFoundException {
        File fileList= new File("list.txt");
        Scanner scanFile = new Scanner(fileList);
        String currentLine="";
        boolean check=false;
        while(scanFile.hasNextLine()) {
            currentLine=scanFile.nextLine();
            if (currentLine.contains(name)) {
                //List.txt moet gecheckt worden a hoofd.
                System.out.println("Array contains: " + name);
                check = true;
            } else
                check = false;
        }
        scanFile.close();
        return check;
    }

    public void readFromFile(String fileName) throws IOException {
        names.clear();
        //File file = new File(fileName);
        BufferedReader fileIn = new BufferedReader(new FileReader(fileName));
        String line = fileIn.readLine();
        names.add(line);
        //Scanner input = new Scanner(file);
        /*while(input.hasNextLine()){
            names.add(input.nextLine());
        }
        input.close();*/
        fileIn.close();
        for(String str: names){
            System.out.println("Filllist: "+str);
        }
    }
}

