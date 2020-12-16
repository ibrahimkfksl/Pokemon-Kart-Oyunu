
package ProLab2;


import javax.swing.ImageIcon;

public class Zubat extends Pokemon {

     private int hasarPuani = 50;

    public Zubat() {
        super("Zubat", "Hava", "5", 50);

        super.kartResmi = new ImageIcon("resimler\\Zubat.jpg");
    }

    
    public Zubat(String pokemanAdi, String pokemonTipi, int hasarPuani, String pokemonId) {
        super(pokemanAdi, pokemonTipi, pokemonId, hasarPuani);

    }

    @Override
    public int hasarPuaniGoster() {
        return hasarPuani;
    }

}
