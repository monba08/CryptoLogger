public class InformationUser {
    String password;
    String voornaam;
    String coin;
    int coinValue;
    int quantityCoin;
    String coin2;
    int coinValue2;
    int quantityCoin2;

    public InformationUser(String voornaam, String password, String coin, int coinValue, int quantityCoin,String coin2, int coinValue2, int quantityCoin2){
        this.password = password;
        this.voornaam = voornaam;
        this.coin= coin;
        this.coinValue= coinValue;
        this.quantityCoin= quantityCoin;
        this.coin2= coin2;
        this.coinValue2= coinValue2;
        this.quantityCoin2= quantityCoin2;

    }

    public String toString(){
        return this.voornaam + " " + this.password + " " +this.coin+ " " +this.coinValue+ " "+this.quantityCoin+" " +this.coin2+ " " +this.coinValue2+ " "+this.quantityCoin2 ;
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

