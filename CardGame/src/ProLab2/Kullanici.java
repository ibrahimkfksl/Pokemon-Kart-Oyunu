
package ProLab2;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Kullanici extends Oyuncu{

    private Pokemon secilenKart = new Pokemon();
    private ArrayList<Pokemon> kartList = new ArrayList<Pokemon>();
    private Arena arena=new Arena();
    private int hangiKart;
    
    public Kullanici(String oyuncuID, String oyuncuAdi, int skor) {
        super(oyuncuID, oyuncuAdi, skor);
    }

    public Kullanici() {
        super("2", "Guest", 0);
    }
    
        
    
    @Override
    protected int kartSec() {
        //Kullicinin mouse a tikla olayi ile kart sectigi kismin kodu
        
        hangiKart=-1;    

        while (hangiKart == -1) {
            arena.sag1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    hangiKart = 0;
                }
            });

            arena.sag2.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    hangiKart = 1;
                }
            });

            arena.sag3.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    hangiKart = 2;
                }
            });
        }
        
       int kart=hangiKart;
       hangiKart=0;
        
    
        return  kart;
    }

   
    
    //////////////getter setter fonksiyonlar\\\\\\\\\\\\\\\\\\\\\\\\\
    public Pokemon getSecilenKart() {
        return secilenKart;
    }

    public void setSecilenKart(Pokemon secilenKart) {
        this.secilenKart = secilenKart;
    }

    public ArrayList<Pokemon> getKartList() {
        return kartList;
    }

    public void setKartList(ArrayList<Pokemon> kartList) {
        this.kartList = kartList;
    }


    public int getHangiKart() {
        return hangiKart;
    }

    public void setHangiKart(int hangiKart) {
        this.hangiKart = hangiKart;
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }
    
    
    
    
}
