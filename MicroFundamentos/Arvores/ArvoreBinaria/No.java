
public class No {

    public int elemento;
    public No esq, dir;

    public No(int elemento){

        this.elemento = elemento;
        esq = dir = null;

    }

    public No(int elemento, No esq, No dir){

        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;

    }
    
}