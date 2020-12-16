
package ProLab2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame {

    static int islem = 0;
    JButton secim1;
    JButton secim2;
    JButton secim3;
    ImageIcon image = new ImageIcon("resimler\\Arena.jpg");

    //Menu classından nesne olusturulur oluşturulmaz paneli duzenlememiz lazım
    // Bu yuzden constructor a yerlesimler yapildi
    public Menu() {

        //Ekranin kullanildigi cozunurluk bilgisini aliyor
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  

        // Arkaya resim eklemek icin kullandıgımız kod blogu
        //https://stackoverflow.com/questions/18777893/jframe-background-image
        this.setLayout(new BorderLayout());
        this.setContentPane(new JLabel(image));
        this.setLayout(new FlowLayout());

        int x = screenSize.width, y = screenSize.height;  //fullscreen modda açan kısım
       
        int boyx, boyy;
        int basx, basy;

        boyx = x * 40 / 100;
        boyy = y * 10 / 100;

        basx = x * 30 / 100;
        basy = (y * 35 / 100) - (y * 10 / 100);

        this.setTitle("PokemonDuello");
        this.setSize(x, y);
        this.setLayout(null);

        
        secim1 = new JButton("Nasil Oynanir");
        secim2 = new JButton("Bilgisayar vs Bilgisayar");
        secim3 = new JButton("Bilgisayar vs Oyuncu");



        this.add(secim1);
        this.add(secim2);
        this.add(secim3);

        //Buttonların Yerlesimini Ayarladigimiz kisim
        secim1.setBounds(basx, basy, boyx, boyy);
        secim2.setBounds(basx, basy + (y * 15 / 100), boyx, boyy);
        secim3.setBounds(basx, basy + (y * 30 / 100), boyx, boyy);

        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //Mouse Tıklamalarına Göre Hangi İşlemi Yapacağımızı Öğrenmek İçin Yazıldı
    public int islemSonucu() {

        while (islem == 0) {
            secim1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    islem = 1;
                }
            });

            secim2.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    islem = 2;
                }
            });

            secim3.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    islem = 3;
                }
            });
        }
        
        int donder=islem;
        islem=0;
        return donder;
    }

    //Mouse Tıklamasından Sonra Dongu Icınde Tekrar Hata Almamak icin Yazilan Kod
    public static void islemSifirla() {
        Menu.islem = 0;
    }
    
    

}


