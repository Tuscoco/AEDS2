import java.util.*;

/**
 * Pilha
 */

public class Pilha {

    private int[] array;
    private int n;


    public Pilha(){
        this.array = new int[10];
        this.n = 0;
    }

    public Pilha(int tam){
        this.array = new int[tam];
        this.n = 0;
    }

    public void push(int num) throws Exception{

        if(n >= array.length){
            throw new Exception("Pilha cheia!");
        }

        this.array[n] = num;
        n++;

    }

    public int pop() throws Exception{

        if(n == 0){
            throw new Exception("Pilha vazia!");
        }

        n--;
        return array[n];

    }

    public void mostrar(){

        System.out.println("==");
        for(int i = n - 1;i >= 0;i--){
            System.out.println(array[i]);
        }
        System.out.println("==");

    }
    
}