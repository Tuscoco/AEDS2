import java.util.*;

/**
 * Main
 */

public class Main {

    public static void main(String[] args) throws Exception{
        
        Pilha pilha = new Pilha();
        
        for(int i = 0;i < 10;i++){
            pilha.push(i);
        }

        pilha.mostrar();

        for(int i = 0;i < 5;i++){
            System.out.print(pilha.pop() + " ");
        }
        System.out.println();

        pilha.mostrar();

    }
    
}