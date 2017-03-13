public class RataKredytu {

    int numerRaty;
    double kwotaKapitalu;
    double kwotaOdsetek;
    double oplatyStale;
    double calkowitaKwotaRaty;

    double wyliczKwoteRaty() {
        return kwotaKapitalu + kwotaOdsetek + oplatyStale;
    }
}
