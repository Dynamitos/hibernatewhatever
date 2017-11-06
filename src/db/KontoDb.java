package db;

import dbUtility.DbAccessBase;
import java.util.List;
import pojo.Buchung;
import pojo.Konto;

public class KontoDb {

    private DbAccessBase<Konto> kontoDbAccess;
    
    public KontoDb() throws Exception {
        this.kontoDbAccess = new DbAccessBase<>(Konto.class.getName(), Konto.class);
    }
    
    public void addTestdaten() throws Exception {
        Konto k1 = new Konto();
        Buchung b1k1 = new Buchung(-120, "12.10.2017", "Miete");
        Buchung b2k1 = new Buchung(1200, "01.02.2016", "Gehalt");
        
        Konto k2 = new Konto();
        Buchung b1k2 = new Buchung(1000, "24.12.2016", "Lotto");
        
        //Verlinken
        k1.addBuchung(b1k1);
        k1.addBuchung(b2k1);
        
        k2.addBuchung(b1k2);
        
        //Persistieren
        add(k1, k2);
    }
    
    public void add(Konto... konten) throws Exception {
        kontoDbAccess.add(konten);
    }
    
    public List<Konto> read() throws Exception {
        return kontoDbAccess.read();
    }
    
}
