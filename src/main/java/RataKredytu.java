public class RataKredytu {

    int numerRaty;
    double kwotaKapitalu;
    double kwotaOdsetek;
    double oplatyStale;
    double calkowitaKwotaRaty;

    double wyliczKwoteRaty() {
        return kwotaKapitalu + kwotaOdsetek + oplatyStale;
    }

    public int getNumerRaty() {
        return numerRaty;
    }

    public void setNumerRaty(int numerRaty) {
        this.numerRaty = numerRaty;
    }

    public double getKwotaKapitalu() {
        return kwotaKapitalu;
    }

    public void setKwotaKapitalu(double kwotaKapitalu) {
        this.kwotaKapitalu = kwotaKapitalu;
    }

    public double getKwotaOdsetek() {
        return kwotaOdsetek;
    }

    public void setKwotaOdsetek(double kwotaOdsetek) {
        this.kwotaOdsetek = kwotaOdsetek;
    }

    public double getOplatyStale() {
        return oplatyStale;
    }

    public void setOplatyStale(double oplatyStale) {
        this.oplatyStale = oplatyStale;
    }

    public double getCalkowitaKwotaRaty() {
        return calkowitaKwotaRaty;
    }

    public void setCalkowitaKwotaRaty(double calkowitaKwotaRaty) {
        this.calkowitaKwotaRaty = calkowitaKwotaRaty;
    }
}
