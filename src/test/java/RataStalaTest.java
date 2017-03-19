import org.junit.Test;
import pl.pjwstk.creditcalculator.core.DaneDoWyliczeniaRaty;
import pl.pjwstk.creditcalculator.core.Kalkulator;
import pl.pjwstk.creditcalculator.core.RataKredytu;
import pl.pjwstk.creditcalculator.core.TypRaty;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RataStalaTest {

    Kalkulator kalkulator = new Kalkulator();

    @Test
    public void kwota1000IloscRat10Oprocentowanie5OplataStala20TypRatyStala() throws Exception {
        // given
        DaneDoWyliczeniaRaty daneDoWyliczeniaRaty = new DaneDoWyliczeniaRaty(1000,10,5,20, TypRaty.STALA);

        // when
        List<RataKredytu> ratyKredytu = kalkulator.calculate(daneDoWyliczeniaRaty);

        // then
        assertEquals(10, ratyKredytu.size());

        RataKredytu rataKredytu1 = ratyKredytu.get(0);
        assertEquals(rataKredytu1.getNumerRaty(), 1);
        assertEquals(rataKredytu1.getKwotaKapitalu(), 100, 2);
        assertEquals(rataKredytu1.getKwotaOdsetek(), 5, 2);
        assertEquals(rataKredytu1.getOplatyStale(), 20, 2);
        assertEquals(rataKredytu1.getCalkowitaKwotaRaty(), 125, 2);

        RataKredytu rataKredytu2 = ratyKredytu.get(1);
        assertEquals(rataKredytu2.getNumerRaty(), 2);
        assertEquals(rataKredytu2.getKwotaKapitalu(), 100, 2);
        assertEquals(rataKredytu2.getKwotaOdsetek(), 5, 2);
        assertEquals(rataKredytu2.getOplatyStale(), 20, 2);
        assertEquals(rataKredytu2.getCalkowitaKwotaRaty(), 125, 2);
    }

    @Test
    public void kwota1000IloscRat10Oprocentowanie5OplataStala0TypRatyStala() throws Exception {
        // given
        DaneDoWyliczeniaRaty daneDoWyliczeniaRaty = new DaneDoWyliczeniaRaty(1000,10,5,0,TypRaty.STALA);

        // when
        List<RataKredytu> ratyKredytu = kalkulator.calculate(daneDoWyliczeniaRaty);

        // then
        assertEquals(10, ratyKredytu.size());

        RataKredytu rataKredytu1 = ratyKredytu.get(0);
        assertEquals(rataKredytu1.getNumerRaty(), 1);
        assertEquals(rataKredytu1.getKwotaKapitalu(), 100, 2);
        assertEquals(rataKredytu1.getKwotaOdsetek(), 5, 2);
        assertEquals(rataKredytu1.getOplatyStale(), 0, 2);
        assertEquals(rataKredytu1.getCalkowitaKwotaRaty(), 105, 2);

        RataKredytu rataKredytu2 = ratyKredytu.get(1);
        assertEquals(rataKredytu2.getNumerRaty(), 2);
        assertEquals(rataKredytu2.getKwotaKapitalu(), 100, 2);
        assertEquals(rataKredytu2.getKwotaOdsetek(), 5, 2);
        assertEquals(rataKredytu2.getOplatyStale(), 0, 2);
        assertEquals(rataKredytu2.getCalkowitaKwotaRaty(), 105, 2);
    }
}