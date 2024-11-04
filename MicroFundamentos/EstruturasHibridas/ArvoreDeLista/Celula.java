
 public class Celula {

    Contato elemento;
    Celula prox;

    public Celula(){

        this.elemento = null;
        this.prox = null;

    }

    public Celula(Contato x){

        this.elemento = x;
        this.prox = null;

    }
    
}