package pl.pjwstk.creditcalculator.core;

import java.util.ArrayList;
import java.util.List;

public class Kalkulator {

    public List<RataKredytu> calculate(DaneDoWyliczeniaRaty daneDoWyliczeniaRaty) {
        if (daneDoWyliczeniaRaty.getTypRaty() == TypRaty.STALA) {
            return wyliczRatyStale(daneDoWyliczeniaRaty);
        }
        return wyliczRatyMalejace(daneDoWyliczeniaRaty);
    }

    private List<RataKredytu> wyliczRatyMalejace(DaneDoWyliczeniaRaty daneDoWyliczeniaRaty) {
        List<RataKredytu> rataKredytuList = new ArrayList<>();
        double poprzedniaKwotaKapitalowa = 0;

        for (int i = 1; i <= daneDoWyliczeniaRaty.getIloscRat(); i++) {
            double kwotaKapitalu = daneDoWyliczeniaRaty.getKwotaKredytu() / daneDoWyliczeniaRaty.getIloscRat();
            double kwotaOdsetek = (daneDoWyliczeniaRaty.getKwotaKredytu() - poprzedniaKwotaKapitalowa) * ((daneDoWyliczeniaRaty.getOprocentowanie() / 100) / (daneDoWyliczeniaRaty.getIloscRat() / 12));

            poprzedniaKwotaKapitalowa = poprzedniaKwotaKapitalowa + kwotaKapitalu;

            RataKredytu rataKredytu = new RataKredytu(i, kwotaKapitalu, kwotaOdsetek,
                    daneDoWyliczeniaRaty.getOplataStala());

            rataKredytuList.add(rataKredytu);
        }
        return rataKredytuList;
    }

    private List<RataKredytu> wyliczRatyStale(DaneDoWyliczeniaRaty daneDoWyliczeniaRaty) {
        List<RataKredytu> rataKredytuList = new ArrayList<>();

        for (int i = 1; i <= daneDoWyliczeniaRaty.getIloscRat(); i++) {
            double kwotaKapitalu = daneDoWyliczeniaRaty.getKwotaKredytu() / daneDoWyliczeniaRaty.getIloscRat();
            double kwotaOdsetek = kwotaKapitalu * (daneDoWyliczeniaRaty.getOprocentowanie() / 100);

            RataKredytu rataKredytu = new RataKredytu(i, kwotaKapitalu, kwotaOdsetek,
                    daneDoWyliczeniaRaty.getOplataStala());
            
            rataKredytuList.add(rataKredytu);
        }
        return rataKredytuList;
    }
}
