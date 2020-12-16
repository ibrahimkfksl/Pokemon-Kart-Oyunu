
package ProLab2;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Arena extends JFrame {

    Oyuncu oyuncu1;
    Oyuncu oyuncu2;

    JButton solust;
    JButton sol1;
    JButton sol2;
    JButton sol3;
    JButton orta11;
    JButton orta12;
    JButton orta2;
    JButton sagust;
    JButton sag1;
    JButton sag2;
    JButton sag3;

    //Arkaya resim eklemek icin kullaniyoruz
    ImageIcon wallpaper = new ImageIcon("resimler\\Arena2.jpg");

    public Arena() {
        //ekranın çözünürlük bilgilerini alıyor
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Arkaya resim eklemek icin kullandıgımız kod blogu
        //kaynak:https://stackoverflow.com/questions/18777893/jframe-background-image
        this.setLayout(new BorderLayout());
        this.setContentPane(new JLabel(wallpaper));
        this.setLayout(new FlowLayout());

        //ekranin cözünürlük bilgilerini 2 degiskene  aktarir
        int x = screenSize.width, y = screenSize.height;

        //Acilacak Pencerenin Ozelliklerini Duzenenler
        this.setTitle("PokemonDuello");
        this.setSize(x, y);
        this.setLayout(null);

        int boyx, boyy;

        //Pencereye ekleyecegimiz butonlarin boyutlarini duzenledik
        boyx = x * 7 / 100;
        boyy = y * 20 / 100;

        //ikinci bir buton boyut ayari yapar
        int boyx2 = x * 20 / 100;
        int boyy2 = y * 15 / 100;

        //Buttonlari tanimlandigi kisim
        solust = new JButton();
        sol1 = new JButton();
        sol2 = new JButton();
        sol3 = new JButton();
        orta11 = new JButton();
        orta12 = new JButton();
        orta2 = new JButton();
        sagust = new JButton();
        sag1 = new JButton();
        sag2 = new JButton();
        sag3 = new JButton();

        //Butonlarin konum ve boy bilgilerini duzenlenler
        solust.setBounds((x * 2 / 100), (y * 5 / 100) - (y * 3 / 100), boyx2, boyy2);
        sol1.setBounds((x * 2 / 100), (y * 25 / 100) - (y * 3 / 100), boyx, boyy);
        sol2.setBounds((x * 2 / 100), (y * 50 / 100) - (y * 3 / 100), boyx, boyy);
        sol3.setBounds((x * 2 / 100), (y * 75 / 100) - (y * 3 / 100), boyx, boyy);
        orta11.setBounds((x * 37 / 100), ((int) (y * 37.5 / 100) - (y * 2 / 100)), (boyx + (x * 1 / 100)), (boyy + (y * 1 / 100)));
        orta12.setBounds((x * 56 / 100), ((int) (y * 37.5 / 100) - (y * 2 / 100)), (boyx + (x * 1 / 100)), (boyy + (y * 1 / 100)));
        orta2.setBounds((int) (x * (46.5) / 100), (y * 75 / 100) - (y * 2 / 100), (boyx + (x * 1 / 100)), (boyy + (y * 1 / 100)));
        sagust.setBounds((x * 77 / 100), (y * 5 / 100) - (y * 3 / 100), boyx2, boyy2);
        sag1.setBounds((x * 90 / 100), (y * 25 / 100) - (y * 3 / 100), boyx, boyy);
        sag2.setBounds((x * 90 / 100), (y * 50 / 100) - (y * 3 / 100), boyx, boyy);
        sag3.setBounds((x * 90 / 100), (y * 75 / 100) - (y * 3 / 100), boyx, boyy);

        //Ortadaki butonlarin atka temasini siyaha cevirir
        orta11.setBackground(Color.black);
        orta12.setBackground(Color.black);

        //ucerli sekilde olan bu kodlar butonlari:
        //transparan bir hale cevirir
        
        solust.setOpaque(false);
        solust.setContentAreaFilled(false);
        solust.setBorderPainted(false);

        sol1.setOpaque(false);
        sol1.setContentAreaFilled(false);
        sol1.setBorderPainted(false);

        sol2.setOpaque(false);
        sol2.setContentAreaFilled(false);
        sol2.setBorderPainted(false);

        sol3.setOpaque(false);
        sol3.setContentAreaFilled(false);
        sol3.setBorderPainted(false);

        sagust.setOpaque(false);
        sagust.setContentAreaFilled(false);
        sagust.setBorderPainted(false);

        sag1.setOpaque(false);
        sag1.setContentAreaFilled(false);
        sag1.setBorderPainted(false);

        sag2.setOpaque(false);
        sag2.setContentAreaFilled(false);
        sag2.setBorderPainted(false);

        sag3.setOpaque(false);
        sag3.setContentAreaFilled(false);
        sag3.setBorderPainted(false);

        orta11.setBorderPainted(false);
        orta12.setBorderPainted(false);

        //butonlari panele ekler
        this.add(solust);
        this.add(sol1);
        this.add(sol2);
        this.add(sol3);
        this.add(orta11);
        this.add(orta12);
        this.add(orta2);
        this.add(sagust);
        this.add(sag1);
        this.add(sag2);
        this.add(sag3);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void kartlariDiz() {
        //Bu metot oyuncularin ellerindeki kartlarin bilgilerine gore butonlara
        //kartlarin yerlesimini yapar
        
        /////////////oyuncu1//////////////
        if (oyuncu1.getKartListesi().get(0) != null) {
            if ((oyuncu1.getKartListesi().get(0).isKartKullanildiMi() == true)) {
                sol1.setIcon(null);
            } else {
                sol1.setIcon(oyuncu1.getKartListesi().get(0).getKartResmi());
            }
        } else {
            sol1.setIcon(null);
        }

        if (oyuncu1.getKartListesi().get(1) != null) {
            if (oyuncu1.getKartListesi().get(1).isKartKullanildiMi() == true) {
                sol2.setIcon(null);
            } else {
                sol2.setIcon(oyuncu1.getKartListesi().get(1).getKartResmi());
            }
        } else {
            sol2.setIcon(null);
        }

        if (oyuncu1.getKartListesi().get(2) != null) {

            if (oyuncu1.getKartListesi().get(2).isKartKullanildiMi() == true) {
                sol3.setIcon(null);
            } else {
                sol3.setIcon(oyuncu1.getKartListesi().get(2).getKartResmi());
            }
        } else {
            sol3.setIcon(null);
        }

        ///////////////////oyuncu2/////////////////////////////
        if (oyuncu2.getKartListesi().get(0) != null) {
            if (oyuncu2.getKartListesi().get(0).isKartKullanildiMi() == true) {
                sag1.setIcon(null);
            } else {
                sag1.setIcon(oyuncu2.getKartListesi().get(0).getKartResmi());
            }
        } else {
            sag1.setIcon(null);
        }

        if (oyuncu2.getKartListesi().get(1) != null) {
            if (oyuncu2.getKartListesi().get(1).isKartKullanildiMi() == true) {
                sag2.setIcon(null);
            } else {
                sag2.setIcon(oyuncu2.getKartListesi().get(1).getKartResmi());
            }
        } else {
            sag2.setIcon(null);
        }

        if (oyuncu2.getKartListesi().get(2) != null) {
            if (oyuncu2.getKartListesi().get(2).isKartKullanildiMi() == true) {
                sag3.setIcon(null);
            } else {
                sag3.setIcon(oyuncu2.getKartListesi().get(2).getKartResmi());
            }
        } else {
            sag3.setIcon(null);
        }

    }

    public void oyunculariAl(Oyuncu oyuncu1, Oyuncu oyuncu2) {
        //oyuncularin bilgilerini alan kisim
        this.oyuncu1 = oyuncu1;
        this.oyuncu2 = oyuncu2;
    }

    public void puanlariGuncelle() {
        //Ekrana puanlari yazan metot
        solust.setText(oyuncu1.getOyuncuAdi() + "\n" + "     Puan: " + oyuncu1.getSkor());
        sagust.setText(oyuncu2.getOyuncuAdi() + "\n" + "     Puan: " + oyuncu2.getSkor());

    }

    public void kartAt(int oyuncu, int kart) {
        //oyuncunun sectigi kartin resmini ortaki dovus sahasina yerlestirmeye yarar
        if (oyuncu == 1) {
            orta11.setIcon(oyuncu1.getKartListesi().get(kart).getKartResmi());
            oyuncu1.kartiSil(kart);
        } else if (oyuncu == 2) {
            orta12.setIcon(oyuncu2.getKartListesi().get(kart).getKartResmi());
            oyuncu2.kartiSil(kart);

        }
    }

    public void ortaBosalt() {
        //tur bitince orta bulununan butonlarin kart resimlerini siler
        orta11.setIcon(null);
        orta12.setIcon(null);
    }

    public void siraGoster(ImageIcon sira) {
        //oyuncu sirasinin hangi oyuncuda oldugunu gosterir
        orta2.setIcon(sira);

    }

}

