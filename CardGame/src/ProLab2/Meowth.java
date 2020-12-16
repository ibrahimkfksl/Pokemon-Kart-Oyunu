
package ProLab2;


import javax.swing.ImageIcon;

public class Meowth extends Pokemon {

    private int hasarPuani = 40;

    public Meowth() {
        super("Meowth", "Normal", "10", 40);
        super.kartResmi = new ImageIcon("resimler\\Meowth.jpg");

    }

   
    public Meowth(String pokemanAdi, String pokemonTipi, int hasarPuani, String pokemonId) {
        super(pokemanAdi, pokemonTipi, pokemonId, hasarPuani);
    }

    @Override
    public int hasarPuaniGoster() {
        return hasarPuani;
    }

}
