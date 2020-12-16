
package ProLab2;


import javax.swing.ImageIcon;

public class Psyduck extends Pokemon {

     private int hasarPuani = 20;

    public Psyduck() {
        super("Psyduck", "Su", "6", 20);
        super.kartResmi = new ImageIcon("resimler\\Psyduck.jpg");
    }

    
    public Psyduck(String pokemanAdi, String pokemonTipi, int hasarPuani, String pokemonId) {
        super(pokemanAdi, pokemonTipi, pokemonId, hasarPuani);

    }

    @Override
    public int hasarPuaniGoster() {
        return hasarPuani;
    }
}
