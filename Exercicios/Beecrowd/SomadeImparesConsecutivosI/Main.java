import java.util.*;

/**
 * Main
 */

public class Main {

    public static int somar(int[] array){

        int menor = array[0];
        int maior = array[1];

        int soma = 0;

        for(int i = menor;i < maior;i++){

            if(i % 2 != 0){
                soma += i;
            }

        }

        return soma;

    }
    
    public static int[] organizar(int n1, int n2){

        if(n1 > n2){
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }

        int[] resultado = {n1,n2};

        return resultado;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n1 = scan.nextInt();
        int n2 = scan.nextInt();

        int[] array = organizar(n1, n2);

        int soma = somar(array);

        System.out.println(soma);

        scan.close();

    }
    
}