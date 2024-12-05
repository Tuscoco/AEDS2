

public class Lista {
    
    private Celula primeiro, ultimo;

    public Lista(){

        primeiro = new Celula();
        ultimo = primeiro;

    }

    public void inserir(int x){

        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;

    }

    public boolean pesquisa(int x){

        Celula i = primeiro.prox;

        while(i != null){

            if(i.elemento == x){

                return true;

            }

            i = i.prox;

        }

        return false;

    }

}
