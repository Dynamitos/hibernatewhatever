package pojo;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import loggUtility.Loggable;

@Entity
public class Buchung 
implements Loggable<Buchung>{
@Id
    @GeneratedValue
    private Integer id;
    private double betrag;
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Transient
    public final SimpleDateFormat sdfDatum = new SimpleDateFormat("dd.MM.YYYY");
    private String text;
    @ManyToOne( ) //fetch:Default ist Eager
    @JoinColumn(name = "konto_id", //name in Tabelle
                nullable = false)
    private Konto konto; //Attribut-Name

    public Buchung(double betrag, String strDatum, String text) 
    throws Exception
    {
        this.betrag = betrag;
        this.datum = sdfDatum.parse(strDatum);
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("%5d|%8.2f|%12s|%10s",
                id, betrag, getDatumAsString(), text);              
    }
    
        
    public String getDatumAsString()
    {
        return sdfDatum.format(datum);
    }
    
    //Callable Logging
    /*Design Pattern "Command Pattern" mit Loggable<T> Parameter für 
     callback-Methode eines beliebigen  Objektes (Generic Type T)*/    
    @Override
    public String loggLong() {
         return loggShort() + 
                 ", konto=" + konto.loggShort() + '}';
    }
  
    @Override
    public String loggShort() {
                 return "Buchung{" + "id=" + id + ", betrag=" + betrag +
                ", datum=" + getDatumAsString() + ", text=" + text  + '}';  
    }      
      
    public void set (String line) throws Exception{
        String[] token = line.split(":");
        if (token.length!=2)
            throw new Exception("Falsche Attribut-Anzahl");
        //Long kontoNr = Long.parseLong(token[0]);// Nicht erlaubt zu ändern!! 

        this.betrag = Double.parseDouble(token[1]);
        
        //todo.. retsliche Attribute aus line setzen!
    }    
    //POJO
    public Buchung() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }
    
}
