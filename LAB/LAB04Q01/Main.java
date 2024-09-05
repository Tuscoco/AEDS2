import java.util.*;

/**
 * Main
 */

public class Main {
    
    public static void ordenarMod(int[] array,int m){

        for(int i = 1;i < array.length;i++){

            int tmp = array[i];
            int j = i - 1;

            while((j >= 0) && ((array[j] % m) > (tmp % m))){

                array[j + 1] = array[j];
                j--;

            }

            array[j + 1] = tmp;

        }

    }

    public static void swap(int menor,int i,int[] array){

        int temp = array[menor];
        array[menor] = array[i];
        array[i] = temp;

    }

    public static void ordenar(int[] array,int m){

        int n = array.length;

        for(int i = 0;i < (n - 1);i++){

            int menor = i;

            for(int j = i + 1;j < n;j++){

                if((array[menor] % m) == (array[j] % m)){

                    if((array[menor] % 2 == 0) && (array[j] % 2 != 0)){

                        swap(j, i, array);

                    }else if((array[menor] % 2 != 0) && (array[j] % 2 != 0)){

                        if(array[menor] < array[j]){

                            swap(j, i, array);

                        }

                    }else if((array[menor] % 2 == 0) && (array[j] % 2 == 0)){

                        if(array[menor] > array[j]){

                            swap(j, i, array);

                        }

                    }

                }

            }

            swap(menor, i, array);

        }

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n;
        int m;

        do{

            n = scan.nextInt();
            m = scan.nextInt();

            if(n != 0 && m != 0){

                int[] array = new int[n];

                for(int i = 0;i < n;i++){

                    array[i] = scan.nextInt();

                }

                ordenarMod(array,m);
                ordenar(array, m);

                System.out.println(n + " " + m);
                for(int i = 0;i < n;i++){

                    System.out.println(array[i]);

                }

            }

        }while(n != 0 && m != 0);

        System.out.println(n + " " + m);

        scan.close();

    }
    
}