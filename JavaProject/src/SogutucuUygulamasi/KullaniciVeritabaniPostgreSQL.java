package SogutucuUygulamasi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class KullaniciVeritabaniPostgreSQL implements IKullaniciVeritabaniPostgreSQL{
    private IEkran ekran;
    private Kullanici kullanici;
    private String kullaniciAdi;
    private String sifre;
    private int kontrol=0;
    private ArrayList<String> kullaniciBilgileri = new ArrayList<String>();


    public KullaniciVeritabaniPostgreSQL(IEkran ekran,Kullanici kullanici) {
        this.ekran = ekran;
        this.kullanici=kullanici;
    }

    private Connection baglan(){

        Connection conn=null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SogutucuVeritabani",
                    "postgres", "Mshsys02129");
            if (conn != null)
                ekran.mesajGoruntule("Veritabanına bağlandı.");
            else
                ekran.mesajGoruntule("Bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public Kullanici kullaniciDogrula() {

        Connection conn=this.baglan();
        String sql= "SELECT \"kullaniciAdi2\", \"sifre\" FROM \"KullaniciSifre\"";

        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            do{
                while(rs.next())
                {
                    kullaniciBilgileri.add(rs.getString("kullaniciAdi2"));
                    kullaniciBilgileri.add(rs.getString("sifre"));
                }

                ekran.mesajGoruntule("Kullanici adinizi giriniz:");
                Scanner girdi1 = new Scanner(System.in);
                kullaniciAdi=girdi1.nextLine();

                for(int j = 0; j<kullaniciBilgileri.size();j++)
                {
                    if(kullaniciAdi.equals(kullaniciBilgileri.get(j)))
                    {
                        ekran.mesajGoruntule("Kullanici adi dogrulandi, lutfen bekleyiniz...");

                        ekran.mesajGoruntule("Sifrenizi giriniz:");
                        Scanner girdi2 = new Scanner(System.in);
                        sifre=girdi2.nextLine();

                        for(int i = 0; i < kullaniciBilgileri.size(); i++ )
                        {
                            if(kullaniciAdi.equals(kullaniciBilgileri.get(i)))
                            {
                                if(sifre.equals(kullaniciBilgileri.get(i+1)))
                                {
                                    ekran.mesajGoruntule("Bilgiler dogrulandi, lutfen bekleyiniz...");
                                    ekran.mesajGoruntule("Yapmak istediğiniz işlemi menüden seçiniz.");
                                    kontrol = 1;
                                }
                            }
                        }

                    };

                };

                if(kontrol == 0)
                {
                    ekran.mesajGoruntule("Girilen bilgiler yanlis, kontrol edip tekrar deneyiniz");
                }

            }while(kontrol == 0);

            rs.close();
            stmt.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return kullanici;
    }
}
