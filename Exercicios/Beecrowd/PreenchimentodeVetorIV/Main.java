import java.util.*;

/**
 * Main
 */

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int[] par = new int[5];
        int[] impar = new int[5];

        int indexPar = 0;
        int indexImpar = 0;

        for(int i = 0;i < 15;i++){

            int num = scan.nextInt();

            if(num % 2 == 0){

                par[indexPar] = num;
                indexPar++;

            }else{

                impar[indexImpar] = num;
                indexImpar++;

            }


            if(indexPar == 5){
                
                for(int j = 0;j < 5;j++){

                    System.out.println("par[" + j + "] = " + par[j]);

                }

                indexPar = 0;

            }else if(indexImpar == 5){

                for(int j = 0;j < 5;j++){

                    System.out.println("impar[" + j + "] = " + impar[j]);

                }

                indexImpar = 0;

            }

        }

        for(int i = 0;i < indexImpar;i++){

            System.out.println("impar[" + i + "] = " + impar[i]);

        }

        for(int i = 0;i < indexPar;i++){

            System.out.println("par[" + i + "] = " + par[i]);

        }

        scan.close();

    }
    
}