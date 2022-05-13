package SogutucuUygulamasi;

public class AgArayuzu {
    private ISicaklikAlgilayici sicaklikAlgilayici;
    private IEyleyici eyleyici;
    private ITusTakimi tusTakimi;
    private IEkran ekran;
    private Kullanici kullanici;

    private static final int SOGUTUCU_AC=1;
    private static final int SOGUTUCU_KAPAT=2;
    private static final int SICAKLIK_OLC=3;
    private static final int CIKIS=4;

    public AgArayuzu(){
        sicaklikAlgilayici=new SicaklikAlgilayici();
        eyleyici=new Eyleyici();
        tusTakimi=new TusTakimi();
        ekran=new Ekran();
    }

    public void basla(){
        IKullaniciVeritabaniPostgreSQL veritabani=new KullaniciVeritabaniPostgreSQL(ekran,kullanici);
        veritabani.kullaniciDogrula();
        islemSecimi();
    }
    private void islemSecimi(){
        int secim;
        do {
            secim=menuyuGoster();
            ekran.ekranTemizle();
            switch (secim){
                case SOGUTUCU_AC:
                    IIslem sogutucuCalistir=new SogutucuCalistirma(eyleyici,ekran);
                    sogutucuCalistir.islemYap();
                    break;
                case SOGUTUCU_KAPAT:
                    IIslem sogutucuKapat=new SogutucuKapatma(eyleyici,ekran);
                    sogutucuKapat.islemYap();
                    break;
                case SICAKLIK_OLC:
                    ISicaklikAlgilayici sicaklik=new SicaklikAlgilayici(new Publisher());
                    sicaklik.aboneEkle(new Subscriber1());
                    sicaklik.aboneEkle(new Subscriber2());
                    sicaklik.sicaklikOlc();
                    break;
                case CIKIS:
                    ekran.mesajGoruntule("Çıkılıyor.");
                    break;
                default:
                    ekran.mesajGoruntule("1-4 arasında değer girmelisiniz!");
                    break;
            }
        }while(secim!=4);
    }
    private int menuyuGoster(){

        ekran.mesajGoruntule("* * * * * * * * * * * * *");
        ekran.mesajGoruntule("* 1-Soğutucu Çalıştır   *");
        ekran.mesajGoruntule("* 2-Soğutucu Kapat      *");
        ekran.mesajGoruntule("* 3-Sıcaklık Görüntüle  *");
        ekran.mesajGoruntule("* 4-Çıkış               *");
        ekran.mesajGoruntule("* * * * * * * * * * * * *");

        return tusTakimi.veriAl();
    }
}
