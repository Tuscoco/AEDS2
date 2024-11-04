
public class Lista {
    
    private Celula primeiro, ultimo;

    public Lista(){

        primeiro = new Celula();
        ultimo = primeiro;

    }

    public void inserirFim(Contato x){

        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;

    }

    public void mostrar(){

        if(primeiro == ultimo){

            System.out.println("Lista vazia!");

        }else{

            Celula i = primeiro.prox;

            while(i != null){

                System.out.println(i.elemento.toString());

                i = i.prox;

            }

        }

    }

}
