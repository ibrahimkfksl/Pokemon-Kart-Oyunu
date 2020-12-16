package ProLab2;

import javax.swing.ImageIcon;

public class Charmander extends Pokemon {

    private int hasarPuani = 60;

    public Charmander() {
        super("Charmander", "Ateş", "3", 60);

        super.kartResmi = new ImageIcon("resimler\\Charmander.jpg");
    }

    public Charmander(String pokemanAdi, String pokemonTipi, int hasarPuani, String pokemonId) {
        super(pokemanAdi, pokemonTipi, pokemonId, hasarPuani);

    }

    @Override
    public int hasarPuaniGoster() {
        return hasarPuani;
    }

}
