package SogutucuUygulamasi;

public class SogutucuKapatma implements IIslem{
    IEyleyici eyleyici;
    IEkran ekran;

    public SogutucuKapatma(IEyleyici eyleyici, IEkran ekran) {
        this.eyleyici = eyleyici;
        this.ekran = ekran;
    }

    @Override
    public void islemYap() {
        eyleyici.sogutucuKapatiliyormu();
        ekran.mesajGoruntule("Soğutucu kapatıldı.");
    }
}
