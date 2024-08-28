import java.util.*;

/**
 * Main
 */

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        double total = 0;
        int produto;
        
        int quant = scan.nextInt();

        for(int i = 0;i < quant;i++){

            produto = scan.nextInt();
            int quantProd = scan.nextInt();

            double valor = 0;

            if(produto == 1001){

                valor = 1.50;

            }else if(produto == 1002){

                valor = 2.50;

            }else if(produto == 1003){

                valor = 3.50;

            }else if(produto == 1004){

                valor = 4.50;

            }else if(produto == 1005){

                valor = 5.50;

            }

            total += (quantProd * valor);

        }

        System.out.printf("%.2f",total);
        System.out.println();

        scan.close();

    }
    
}