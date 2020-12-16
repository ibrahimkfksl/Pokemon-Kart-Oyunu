package ProLab2;

import javax.swing.ImageIcon;

public class Butterfree extends Pokemon {

    private int hasarPuani = 10;

    public Butterfree() {
        super("Butterfree", "Hava", "8", 10);
        super.kartResmi = new ImageIcon("resimler\\Butterfree.jpg");
    }

    public Butterfree(String pokemanAdi, String pokemonTipi, int hasarPuani, String pokemonId) {
        super(pokemanAdi, pokemonTipi, pokemonId, hasarPuani);
    }

    @Override
    public int hasarPuaniGoster() {
        return hasarPuani;
    }

}
