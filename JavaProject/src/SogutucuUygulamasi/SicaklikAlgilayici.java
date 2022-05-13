package SogutucuUygulamasi;

import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici{
    private int sicaklik;
    private Random random=new Random();
    private ISubject publisher;
    private IIslem islem;

    SicaklikAlgilayici(ISubject publisher){
        this.publisher=publisher;
        islem=new SicaklikGoruntule();
    }

    public SicaklikAlgilayici() {

    }
    @Override
    public void aboneEkle(IObserver abone){
        publisher.attach(abone);
    }
    @Override
    public void sicaklikOlc() {
        sicaklik=Math.abs(random.nextInt()%100);
        islem.islemYap();
        System.out.println(sicaklik);
        if(sicaklik>45){
            publisher.notify("Sıcaklık 45 derecenin üzerine çıktı, soğutucuyu açmanız tavsiye edilir.");
        }
    }
}
