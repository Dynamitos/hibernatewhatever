
package pojo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import loggUtility.Loggable;


@Entity
public class Konto 
        implements Loggable<Konto>
{
    @Id
  @GeneratedValue
  private Long kontoNr = null;
  private double kontoStand = 0.0;
  @OneToMany(//fetch:Default ist Lazy
          mappedBy = "konto", //Attribut-Name von Klasse Buchung
            cascade = CascadeType.ALL)
  private Set<Buchung> buchungen = 
          new HashSet<>();

    /*
    für JLIst notwendig
    */
    @Override
    public String toString() {
                return String.format("%5d|%8.2f|", 
                kontoNr, kontoStand);    
    }

    public void addBuchung(Buchung b)
    {
        buchungen.add(b);
        kontoStand += b.getBetrag(); //todo
        
                // buchung mit konto verlinken, wegen Bi-direktional
        b.setKonto(this); //todo

    }
  
    //Loggable
    /*Design Pattern "Command Pattern" mit Loggable<T> Parameter für 
     callback-Methode eines beliebigen  Objektes (Generic Type T)*/     
    @Override
    public String loggLong() {
        StringBuilder sbBuchungen = new StringBuilder();
        for (Buchung buchung : buchungen) {
            sbBuchungen.append(buchung.loggShort());
        }
        return loggShort() + 
                ", buchungen=" + sbBuchungen.toString() + '}';
    }
  
    @Override
    public String loggShort() {
        return "Konto{" + "kontoNr=" + kontoNr + 
                ", kontoStand=" + kontoStand + '}';
    }  
      
    public void set (String line) throws Exception{
        String[] token = line.split(":");
        if (token.length!=2)
            throw new Exception("Falsche Attribut-Anzahl");
        //Long kontoNr = Long.parseLong(token[0]);// Nicht erlaubt zu ändern!! 

        this.kontoStand = new Scanner(token[1]).nextDouble();
    }    
  //PoJO

    public Konto() {
    }


    public long getKontoNr() {
        return kontoNr;
    }

    public void setKontoNr(long kontoNr) {
        this.kontoNr = kontoNr;
    }

    public double getKontoStand() {
        return kontoStand;
    }

    public void setKontoStand(double kontoStand) {
        this.kontoStand = kontoStand;
    }

    public Set<Buchung> getBuchungen() {
        return buchungen;
    }

    public void setBuchungen(Set<Buchung> buchungen) {
        this.buchungen = buchungen;
    }
  
}
