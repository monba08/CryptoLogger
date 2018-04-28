import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InformationUser {
    String password;
    String voornaam;
    String coin;
    int coinValue;
    int quantityCoin;
    public ArrayList<String> namen;


    public InformationUser(){
        this.voornaam = voornaam;
        this.namen = new ArrayList();

    }

    public String toString(){
        return this.voornaam + " " + this.password + " " +this.coin+ " " +this.coinValue+ " "+this.quantityCoin ;
    }

    public String getPassword(){
        return this.password;
    }

    public String getVoornaam(){
        return this.voornaam;
    }

    public String getCoin(){
        return this.coin;
    }

    public int getCoinValue(){
        return this.coinValue;
    }

    public int getQuantityCoin(){
        return this.quantityCoin;
    }

    public void setVoornaam(String name){
        this.voornaam=name;
    }

    public void setPass(String pass){
        this.password=pass;
    }
    public void setCoin(String coinName){
        this.coin=coinName;
    }
    public void setCoinValue(int value){
        this.coinValue=value;
    }
    public void setQuantityCoin(int quantity){
        this.quantityCoin=quantity;
    }
    public void addPerson(String name){
        namen.add(name);
    }
    public boolean checkName(String name){
        if (namen.contains(name))
            return true;
        else
            return false;
    }
    public void fillList(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner input = new Scanner(file);
        while(input.hasNextLine()){
            namen.add(input.nextLine());
        }
        input.close();
    }
    public void appendToList(String name){
       namen.add(name);
    }
}

