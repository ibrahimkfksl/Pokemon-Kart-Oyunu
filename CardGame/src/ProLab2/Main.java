//Abdullah Yasar KISA--180201015
//Ibrahim KAFKASLI--180201078
package ProLab2;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {

    //throws yazmamizin sebebi sleep apisini kullanabilmek icin 
    public static void main(String[] args) throws InterruptedException {

        while (true) {
            Menu menu = new Menu();
            Arena arena = new Arena();
            Random r = new Random();

            ImageIcon siraSol = new ImageIcon("resimler\\siraSol.png");
            ImageIcon siraSag = new ImageIcon("resimler\\siraSag.png");

            int i, j;
            String oyun_sonu_mesaj = null;
            String nasil_oynanir;

            ArrayList<Pokemon> oyuncu1Deste = new ArrayList<Pokemon>(3);//ilk oyuncunun destesi
            ArrayList<Pokemon> oyuncu2Deste = new ArrayList<Pokemon>(3);//ikinci oyuncunun destesi
            ArrayList<Pokemon> ortadakiDeste = new ArrayList<Pokemon>(4);//Ortadaki kartlarin destesi

            Pokemon ilk_deste[] = new Pokemon[10];
            int deste_karistirici[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

            Pokemon pokemon1 = new Bulbasaur();
            Pokemon pokemon2 = new Butterfree();
            Pokemon pokemon3 = new Charmander();
            Pokemon pokemon4 = new Jigglypuff();
            Pokemon pokemon5 = new Meowth();
            Pokemon pokemon6 = new Pikachu();
            Pokemon pokemon7 = new Psyduck();
            Pokemon pokemon8 = new Snorlax();
            Pokemon pokemon9 = new Squirtle();
            Pokemon pokemon10 = new Zubat();
            Pokemon bosKart = new Pokemon();

            //bos_kart  masada kart olamayan bosluklari kullanmak icin eklenen bir nesne
            bosKart.setKartKullanildiMi(true);

            ilk_deste[0] = pokemon1;
            ilk_deste[1] = pokemon2;
            ilk_deste[2] = pokemon3;
            ilk_deste[3] = pokemon4;
            ilk_deste[4] = pokemon5;
            ilk_deste[5] = pokemon6;
            ilk_deste[6] = pokemon7;
            ilk_deste[7] = pokemon8;
            ilk_deste[8] = pokemon9;
            ilk_deste[9] = pokemon10;

            // bu dongu ile destemizi karistirmak icin kullanacagiz
            for (i = 0; i < 10; i++) {
                int tmp = 0 + r.nextInt(10);

                for (j = 0; j < 10; j++) {
                    if (tmp == deste_karistirici[j]) {
                        break;
                    }
                }

                if (j == 10) {
                    deste_karistirici[i] = tmp;
                } else {
                    i--;
                }
            }

            // kartlari oyunculara ve masaya dagitiyoruz
            i = 0;
            while (i < 10) {
                if (i < 3) {
                    oyuncu1Deste.add(ilk_deste[deste_karistirici[i]]);
                } else if (i >= 3 && i < 6) {
                    oyuncu2Deste.add(ilk_deste[deste_karistirici[i]]);
                } else if (i >= 6 && i < 10) {
                    ortadakiDeste.add(ilk_deste[deste_karistirici[i]]);
                }

                i++;
            }

            //Nasil Oynanir Ekraninda Yazmasi Gereken Mesaj
            nasil_oynanir = "Oyun Turunuzu Seciniz:\n"
                    + "1-Bilgisayar vs Bilgisayar\n"
                    + "Bilgisayar kendi ile savasir. Kartlari iki tarafta rastgele atar.\n"
                    + "Her kart atisinda iki kartin arasindan hasar puani yuksek olan kart"
                    + "diger karti yener.\n"
                    + "Her turda karsi oyunucunun kartini yenen oyuncu 5 puan kazanir.\n"
                    + "En cok puani kazanan oyunu kazanir."
                    + "\n"
                    + "2-Bilgisayar vs Kullanici\n"
                    + "Bilgisayar rastgele kart atar.\n"
                    + "Kullanici ise atmak istedigi kartin uzerine gelerek karta tiklar.\n"
                    + "Her kart atisinda iki kartin arasindan hasar puani yuksek olan kart"
                    + "diger karti yener.\n"
                    + "Her turda karsi oyunucunun kartini yenen oyuncu 5 puan kazanir.\n"
                    + "En cok puani kazanan oyunu kazanir.\n\n"
                    + "Oyundan cikmak icin sag ust koseden carpi isaretine basabilirsiniz.";

            int secilen_kart1;
            int secilen_kart2;
            int menuIslem;

            menu.setVisible(true);
            menuIslem = menu.islemSonucu();

            //////////////Oyunun Basladigi Yer\\\\\\\\\\\\\\\\\\\\\\\
            if (menuIslem == 1) {
                //Oyunun Nasil Oynanmasi Gerektigini Ekrana Yazdirdamaya Yarayan Panel
                JOptionPane.showMessageDialog(null, nasil_oynanir, "Nasil Oynanir", JOptionPane.DEFAULT_OPTION);
                Menu.islemSifirla();
                menuIslem = 0;
                menu.setVisible(false);
                continue;
            } else if (menuIslem == 2) {
                menu.setVisible(false);

                Oyuncu oyuncu1 = new Bilgisayar();
                Oyuncu oyuncu2 = new Bilgisayar();

                oyuncu1.setKartListesi(oyuncu1Deste);
                oyuncu2.setKartListesi(oyuncu2Deste);

                arena.oyunculariAl(oyuncu1, oyuncu2);

                arena.kartlariDiz();
                arena.siraGoster(siraSol);
                arena.puanlariGuncelle();
                arena.setVisible(true);

                Thread.sleep(2000);

                j = 0;
                for (i = 0; i < 5; i++) {
                    arena.siraGoster(siraSol);

                    do {
                        //donguye sokma sebebimiz eger random gelen sayinin
                        //gosterdigi indisteki kart kullanilmis ise tekrar kullanmamasi icin
                        secilen_kart1 = oyuncu1.kartSec();
                    } while (secilen_kart1 == -1 || oyuncu1.getKartListesi().get(secilen_kart1).isKartKullanildiMi() == true);

                    oyuncu1.kartiSil(secilen_kart1);
                    arena.kartAt(1, secilen_kart1);
                    arena.kartlariDiz();
                    arena.puanlariGuncelle();
                    arena.siraGoster(siraSag);
                    Thread.sleep(2000);

                    do {
                        //donguye sokma sebebimiz eger random gelen sayinin
                        //gosterdigi indisteki kart kullanilmis ise tekrar kullanmamasi icin
                        secilen_kart2 = oyuncu2.kartSec();
                    } while (secilen_kart2 == -1 || oyuncu2.getKartListesi().get(secilen_kart2).isKartKullanildiMi() == true);

                    oyuncu2.kartiSil(secilen_kart2);
                    arena.kartAt(2, secilen_kart2);
                    arena.kartlariDiz();
                    arena.siraGoster(null);
                    arena.puanlariGuncelle();
                    Thread.sleep(2000);

                    int oyuncu1HasarPuani = oyuncu1.getKartListesi().get(secilen_kart1).hasarPuaniGoster();
                    int oyuncu2HasarPuani = oyuncu2.getKartListesi().get(secilen_kart2).hasarPuaniGoster();

                    //Oyuncularin sectikleri kartlara gore hasar puanlarini karsilastirip
                    //uygun oyuncunun skorununa ekleme yaptik
                    if (oyuncu1HasarPuani > oyuncu2HasarPuani) {
                        oyuncu1.setSkor(oyuncu1.getSkor() + 5);
                    } else if (oyuncu1HasarPuani < oyuncu2HasarPuani) {
                        oyuncu2.setSkor(oyuncu2.getSkor() + 5);
                    }

                    //Buradaki if kosulu masadaki destede kartin olup olmamasini kontrol ediyor
                    if (j < 4) {
                        oyuncu1.getKartListesi().remove(secilen_kart1);
                        oyuncu1.getKartListesi().add(secilen_kart1, ortadakiDeste.get(j));

                        j++;
                        oyuncu2.getKartListesi().remove(secilen_kart2);
                        oyuncu2.getKartListesi().add(secilen_kart2, ortadakiDeste.get(j));

                        j++;
                    } else {
                        oyuncu1.getKartListesi().remove(secilen_kart1);
                        oyuncu1.getKartListesi().add(secilen_kart1, bosKart);

                        oyuncu2.getKartListesi().remove(secilen_kart2);
                        oyuncu2.getKartListesi().add(secilen_kart2, bosKart);

                    }

                    arena.ortaBosalt();
                    arena.kartlariDiz();

                    //Oyunun sonunda bitmesi gerekirken sol taraftaki oyunucu isaret ediyor
                    //BU durumu engellemek icin yapildi
                    if (i != 4) {
                        arena.siraGoster(siraSol);
                    }
                    arena.puanlariGuncelle();
                    Thread.sleep(2000);

                }

                //Asagidaki if-else blogu oyun sonunda kimin kazandigini ekrana yazdirmak icin 
                //kullanilan stringi olusturan kisim
                if (oyuncu1.getSkor() > oyuncu2.getSkor()) {
                    oyun_sonu_mesaj = "Kazanan : " + oyuncu1.getOyuncuAdi() + "\n" + oyuncu1.getOyuncuAdi() + " Puani:  " + oyuncu1.getSkor() + "\n" + oyuncu2.getOyuncuAdi() + " Puani: " + oyuncu2.getSkor();
                } else if (oyuncu2.getSkor() > oyuncu1.getSkor()) {
                    oyun_sonu_mesaj = "Kazanan : " + oyuncu2.getOyuncuAdi() + "\n" + oyuncu2.getOyuncuAdi() + " Puani:  " + oyuncu2.getSkor() + "\n" + oyuncu1.getOyuncuAdi() + " Puani: " + oyuncu1.getSkor();

                } else {
                    oyun_sonu_mesaj = "Oyun Berabere Bitmistir";
                }

            } else if (menuIslem == 3) {
                //Kullanici vs Bilgisayarda kullanici adini ogrenmek icin yazilan kod
                String oyuncu_adi = JOptionPane.showInputDialog("Oyuncunun Nickini Giriniz: ");
                //Oyuncu Adi Girilmez ise Oyun Baslatilmiyor
                if (oyuncu_adi == null) {
                    String uyari = "Oyuncu Icin Isim Girmeniz Gerekmektedir";
                    JOptionPane.showMessageDialog(null, uyari, "HATA", JOptionPane.DEFAULT_OPTION);
                    Menu.islemSifirla();
                    menuIslem = 0;
                    menu.setVisible(false);
                    continue;
                }
                menu.setVisible(false);

                Oyuncu oyuncu1 = new Bilgisayar();
                Kullanici oyuncu2 = new Kullanici("User", oyuncu_adi, 0);

                //Kullaniciya arena nesnesini gonderdik
                //Cunku kart secme metotunda buttonlara mouse tiklamasi almasi gerekiyor
                oyuncu2.setArena(arena);

                oyuncu1.setKartListesi(oyuncu1Deste);
                oyuncu2.setKartListesi(oyuncu2Deste);

                arena.oyunculariAl(oyuncu1, oyuncu2);

                arena.kartlariDiz();
                arena.siraGoster(siraSol);
                arena.puanlariGuncelle();
                arena.setVisible(true);
                Thread.sleep(4000);

                j = 0;
                for (i = 0; i < 5; i++) {
                    arena.siraGoster(siraSol);
                    do {
                        //donguye sokma sebebimiz eger random gelen sayinin
                        //gosterdigi indisteki kart kullanilmis ise tekrar kullanmamasi icin
                        secilen_kart1 = oyuncu1.kartSec();
                    } while (secilen_kart1 == -1 || oyuncu1.getKartListesi().get(secilen_kart1).isKartKullanildiMi() == true);

                    oyuncu1.kartiSil(secilen_kart1);
                    arena.kartAt(1, secilen_kart1);
                    arena.kartlariDiz();
                    arena.puanlariGuncelle();
                    arena.siraGoster(siraSag);

                    do {
                        //donguye sokma sebebimiz eger kullanicinin sectigi butonun geri donderdigi sayinin
                        //gosterdigi indisteki kart kullanilmis ise tekrar kullanmamasi icin
                        secilen_kart2 = oyuncu2.kartSec();
                    } while (secilen_kart2 == -1 || oyuncu2.getKartListesi().get(secilen_kart2).isKartKullanildiMi() == true);

                    oyuncu2.kartiSil(secilen_kart2);
                    arena.kartAt(2, secilen_kart2);
                    arena.kartlariDiz();
                    arena.siraGoster(null);
                    arena.puanlariGuncelle();
                    Thread.sleep(2000);

                    int oyuncu1HasarPuani = oyuncu1.getKartListesi().get(secilen_kart1).hasarPuaniGoster();
                    int oyuncu2HasarPuani = oyuncu2.getKartListesi().get(secilen_kart2).hasarPuaniGoster();

                    //Oyuncularin sectikleri kartlara gore hasar puanlarini karsilastirip
                    //uygun oyuncunun skorununa ekleme yaptik
                    if (oyuncu1HasarPuani > oyuncu2HasarPuani) {
                        oyuncu1.setSkor(oyuncu1.getSkor() + 5);
                    } else if (oyuncu1HasarPuani < oyuncu2HasarPuani) {
                        oyuncu2.setSkor(oyuncu2.getSkor() + 5);
                    }

                    //Buradaki if kosulu masadaki destede kartin olup olmamasini kontrol ediyor
                    if (j < 4) {
                        oyuncu1.getKartListesi().remove(secilen_kart1);
                        oyuncu1.getKartListesi().add(secilen_kart1, ortadakiDeste.get(j));

                        j++;
                        oyuncu2.getKartListesi().remove(secilen_kart2);
                        oyuncu2.getKartListesi().add(secilen_kart2, ortadakiDeste.get(j));

                        j++;
                    } else {
                        oyuncu1.getKartListesi().remove(secilen_kart1);
                        oyuncu1.getKartListesi().add(secilen_kart1, bosKart);

                        oyuncu2.getKartListesi().remove(secilen_kart2);
                        oyuncu2.getKartListesi().add(secilen_kart2, bosKart);

                    }
                    arena.ortaBosalt();
                    arena.puanlariGuncelle();
                    arena.kartlariDiz();

                    //Oyunun sonunda bitmesi gerekirken sol taraftaki oyunucu isaret ediyor
                    //Bu durumu engellemek icin yapildi
                    if (i != 4) {
                        arena.siraGoster(siraSol);
                    }

                    Thread.sleep(2000);

                }

                //Asagidaki if-else blogu oyun sonunda kimin kazandigini ekrana yazdirmak icin 
                //kullanilan stringi olusturan kisim
                if (oyuncu1.getSkor() > oyuncu2.getSkor()) {
                    oyun_sonu_mesaj = "Kazanan : " + oyuncu1.getOyuncuAdi() + "\n" + oyuncu1.getOyuncuAdi() + " Puani:  " + oyuncu1.getSkor() + "\n" + oyuncu2.getOyuncuAdi() + " Puani: " + oyuncu2.getSkor();
                } else if (oyuncu2.getSkor() > oyuncu1.getSkor()) {
                    oyun_sonu_mesaj = "Kazanan : " + oyuncu2.getOyuncuAdi() + "\n" + oyuncu2.getOyuncuAdi() + " Puani:  " + oyuncu2.getSkor() + "\n" + oyuncu1.getOyuncuAdi() + " Puani: " + oyuncu1.getSkor();

                } else {
                    oyun_sonu_mesaj = "Oyun Berabere Bitmistir";
                }

            }

            //Oyun bitince oyunu kimin kazandigini ve oyuncularin kacar puanda oldukari ekrana yazdiriyoruz
            if (menuIslem == 2 || menuIslem == 3) {
                JOptionPane.showMessageDialog(null, oyun_sonu_mesaj, "Oyun Sonu", JOptionPane.DEFAULT_OPTION);

                Menu.islemSifirla();
                menuIslem = 0;
                menu.setVisible(false);
                arena.setVisible(false);

                continue;
            }

        }
    }

}
