package pl.pjwstk.creditcalculator.core;

import java.util.ArrayList;
import java.util.List;

public class Kalkulator {

    public List<RataKredytu> calculate(Formularz formularz) {
        if (formularz.getTypRaty() == TypRaty.STALA) {
            return wyliczRatyStale(formularz);
        }
        return wyliczRatyMalejace(formularz);
    }

    private List<RataKredytu> wyliczRatyMalejace(Formularz formularz) {
        List<RataKredytu> rataKredytuList = new ArrayList<>();
        double poprzedniaKwotaKapitalowa = 0;

        for (int i = 1; i <= formularz.getIloscRat(); i++) {
            double kwotaKapitalu = formularz.getKwotaKredytu() / formularz.getIloscRat();
            double kwotaOdsetek = (formularz.getKwotaKredytu() - poprzedniaKwotaKapitalowa) * ((formularz.getOprocentowanie() / 100) / (formularz.getIloscRat() / 12));

            poprzedniaKwotaKapitalowa = poprzedniaKwotaKapitalowa + kwotaKapitalu;

            RataKredytu rataKredytu = new RataKredytu(i, kwotaKapitalu, kwotaOdsetek,
                    formularz.getOplataStala());

            rataKredytuList.add(rataKredytu);
        }
        return rataKredytuList;
    }

    private List<RataKredytu> wyliczRatyStale(Formularz formularz) {
        List<RataKredytu> rataKredytuList = new ArrayList<>();

        for (int i = 1; i <= formularz.getIloscRat(); i++) {
            double kwotaKapitalu = formularz.getKwotaKredytu() / formularz.getIloscRat();
            double kwotaOdsetek = kwotaKapitalu * (formularz.getOprocentowanie() / 100);

            RataKredytu rataKredytu = new RataKredytu(i, kwotaKapitalu, kwotaOdsetek,
                    formularz.getOplataStala());
            
            rataKredytuList.add(rataKredytu);
        }
        return rataKredytuList;
    }
}
