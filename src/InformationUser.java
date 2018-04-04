public class InformationUser {
    String familienaam;
    String voornaam;
    String coin;
    int coinValue;
    int quantityCoin;

    public InformationUser(String voornaam, String familienaam, String coin, int coinValue, int quantityCoin){
        this.familienaam = familienaam;
        this.voornaam = voornaam;
        this.coin=coin;
        this.coinValue=coinValue;
        this.quantityCoin=quantityCoin;

    }

    public String toString(){
        return this.familienaam + " " + this.voornaam + " " +this.coin+ " " +this.coinValue+ " "+this.quantityCoin ;
    }

    public String getFamilienaam(){
        return this.familienaam;
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

}

