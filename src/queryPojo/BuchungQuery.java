package queryPojo;

import loggUtility.Loggable;

public class BuchungQuery
        implements Loggable<BuchungQuery> {

    private double betrag;
    private String text;

    public BuchungQuery(double betrag, String text) {
        this.betrag = betrag;
        this.text = text;
    }

    @Override
    public String toString() {
                return String.format("%8.2f|%10s",
                betrag, text);
    }

    /*Design Pattern "Command Pattern" mit Loggable<T> Parameter für 
     callback-Methode eines beliebigen  Objektes (Generic Type T)*/
    @Override
    public String loggLong() {
        return loggShort();
    }

    @Override
    public String loggShort() {
        return  "BuchungQuery{" + "betrag=" + betrag + ", text=" + text + '}';
    }
    
    public void set (String line) throws Exception{
        String[] token = line.split(":");
        if (token.length!=2)
            throw new Exception("Falsche Attribut-Anzahl");
        this.betrag = Double.parseDouble(token[0]);
        this.text = token[0];
    }
    //POJO

    public BuchungQuery() {
    }

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
