package SogutucuUygulamasi;

public class Eyleyici implements IEyleyici{
    IEkran ekran=new Ekran();
    @Override
    public void sogutucuCalistiriliyormu() {
        ekran.mesajGoruntule("Soğutucu çalıştırılıyor...");
    }

    @Override
    public void sogutucuKapatiliyormu() {
        ekran.mesajGoruntule("Soğutucu kapatılıyor...");
    }
}
