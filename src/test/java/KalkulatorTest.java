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


    @Test
    public void kwota100000IloscRat144Oprocentowanie35OplataStala0TypRatyMalejaca() throws Exception {
        // given
        Formularz formularz = new Formularz();
        formularz.kwotaKredytu = 100000;
        formularz.iloscRat = 144;
        formularz.oprocentowanie = 3.5;
        formularz.oplataStala = 0;
        formularz.typRaty = TypRaty.MALEJACA;

        // when
        List<RataKredytu> ratyKredytu = kalkulator.calculate(formularz);

        // then
        assertEquals(144, ratyKredytu.size());

        RataKredytu rataKredytu1 = ratyKredytu.get(0);
        assertEquals(rataKredytu1.numerRaty, 1);
        assertEquals(rataKredytu1.kwotaKapitalu, 694.44, 2);
        assertEquals(rataKredytu1.kwotaOdsetek, 291.67, 2);
        assertEquals(rataKredytu1.oplatyStale, 0, 2);
        assertEquals(rataKredytu1.calkowitaKwotaRaty, 986.11, 2);

        RataKredytu rataKredytu2 = ratyKredytu.get(1);
        assertEquals(rataKredytu2.numerRaty, 2);
        assertEquals(rataKredytu2.kwotaKapitalu, 694.44, 2);
        assertEquals(rataKredytu2.kwotaOdsetek, 289.64, 2);
        assertEquals(rataKredytu2.oplatyStale, 0, 2);
        assertEquals(rataKredytu2.calkowitaKwotaRaty, 984.08, 2);
    }
}