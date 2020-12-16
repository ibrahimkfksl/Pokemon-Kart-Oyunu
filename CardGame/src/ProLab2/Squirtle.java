
package ProLab2;


import javax.swing.ImageIcon;

public class Squirtle extends Pokemon {

    private  int hasarPuani = 30;

    public Squirtle() {
        super("Squirtle", "Su", "4", 30);
        super.kartResmi = new ImageIcon("resimler\\Squirtle.jpg");
    }

    
    public Squirtle(String pokemanAdi, String pokemonTipi, int hasarPuani, String pokemonId) {
        super(pokemanAdi, pokemonTipi, pokemonId, hasarPuani);
    }

    @Override
    public int hasarPuaniGoster() {
        return hasarPuani;
    }

}
