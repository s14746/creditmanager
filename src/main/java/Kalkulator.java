import java.util.ArrayList;
import java.util.List;

public class Kalkulator {

    public List<RataKredytu> calculate(Formularz formularz) {
        if (formularz.typRaty == TypRaty.STALA) {
            return wyliczRatyStale(formularz);
        }

        return wyliczRatyMalejace(formularz);
    }

    private List<RataKredytu> wyliczRatyMalejace(Formularz formularz) {
        List<RataKredytu> rataKredytuList = new ArrayList<>();

        double poprzeniaKwotaKapitalowa = 0;

        for (int i = 1; i <= formularz.iloscRat; i++) {
            double kwotaKapitalowa = formularz.kwotaKredytu / formularz.iloscRat;
            double kwotaOdsetkowa = (formularz.kwotaKredytu - poprzeniaKwotaKapitalowa) * ((formularz.oprocentowanie / 100) / (formularz.iloscRat / 12));
            double rata = kwotaKapitalowa + kwotaOdsetkowa;

            poprzeniaKwotaKapitalowa = kwotaKapitalowa;

            RataKredytu rataKredytu = new RataKredytu();
            rataKredytu.numerRaty = i;
            rataKredytu.kwotaKapitalu = kwotaKapitalowa;
            rataKredytu.kwotaOdsetek = kwotaOdsetkowa;
            rataKredytu.oplatyStale = formularz.oplataStala;
            rataKredytu.calkowitaKwotaRaty = rata;
            rataKredytuList.add(rataKredytu);
        }

        return rataKredytuList;
    }

    private List<RataKredytu> wyliczRatyStale(Formularz formularz) {
        List<RataKredytu> rataKredytuList = new ArrayList<RataKredytu>();

        for (int i = 1; i <= formularz.iloscRat; i++) {
            RataKredytu rataKredytu = new RataKredytu();
            rataKredytu.numerRaty = i;
            rataKredytu.kwotaKapitalu = formularz.kwotaKredytu / formularz.iloscRat;
            rataKredytu.kwotaOdsetek = rataKredytu.kwotaKapitalu * (formularz.oprocentowanie / 100);
            rataKredytu.oplatyStale = formularz.oplataStala;
            rataKredytu.calkowitaKwotaRaty = rataKredytu.wyliczKwoteRaty();
            rataKredytuList.add(rataKredytu);
        }

        return rataKredytuList;
    }
}
