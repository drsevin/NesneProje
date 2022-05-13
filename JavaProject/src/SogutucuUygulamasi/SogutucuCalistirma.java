package SogutucuUygulamasi;

public class SogutucuCalistirma implements IIslem{
    private IEyleyici eyleyici;
    private IEkran ekran;

    public SogutucuCalistirma(IEyleyici eyleyici, IEkran ekran) {
        this.eyleyici = eyleyici;
        this.ekran = ekran;
    }

    @Override
    public void islemYap() {
        eyleyici.sogutucuCalistiriliyormu();
        ekran.mesajGoruntule("Soğutucu çalıştırıldı.");
    }
}
