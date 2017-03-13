import java.util.ArrayList;
import java.util.List;

public class Kalkulator {

    public List<RataKredytu> calculate(Formularz formularz) {
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
