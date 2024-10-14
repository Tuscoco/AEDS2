import java.io.IOException;

/**
 * ListaLinear
 */

public class ListaLinear {

    private int[] array;
    private int n;


    public ListaLinear(){
        array = new int[10];
        n = 0;
    }

    public ListaLinear(int tamanho){
        array = new int[tamanho];
        n = 0;
    }

    public void inserirInicio(int num){

        try{

            if(n >= array.length){
                throw new IOException("Erro ao inserir!");
            }

            for(int i = n;i > 0;i--){
                array[i] = array[i - 1];
            }

            array[0] = num;
            n++;

        }catch(IOException e){
            e.getMessage();
        }

    }

    public void inserirFinal(int num){

        try{

            if(n >= array.length){
                throw new IOException("Erro ao inserir!");
            }

            array[n] = num;
            n++;

        }catch(IOException e){
            e.getMessage();
        }

    }

    public void inserir(int pos,int num){

        try{

            if((n >= array.length) || (pos < 0) || (pos > n)){
                throw new IOException("Erro ao inserir!");
            }

            for(int i = n;i > pos;i--){
                array[i] = array[i - 1];
            }

            array[pos] = num;
            n++;

        }catch(IOException e){
            e.getMessage();
        }

    }

    public int removerInicio() throws IOException{

        if(n == 0){
            throw new IOException("Erro ao remover!");
        }
        
        int resp = array[0];
        n--;

        for(int i = 0;i < n;i++){
            array[i] = array[i + 1];
        }

        return resp;

    }

    public int removerFinal() throws IOException{

        if(n == 0){
            throw new IOException("Erro ao remover!");
        }

        int resp = array[--n];

        return resp;

    }

    public int remover(int pos) throws IOException{

        if(n == 0 || pos < 0 || pos >= n){
            throw new IOException("Erro ao remover!");
        }

        int resp = array[pos];
        n--;

        for(int i = pos;i < n;i++){
            array[i] = array[i + 1];
        }

        return resp;

    }

    public void mostrar(){

        System.out.print("[ ");
        for(int x : array){
            System.out.print(x + " ");
        }
        System.out.println("]");

    }

    public void swap(int i,int j){

        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }

    public void ordenar(){

        boolean swapped = true;

        for(int i = (array.length - 1);i > 0 && swapped;i--){

            swapped = false;

            for(int j = 0;j < i;j++){

                if(array[j] > array[j + 1]){
                    swap(j, j + 1);
                    swapped = true;
                }

            }

        }

    }
    
}