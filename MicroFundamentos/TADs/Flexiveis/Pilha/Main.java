/**
 * Main
 */

public class Main {

    public static void main(String[] args) {
        
        Pilha pilha = new Pilha();

        for(int i = 0;i <= 10;i++){

            pilha.inserir(i);

        }

        pilha.mostrar();

    }
    
}