
package ProLab2;


import javax.swing.ImageIcon;

public class Jigglypuff extends Pokemon {

     private int hasarPuani = 70;

    public Jigglypuff() {
        super("Jigglypuff", "Ses", "9", 70);

        super.kartResmi = new ImageIcon("resimler\\Jigglypuff.jpg");

    }

    
    public Jigglypuff(String pokemanAdi, String pokemonTipi, int hasarPuani, String pokemonId) {
        super(pokemanAdi, pokemonTipi, pokemonId, 70);
    }

    @Override
    public int hasarPuaniGoster() {
        return hasarPuani;
    }

}
