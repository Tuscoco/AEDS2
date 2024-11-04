
public class No {

    public char letra;
    public Lista lista;
    public No esq, dir;

    public No(char letra){

        this.letra = letra;
        lista = new Lista();
        esq = dir = null;

    }
    
}