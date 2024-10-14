/**
 * FilaCircular
 */

public class FilaCircular {

    private int[] array;
    private int primeiro;
    private int ultimo;


    public FilaCircular(){
        array = new int[11];
        primeiro = 0;
        ultimo = 0;
    }

    public FilaCircular(int tam){
        array = new int[tam + 1];
        primeiro = ultimo = 0;
    }

    public void inserir(int num) throws Exception{

        if(((ultimo + 1) % array.length) == primeiro){
            throw new Exception("Erro! Lista Cheia!");
        }

        array[ultimo] = num;
        ultimo = (ultimo + 1) % array.length;

    }

    public int remover() throws Exception{

        if(ultimo == primeiro){
            throw new Exception("Erro! Lista Vazia!");
        }

        int resp = array[primeiro];
        primeiro = (primeiro + 1) % array.length;

        return resp;

    }
    
    public void mostrar(){

        int i = primeiro;
        
        System.out.print("[ ");
        
        while(i != ultimo){

            System.out.print(array[i] + " ");
            i = (i + 1) % array.length;

        }

        System.out.println("]");

    }

    public int tamanho(){

        int resp = 0;

        if(primeiro < ultimo){

            resp = (ultimo - primeiro);

        }else{

            resp = array.length - (ultimo - primeiro);

        }

        return resp;

    }

    public boolean isVazio(){
        return (primeiro == ultimo);
    }
    
}