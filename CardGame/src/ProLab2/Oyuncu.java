
package ProLab2;


import java.util.ArrayList;

public  abstract class Oyuncu {

    private String oyuncuID;
    private String oyuncuAdi;
    private int skor;
   
    private ArrayList<Pokemon> kartListesi = new ArrayList<Pokemon>();

    public Oyuncu(String oyuncuID, String oyuncuAdi, int skor) {
        this.oyuncuID = oyuncuID;
        this.oyuncuAdi = oyuncuAdi;
        this.skor = skor;
    }

    public Oyuncu() {
        this.oyuncuID = null;
        this.oyuncuAdi = null;
        this.skor = 0;
    }

    //her cagırmada bir kart ekliyor arrayliste
    public void kartlariAl(Pokemon x) {
        this.kartListesi.add(x);
    }

    public int skorGoster() {
        return skor;
    }

    protected abstract int kartSec();//ilk yapılınca void yaptık duruma göre baska degerleride alabilir

    // oyunda sectigi kartı bir daha kullanmamak icin
    public void kartiSil(int x) {
        kartListesi.get(x).setKartKullanildiMi(true);
    }
    
    
    

////////Getter Setter Fonksiyonları\\\\\\\\\\\\\\\
    public String getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(String oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    public ArrayList<Pokemon> getKartListesi() {
        return kartListesi;
    }

    public void setKartListesi(ArrayList<Pokemon> kartListesi) {
        this.kartListesi = kartListesi;
    }


}
