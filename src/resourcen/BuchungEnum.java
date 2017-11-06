
package resourcen;

/*
todo: Verfeinern mit Attributen bezeichnung, spaltenbreite
und Konstruktor und getter
*/
public enum BuchungEnum {
     ID, BETRAG, DATUM, TEXT;

    public static String getSpalten() {
        StringBuilder sb = new StringBuilder();
        for (BuchungEnum sp : values()) {
            sb.append(sp.toString()).append("|");
        }
        return sb.toString();
    }
}
