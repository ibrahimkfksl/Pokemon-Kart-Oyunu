
package ProLab2;


import javax.swing.ImageIcon;

public class Snorlax extends Pokemon {

     private int hasarPuani = 30;

    public Snorlax() {
        super("Snorlax", "Normal", "7", 30);
        super.kartResmi = new ImageIcon("resimler\\Snorlax.jpg");
    }

    
    public Snorlax(String pokemanAdi, String pokemonTipi, int hasarPuani, String pokemonId) {
        super(pokemanAdi, pokemonTipi, pokemonId, hasarPuani);
    }

    @Override
    public int hasarPuaniGoster() {
        return hasarPuani;
    }
}
