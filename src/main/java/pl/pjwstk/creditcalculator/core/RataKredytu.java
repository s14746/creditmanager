package pl.pjwstk.creditcalculator.core;

public class RataKredytu {

    private final int numerRaty;
    private final double kwotaKapitalu;
    private final double kwotaOdsetek;
    private final double oplatyStale;
    private final double calkowitaKwotaRaty;

    public RataKredytu(int numerRaty, double kwotaKapitalu, double kwotaOdsetek, double oplatyStale) {
        this.numerRaty = numerRaty;
        this.kwotaKapitalu = kwotaKapitalu;
        this.kwotaOdsetek = kwotaOdsetek;
        this.oplatyStale = oplatyStale;
        this.calkowitaKwotaRaty = kwotaKapitalu + kwotaOdsetek + oplatyStale;
    }

    public int getNumerRaty() {
        return numerRaty;
    }

    public double getKwotaKapitalu() {
        return kwotaKapitalu;
    }

    public double getKwotaOdsetek() {
        return kwotaOdsetek;
    }

    public double getOplatyStale() {
        return oplatyStale;
    }

    public double getCalkowitaKwotaRaty() {
        return calkowitaKwotaRaty;
    }
}
