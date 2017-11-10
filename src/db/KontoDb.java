package db;

import dbUtility.DBAccessBase;
import java.util.List;
import pojo.Buchung;
import pojo.Konto;

public class KontoDb {

    private DBAccessBase<Konto> kontoDbAccess;

    public KontoDb() throws Exception {
        this.kontoDbAccess = new DBAccessBase<>(Konto.class.getName(), Konto.class);
    }

    public void addTestdaten() throws Exception {
        Konto k1 = new Konto();
        Buchung b1k1 = new Buchung(-12.45, "12.05.2005", "Miete");
        Buchung b2k1 = new Buchung(1200.00, "01.06.2006", "Gehalt");

        Konto k2 = new Konto();
        Buchung b1k2 = new Buchung(10000, "24.12.2089", "Lotto");

        k1.addBuchung(b1k1);
        k1.addBuchung(b2k1);
        k2.addBuchung(b1k2);

        //Persistieren
        
        add(k1, k2);
    }

    public void add(Konto... konto) throws Exception {
        kontoDbAccess.add(konto);
    }

    public List<Konto> read() throws Exception {
        List<Konto> liste = kontoDbAccess.read();
        return liste;
    }

}
