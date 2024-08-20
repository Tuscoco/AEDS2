import java.util.*;

/**
 * Main
 */

public class Main {

    public static void espelhar(int[] array){

        for(int i = array.length - 1;i >= 0;i--){

            if(array[i] >= 10 && array[i] < 100){

                int pd = array[i]/10;
                int sd = array[i]%10;

                System.out.print(sd);
                System.out.print(pd);

            }else if(array[i] >= 100 && array[i] < 1000){

                int pd = array[i]/100;
                int dm = (array[i]/10)%10;
                int ud = array[i]%100;

                System.out.print(ud);
                System.out.print(dm);
                System.out.print(pd);

            }else{

                System.out.print(array[i]);

            }

        }

    }

    public static boolean fim(int[] array){

        boolean resultado = false;

        if(array == null){

            resultado = true;

        }

        return resultado;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int c = 0;

        do{

            int n1 = scan.nextInt(),n2 = scan.nextInt();

            int s = (n2 - n1) + 1;

            int[] array = new int[s];

            for(int i = 0;i < s;i++,n1++){

                array[i] = n1;
                System.out.print(array[i]);

            }

            espelhar(array);

            System.out.println("");

            c++;

        }while(c != 3);

        scan.close();

    }
    
}