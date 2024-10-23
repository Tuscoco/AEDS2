/**
 * Celula
 */

public class CelulaM {

    private int elemento;
    public CelulaM dir,esq,sup,inf;

    public CelulaM(){

        this.elemento = 0;
        dir = esq = sup = inf = null;

    }

    public void setElemento(int elemento){
        this.elemento = elemento;
    }

    public int getElemento(){
        return elemento;
    }
    
}