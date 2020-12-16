
package ProLab2;

import java.util.ArrayList;
import java.util.Random;

public class Bilgisayar extends Oyuncu {

    static int oyuncuNumarasi = 1;
    private Random random = new Random();
    private Pokemon secilenKart = new Pokemon();
    private ArrayList<Pokemon> kartList = new ArrayList<Pokemon>();

    public Bilgisayar(String oyuncuID, String oyuncuAdi, int skor) {
        super(oyuncuID, oyuncuAdi, skor);
        super.setOyuncuAdi(getOyuncuAdi() + oyuncuNumarasi);
        oyuncuNumarasi++;

    }

    public Bilgisayar() {
        super("1", "Bilgisayar", 0);
        super.setOyuncuAdi(getOyuncuAdi() + oyuncuNumarasi);
        oyuncuNumarasi++;

    }

    @Override
    protected int kartSec() {
        int a;
        a = 0 + random.nextInt(3);//içerideki sayıya kadar yazıoyr 3 dahil değil

        return a;

    }

}
