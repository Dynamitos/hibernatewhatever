package resourcen;

/*
todo: Verfeinern mit Attributen bezeichnung, spaltenbreite
und Konstruktor und getter
*/
public enum KontoEnum {
    KONTO_NR, KONTOSTAND;

    public static String getSpalten(char trennzeichen) {
        StringBuilder sb = new StringBuilder();
        for (KontoEnum sp : values()) {
            sb.append(sp.toString()).append(trennzeichen);
        }
        return sb.toString();
    }
}
