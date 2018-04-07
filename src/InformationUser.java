public class InformationUser {
    String password;
    String voornaam;
    String coin;
    int coinValue;
    int quantityCoin;

    public InformationUser(/*String voornaam, String password, String coin, int coinValue, int quantityCoin*/String voornaam, String password, String coin, int coinValue, int quantityCoin){
        this.password = password;
        this.voornaam = voornaam;
        this.coin= coin;
        this.coinValue= coinValue;
        this.quantityCoin= quantityCoin;

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
}

