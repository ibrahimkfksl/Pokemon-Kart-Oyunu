
package ProLab2;


import javax.swing.ImageIcon;


public class Bulbasaur extends Pokemon{
     
    
    private int hasarPuani=50;
     
    
    public Bulbasaur() {
        super("Bulbasaur","Cim","2",50);        
        super.kartResmi= new ImageIcon("resimler\\Bulbasaur.jpg");
    }

    
    public Bulbasaur(String pokemanAdi, String pokemonTipi, int hasarPuani, String pokemonId) {
        super(pokemanAdi, pokemonTipi,pokemonId,hasarPuani);
             
    }

    @Override
    public int hasarPuaniGoster() {
        return hasarPuani;
    }
    
   

    
    
}
