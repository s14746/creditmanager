import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class KalkulatorTest {

    Kalkulator kalkulator = new Kalkulator();

    @Test
    public void kwota1000IloscRat10Oprocentowanie5OplataStala20TypRatyStala() throws Exception {
        // given
        Formularz formularz = new Formularz();
        formularz.kwotaKredytu = 1000;
        formularz.iloscRat = 10;
        formularz.oprocentowanie = 5;
        formularz.oplataStala = 20;
        formularz.typRaty = TypRaty.STALA;

        // when
        List<RataKredytu> ratyKredytu = kalkulator.calculate(formularz);

        // then
        assertEquals(10, ratyKredytu.size());

        RataKredytu rataKredytu1 = ratyKredytu.get(0);
        assertEquals(rataKredytu1.numerRaty, 1);
        assertEquals(rataKredytu1.kwotaKapitalu, 100, 2);
        assertEquals(rataKredytu1.kwotaOdsetek, 5, 2);
        assertEquals(rataKredytu1.oplatyStale, 20, 2);
        assertEquals(rataKredytu1.calkowitaKwotaRaty, 125, 2);
    }
}