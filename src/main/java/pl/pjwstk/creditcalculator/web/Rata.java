package pl.pjwstk.creditcalculator.web;

import pl.pjwstk.creditcalculator.core.RataKredytu;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Rata {
    private static final NumberFormat formatter = new DecimalFormat("#0.00");

    private final String numerRaty;
    private final String kwotaKapitalu;
    private final String kwotaOdsetek;
    private final String oplatyStale;
    private final String calkowitaKwotaRaty;

    public Rata(RataKredytu rataKredytu) {
        numerRaty = String.valueOf(rataKredytu.getNumerRaty());
        kwotaKapitalu = formatter.format(rataKredytu.getKwotaKapitalu());
        kwotaOdsetek = formatter.format(rataKredytu.getKwotaOdsetek());
        oplatyStale = formatter.format(rataKredytu.getOplatyStale());
        calkowitaKwotaRaty = formatter.format(rataKredytu.getCalkowitaKwotaRaty());
    }

    public String getNumerRaty() {
        return numerRaty;
    }

    public String getKwotaKapitalu() {
        return kwotaKapitalu;
    }

    public String getKwotaOdsetek() {
        return kwotaOdsetek;
    }

    public String getOplatyStale() {
        return oplatyStale;
    }

    public String getCalkowitaKwotaRaty() {
        return calkowitaKwotaRaty;
    }
}
