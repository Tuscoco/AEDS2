import java.util.*;

/**
 * Main
 */

public class Main {

    public static int[] mandioca = {300,1500,600,1000,150};

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int[] porcoes = new int[5];
        int soma = 0;

        for(int i = 0;i < 5;i++){

            porcoes[i] = scan.nextInt();

            porcoes[i] *= mandioca[i];

            soma += porcoes[i];

        }

        soma += 225;

        System.out.println(soma);

        scan.close();

    }
    
}