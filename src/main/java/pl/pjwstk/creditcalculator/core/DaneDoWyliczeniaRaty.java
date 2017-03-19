package pl.pjwstk.creditcalculator.core;

public class DaneDoWyliczeniaRaty {

    private final double kwotaKredytu;
    private final int iloscRat;
    private final double oprocentowanie;
    private final double oplataStala;
    private final TypRaty typRaty;

    public DaneDoWyliczeniaRaty(double kwotaKredytu, int iloscRat, double oprocentowanie, double oplataStala, TypRaty typRaty) {
        this.kwotaKredytu = kwotaKredytu;
        this.iloscRat = iloscRat;
        this.oprocentowanie = oprocentowanie;
        this.oplataStala = oplataStala;
        this.typRaty = typRaty;
    }

    public double getKwotaKredytu() {
        return kwotaKredytu;
    }

    public int getIloscRat() {
        return iloscRat;
    }

    public double getOprocentowanie() {
        return oprocentowanie;
    }

    public double getOplataStala() {
        return oplataStala;
    }

    public TypRaty getTypRaty() {
        return typRaty;
    }
}
