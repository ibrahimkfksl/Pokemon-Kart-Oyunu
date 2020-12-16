
package ProLab2;


import javax.swing.ImageIcon;


public class Pokemon {
    
    private String pokemanAdi;
    private String pokemonTipi;
    private String pokemonId;
    private boolean kartKullanildiMi;
    ImageIcon kartResmi;

    public Pokemon(){
        this.pokemanAdi=null;
        this.pokemonTipi=null;
        this.pokemonId=null;
        this.kartKullanildiMi=false;
        
        
    }
    
    public Pokemon(String pokemanAdi, String pokemonTipi,String pokemonId,int hasarPuani) {
        this.pokemanAdi = pokemanAdi;
        this.pokemonTipi = pokemonTipi;
        this.pokemonId=pokemonId;
        this.kartKullanildiMi=false;
    }
    
    public int hasarPuaniGoster(){
        return 0;
    }
    
    
    
    
    
    

   
    
    
    
    
    
    
    
    
    ////////////getter setterlar\\\\\\\\\\\\\\\\\\\\\\
    public String getPokemanAdi() {
        return pokemanAdi;
    }

    public void setPokemanAdi(String pokemanAdi) {
        this.pokemanAdi = pokemanAdi;
    }

    public String getPokemonTipi() {
        return pokemonTipi;
    }

    public void setPokemonTipi(String pokemonTipi) {
        this.pokemonTipi = pokemonTipi;
    }

    public String getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(String pokemonId) {
        this.pokemonId = pokemonId;
    }

    public ImageIcon getKartResmi() {
        return kartResmi;
    }

    public void setKartResmi(ImageIcon kartResmi) {
        this.kartResmi = kartResmi;
    }

    public boolean isKartKullanildiMi() {
        return kartKullanildiMi;
    }

    public void setKartKullanildiMi(boolean kartKullanildiMi) {
        this.kartKullanildiMi = kartKullanildiMi;
    }
    
    
}
