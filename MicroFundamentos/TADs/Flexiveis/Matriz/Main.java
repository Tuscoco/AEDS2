/**
 * Main
 */

 import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        Matriz matriz = new Matriz();
        int[] vet = new int[9];

        for(int i = 0;i < 9;i++){

            System.out.println("Informe o " + (i + 1) + " numero:");

            vet[i] = scan.nextInt();

        }

        matriz.inserir(vet);

        matriz.mostrar();

        scan.close();

    }
    
}