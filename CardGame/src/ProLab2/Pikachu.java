
package ProLab2;


import javax.swing.ImageIcon;

public class Pikachu extends Pokemon {

     private int hasarPuani = 40;

    public Pikachu() {
        super("Pikachu", "Elektrik", "1", 40);
        super.kartResmi = new ImageIcon("resimler\\Pikachu.jpg");
    }

    
    public Pikachu(String pokemanAdi, String pokemonTipi, int hasarPuani, String pokemonId) {
        super(pokemanAdi, pokemonTipi, pokemonId, hasarPuani);

    }

    @Override
    public int hasarPuaniGoster() {
        return hasarPuani;
    }

}
