import org.junit.Test;
import pl.pjwstk.creditcalculator.core.Formularz;
import pl.pjwstk.creditcalculator.core.Kalkulator;
import pl.pjwstk.creditcalculator.core.RataKredytu;
import pl.pjwstk.creditcalculator.core.TypRaty;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RataMalejacaTest {

    Kalkulator kalkulator = new Kalkulator();

    @Test
    public void kwota100000IloscRat144Oprocentowanie35OplataStala0TypRatyMalejaca() throws Exception {
        // given
        Formularz formularz = new Formularz(100000,144,3.5,0,TypRaty.MALEJACA);

        // when
        List<RataKredytu> ratyKredytu = kalkulator.calculate(formularz);

        // then
        assertEquals(144, ratyKredytu.size());

        RataKredytu rataKredytu1 = ratyKredytu.get(0);
        assertEquals(rataKredytu1.getNumerRaty(), 1);
        assertEquals(694.44, rataKredytu1.getKwotaKapitalu(), 2);
        assertEquals(rataKredytu1.getKwotaOdsetek(), 291.67, 2);
        assertEquals(rataKredytu1.getOplatyStale(), 0, 2);
        assertEquals(rataKredytu1.getCalkowitaKwotaRaty(), 986.11, 2);

        RataKredytu rataKredytu2 = ratyKredytu.get(1);
        assertEquals(rataKredytu2.getNumerRaty(), 2);
        assertEquals(rataKredytu2.getKwotaKapitalu(), 694.44, 2);
        assertEquals(rataKredytu2.getKwotaOdsetek(), 289.64, 2);
        assertEquals(rataKredytu2.getOplatyStale(), 0, 2);
        assertEquals(rataKredytu2.getCalkowitaKwotaRaty(), 984.08, 2);

        RataKredytu rataKredytu3 = ratyKredytu.get(2);
        assertEquals(rataKredytu3.getNumerRaty(), 3);
        assertEquals(rataKredytu3.getKwotaKapitalu(), 694.44, 2);
        assertEquals(rataKredytu3.getKwotaOdsetek(), 287.62, 2);
        assertEquals(rataKredytu3.getOplatyStale(), 0, 2);
        assertEquals(rataKredytu3.getCalkowitaKwotaRaty(), 982.06, 2);
    }

    @Test
    public void kwota100000IloscRat144Oprocentowanie35OplataStala150TypRatyMalejaca() throws Exception {
        // given
        Formularz formularz = new Formularz(100000,144,3.5,150, TypRaty.MALEJACA);

        // when
        List<RataKredytu> ratyKredytu = kalkulator.calculate(formularz);

        // then
        assertEquals(144, ratyKredytu.size());

        RataKredytu rataKredytu1 = ratyKredytu.get(0);
        assertEquals(rataKredytu1.getNumerRaty(), 1);
        assertEquals(rataKredytu1.getKwotaKapitalu(), 694.44, 2);
        assertEquals(rataKredytu1.getKwotaOdsetek(), 291.67, 2);
        assertEquals(rataKredytu1.getOplatyStale(), 150, 2);
        assertEquals(rataKredytu1.getCalkowitaKwotaRaty(), 1136.11, 2);

        RataKredytu rataKredytu2 = ratyKredytu.get(1);
        assertEquals(rataKredytu2.getNumerRaty(), 2);
        assertEquals(rataKredytu2.getKwotaKapitalu(), 694.44, 2);
        assertEquals(rataKredytu2.getKwotaOdsetek(), 289.64, 2);
        assertEquals(rataKredytu2.getOplatyStale(), 150, 2);
        assertEquals(rataKredytu2.getCalkowitaKwotaRaty(), 1134.08, 2);

        RataKredytu rataKredytu3 = ratyKredytu.get(2);
        assertEquals(rataKredytu3.getNumerRaty(), 3);
        assertEquals(694.44, rataKredytu3.getKwotaKapitalu(), 2);
        assertEquals(rataKredytu3.getKwotaOdsetek(), 287.62, 2);
        assertEquals(rataKredytu3.getOplatyStale(), 150, 2);
        assertEquals(rataKredytu3.getCalkowitaKwotaRaty(), 1132.06, 2);
    }
}
